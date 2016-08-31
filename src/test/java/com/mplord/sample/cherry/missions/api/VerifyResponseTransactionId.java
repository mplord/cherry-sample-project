package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import org.junit.Assert;

import com.mplord.sample.cherry.memory.TheFilingHistory;
import com.mplord.sample.cherry.memory.TheResponseRecord;
import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.Mission;
import io.magentys.mplord.agent.AgentTypedMemory;

public class VerifyResponseTransactionId implements Mission<AgentTypedMemory, AgentTypedMemory> {

    @Inject
    private TheFilingHistory theFilingHistory;

    @Inject
    private TheResponseRecord theResponseRecord;

    public static VerifyResponseTransactionId verifiesResponseTransactionId() {
        return new VerifyResponseTransactionId();
    }

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