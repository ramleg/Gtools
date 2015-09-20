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
public class SiteDAOpsql {
    
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList sites = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = 
                "SELECT \n" +
                "  sites.sites_id, \n" +
                "  sites.sites_desc, \n" +
                "  sites.sites_sap_desc, \n" +
                "  sites.sites_ad_desc, \n" +
                "  sites.sites_fk_pais, \n" +
                "  pais.pais_desc\n" +
                "FROM \n" +
                "  app.sites, \n" +
                "  app.pais\n" +
                "WHERE \n" +
                "  sites.sites_fk_pais = pais.pais_id;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        while (rs.next()) {
            Site elSite = new Site();
            Pais elPais = new Pais();
            elSite.setId(rs.getString("sites_id"));
            elSite.setDesc(rs.getString("sites_desc"));
            elSite.setSap_desc(rs.getString("sites_sap_desc"));
            elSite.setAd_desc(rs.getString("sites_ad_desc"));
            //cargo el pais en su bean
            elPais.setId(rs.getInt("sites_fk_pais"));
            elPais.setDesc(rs.getString("pais_desc"));
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
