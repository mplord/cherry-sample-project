package com.mplord.sample.cherry.missions.agent;

import io.magentys.MissionTypedMemory;
import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AskAgent implements MissionTypedMemory<AgentTypedMemory> {

    public static AskAgent askAgent(TypedKey<?> key, AgentTypedMemory otherAgent) {
        return new AskAgent(key, otherAgent);
    }

    private TypedKey<?> key;
    private AgentTypedMemory otherAgent;

    public AskAgent(TypedKey<?> key, AgentTypedMemory otherAgent) {
        this.key = key;
        this.otherAgent = otherAgent;
    }

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {
        agent.askThe(otherAgent, key);

        return agent;
    }
}