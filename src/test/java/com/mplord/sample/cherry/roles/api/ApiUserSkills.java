package com.mplord.sample.cherry.roles.api;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.missions.api.ConsumeLatestRecordsMission;
import com.mplord.sample.cherry.missions.api.ReadLatestRecordFromStreamMission;
import com.mplord.sample.cherry.missions.api.VerifyResponseTransactionIdMission;

import io.magentys.mplord.Skills;

public class ApiUserSkills extends Skills {

    @Inject
    private Provider<ConsumeLatestRecordsMission> consumesAllTheLatestRecords;

    @Inject
    private Provider<ReadLatestRecordFromStreamMission> readsLatestRecordFromStream;

    @Inject
    private Provider<VerifyResponseTransactionIdMission> verifiesResponseTransactionId;

    public ConsumeLatestRecordsMission consumesAllTheLatestRecords() {
        return skill(consumesAllTheLatestRecords);
    }

    public ReadLatestRecordFromStreamMission readsLatestRecordFromStream() {
        return skill(readsLatestRecordFromStream);
    }

    public VerifyResponseTransactionIdMission verifiesResponseTransactionId() {
        return skill(verifiesResponseTransactionId);
    }

}
