package com.ita.covid.ProjectCovid19;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.sql.Date;
@Entity
public class Person {

    @Id
    @Pattern(regexp= "^[0-9]{10}$",message="contact must be 10 digits." )
    private String personContact;

    @NotNull
    @Min(1)
    @Max(200)
    private short personAge;

    @NotNull
    @Min(1)
    private short personFamilyMembers;
    private boolean personRecovered;
    private boolean personDead;
    private boolean personTravelledAbroad;
    @Pattern(regexp= "^[A-Za-z]{0,15}$",message="must be name without any spaces." )
    private String personTravelledAbroadCityName;
    private boolean personTravelledInCountry;
    @Pattern(regexp= "^[A-Za-z]{0,15}$",message="must be name without any spaces." )
    private String personTravelledInCountryCityName;

    @NotNull
    @Pattern(regexp= "^[A-Za-z]{1,15}$",message="must be name without any spaces." )
    private String personFirstName;

    @NotNull
    @Pattern(regexp= "^[A-Za-z]{1,15}$",message="must be name without any spaces." )
    private String personLastName;

    @NotNull
    @Pattern(regexp= "^(Male)|(Female)|(Other)$")
    private String personGender;

    @NotNull
    @Pattern(regexp= "^[A-Za-z]{1,15}$",message="must be name without any spaces." )
    private String personCity;
    @NotNull
    @Pattern(regexp= "^[A-Za-z]{1,15}$",message="must be name without any spaces." )
    private String personState;
    @Email
    private String personEmail;

    private Date personInfectionDate;

    public Person(){

    }

    public Person(String personContact, short personAge, short personFamilyMembers, boolean personRecovered, boolean personDead, boolean personTravelledAbroad, String personTravelledAbroadCityName, boolean personTravelledInCountry, String personTravelledInCountryCityName, String personFirstName, String personLastName, String personGender, String personCity, String personState, String personEmail, Date personInfectionDate) {
        this.personContact = personContact;
        this.personAge = personAge;
        this.personFamilyMembers = personFamilyMembers;
        this.personRecovered = personRecovered;
        this.personDead = personDead;
        this.personTravelledAbroad = personTravelledAbroad;
        this.personTravelledAbroadCityName = personTravelledAbroadCityName;
        this.personTravelledInCountry = personTravelledInCountry;
        this.personTravelledInCountryCityName = personTravelledInCountryCityName;
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.personGender = personGender;
        this.personCity = personCity;
        this.personState = personState;
        this.personEmail = personEmail;
        this.personInfectionDate = personInfectionDate;
    }


    public Date getPersonInfectionDate() {
        return personInfectionDate;
    }

    public void setPersonInfectionDate(Date personInfectionDate) {
        this.personInfectionDate = personInfectionDate;
    }

    public short getPersonAge() {
        return personAge;
    }

    public void setPersonAge(short personAge) {
        this.personAge = personAge;
    }

    public short getPersonFamilyMembers() {
        return personFamilyMembers;
    }

    public void setPersonFamilyMembers(short personFamilyMembers) {
        this.personFamilyMembers = personFamilyMembers;
    }


    public boolean isPersonRecovered() {
        return personRecovered;
    }

    public void setPersonRecovered(boolean personRecovered) {
        this.personRecovered = personRecovered;
    }

    public boolean isPersonDead() {
        return personDead;
    }

    public void setPersonDead(boolean personDead) {
        this.personDead = personDead;
    }

    public boolean isPersonTravelledAbroad() {
        return personTravelledAbroad;
    }

    public void setPersonTravelledAbroad(boolean personTravelledAbroad) {
        this.personTravelledAbroad = personTravelledAbroad;
    }

    public String getPersonTravelledAbroadCityName() {
        return personTravelledAbroadCityName;
    }

    public void setPersonTravelledAbroadCityName(String personTravelledAbroadCityName) {
        this.personTravelledAbroadCityName = personTravelledAbroadCityName;
    }

    public boolean isPersonTravelledInCountry() {
        return personTravelledInCountry;
    }

    public void setPersonTravelledInCountry(boolean personTravelledInCountry) {
        this.personTravelledInCountry = personTravelledInCountry;
    }

    public String getPersonTravelledInCountryCityName() {
        return personTravelledInCountryCityName;
    }

    public void setPersonTravelledInCountryCityName(String personTravelledInCountryCityName) {
        this.personTravelledInCountryCityName = personTravelledInCountryCityName;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    @Id
    public String getPersonContact() {
        return personContact;
    }

    public void setPersonContact(String personContact) {
        this.personContact = personContact;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public String getPersonState() {
        return personState;
    }

    public void setPersonState(String personState) {
        this.personState = personState;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }
}
