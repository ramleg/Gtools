package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author r.sanchez
 */
public class SubOrgDAOpsql {
        
    public static SubOrg getById (Connection conn, String id)throws Exception{
        
        String laConsulta = "SELECT * FROM app.suborg WHERE suborg_id=" + id + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        SubOrg sub_org = new SubOrg();
        sub_org.setId(rs.getInt("suborg_id"));
        sub_org.setDesc(rs.getString("suborg_desc"));
        sub_org.setDom(rs.getString("suborg_email"));
        
        stmtConsulta.close();
        
        return sub_org;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList suborg = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.suborg;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        
        while (rs.next()) {
            SubOrg sub_org = new SubOrg();
            // Arma el objeto Organization
            sub_org.setId(rs.getInt("suborg_id"));
            sub_org.setDesc(rs.getString("suborg_desc"));
            sub_org.setDom(rs.getString("suborg_email"));
            // Agrega la coleccion
            suborg.add(sub_org);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el alumno
        return suborg;
    }
}
