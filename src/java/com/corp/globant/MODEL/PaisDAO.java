package com.corp.globant.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author ramiro.acoglanis
 */
public class PaisDAO {
        
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList paises = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.pais;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        while (rs.next()) {
            // Arma el objeto Alumno
            Pais elPais = new Pais();
            elPais.setId(rs.getInt("id"));
            elPais.setDesc(rs.getString("desc"));
            // Agrega el alumno a la coleccion
            paises.add(elPais);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el alumno
        return paises;
    }
}
