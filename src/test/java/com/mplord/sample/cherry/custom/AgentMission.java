package com.mplord.sample.cherry.custom;

import io.magentys.Agent;
import io.magentys.Mission;

public class AgentMission {
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
        return this;
    }

    public Agent perform() {
        return agent.performs(mission);
    }
}
