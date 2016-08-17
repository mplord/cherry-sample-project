package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.roles.mongo.MongoSystemRole;

public class ChipsAgent extends BaseAgent {

    public MongoSystemRole withUserRole() {
        return new MongoSystemRole(this);
    }

}
