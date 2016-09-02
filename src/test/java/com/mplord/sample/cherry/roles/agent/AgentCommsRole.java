package com.mplord.sample.cherry.roles.agent;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.missions.agent.AskAgentMission;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.Skill;
import io.magentys.mplord.Skills;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AgentCommsRole extends Skills {

    @Inject
    private Provider<AskAgentMission> askAgentMission;

    public Skill asksAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return askAgentMission.get().prepare(getAgent(), key, otherAgent);
    }

    public Skill informsAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return askAgentMission.get().prepare(otherAgent, key, getAgent());
    }
}
