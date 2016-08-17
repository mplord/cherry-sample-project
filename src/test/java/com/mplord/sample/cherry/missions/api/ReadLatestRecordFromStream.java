package com.mplord.sample.cherry.missions.api;

import java.util.List;

import com.mplord.sample.mock.tools.QueueReader;

import io.magentys.Agent;
import io.magentys.Mission;

public class ReadLatestRecordFromStream extends ApiMission implements Mission<Agent> {

    public static ReadLatestRecordFromStream readsLatestRecordFromStream() {
        return new ReadLatestRecordFromStream();
    }

    @Override
    public Agent accomplishAs(Agent agent) {

        QueueReader qr = agent.usingThe(QueueReader.class);
        qr.waitChange(true);

        List<String> results = qr.getNewResults();
        outputResults("-N- ", results, false);

        agent.keepsInMind("response-record", results.get(0));

        return agent;
    }
}