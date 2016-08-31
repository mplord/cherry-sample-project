package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.roles.base.BaseRoleConcrete;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;

public class BaseAgent extends AgentTypedMemory {

    @Inject
    private BaseRoleConcrete baseRole;

    private AgentTypedMemory otherAgent;

    public BaseAgent() {
        super();
    }

    private BaseRoleConcrete withBaseRole() {
        return baseRole.withAgent(this);
    }

    public BaseAgent asks(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission about(TypedKey<?> key) {
        return withBaseRole().asksAgent(key, otherAgent);
    }

    public BaseAgent informs(AgentTypedMemory otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission of(TypedKey<?> key) {
        return withBaseRole().informsAgent(key, otherAgent);
    }

    // public <VALUE> VALUE recalls(BaseKey baseKey, Class<VALUE> clazz) {
    // return recalls(baseKey.name(), clazz);
    // }
}
