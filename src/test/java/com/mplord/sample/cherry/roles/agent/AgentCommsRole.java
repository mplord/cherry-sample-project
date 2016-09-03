package com.mplord.sample.cherry.roles.agent;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.missions.agent.AskAgentMission;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;
import io.magentys.mplord.skills.Skill;
import io.magentys.mplord.skills.Skills;

public class AgentCommsRole extends Skills<AgentTypedMemory> {

    @Inject
    private Provider<AskAgentMission> askAgentMission;

    public Skill<AgentTypedMemory> asksAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return askAgentMission.get().prepare(getAgent(), key, otherAgent);
    }

    public Skill<AgentTypedMemory> informsAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return askAgentMission.get().prepare(otherAgent, key, getAgent());
    }
}
