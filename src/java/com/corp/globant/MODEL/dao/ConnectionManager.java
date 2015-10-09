package com.corp.globant.MODEL.dao;

import static com.corp.globant.config.Init.config;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ramiro Acoglanis
 */
public abstract class ConnectionManager {
    /**
     * Creates a new instance of ConnectionManager
     * @return Connection
     * @throws java.lang.Exception
     */
    public static Connection getConnection() throws Exception {
        // set the driver
        String dbDriver = config.getDbDriver();
        // set the connection string
        String dbConnString = config.getDbConnection();
        // set the db user
        String dbUser = config.getDbUser();
        // ser the password
        String dbPassword = config.getDbPasswd();
        // loads the driver
        Class.forName(dbDriver).newInstance();
        // establishes and return the connection 
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }

}
