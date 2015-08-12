package com.corp.globant.MODEL;
/**
 *
 * @author r.sanchez
 */
public class OuPositions {
   private Integer id;
   private String desc;
   private String ou;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setOu(String ou) {
        this.ou = ou;
    }    
    
    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
    public String getOu() {
        return ou;
    }

}
