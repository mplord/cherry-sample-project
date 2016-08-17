package com.mplord.sample.cherry.roles.base;

import com.mplord.sample.cherry.custom.AgentMission;

import io.magentys.Agent;
import io.magentys.Mission;

public class BaseRole {
    private Agent agent;

    public BaseRole(Agent agent) {
        this.agent = agent;
    }

    protected Agent getAgent() {
        return agent;
    }

    protected AgentMission getMission(Mission<Agent> mission) {
        return (new AgentMission()).withAgent(agent).withMission(mission);
    }
}
