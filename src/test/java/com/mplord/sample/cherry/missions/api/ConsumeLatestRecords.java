package com.mplord.sample.cherry.missions.api;

import java.util.List;

import javax.inject.Inject;

import com.mplord.sample.mock.tools.QueueReader;
import com.mplord.sample.mock.tools.ResultWriter;

import io.magentys.Agent;
import io.magentys.Mission;

public class ConsumeLatestRecords implements Mission<Agent> {

    @Inject
    private QueueReader queueReader;

    @Inject
    private ResultWriter resultWriter;

    public static ConsumeLatestRecords consumedLatestRecords() {
        return new ConsumeLatestRecords();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        // task - wait for no change
        queueReader.waitChange(false);

        // task - output latest results
        List<String> newResults = queueReader.getNewResults();
        resultWriter.outputResults("-F- ", newResults, true);

        return agent;
    }
}