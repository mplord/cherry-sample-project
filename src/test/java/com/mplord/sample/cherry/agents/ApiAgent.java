package com.mplord.sample.cherry.agents;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.mplord.sample.cherry.roles.api.ApiRole;
import com.mplord.sample.cherry.roles.api.ApiSystemRole;

public class ApiAgent extends BaseAgent {

    @Inject
    Provider<ApiSystemRole> apiSystemRoleProvider;

    @Inject
    Provider<ApiRole> apiRoleProvider;

    public ApiSystemRole withSystemRole() {
        return apiSystemRoleProvider.get().withAgent(this);
    }

    public ApiRole withUserRole() {
        return apiRoleProvider.get().withAgent(this);
    }

}
