package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ramiro.acoglanis
 */
public class PaisDAOpsql {
        
    public static Pais getById (Connection conn, String id)throws Exception{
        
        String laConsulta = "SELECT * FROM app.pais WHERE id=" + id + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        Pais elPais = new Pais();
        elPais.setId(rs.getInt("pais_id"));
        elPais.setDesc(rs.getString("pais_desc"));
        
        stmtConsulta.close();
        
        return elPais;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList paises = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.pais;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        
        while (rs.next()) {
            Pais elPais = new Pais();
            // Arma el objeto Pais
            elPais.setId(rs.getInt("pais_id"));
            elPais.setDesc(rs.getString("pais_desc"));
            // Agrega el alumno a la coleccion
            paises.add(elPais);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el alumno
        return paises;
    }
}
