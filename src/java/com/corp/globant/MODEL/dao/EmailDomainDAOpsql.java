package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.EmailDomain;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ramiro.acoglanis
 */
public class EmailDomainDAOpsql {
    
    public static ArrayList<EmailDomain> getAllBySubdomain(Connection conn, String subdomain) throws Exception {
        ArrayList<EmailDomain> emailDomainList = new ArrayList();
        
        String query = "SELECT \n" +
        "  email_domains.email_domains_id, \n" +
        "  email_domains.email_domains_desc\n" +
        "FROM \n" +
        "  app.email_domains\n" +
        "WHERE\n" +
        "  email_domains.email_domains_subdomain_fk\n" +
        "  =" + subdomain + ";";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            EmailDomain emailDomain = new EmailDomain();
            emailDomain.setId(rs.getString("email_domains_id"));
            emailDomain.setDesc(rs.getString("email_domains_desc"));
            
            emailDomainList.add(emailDomain);
        }
        return emailDomainList;
    }
    
    public static EmailDomain getById(Connection conn, String id) throws SQLException{
        
        String query = "SELECT * \n" +
        "FROM \n" +
        "  app.email_domains\n" +
        "  WHERE\n" +
        "  email_domains_id=" + id + ";";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        EmailDomain emailDomain = new EmailDomain();
        
        if(rs.next()){
            emailDomain.setId(rs.getString("email_domains_id"));
            emailDomain.setDesc(rs.getString("email_domains_desc"));
            emailDomain.setSubDomain(rs.getString("email_domains_subdomain_fk"));
        }else{
            emailDomain.setId("");
        }
        
        return emailDomain;
    }
    
}
