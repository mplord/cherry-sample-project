package com.mplord.sample.cherry.custom;

import javax.inject.Inject;

import com.google.inject.Injector;

import io.magentys.Mission;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AgentMission {
    @Inject
    private Injector injector;

    private AgentTypedMemory agent;
    private Mission<AgentTypedMemory, AgentTypedMemory> mission;

    public AgentMission() {
    }

    public AgentMission withAgent(AgentTypedMemory agent) {
        this.agent = agent;
        return this;
    }

    public AgentMission withMission(Mission<AgentTypedMemory, AgentTypedMemory> mission) {
        this.mission = mission;
        injector.injectMembers(mission);
        return this;
    }

    public AgentTypedMemory perform() {
        return agent.performs(mission);
    }
}
