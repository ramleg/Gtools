package com.corp.globant.MODEL.beans;
/**
 *
 * @author ramiro.acoglanis
 */
public class User {
    private String id;
    private String name;
    private String lastname;
    private String domainUser;
    private String rol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDomainUser() {
        return domainUser;
    }

    public void setDomainUser(String userId) {
        this.domainUser = userId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
