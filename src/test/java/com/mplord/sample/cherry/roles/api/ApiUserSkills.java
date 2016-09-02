package com.mplord.sample.cherry.roles.api;

import com.mplord.sample.cherry.missions.api.ConsumeLatestRecordsMission;
import com.mplord.sample.cherry.missions.api.ReadLatestRecordFromStreamMission;
import com.mplord.sample.cherry.missions.api.VerifyResponseTransactionIdMission;

import io.magentys.Agent;
import io.magentys.mplord.Skills;

public class ApiUserSkills extends Skills {

    public ApiUserSkills(Agent agent) {
        super(agent);
    }

    public ConsumeLatestRecordsMission consumesAllTheLatestRecords() {
        return skill(ConsumeLatestRecordsMission.class);
    }

    public ReadLatestRecordFromStreamMission readsLatestRecordFromStream() {
        return skill(ReadLatestRecordFromStreamMission.class);
    }

    public VerifyResponseTransactionIdMission verifiesResponseTransactionId() {
        return skill(VerifyResponseTransactionIdMission.class);
    }

}
