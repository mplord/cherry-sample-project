package com.mplord.sample.junit;

import javax.inject.Inject;

import org.junit.Test;

import com.mplord.sample.cherry.agents.ApiAgent;
import com.mplord.sample.cherry.agents.ChipsAgent;
import com.mplord.sample.cherry.custom.CherryScenario;
import com.mplord.sample.cherry.memory.TheFilingHistory;

public class SampleTest extends TestBase {

    @Inject
    private ApiAgent apiAgent;

    @Inject
    private ChipsAgent chipsAgent;

    @Inject
    private TheFilingHistory theFilingHistory;

    @Test
    public void test_consume_new_filing_history_record_after_new_delta() {

        CherryScenario.withTypedMemoryAgents()
            .scenario("consume new filing history record after new delta")
            .given(apiAgent.withSystemSkills().connectsToTheStreamingApi())
            .and(apiAgent.withUserSkills().consumesAllTheLatestRecords())
            .when(chipsAgent.withUserSkills().causesAFilingHistoryDeltaToBeSentFromChips())
            .and(apiAgent.withUserSkills().readsLatestRecordFromStream())
            .and(chipsAgent.informs(apiAgent).of(theFilingHistory))
            .then(apiAgent.withUserSkills().verifiesResponseTransactionId());

    }

}
