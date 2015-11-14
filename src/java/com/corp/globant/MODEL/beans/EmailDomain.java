package com.corp.globant.MODEL.beans;
/**
 *
 * @author ramiro.acoglanis
 */
public class EmailDomain {
    
    private String id;
    private String desc;
    private String subDomain;

    public EmailDomain(){}

    public EmailDomain(String id) {
        this.id = id;
    }
    
    public EmailDomain(String id, String desc) {
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

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }
    
}
