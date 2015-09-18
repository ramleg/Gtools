package com.corp.globant.model.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class UserDAOpsql {
        
    public static User getByUserId (Connection conn, String userId)throws Exception{
        
        String laConsulta = "SELECT * FROM app.users WHERE user_domain=" + userId + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        User user = new User();
        user.setId(rs.getString("user_id"));
        user.setName(rs.getString("user_name"));
        user.setLastname(rs.getString("user_lastname"));
        user.setUserId(rs.getString("user_domain"));
        user.setRol(rs.getString("user_status"));
        
        stmtConsulta.close();
        
        return user;
    }
    public static ArrayList<User> getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList users = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.users;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        
        while (rs.next()) {
            User user = new User();
            // Arma el objeto Pais
            user.setId(rs.getString("user_id"));
            user.setName(rs.getString("user_name"));
            user.setLastname(rs.getString("user_lastname"));
            user.setUserId(rs.getString("user_domain"));
            user.setRol(rs.getString("user_status"));
            // Agrega el alumno a la coleccion
            users.add(user);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el alumno
        return users;
    }
}
