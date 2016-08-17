package com.mplord.sample.junit;

import javax.inject.Inject;

import org.junit.Test;

import com.mplord.sample.cherry.agents.ApiAgent;
import com.mplord.sample.cherry.agents.ChipsAgent;
import com.mplord.sample.cherry.custom.CherryScenario;
import com.mplord.sample.cherry.memory.FilingHistoryKey;

public class SampleTest extends TestBase {

    @Inject
    private ApiAgent apiAgent;

    @Inject
    private ChipsAgent chipsAgent;

    @Inject
    private FilingHistoryKey filingHistory;

    @Test
    public void test_consume_new_filing_history_record_after_new_delta() {

        CherryScenario.start().withTitle("consume new filing history record after new delta")
            .given(apiAgent.withSystemRole().connectsToTheStreamingApi())
            .and(apiAgent.withUserRole().consumesAllTheLatestRecords())
            .when(chipsAgent.withUserRole().causesAFilingHistoryDeltaToBeSentFromChips())
            .and(apiAgent.withUserRole().readsLatestRecordFromStream())
            .and(chipsAgent.informs(apiAgent).of(filingHistory))
            .then(apiAgent.withUserRole().verifiesResponseTransactionId());

    }

}
