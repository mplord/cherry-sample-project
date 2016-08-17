package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.roles.mongo.MongoSystemRole;

import io.magentys.CoreMemory;

public class ChipsAgent extends BaseAgent {

    public MongoSystemRole withUserRole() {
        return new MongoSystemRole(this);
    }

    public ChipsAgent() {
        super(new CoreMemory());
    }
}
