package com.mplord.sample.cherry.roles.api;

import com.mplord.sample.cherry.missions.api.StartQueueReaderMission;

import io.magentys.Agent;
import io.magentys.mplord.Skills;

public class ApiSystemSkills extends Skills {

    public ApiSystemSkills(Agent agent) {
        super(agent);
    }

    public StartQueueReaderMission connectsToTheStreamingApi() {
        return skill(StartQueueReaderMission.class);
    }

}
