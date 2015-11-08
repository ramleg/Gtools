package com.corp.globant.MODEL.beans;

/**
 *
 * @author ramiro.acoglanis
 */
public class PhoneNumber {
    
    private String number;
    private String userAssigned;
    private Country country;
    private Boolean reserved;
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(String userAssigned) {
        this.userAssigned = userAssigned;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
    
    
}
