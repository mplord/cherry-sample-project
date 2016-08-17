package com.mplord.sample.cherry.custom;

import javax.inject.Inject;

import com.google.inject.Injector;

import io.magentys.Agent;
import io.magentys.Mission;

public class AgentMission {
    @Inject
    private Injector injector;

    private Agent agent;
    private Mission<Agent> mission;

    public AgentMission() {
    }

    public AgentMission withAgent(Agent agent) {
        this.agent = agent;
        return this;
    }

    public AgentMission withMission(Mission<Agent> mission) {
        this.mission = mission;
        injector.injectMembers(mission);
        return this;
    }

    public Agent perform() {
        return agent.performs(mission);
    }
}
