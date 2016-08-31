package com.mplord.sample.cherry.missions.mongo;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.TheFilingHistory;
import com.mplord.sample.mock.objects.FilingHistory;
import com.mplord.sample.mock.tools.MongoWriter;

import io.magentys.Mission;
import io.magentys.mplord.agent.AgentTypedMemory;

public class AddFilingHistoryDelta implements Mission<AgentTypedMemory, AgentTypedMemory> {

    @Inject
    private MongoWriter mongoWriter;

    @Inject
    private TheFilingHistory theFilingHistory;

    public static AddFilingHistoryDelta addsFilingHistoryDelta() {
        return new AddFilingHistoryDelta();
    }

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {

        System.out.println("Added a file history delta to the mongo queue");

        FilingHistory filingHistory = new FilingHistory("UniqueId");
        agent.keepsInMind(theFilingHistory, filingHistory);

        System.out.println("MongoWriter tool obtained: " + mongoWriter);

        return agent;
    }

}