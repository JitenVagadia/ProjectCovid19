package com.ita.covid.ProjectCovid19;

import javax.persistence.Id;
public class CityInfoMin {
    @Id
    private String cityInfoMinCityName;
    private int cityInfoMinCases;

    public CityInfoMin(){}
    public CityInfoMin(String cityInfoMinCityName, int cityInfoMinCases) {
        this.cityInfoMinCityName = cityInfoMinCityName;
        this.cityInfoMinCases = cityInfoMinCases;
    }

    public String getCityInfoMinCityName() {
        return cityInfoMinCityName;
    }

    public void setCityInfoMinCityName(String cityInfoMinCityName) {
        this.cityInfoMinCityName = cityInfoMinCityName;
    }

    public int getCityInfoMinCases() {
        return cityInfoMinCases;
    }

    public void setCityInfoMinCases(int cityInfoMinCases) {
        this.cityInfoMinCases = cityInfoMinCases;
    }
}
