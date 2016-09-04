package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.roles.agent.AgentCommsRole;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;
import io.magentys.mplord.skills.Skill;

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

    public Skill<AgentTypedMemory> about(TypedKey<?> key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public BaseAgent informs(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public Skill<AgentTypedMemory> of(TypedKey<?> key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }

    public Skill<AgentTypedMemory> asksAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public Skill<AgentTypedMemory> informsAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }
}
