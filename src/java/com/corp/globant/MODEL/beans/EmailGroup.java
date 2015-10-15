package com.corp.globant.MODEL.beans;

/**
 *
 * @author acogl
 */
public class EmailGroup {
    
    private String id;
    private String desc;
    private String domainGroup;
    private Location location;

    public EmailGroup() {}
    
    public EmailGroup(String id) {
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

    public String getDomainGroup() {
        return domainGroup;
    }

    public void setDomainGroup(String domainGroup) {
        this.domainGroup = domainGroup;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
