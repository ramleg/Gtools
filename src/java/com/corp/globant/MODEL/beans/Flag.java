package com.corp.globant.MODEL.beans;
import com.google.gson.annotations.SerializedName;
/**
 *
 * @author ramiro.acoglanis
 */
public class Flag {
    @SerializedName("flag")
    private String flag;
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
}
