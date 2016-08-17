package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.Agent;
import io.magentys.Mission;

public class StartQueueReader implements Mission<Agent> {

    @Inject
    private QueueReader queueReader;

    public static StartQueueReader startedQueueReader() {
        return new StartQueueReader();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        queueReader.start();

        return agent;
    }
}