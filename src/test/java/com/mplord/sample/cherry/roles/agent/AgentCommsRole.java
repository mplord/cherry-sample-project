package com.mplord.sample.cherry.roles.agent;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.agent.AskAgent;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.commons.typemap.TypedKey;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AgentCommsRole extends BaseRole<AgentCommsRole> {

    public AgentMission asksAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return getMission(AskAgent.askAgent(key, otherAgent));
    }

    public AgentMission informsAgent(AgentTypedMemory otherAgent, TypedKey<?> key) {
        return getMission(AskAgent.askAgent(key, getAgent()), otherAgent);
    }
}
