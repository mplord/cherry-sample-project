package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import org.junit.Assert;

import com.mplord.sample.cherry.memory.TheFilingHistory;
import com.mplord.sample.cherry.memory.TheResponseRecord;
import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.mplord.agent.AgentTypedMemory;
import io.magentys.mplord.skills.Skill;

public class VerifyResponseTransactionIdMission extends Skill<AgentTypedMemory> {

    @Inject
    private TheFilingHistory theFilingHistory;

    @Inject
    private TheResponseRecord theResponseRecord;

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {
        FilingHistory filingHistory = agent.recalls(theFilingHistory);

        String filingHistoryResponseId = agent.recalls(theResponseRecord);

        System.out.println("Response Id: " + filingHistoryResponseId);

        Assert.assertTrue("Filing history id did not match response id",
                filingHistory.getId().equals(filingHistoryResponseId));

        return agent;
    }
}