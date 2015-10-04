package com.corp.globant.MODEL.dao;

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
        String dbDriver = "org.postgresql.Driver";
        // set the connection string
        String dbConnString = "jdbc:postgresql://10.80.10.181:5432/db_gtools";
        // set the db user
        String dbUser = "postgres";
        // ser the password
        String dbPassword = "postgres";
        // loads the driver
        Class.forName(dbDriver).newInstance();
        // establishes and return the connection 
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }

}
