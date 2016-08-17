package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.roles.api.ApiRole;
import com.mplord.sample.cherry.roles.api.ApiSystemRole;

import io.magentys.CoreMemory;

public class ApiAgent extends BaseAgent {

    public ApiSystemRole withSystemRole() {
        return new ApiSystemRole(this);
    }

    public ApiRole withUserRole() {
        return new ApiRole(this);
    }

    public ApiAgent() {
        super(new CoreMemory());
    }

}
