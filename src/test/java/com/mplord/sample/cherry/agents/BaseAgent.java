package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.roles.agent.AgentCommsRole;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.Skill;
import io.magentys.mplord.agent.AgentTypedMemory;

public class BaseAgent extends AgentTypedMemory {

    @Inject
    private Provider<AgentCommsRole> agentCommsRole;

    private AgentTypedMemory otherAgent;

    public AgentCommsRole withCommsRole() {
        AgentCommsRole skills = agentCommsRole.get();
        skills.withAgent(this);
        return skills;
    }

    public BaseAgent asks(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public Skill about(TypedKey<?> key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public BaseAgent informs(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public Skill of(TypedKey<?> key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }

    public Skill asksAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public Skill informsAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }
}
