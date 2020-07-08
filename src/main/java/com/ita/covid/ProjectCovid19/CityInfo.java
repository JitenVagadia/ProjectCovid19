package com.ita.covid.ProjectCovid19;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityInfo {

    @Id
    private String cityInfoCityName;
    private int cityInfoCases;
    private int cityInfoDead;
    private int cityInfoRecovered;

    public CityInfo(){}
    public CityInfo(String cityInfoCityName) {
        this.cityInfoCityName = cityInfoCityName;
        this.cityInfoCases = 1;
    }

    public String getCityInfoCityName() {
        return cityInfoCityName;
    }

    public void setCityInfoCityName(String cityInfoCityName) {
        this.cityInfoCityName = cityInfoCityName;
    }

    public int getCityInfoCases() {
        return cityInfoCases;
    }

    public void setCityInfoCases(int cityInfoCases) {
        this.cityInfoCases = cityInfoCases;
    }

    public int getCityInfoDead() {
        return cityInfoDead;
    }

    public void setCityInfoDead(int cityInfoDead) {
        this.cityInfoDead = cityInfoDead;
    }

    public int getCityInfoRecovered() {
        return cityInfoRecovered;
    }

    public void setCityInfoRecovered(int cityInfoRecovered) {
        this.cityInfoRecovered = cityInfoRecovered;
    }
}
