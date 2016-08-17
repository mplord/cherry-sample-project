package com.mplord.sample.steps;

import com.mplord.sample.cherry.agents.ApiAgent;
import com.mplord.sample.cherry.agents.ChipsAgent;
import com.mplord.sample.cherry.custom.CherryScenario;
import com.mplord.sample.mock.tools.MongoWriter;
import com.mplord.sample.mock.tools.QueueReader;

import cucumber.api.java.en.Given;

public class ApiSteps {

    @Given("^a cherry test$")
    public void a_cherry_test() throws Throwable {
        ApiAgent apiUser = new ApiAgent();
        apiUser.obtains(new QueueReader());

        ChipsAgent chips = new ChipsAgent();
        chips.obtains(new MongoWriter());

        CherryScenario.start().withTitle("consume new filing history record after new delta")
            .given(apiUser.withSystemRole().connectsToTheStreamingApi())
            .and(apiUser.withUserRole().consumesAllTheLatestRecords())
            .when(chips.withUserRole().causesAFilingHistoryDeltaToBeSentFromChipsRemembering("filing-history"))
            .and(apiUser.withUserRole().readsLatestRecordFromStream())
            .and(chips.informs(apiUser).of("filing-history"))
            .then(apiUser.withUserRole().verifiesResponseTransactionId());

    }

}
