package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.Sub_Org;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author r.sanchez
 */
public class Sub_OrgDAOpsql {
        
    public static Sub_Org getById (Connection conn, String id)throws Exception{
        
        String laConsulta = "SELECT * FROM app.organization WHERE id=" + id + ";";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        Sub_Org sub_org = new Sub_Org();
        sub_org.setId(rs.getInt("org_id"));
        sub_org.setDesc(rs.getString("org_desc"));
        sub_org.setDom(rs.getString("org_domain"));
        
        stmtConsulta.close();
        
        return sub_org;
    }
    public static ArrayList getAll(Connection conn) throws Exception {
        // Construye la coleccion
        ArrayList suborg = new ArrayList();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM app.organization;";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        // Obtiene los datos
        
        while (rs.next()) {
            Sub_Org sub_org = new Sub_Org();
            // Arma el objeto Organization
            sub_org.setId(rs.getInt("org_id"));
            sub_org.setDesc(rs.getString("org_desc"));
            sub_org.setDom(rs.getString("org_domain"));
            // Agrega la coleccion
            suborg.add(sub_org);
        }
        // Cierra el Statement y la Connection
        stmtConsulta.close();
        // Retorna el alumno
        return suborg;
    }
}
