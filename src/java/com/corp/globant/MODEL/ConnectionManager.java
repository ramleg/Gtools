/*
 * ConnectionManager.java
 *
 *
 */
package com.corp.globant.MODEL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sebastian S. Sanga
 */
public abstract class ConnectionManager {
    /**
     * Creates a new instance of ConnectionManager
     */
    public ConnectionManager() {
    }

    public static Connection getConnection() throws Exception {

        // Establece el nombre del driver a utilizar
        String dbDriver = "org.postgresql.Driver";
        // Establece la conexion a utilizar contra la base de datos
        String dbConnString = "jdbc:postgresql://10.80.10.181:5432/db_gtools";
        
        // Establece el usuario de la base de datos
        String dbUser = "postgres";
        
        // Establece la contraseña de la base de datos
        String dbPassword = "postgres";
        
        // Establece el driver de conexion
        Class.forName(dbDriver).newInstance();

        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }

}
