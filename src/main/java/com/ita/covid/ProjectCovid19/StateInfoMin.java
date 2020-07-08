package com.ita.covid.ProjectCovid19;

import javax.persistence.Id;

public class StateInfoMin {
    @Id
    private String stateInfoMinCityName;
    private int stateInfoMinCases;

    public StateInfoMin(){}
    public StateInfoMin(String stateInfoMinCityName, int stateInfoMinCases) {
        this.stateInfoMinCityName = stateInfoMinCityName;
        this.stateInfoMinCases = stateInfoMinCases;
    }

    public String getStateInfoMinCityName() {
        return stateInfoMinCityName;
    }

    public void setStateInfoMinCityName(String stateInfoMinCityName) {
        this.stateInfoMinCityName = stateInfoMinCityName;
    }

    public int getStateInfoMinCases() {
        return stateInfoMinCases;
    }

    public void setStateInfoMinCases(int stateInfoMinCases) {
        this.stateInfoMinCases = stateInfoMinCases;
    }
}
