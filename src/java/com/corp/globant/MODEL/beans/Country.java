package com.corp.globant.MODEL.beans;
/**
 *
 * @author ramiro.acoglanis
 */
public class Country {
   private Integer id;
   private String desc;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

}
