package com.corp.globant.config;
/**
 * @author Ramiro Acoglanis
 */
public class Config {
    
    private String ldapserverDefault;
    private String ldapseverAlternative;
    private String ldapuser;
    private String ldappasswd;
    
    private String dbDriver;
    private String dbConnection;
    private String dbUser;
    private String dbPasswd;

    public String getLdapserverDefault() {
        return ldapserverDefault;
    }

    public void setLdapserverDefault(String ldapserverDefault) {
        this.ldapserverDefault = ldapserverDefault;
    }

    public String getLdapseverAlternative() {
        return ldapseverAlternative;
    }

    public void setLdapseverAlternative(String ldapseverAlternative) {
        this.ldapseverAlternative = ldapseverAlternative;
    }

    public String getLdapuser() {
        return ldapuser;
    }

    public void setLdapuser(String ldapuser) {
        this.ldapuser = ldapuser;
    }

    public String getLdappasswd() {
        return ldappasswd;
    }

    public void setLdappasswd(String ldappasswd) {
        this.ldappasswd = ldappasswd;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPasswd() {
        return dbPasswd;
    }

    public void setDbPasswd(String dbPasswd) {
        this.dbPasswd = dbPasswd;
    }
    
    
    
}
