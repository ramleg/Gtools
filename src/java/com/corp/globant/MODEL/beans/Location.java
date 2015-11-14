package com.corp.globant.MODEL.beans;

import com.corp.globant.MODEL.beans.Country;

/**
 *
 * @author ramiro.acoglanis
 */
public class Location {
    private String id;
    private String desc;
    private String sap_desc;
    private String ad_desc;
    private Country country;

    public Location() {}

    public Location(String id) {
        this.id = id;
    }

    public Location(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSap_desc() {
        return sap_desc;
    }

    public void setSap_desc(String sap_desc) {
        this.sap_desc = sap_desc;
    }

    public String getAd_desc() {
        return ad_desc;
    }

    public void setAd_desc(String ad_desc) {
        this.ad_desc = ad_desc;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
