package com.mplord.sample.cherry.missions.mongo;

import com.mplord.sample.mock.objects.FilingHistory;
import com.mplord.sample.mock.tools.MongoWriter;

import io.magentys.Agent;
import io.magentys.Mission;

public class AddFilingHistoryDelta implements Mission<Agent> {

    public static AddFilingHistoryDelta addsFilingHistoryDelta() {
        return new AddFilingHistoryDelta();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        System.out.println("Added a file history delta to the mongo queue");

        FilingHistory filingHistory = new FilingHistory("UniqueId");
        agent.keepsInMind("filing-history", filingHistory);

        System.out.println("MongoWriter tool obtained: " + agent.usingThe(MongoWriter.class));

        return agent;
    }

}