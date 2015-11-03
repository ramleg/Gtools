package com.corp.globant.VIEW.beans;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author ramiro.acoglanis
 */
public class FrmUserAdd {
    
    @SerializedName("subOrganization")
    private String subOrganization;
    @SerializedName("name")
    private String name;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("identificationNumber")
    private String identificationNumber;
    @SerializedName("domainName")
    private String domainUser;
    @SerializedName("email")
    private String email;
    @SerializedName("position")
    private String position;
    @SerializedName("areaOU")
    private String areaOU;
    @SerializedName("location")
    private String location;
    @SerializedName("emailGroup")
    private String emailGroup;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("country")
    private String country;

    public String getSubOrganization() {
        return subOrganization;
    }

    public void setSubOrganization(String subOrganization) {
        this.subOrganization = subOrganization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getDomainUser() {
        return domainUser;
    }

    public void setDomainUser(String domainUser) {
        this.domainUser = domainUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAreaOU() {
        return areaOU;
    }

    public void setAreaOU(String areaOU) {
        this.areaOU = areaOU;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmailGroup() {
        return emailGroup;
    }

    public void setEmailGroup(String emailGroup) {
        this.emailGroup = emailGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
