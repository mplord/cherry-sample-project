package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.memory.BaseKey;
import com.mplord.sample.cherry.roles.agent.AgentCommsRole;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.Agent;
import io.magentys.CoreMemory;

public class BaseAgent extends Agent {

    @Inject
    private Provider<AgentCommsRole> agentCommsRole;

    private Agent otherAgent;

    public BaseAgent() {
        super(new CoreMemory());
    }

    public AgentCommsRole withCommsRole() {
        return getRole(agentCommsRole);
    }

    public BaseAgent asks(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission about(BaseKey key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public BaseAgent informs(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission of(BaseKey key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }

    protected <ROLE extends BaseRole<ROLE>> ROLE getRole(Provider<ROLE> role) {
        return role.get().withAgent(this);
    }

    public AgentMission asksAgent(Agent otherAgent, BaseKey key) {
        return withCommsRole().asksAgent(otherAgent, key);
    }

    public AgentMission informsAgent(Agent otherAgent, BaseKey key) {
        return withCommsRole().informsAgent(otherAgent, key);
    }
}
