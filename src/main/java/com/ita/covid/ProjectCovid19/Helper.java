package com.ita.covid.ProjectCovid19;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Helper {

    @Id
    @Pattern(regexp= "^[0-9]{10}$",message="contact must be 10 digits." )
    private String helperContact;
    @Size(min=3,max=30,message="Name must be between 3 and 30 characters.")
    private String helperName;
    @Pattern(regexp= "^[A-Za-z]{1,15}$",message="must be name without any spaces." )
    private String helperCity;
    @Pattern(regexp= "^[A-Za-z]{1,15}$",message="must be name without any spaces." )
    private String helperState;
    @NotNull
    @Email(message="must be a valid email.")
    private String helperEmail;
    private String helperAddress;
    private String helperDescription;

    public Helper(){

    }


    public Helper(String helperContact, String helperName, String helperCity, String helperState, String helperEmail, String helperAddress,String helperDescription) {
        this.helperContact = helperContact;
        this.helperName = helperName;
        this.helperCity = helperCity;
        this.helperState = helperState;
        this.helperEmail = helperEmail;
        this.helperAddress = helperAddress;
        this.helperDescription = helperDescription;
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

    public String getHelperDescription() { return helperDescription; }

    public void setHelperDescription(String helperDescription) { this.helperDescription = helperDescription; }


}
