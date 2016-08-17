package com.mplord.sample.cherry.roles.mongo;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.mongo.AddFilingHistoryDelta;
import com.mplord.sample.cherry.roles.base.BaseRole;

import io.magentys.Agent;

public class MongoSystemRole extends BaseRole {

    public MongoSystemRole(Agent agent) {
        super(agent);
    }

    public AgentMission causesAFilingHistoryDeltaToBeSentFromChipsRemembering(String key) {
        return getMission(AddFilingHistoryDelta.addsFilingHistoryDelta(key));
    }

}
