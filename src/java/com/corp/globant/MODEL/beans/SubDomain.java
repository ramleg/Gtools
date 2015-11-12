package com.corp.globant.MODEL.beans;
/**
 *
 * @author r.sanchez
 */
public class SubDomain {
   private String id;
   private String desc;
   private String category;
   
    public SubDomain() {}

    public SubDomain(String id) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
