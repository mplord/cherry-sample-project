package com.mplord.sample.cherry.roles.api;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.api.StartQueueReader;
import com.mplord.sample.cherry.roles.base.BaseRole;

public class ApiSystemRole extends BaseRole<ApiSystemRole> {

    public AgentMission connectsToTheStreamingApi() {
        return getMission(StartQueueReader.startedQueueReader());
    }

}
