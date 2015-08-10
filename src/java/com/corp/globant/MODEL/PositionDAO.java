package com.corp.globant.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class PositionDAO {
    
    public static Position getById (Connection conn, String id)throws Exception{
        
        String laConsulta = "SELECT * FROM app.positions WHERE positions_id=" + id + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        Position pos = new Position();
        pos.setId(rs.getString("positions_id"));
        pos.setDesc(rs.getString("positions_desc"));
        
        stmtConsulta.close();
        
        return pos;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList positions = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.positions;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        while (rs.next()) {
            Position pos = new Position();
            // Arma el objeto Pais
            pos.setId(rs.getString("positions_id"));
            pos.setDesc(rs.getString("positions_desc"));
            // Agrega el alumno a la coleccion
            positions.add(pos);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el alumno
        return positions;
    }
    
}
