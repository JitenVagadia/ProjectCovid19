package com.ita.covid.ProjectCovid19;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Helper {

    @Id
    private String helperContact;
    private String helperName;
    private String helperCity;
    private String helperState;
    private String helperEmail;
    private String helperAddress;
    private String Description;

    public Helper(String helperContact, String helperName, String helperCity, String helperState, String helperEmail, String helperAddress, String description) {
        this.helperContact = helperContact;
        this.helperName = helperName;
        this.helperCity = helperCity;
        this.helperState = helperState;
        this.helperEmail = helperEmail;
        this.helperAddress = helperAddress;
        this.Description = description;
    }


    public String getHelperContact() {
        return helperContact;
    }

    public void setHelperContact(String helperContact) {
        this.helperContact = helperContact;
    }

    public String getHelperName() {
        return helperName;
    }

    public void setHelperName(String helperName) {
        this.helperName = helperName;
    }

    public String getHelperCity() {
        return helperCity;
    }

    public void setHelperCity(String helperCity) {
        this.helperCity = helperCity;
    }

    public String getHelperState() {
        return helperState;
    }

    public void setHelperState(String helperState) {
        this.helperState = helperState;
    }

    public String getHelperEmail() {
        return helperEmail;
    }

    public void setHelperEmail(String helperEmail) {
        this.helperEmail = helperEmail;
    }

    public String getHelperAddress() {
        return helperAddress;
    }

    public void setHelperAddress(String helperAddress) {
        this.helperAddress = helperAddress;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

}
