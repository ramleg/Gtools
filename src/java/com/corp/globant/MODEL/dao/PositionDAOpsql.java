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
        
        String laConsulta = "SELECT * FROM app.positions WHERE positions_id=" + id + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        Position pos = new Position();
        pos.setId(rs.getString("positions_id"));
        pos.setDesc(rs.getString("positions_desc"));
        pos.setOu(rs.getString("fk_ou_positions_id"));
        
        stmtConsulta.close();
        
        return pos;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList positions = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT \n" +
                            "  positions.positions_id, \n" +
                            "  positions.positions_desc, \n" +
                            "  ou_positions.ou_ad\n" +
                            "FROM \n" +
                            "  app.positions, \n" +
                            "  app.ou_positions\n" +
                            "WHERE \n" +
                            "  positions.fk_ou_positions_id = ou_positions.ou_id;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        while (rs.next()) {
            Position pos = new Position();
            // Arma el objeto Pais
            pos.setId(rs.getString("positions_id"));
            pos.setDesc(rs.getString("positions_desc"));
            pos.setOu(rs.getString("ou_ad"));
            // Agrega la psosion a la coleccion
            positions.add(pos);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna la posision
        return positions;
    }
    
}
