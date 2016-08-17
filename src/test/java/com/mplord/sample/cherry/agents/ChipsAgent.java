package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.roles.mongo.MongoSystemRole;

public class ChipsAgent extends BaseAgent {

    @Inject
    Provider<MongoSystemRole> mongoSystemRoleProvider;

    public MongoSystemRole withUserRole() {
        return mongoSystemRoleProvider.get().withAgent(this);
    }

}
