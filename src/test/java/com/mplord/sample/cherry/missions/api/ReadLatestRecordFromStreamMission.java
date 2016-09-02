package com.mplord.sample.cherry.missions.api;

import java.util.List;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.TheResponseRecord;
import com.mplord.sample.cherry.tasks.WriteResultsTask;
import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.mplord.Skill;
import io.magentys.mplord.agent.AgentTypedMemory;

public class ReadLatestRecordFromStreamMission extends Skill {

    @Inject
    private QueueReader queueReader;

    @Inject
    private TheResponseRecord theResponseRecord;

    @Inject
    private WriteResultsTask writeResultsTask;

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {

        queueReader.waitChange(true);

        List<String> results = queueReader.getNewResults();
        writeResultsTask.outputResults("-N- ", results, false);

        agent.keepsInMind(theResponseRecord, results.get(0));

        return agent;
    }
}