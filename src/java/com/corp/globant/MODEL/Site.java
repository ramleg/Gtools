package com.corp.globant.MODEL;
/**
 *
 * @author ramiro.acoglanis
 */
public class Site {
    private String id;
    private String desc;
    private String sap_desc;
    private String ad_desc;
    private Pais pais;

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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
