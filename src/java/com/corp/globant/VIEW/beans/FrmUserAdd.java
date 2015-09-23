package com.corp.globant.VIEW.beans;

/**
 *
 * @author ramiro.acoglanis
 */
public class FrmUserAdd {
    
    private String subOrganization;
    private String firstName;
    private String lastName;
    private String identificationNumber;
    private String domainName;
    private String email;
    private String position;
    private String areaOU;
    private String location;
    private String emailGroup;
    private String phoneNumber;
    private String country;

    public FrmUserAdd() {
    }

    public FrmUserAdd(String subOrganization, String firstName, String lastName,
            String identificationNumber, String domainName, String email, String position,
            String areaOU, String location, String emailGroup, String phoneNumber, String country) {
        this.subOrganization = subOrganization;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.domainName = domainName;
        this.email = email;
        this.position = position;
        this.areaOU = areaOU;
        this.location = location;
        this.emailGroup = emailGroup;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }
    

    public String getSubOrganization() {
        return subOrganization;
    }

    public void setSubOrganization(String subOrganization) {
        this.subOrganization = subOrganization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
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
