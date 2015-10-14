package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import com.corp.globant.VIEW.beans.FrmUserAdd;
import java.sql.*;

/**
 *
 * @author ramiro.acoglanis
 */
public class HiresDAOpsql {
    public static Hire getByDomainUser (Connection conn, String domainUser) throws SQLException{
        
        String query = "SELECT * FROM app.hires WHERE hires_domain_user='" + domainUser + "';";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Hire hire = new Hire();
        if(rs.next()){
            hire.setId(rs.getString("hires_id"));
            
        }
        
        stmt.close();
        
        return hire;
    }
    
    public static void create(Connection conn, Hire hire) throws SQLException{
        
        String query = "INSERT INTO hires"
                + "() "
                + "("
                + hire.getName() + ", "
                + hire.getLastname() + ", "
                + hire.getIdNumber() + ", "
                + hire.getDomainUser() + ", "
                + hire.getEmail() + ", "
                + hire.getPosition().getId() + ", "
                + hire.getLocation().getId() + ", "
                + hire.getEmailGroup().getId() + ", "
                + hire.getPhoneNumber() + ", "
                + hire.getCountry().getId()
                + ")";
        Statement stmt = conn.createStatement();
        stmt.executeQuery(query);
        stmt.close();
        
    }
    
}
