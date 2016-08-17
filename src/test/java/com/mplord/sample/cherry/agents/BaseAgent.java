package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.agent.AskAgent;

import io.magentys.Agent;
import io.magentys.Memory;

public class BaseAgent extends Agent {

    private Agent otherAgent;

    public BaseAgent(Memory<String> memory) {
        super(memory);
    }

    public BaseAgent asks(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission about(String key) {
        return (new AgentMission()).withAgent(this).withMission(AskAgent.askAgent(key, otherAgent));
    }

    public BaseAgent informs(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AgentMission of(String key) {
        return (new AgentMission()).withAgent(otherAgent).withMission(AskAgent.askAgent(key, this));
    }

}
