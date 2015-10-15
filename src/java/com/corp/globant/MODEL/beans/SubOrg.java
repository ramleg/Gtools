package com.corp.globant.MODEL.beans;
/**
 *
 * @author r.sanchez
 */
public class SubOrg {
   private String id;
   private String desc;
   private String domainEmail;

    public SubOrg() {}

    public SubOrg(String id) {
        this.id = id;
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

    public String getDomainEmail() {
        return domainEmail;
    }

    public void setDomainEmail(String domainEmail) {
        this.domainEmail = domainEmail;
    }



}
