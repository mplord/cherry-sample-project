package com.mplord.sample.cherry.custom;

public class CherryScenario {

    private String title;

    public static CherryScenario start() {
        return new CherryScenario();
    }

    public CherryScenario withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    private CherryScenario perform(AgentMission agentMission) {
        agentMission.perform();
        return this;
    }

    public CherryScenario given(AgentMission agentMission) {
        return perform(agentMission);
    }

    public CherryScenario when(AgentMission agentMission) {
        return perform(agentMission);
    }

    public CherryScenario then(AgentMission agentMission) {
        return perform(agentMission);
    }

    public CherryScenario and(AgentMission agentMission) {
        return perform(agentMission);
    }

}
