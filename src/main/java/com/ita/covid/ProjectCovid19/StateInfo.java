package com.ita.covid.ProjectCovid19;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StateInfo {

    @Id
    private String StateInfoStateName;
    private int StateInfoCases;
    private int StateInfoDead;
    private int StateInfoRecovered;

    public StateInfo() {

    }

    public StateInfo(String stateInfoStateName) {
        StateInfoStateName = stateInfoStateName;
        this.StateInfoCases=1;
    }

    public String getStateInfoStateName() {
        return StateInfoStateName;
    }

    public void setStateInfoStateName(String stateInfoStateName) {
        StateInfoStateName = stateInfoStateName;
    }

    public int getStateInfoCases() {
        return StateInfoCases;
    }

    public void setStateInfoCases(int stateInfoCases) {
        StateInfoCases = stateInfoCases;
    }

    public int getStateInfoDead() {
        return StateInfoDead;
    }

    public void setStateInfoDead(int stateInfoDead) {
        StateInfoDead = stateInfoDead;
    }

    public int getStateInfoRecovered() {
        return StateInfoRecovered;
    }

    public void setStateInfoRecovered(int stateInfoRecovered) {
        StateInfoRecovered = stateInfoRecovered;
    }
}
