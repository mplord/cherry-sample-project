package com.mplord.sample.cherry.roles.api;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.missions.api.StartQueueReaderMission;

import io.magentys.mplord.Skills;

public class ApiSystemSkills extends Skills {

    @Inject
    private Provider<StartQueueReaderMission> startQueueReaderMission;

    public StartQueueReaderMission connectsToTheStreamingApi() {
        return skill(startQueueReaderMission);
    }

}
