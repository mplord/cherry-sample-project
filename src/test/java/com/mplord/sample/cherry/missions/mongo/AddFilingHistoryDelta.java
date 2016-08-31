package com.mplord.sample.cherry.missions.mongo;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.TheFilingHistory;
import com.mplord.sample.mock.objects.FilingHistory;
import com.mplord.sample.mock.tools.MongoWriter;

import io.magentys.Agent;
import io.magentys.Mission;

public class AddFilingHistoryDelta implements Mission<Agent> {

    @Inject
    private MongoWriter mongoWriter;

    @Inject
    private TheFilingHistory theFilingHistory;

    public static AddFilingHistoryDelta addsFilingHistoryDelta() {
        return new AddFilingHistoryDelta();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        System.out.println("Added a file history delta to the mongo queue");

        FilingHistory filingHistory = new FilingHistory("UniqueId");
        agent.keepsInMind(theFilingHistory.name(), filingHistory);

        System.out.println("MongoWriter tool obtained: " + mongoWriter);

        return agent;
    }

}