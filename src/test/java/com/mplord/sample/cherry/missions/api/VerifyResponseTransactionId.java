package com.mplord.sample.cherry.missions.api;

import javax.inject.Inject;

import org.junit.Assert;

import com.mplord.sample.cherry.memory.FilingHistoryKey;
import com.mplord.sample.cherry.memory.ResponseRecordKey;
import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.Agent;
import io.magentys.Mission;

public class VerifyResponseTransactionId implements Mission<Agent> {

    @Inject
    private FilingHistoryKey filingHistoryKey;

    @Inject
    private ResponseRecordKey responseRecordKey;

    public static VerifyResponseTransactionId verifiesResponseTransactionId() {
        return new VerifyResponseTransactionId();
    }

    @Override
    public Agent accomplishAs(Agent agent) {
        FilingHistory filingHistory = agent.recalls(filingHistoryKey.name(), FilingHistory.class);

        String filingHistoryResponseId = agent.recalls(responseRecordKey.name(), String.class);

        System.out.println("Response Id: " + filingHistoryResponseId);

        Assert.assertTrue("Filing history id did not match response id",
                filingHistory.getId().equals(filingHistoryResponseId));

        return agent;
    }
}