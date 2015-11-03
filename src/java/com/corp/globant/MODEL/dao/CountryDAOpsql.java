package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ramiro.acoglanis
 */
public class CountryDAOpsql {
        
    public static Country getById (Connection conn, String id)throws Exception{

        String query = "SELECT * FROM app.countries WHERE countries_id=" + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        Country country = new Country();
        country.setId(rs.getString("countries_id"));
        country.setDesc(rs.getString("countries_desc"));
        
        stmt.close();
        
        return country;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList countries = new ArrayList();
        // Arma la consulta y la ejecuta
        String query = "SELECT * FROM app.countries;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // Obtiene los datos
        while (rs.next()) {
            Country country = new Country();
            // Arma el objeto Country
            country.setId(rs.getString("countries_id"));
            country.setDesc(rs.getString("countries_desc"));
            countries.add(country);
        }
        stmt.close();
        return countries;
    }
}
