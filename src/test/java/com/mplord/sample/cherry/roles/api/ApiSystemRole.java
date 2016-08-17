package com.mplord.sample.cherry.roles.api;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.api.StartQueueReader;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.Agent;

public class ApiSystemRole extends BaseRole {

    public ApiSystemRole(Agent agent) {
        super(agent);
    }

    public AgentMission connectsToTheStreamingApi() {
        return getMission(StartQueueReader.startedQueueReader());
    }

}
