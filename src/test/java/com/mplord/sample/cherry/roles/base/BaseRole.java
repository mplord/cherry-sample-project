package com.mplord.sample.cherry.roles.base;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.agent.AskAgent;

import io.magentys.Agent;
import io.magentys.Mission;

public class BaseRole<T extends BaseRole<T>> {

    @Inject
    Provider<AgentMission> agentMissionProvider;

    private Agent agent;

    public T withAgent(Agent agent) {
        this.agent = agent;
        return (T) this;
    }

    protected Agent getAgent() {
        return agent;
    }

    protected AgentMission getMission(Mission<Agent> mission) {
        return agentMissionProvider.get().withAgent(agent).withMission(mission);
    }

    public AgentMission asksAgent(String key, Agent otherAgent) {
        return getMission(AskAgent.askAgent(key, otherAgent));
    }

    public AgentMission informsAgent(String key, Agent otherAgent) {
        return agentMissionProvider.get().withAgent(otherAgent).withMission(AskAgent.askAgent(key, agent));
    }
}
