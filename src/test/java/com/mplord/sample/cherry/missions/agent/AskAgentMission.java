package com.mplord.sample.cherry.missions.agent;

import io.magentys.Agent;
import io.magentys.mplord.Skill;

public class AskAgentMission extends Skill {

    private String key;
    private Agent otherAgent;

    public AskAgentMission(Agent agent, String key, Agent otherAgent) {
        super(agent);
        this.key = key;
        this.otherAgent = otherAgent;
    }

    @Override
    public Agent accomplishAs(Agent agent) {
        agent.askThe(otherAgent, key);

        return agent;
    }
}