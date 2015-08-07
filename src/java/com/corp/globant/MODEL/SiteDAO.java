package com.corp.globant.MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class SiteDAO {
    
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList sites = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = 
                "SELECT sites.id, sites.desc, sites.sap_desc, sites.ad_desc, pais.desc, sites.fk_pais "
                + "FROM app.sites, app.pais "
                + "WHERE sites.fk_pais = pais.id;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        
        while (rs.next()) {
            Site elSite = new Site();
            Pais elPais = new Pais();
            elSite.setId(rs.getString("id"));
            elSite.setDesc(rs.getString("desc"));
            elSite.setSap_desc(rs.getString("sap_desc"));
            elSite.setAd_desc(rs.getString("ad_desc"));
            //cargo el pais en su bean
            elPais.setId(rs.getInt("fk_pais"));
            elPais.setDesc(rs.getString("desc"));
            //cargo el bean de pais en el bean del Site
            elSite.setPais(elPais);
            // Agrega el alumno a la coleccion
            sites.add(elSite);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el ArrayList de Sites
        return sites;
    }
    
}
