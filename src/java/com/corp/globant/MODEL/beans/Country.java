package com.corp.globant.MODEL.beans;
/**
 *
 * @author ramiro.acoglanis
 */
public class Country {
   private String id;
   private String desc;

    public Country() {}

    public Country(String id) {
        this.id = id;
    }

    public Country(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

}
