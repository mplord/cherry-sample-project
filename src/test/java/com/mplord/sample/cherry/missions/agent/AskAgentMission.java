package com.mplord.sample.cherry.missions.agent;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.Skill;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AskAgentMission extends Skill {

    private TypedKey<?> key;
    private AgentTypedMemory otherAgent;

    public AskAgentMission prepare(AgentTypedMemory agent, TypedKey<?> key, AgentTypedMemory otherAgent) {
        useAgent(agent);
        this.key = key;
        this.otherAgent = otherAgent;
        return this;
    }

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {
        agent.askThe(otherAgent, key);

        return agent;
    }
}