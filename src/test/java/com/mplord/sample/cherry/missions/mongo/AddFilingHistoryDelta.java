package com.mplord.sample.cherry.missions.mongo;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.FilingHistoryKey;
import com.mplord.sample.mock.objects.FilingHistory;
import com.mplord.sample.mock.tools.ResultWriter;
import com.mplord.sample.mock.tools.MongoWriter;

import io.magentys.Agent;
import io.magentys.Mission;

public class AddFilingHistoryDelta extends ResultWriter implements Mission<Agent> {

    @Inject
    private MongoWriter mongoWriter;

    @Inject
    private FilingHistoryKey filingHistoryKey;

    public static AddFilingHistoryDelta addsFilingHistoryDelta() {
        return new AddFilingHistoryDelta();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        System.out.println("Added a file history delta to the mongo queue");

        FilingHistory filingHistory = new FilingHistory("UniqueId");
        agent.keepsInMind(filingHistoryKey.name(), filingHistory);

        System.out.println("MongoWriter tool obtained: " + mongoWriter);

        return agent;
    }

}