package com.mplord.sample.cherry.agents;

import com.mplord.sample.cherry.roles.api.ApiUserSkills;
import com.mplord.sample.cherry.roles.api.ApiSystemSkills;

public class ApiAgent extends BaseAgent {

    public ApiSystemSkills withSystemSkills() {
        return new ApiSystemSkills(this);
    }

    public ApiUserSkills withUserSkills() {
        return new ApiUserSkills(this);
    }

}
