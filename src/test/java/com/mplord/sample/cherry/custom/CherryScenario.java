package com.mplord.sample.cherry.custom;

import io.magentys.mplord.agent.AgentBase;
import io.magentys.mplord.agent.AgentTypedMemory;
import io.magentys.mplord.skills.Skill;

public class CherryScenario<AGENT extends AgentBase<AGENT>> {

    private String title;

    public static CherryScenario<AgentTypedMemory> withTypedMemoryAgents() {
        return new CherryScenario<AgentTypedMemory>();
    }

    public CherryScenario() {
    }

    public CherryScenario<AGENT> scenario(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    private CherryScenario<AGENT> perform(Skill<AGENT> skill) {
        skill.accomplish();
        return this;
    }

    public CherryScenario<AGENT> given(Skill<AGENT> skill) {
        return perform(skill);
    }

    public CherryScenario<AGENT> when(Skill<AGENT> skill) {
        return perform(skill);
    }

    public CherryScenario<AGENT> then(Skill<AGENT> skill) {
        return perform(skill);
    }

    public CherryScenario<AGENT> and(Skill<AGENT> skill) {
        return perform(skill);
    }

    /*
     * public CherryScenario performAll(AgentMission... agentMissions) { for (AgentMission agentMission : agentMissions) { perform(agentMission); } return this;
     * }
     */

}
