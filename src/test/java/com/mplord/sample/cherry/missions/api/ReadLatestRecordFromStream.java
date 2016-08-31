package com.mplord.sample.cherry.missions.api;

import java.util.List;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.ResponseRecordKey;
import com.mplord.sample.mock.tools.QueueReader;
import com.mplord.sample.mock.tools.ResultWriter;

import io.magentys.Mission;
import io.magentys.mplord.agent.AgentTypedMemory;

public class ReadLatestRecordFromStream implements Mission<AgentTypedMemory, AgentTypedMemory> {

    @Inject
    private QueueReader queueReader;

    @Inject
    private ResponseRecordKey responseRecordKey;

    @Inject
    private ResultWriter resultWriter;

    public static ReadLatestRecordFromStream readsLatestRecordFromStream() {
        return new ReadLatestRecordFromStream();
    }

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {

        queueReader.waitChange(true);

        List<String> results = queueReader.getNewResults();
        resultWriter.outputResults("-N- ", results, false);

        agent.keepsInMind(responseRecordKey, results.get(0));

        return agent;
    }
}