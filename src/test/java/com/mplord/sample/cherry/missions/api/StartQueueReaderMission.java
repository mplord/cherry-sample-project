package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.mplord.agent.AgentTypedMemory;
import io.magentys.mplord.skills.Skill;

public class StartQueueReaderMission extends Skill<AgentTypedMemory> {

    @Inject
    private QueueReader queueReader;

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {

        queueReader.start();

        return agent;
    }
}