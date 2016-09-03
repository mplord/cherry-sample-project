package com.mplord.sample.cherry.missions.mongo;

import javax.inject.Inject;

import com.mplord.sample.cherry.memory.TheFilingHistory;
import com.mplord.sample.mock.objects.FilingHistory;
import com.mplord.sample.mock.tools.MongoWriter;

import io.magentys.mplord.agent.AgentTypedMemory;
import io.magentys.mplord.skills.Skill;

public class AddFilingHistoryDeltaMission extends Skill<AgentTypedMemory> {

    @Inject
    private MongoWriter mongoWriter;

    @Inject
    private TheFilingHistory theFilingHistory;

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {

        System.out.println("Added a file history delta to the mongo queue");

        FilingHistory filingHistory = new FilingHistory("UniqueId");
        agent.keepsInMind(theFilingHistory, filingHistory);

        System.out.println("MongoWriter tool obtained: " + mongoWriter);

        return agent;
    }

}
