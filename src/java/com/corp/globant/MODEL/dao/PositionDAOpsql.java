package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author ramiro.acoglanis
 */
public class PositionDAOpsql {
    
    public static Position getById (Connection conn, String id)throws Exception{
        
        String query = "SELECT * FROM app.positions WHERE positions_id=" + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Position pos = new Position();
        if(rs.next()){
            pos.setId(rs.getString("positions_id"));
            pos.setDesc(rs.getString("positions_desc"));
            pos.setOu(rs.getString("positions_ou"));
        }else{
            pos.setId("");
        }
        stmt.close();
        
        return pos;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList positions = new ArrayList();
        // Arma la consulta y la ejecuta
        String query = "SELECT * FROM app.positions";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // Obtiene los datos
        while (rs.next()) {
            Position pos = new Position();
            pos.setId(rs.getString("positions_id"));
            pos.setDesc(rs.getString("positions_desc"));
            pos.setOu(rs.getString("positions_ou"));
            // Agrega la position a la coleccion
            positions.add(pos);
        }
        // Cierra el Statement y la Connection
        stmt.close();
        // Retorna la posision
        return positions;
    }
    
}
