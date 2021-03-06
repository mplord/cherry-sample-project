package com.mplord.sample.cherry.missions.api;

import org.junit.Assert;

import com.mplord.sample.mock.objects.FilingHistory;

import io.magentys.Agent;
import io.magentys.Mission;

public class VerifyResponseTransactionId extends ApiMission implements Mission<Agent> {

    public static VerifyResponseTransactionId verifiesResponseTransactionId() {
        return new VerifyResponseTransactionId();
    }

    @Override
    public Agent accomplishAs(Agent agent) {
        FilingHistory filingHistory = agent.recalls("filing-history", FilingHistory.class);

        String filingHistoryResponseId = agent.recalls("response-record", String.class);

        System.out.println("Response Id: " + filingHistoryResponseId);

        Assert.assertTrue("Filing history id did not match response id",
                filingHistory.getId().equals(filingHistoryResponseId));

        return agent;
    }
}