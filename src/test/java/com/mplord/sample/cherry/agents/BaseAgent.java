package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.memory.BaseKey;
import com.mplord.sample.cherry.roles.base.BaseRoleConcrete;

import io.magentys.Agent;
import io.magentys.CoreMemory;

public class BaseAgent extends Agent {

    @Inject
    private BaseRoleConcrete baseRole;

    private Agent otherAgent;

    public BaseAgent() {
        super(new CoreMemory());
    }

    private BaseRoleConcrete withBaseRole() {
        return baseRole.withAgent(this);
    }

    public BaseAgent asks(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission about(BaseKey key) {
        return withBaseRole().asksAgent(key.name(), otherAgent);
    }

    public BaseAgent informs(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission of(BaseKey key) {
        return withBaseRole().informsAgent(key.name(), otherAgent);
    }

    // public <VALUE> VALUE recalls(BaseKey baseKey, Class<VALUE> clazz) {
    // return recalls(baseKey.name(), clazz);
    // }
}
