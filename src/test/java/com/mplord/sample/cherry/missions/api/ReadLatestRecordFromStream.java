package com.mplord.sample.cherry.missions.api;

import java.util.List;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.ResponseRecordKey;
import com.mplord.sample.mock.tools.QueueReader;
import com.mplord.sample.mock.tools.ResultWriter;

import io.magentys.Agent;
import io.magentys.Mission;

public class ReadLatestRecordFromStream implements Mission<Agent> {

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
    public Agent accomplishAs(Agent agent) {

        queueReader.waitChange(true);

        List<String> results = queueReader.getNewResults();
        resultWriter.outputResults("-N- ", results, false);

        agent.keepsInMind(responseRecordKey.name(), results.get(0));

        return agent;
    }
}