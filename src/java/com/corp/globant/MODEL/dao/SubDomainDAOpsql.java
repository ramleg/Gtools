package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Ramiro Acoglanis
 */
public class SubDomainDAOpsql {
        
    public static SubDomain getById (Connection conn, String id)throws Exception{
        
        String query = "SELECT * FROM app.subdomain WHERE subdomain_id=" + id + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        SubDomain subDomain = new SubDomain();
        if(rs.next()){
            subDomain.setId(rs.getString("subdomain_id"));
            subDomain.setDesc(rs.getString("subdomain_desc"));
            subDomain.setCategory(rs.getString("subdomain_category"));
        }else{
            subDomain.setId("");
        }
        stmt.close();
        conn.close();
        return subDomain;
    }
    
    public static ArrayList getAllbyCategory(Connection conn, String cat) throws Exception {
        // Construye la coleccion
        ArrayList<SubDomain> subDomainList = new ArrayList();
        // Arma la consulta y la ejecuta
        String query = "SELECT * FROM app.subdomain WHERE subdomain_category = '" + cat + "';";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // Obtiene los datos
        
        while (rs.next()) {
            SubDomain subDomain = new SubDomain();
            // Arma el objeto Organization
            subDomain.setId(rs.getString("subdomain_id"));
            subDomain.setDesc(rs.getString("subdomain_desc"));
            subDomain.setCategory(rs.getString("subdomain_category"));
            // Agrega la coleccion
            subDomainList.add(subDomain);
        }
        // Cierra el Statement y la Connection
        stmt.close();
        conn.close();
        return subDomainList;
    }

}
