package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.roles.agent.AgentCommsRole;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;

public class BaseAgent extends AgentTypedMemory {

    @Inject
    private Provider<AgentCommsRole> agentCommsRole;

    private AgentTypedMemory otherAgent;

    public BaseAgent() {
        super();
    }

    public AgentCommsRole withCommsRole() {
        return getRole(agentCommsRole);
    }

    public BaseAgent asks(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission about(TypedKey<?> key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public BaseAgent informs(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission of(TypedKey<?> key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }

    protected <ROLE extends BaseRole<ROLE>> ROLE getRole(Provider<ROLE> role) {
        return role.get().withAgent(this);
    }

    public AgentMission asksAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public AgentMission informsAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }
}
