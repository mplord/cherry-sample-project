package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.missions.agent.AskAgentMission;

import io.magentys.Agent;
import io.magentys.CoreMemory;

public class BaseAgent extends Agent {

    private Agent otherAgent;

    public BaseAgent() {
        super(new CoreMemory());
    }

    public BaseAgent asks(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AskAgentMission about(String key) {
        return new AskAgentMission(this, key, otherAgent);
    }

    public BaseAgent informs(Agent otherAgent) {
        this.otherAgent = otherAgent;
        return this;
    }

    public AskAgentMission of(String key) {
        return new AskAgentMission(otherAgent, key, this);
    }

}
