package com.mplord.sample.cherry.roles.agent;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.memory.BaseKey;
import com.mplord.sample.cherry.missions.agent.AskAgent;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.Agent;

public class AgentCommsRole extends BaseRole<AgentCommsRole> {

    public AgentMission asksAgent(Agent otherAgent, BaseKey key) {
        return getMission(AskAgent.askAgent(key.name(), otherAgent));
    }

    public AgentMission informsAgent(Agent otherAgent, BaseKey key) {
        return getMission(AskAgent.askAgent(key.name(), getAgent()), otherAgent);
    }
}
