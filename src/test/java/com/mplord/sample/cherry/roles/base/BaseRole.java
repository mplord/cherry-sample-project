package com.mplord.sample.cherry.roles.base;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.agent.AskAgent;

import io.magentys.Mission;
import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;

public class BaseRole<T extends BaseRole<T>> {

    @Inject
    Provider<AgentMission> agentMissionProvider;

    private AgentTypedMemory agent;

    @SuppressWarnings("unchecked")
    public T withAgent(AgentTypedMemory agent) {
        this.agent = agent;
        return (T) this;
    }

    protected AgentTypedMemory getAgent() {
        return agent;
    }

    protected AgentMission getMission(Mission<AgentTypedMemory, AgentTypedMemory> mission) {
        return agentMissionProvider.get().withAgent(agent).withMission(mission);
    }

    protected AgentMission getMission(Mission<AgentTypedMemory, AgentTypedMemory> mission, AgentTypedMemory otherAgent) {
        return agentMissionProvider.get().withAgent(otherAgent).withMission(mission);
    }
    
    public AgentMission asksAgent(TypedKey<?> key, AgentTypedMemory otherAgent) {
        return getMission(AskAgent.askAgent(key, otherAgent));
    }

    public AgentMission informsAgent(TypedKey<?> key, AgentTypedMemory otherAgent) {
        return agentMissionProvider.get().withAgent(otherAgent).withMission(AskAgent.askAgent(key, agent));
    }
}
