package com.mplord.sample.cherry.missions.api;

import java.util.List;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.Agent;
import io.magentys.Mission;

public class ConsumeLatestRecords extends ApiMission implements Mission<Agent> {

    public static ConsumeLatestRecords consumedLatestRecords() {
        return new ConsumeLatestRecords();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        // task - wait for no change
        QueueReader qr = agent.usingThe(QueueReader.class);
        qr.waitChange(false);

        // task - output latest results
        List<String> newResults = qr.getNewResults();
        outputResults("-F- ", newResults, true);

        return agent;
    }
}