package com.mplord.sample.junit;

import org.junit.Test;

import com.mplord.sample.cherry.agents.ApiAgent;
import com.mplord.sample.cherry.agents.ChipsAgent;
import com.mplord.sample.cherry.custom.CherryScenario;
import com.mplord.sample.mock.tools.MongoWriter;
import com.mplord.sample.mock.tools.QueueReader;

public class SampleTest extends TestBase {

    @Test
    public void test_consume_new_filing_history_record_after_new_delta() {
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
