package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import org.junit.Assert;

import com.mplord.sample.cherry.memory.FilingHistoryKey;
import com.mplord.sample.cherry.memory.ResponseRecordKey;
import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.Mission;
import io.magentys.mplord.agent.AgentTypedMemory;

public class VerifyResponseTransactionId implements Mission<AgentTypedMemory, AgentTypedMemory> {

    @Inject
    private FilingHistoryKey filingHistoryKey;

    @Inject
    private ResponseRecordKey responseRecordKey;

    public static VerifyResponseTransactionId verifiesResponseTransactionId() {
        return new VerifyResponseTransactionId();
    }

    @Override
    public AgentTypedMemory accomplishAs(AgentTypedMemory agent) {
        FilingHistory filingHistory = agent.recalls(filingHistoryKey);

        String filingHistoryResponseId = agent.recalls(responseRecordKey);

        System.out.println("Response Id: " + filingHistoryResponseId);

        Assert.assertTrue("Filing history id did not match response id",
                filingHistory.getId().equals(filingHistoryResponseId));

        return agent;
    }
}