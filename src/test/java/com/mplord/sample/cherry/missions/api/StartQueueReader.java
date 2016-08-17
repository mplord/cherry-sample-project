package com.mplord.sample.cherry.missions.api;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.Agent;
import io.magentys.Mission;

public class StartQueueReader implements Mission<Agent> {

    public static StartQueueReader startedQueueReader() {
        return new StartQueueReader();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        agent.usingThe(QueueReader.class).start();

        return agent;
    }
}