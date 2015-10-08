package com.corp.globant.MODEL.beans;

import javax.servlet.ServletContextListener;

/**
 *
 * @author ramiro.acoglanis
 */
public abstract class Config implements ServletContextListener{

    private String ldapserverDefault;
    private String ldapseverAlternative;
    private String ldapuser;
    private String ldappasswd;
    private String dbDriver;
    private String dbConnection;
    private String dbUser;
    private String dbPasswd;
    
    
}
