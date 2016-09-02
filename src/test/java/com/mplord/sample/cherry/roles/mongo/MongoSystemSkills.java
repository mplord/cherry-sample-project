package com.mplord.sample.cherry.roles.mongo;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.missions.mongo.AddFilingHistoryDeltaMission;

import io.magentys.mplord.Skills;

public class MongoSystemSkills extends Skills {

    @Inject
    private Provider<AddFilingHistoryDeltaMission> causesAFilingHistoryDeltaToBeSentFromChips;

    public AddFilingHistoryDeltaMission causesAFilingHistoryDeltaToBeSentFromChips() {
        return skill(causesAFilingHistoryDeltaToBeSentFromChips);
    }

}
