package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.roles.mongo.MongoSystemSkills;

public class ChipsAgent extends BaseAgent {

    public MongoSystemSkills withUserSkills() {
        return new MongoSystemSkills(this);
    }

}
