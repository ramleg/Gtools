package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.*;

/**
 *
 * @author ramiro.acoglanis
 */
public class HiresDAOpsql {
    public static Hire getByDomainUser (Connection conn, String domainUser) throws SQLException{
        
        String laConsulta = "SELECT * FROM app.hires WHERE hires_domain_user='" + domainUser + "';";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        Hire hire = new Hire();
        if(rs.next()){
            hire.setId(rs.getString("hires_id"));
            
        }
        
        stmtConsulta.close();
        
        return hire;
    }
}
