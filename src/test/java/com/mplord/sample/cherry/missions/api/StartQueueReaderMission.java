package com.mplord.sample.cherry.missions.api;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.Agent;
import io.magentys.mplord.Skill;

public class StartQueueReaderMission extends Skill {

    @Override
    public Agent accomplishAs(Agent agent) {

        agent.usingThe(QueueReader.class).start();

        return agent;
    }
}