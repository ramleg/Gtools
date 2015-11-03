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
public class LocationDAOpsql {
    
    public static ArrayList<Location> getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList<Location> locations = new ArrayList();
        // Arma la consulta y la ejecuta
        String query = 
                "SELECT \n" +
                "  locations.locations_id, \n" +
                "  locations.locations_desc, \n" +
                "  locations.locations_sap_desc, \n" +
                "  locations.locations_ad_ou, \n" +
                "  countries.countries_id, \n" +
                "  countries.countries_desc\n" +
                "FROM \n" +
                "  app.locations, \n" +
                "  app.countries\n" +
                "WHERE \n" +
                "  locations.locations_country_fk = countries.countries_id;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // Obtiene los datos
        while (rs.next()) {
            Location location = new Location();
            Country country = new Country();
            location.setId(rs.getString("locations_id"));
            location.setDesc(rs.getString("locations_desc"));
            location.setSap_desc(rs.getString("locations_sap_desc"));
            location.setAd_desc(rs.getString("locations_ad_ou"));
            //cargo el pais en su bean
            country.setId(rs.getString("countries_id"));
            country.setDesc(rs.getString("countries_desc"));
            //cargo el bean de pais en el bean del Location
            location.setCountry(country);

            locations.add(location);
        }
        // Cierra el Statement y la Connection
        stmt.close();
        // Retorna el ArrayList de Sites
        return locations;
    }
    
}
