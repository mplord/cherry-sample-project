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

        CherryScenario.start("consume new filing history record after new delta")
            .given(apiAgent.withSystemSkills().connectsToTheStreamingApi())
            .and(apiAgent.withUserSkills().consumesAllTheLatestRecords())
            .when(chipsAgent.withUserSkills().causesAFilingHistoryDeltaToBeSentFromChips())
            .and(apiAgent.withUserSkills().readsLatestRecordFromStream())
            .and(chipsAgent.informs(apiAgent).of("filing-history"))
            .then(apiAgent.withUserSkills().verifiesResponseTransactionId());
    }

}
