package com.mplord.sample.cherry.roles.mongo;

import com.mplord.sample.cherry.missions.mongo.AddFilingHistoryDeltaMission;

import io.magentys.Agent;
import io.magentys.mplord.Skills;

public class MongoSystemSkills extends Skills {

    public MongoSystemSkills(Agent agent) {
        super(agent);
    }

    public AddFilingHistoryDeltaMission causesAFilingHistoryDeltaToBeSentFromChips() {
        return skill(AddFilingHistoryDeltaMission.class);
    }

}
