package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.roles.mongo.MongoSystemSkills;

public class ChipsAgent extends BaseAgent {

    @Inject
    Provider<MongoSystemSkills> mongoSystemRoleProvider;

    public MongoSystemSkills withUserSkills() {
        MongoSystemSkills skills = mongoSystemRoleProvider.get();
        skills.withAgent(this);
        return skills;
    }

}
