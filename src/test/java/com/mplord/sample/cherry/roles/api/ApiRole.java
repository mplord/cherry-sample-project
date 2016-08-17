package com.mplord.sample.cherry.roles.api;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.api.ConsumeLatestRecords;
import com.mplord.sample.cherry.missions.api.ReadLatestRecordFromStream;
import com.mplord.sample.cherry.missions.api.VerifyResponseTransactionId;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.Agent;

public class ApiRole extends BaseRole {

    public ApiRole(Agent agent) {
        super(agent);
    }

    public AgentMission consumesAllTheLatestRecords() {
        return getMission(ConsumeLatestRecords.consumedLatestRecords());
    }

    public AgentMission readsLatestRecordFromStream() {
        return getMission(ReadLatestRecordFromStream.readsLatestRecordFromStream());
    }

    public AgentMission verifiesResponseTransactionId() {
        return getMission(VerifyResponseTransactionId.verifiesResponseTransactionId());
    }

}
