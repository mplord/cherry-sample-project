package com.mplord.sample.cherry.missions.mongo;

import com.mplord.sample.cherry.missions.api.ApiMission;
import com.mplord.sample.mock.objects.FilingHistory;
import com.mplord.sample.mock.tools.MongoWriter;

import io.magentys.Agent;
import io.magentys.Mission;

public class AddFilingHistoryDelta extends ApiMission implements Mission<Agent> {

    public static AddFilingHistoryDelta addsFilingHistoryDelta(String filingHistoryKey) {
        return new AddFilingHistoryDelta(filingHistoryKey);
    }

    private String filingHistoryKey;

    public AddFilingHistoryDelta(String filingHistoryKey) {
        this.filingHistoryKey = filingHistoryKey;
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        try {
            System.out.println("Added a file history delta to the mongo queue");

            FilingHistory filingHistory = new FilingHistory("UniqueId");
            agent.keepsInMind(filingHistoryKey, filingHistory);

            // update in MongoDB queue stubbed out
            System.out.println("MongoWriter tool obtained: " + agent.usingThe(MongoWriter.class));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return agent;
    }

}