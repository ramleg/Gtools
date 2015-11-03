package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class UserDAOpsql {
        
    public static User getByUserDomain (Connection conn, String domainUser) throws SQLException{
        
        String query = "SELECT * FROM app.users WHERE users_domain_user='" + domainUser + "';";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        User user = new User();
        if(rs.next()){
            user.setId(rs.getString("users_id"));
            user.setName(rs.getString("users_name"));
            user.setLastname(rs.getString("users_lastname"));
            user.setDomainUser(rs.getString("users_domain_user"));
            user.setRol(rs.getString("users_rol"));
        }
        
        stmt.close();
        
        return user;
    }
    public static ArrayList<User> getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList users = new ArrayList();
        // Arma la consulta y la ejecuta
        String query = "SELECT * FROM app.users;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // Obtiene los datos
        
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getString("users_id"));
            user.setName(rs.getString("users_name"));
            user.setLastname(rs.getString("users_lastname"));
            user.setDomainUser(rs.getString("users_domain_user"));
            user.setRol(rs.getString("users_rol"));
            users.add(user);
        }
        // Cierra el Statement y la Connection
        stmt.close();
        // Retorna el alumno
        return users;
    }
}
