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
        ApiAgent apiAgent = new ApiAgent();
        apiAgent.obtains(new QueueReader());

        ChipsAgent chipsAgent = new ChipsAgent();
        chipsAgent.obtains(new MongoWriter());

        CherryScenario.start().withTitle("consume new filing history record after new delta")
            .given(apiAgent.withSystemRole().connectsToTheStreamingApi())
            .and(apiAgent.withUserRole().consumesAllTheLatestRecords())
            .when(chipsAgent.withUserRole().causesAFilingHistoryDeltaToBeSentFromChips())
            .and(apiAgent.withUserRole().readsLatestRecordFromStream())
            .and(chipsAgent.informs(apiAgent).of("filing-history"))
            .then(apiAgent.withUserRole().verifiesResponseTransactionId());
    }

}
