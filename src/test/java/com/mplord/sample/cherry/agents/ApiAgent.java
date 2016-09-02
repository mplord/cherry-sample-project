package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.roles.api.ApiSystemSkills;
import com.mplord.sample.cherry.roles.api.ApiUserSkills;

public class ApiAgent extends BaseAgent {

    @Inject
    Provider<ApiSystemSkills> apiSystemRoleProvider;

    @Inject
    Provider<ApiUserSkills> apiRoleProvider;

    public ApiSystemSkills withSystemSkills() {
        ApiSystemSkills skills = apiSystemRoleProvider.get();
        skills.withAgent(this);
        return skills;
    }

    public ApiUserSkills withUserSkills() {
        ApiUserSkills skills = apiRoleProvider.get();
        skills.withAgent(this);
        return skills;
    }

}
