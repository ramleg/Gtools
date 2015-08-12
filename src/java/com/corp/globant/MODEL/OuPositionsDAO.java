package com.corp.globant.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class OuPositionsDAO {
    
    public static OuPositions getById (Connection conn, String id)throws Exception{
        
        String laConsulta = "SELECT * FROM app.ou_positions WHERE ou_id=" + id + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        OuPositions oupos = new OuPositions();
        oupos.setId(rs.getInt("ou_id"));
        oupos.setDesc(rs.getString("ou_desc"));
        oupos.setOu(rs.getString("ou_ad"));
        
        stmtConsulta.close();
        
        return oupos;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList oupositions = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.ou_positions order by ou_desc ASC;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        while (rs.next()) {
            OuPositions oupos = new OuPositions();
            // Arma el objeto Pais
            oupos.setId(rs.getInt("ou_id"));
            oupos.setDesc(rs.getString("ou_desc"));
            oupos.setOu(rs.getString("ou_ad"));
            // Agrega la psosion a la coleccion
            oupositions.add(oupos);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna la posision
        return oupositions;
    }
    
}
