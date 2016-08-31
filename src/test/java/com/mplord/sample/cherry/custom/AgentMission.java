package com.mplord.sample.cherry.custom;

import javax.inject.Inject;

import com.google.inject.Injector;

import io.magentys.MissionTypedMemory;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AgentMission {
    @Inject
    private Injector injector;

    private AgentTypedMemory agent;
    private MissionTypedMemory<AgentTypedMemory> mission;

    public AgentMission() {
    }

    public AgentMission withAgent(AgentTypedMemory agent) {
        this.agent = agent;
        return this;
    }

    public AgentMission withMission(MissionTypedMemory<AgentTypedMemory> mission) {
        this.mission = mission;
        injector.injectMembers(mission);
        return this;
    }

    public AgentTypedMemory perform() {
        return agent.performs(mission);
    }
}
