package com.mplord.sample.cherry.custom;

import io.magentys.mplord.skills.Skill;

public class CherryScenario {

    private String title;

    public static CherryScenario start(String title) {
        return new CherryScenario(title);
    }

    public CherryScenario(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private CherryScenario perform(Skill skill) {
        skill.accomplish();
        return this;
    }

    public CherryScenario given(Skill skill) {
        return perform(skill);
    }

    public CherryScenario when(Skill skill) {
        return perform(skill);
    }

    public CherryScenario then(Skill skill) {
        return perform(skill);
    }

    public CherryScenario and(Skill skill) {
        return perform(skill);
    }

    /*
     * public CherryScenario performAll(AgentMission... agentMissions) { for (AgentMission agentMission : agentMissions) { perform(agentMission); } return this;
     * }
     */

}
