package com.mplord.sample.cherry.roles.mongo;

import com.mplord.sample.cherry.custom.AgentMission;
import com.mplord.sample.cherry.missions.mongo.AddFilingHistoryDelta;
import com.mplord.sample.cherry.roles.base.BaseRole;

public class MongoSystemRole extends BaseRole<MongoSystemRole> {

    public AgentMission causesAFilingHistoryDeltaToBeSentFromChips() {
        return getMission(AddFilingHistoryDelta.addsFilingHistoryDelta());
    }

}
