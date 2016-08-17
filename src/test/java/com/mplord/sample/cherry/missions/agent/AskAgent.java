package com.mplord.sample.cherry.missions.agent;

import io.magentys.Agent;
import io.magentys.Mission;

public class AskAgent implements Mission<Agent> {

    public static AskAgent askAgent(String key, Agent otherAgent) {
        return new AskAgent(key, otherAgent);
    }

    private String key;
    private Agent otherAgent;

    public AskAgent(String key, Agent otherAgent) {
        this.key = key;
        this.otherAgent = otherAgent;
    }

    @Override
    public Agent accomplishAs(Agent agent) {
        agent.askThe(otherAgent, key);

        return agent;
    }
}