package com.ita.covid.ProjectCovid19;

import javax.persistence.Id;
import javax.validation.constraints.Pattern;

public class Updateperson {

    @Id
    @Pattern(regexp= "^[0-9]{10}$",message="contact must be 10 digits." )
    String contact;
    boolean dead;
    boolean recovered;
    public Updateperson(){

    }

    public Updateperson(@Pattern(regexp = "^[0-9]{10}$", message = "contact must be 10 digits.") String contact, boolean dead, boolean recovered) {
        this.contact = contact;
        this.dead = dead;
        this.recovered = recovered;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isRecovered() {
        return recovered;
    }

    public void setRecovered(boolean recovered) {
        this.recovered = recovered;
    }
}
