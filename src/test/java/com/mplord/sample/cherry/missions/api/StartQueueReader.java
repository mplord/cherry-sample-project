package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.Mission;
import io.magentys.mplord.agent.AgentTypedMemory;

public class StartQueueReader implements Mission<AgentTypedMemory, AgentTypedMemory> {

    @Inject
    private QueueReader queueReader;

    public static StartQueueReader startedQueueReader() {
        return new StartQueueReader();
    }

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {

        queueReader.start();

        return agent;
    }
}