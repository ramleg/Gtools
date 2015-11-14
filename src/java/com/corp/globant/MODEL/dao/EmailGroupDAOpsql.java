package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author ramiro.acoglanis
 */
public class EmailGroupDAOpsql {
    
    public static ArrayList<EmailGroup> getAll(Connection conn) throws Exception {
        // declare the arraylist
        ArrayList<EmailGroup> emailGroupList = new ArrayList();
        // set and execute the SQL query
        String query = 
                "SELECT \n" +
                "  email_groups.email_groups_id, \n" +
                "  email_groups.email_groups_desc, \n" +
                "  email_groups.email_groups_domain_group, \n" +
                "  locations.locations_id, \n" +
                "  locations.locations_desc\n" +
                "FROM \n" +
                "  app.email_groups, \n" +
                "  app.locations\n" +
                "WHERE \n" +
                "  email_groups.email_groups_location_fk = locations.locations_id;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // extract data from query
        EmailGroup emailGroup = new EmailGroup();
        Location location = new Location();
        while (rs.next()) {
            emailGroup.setId(rs.getString("email_groups_id"));
            emailGroup.setDesc(rs.getString("email_groups_desc"));
            emailGroup.setDomainGroup(rs.getString("email_groups_domain_group"));
            //set the Location Bean
            location.setId(rs.getString("locations_id"));
            location.setDesc(rs.getString("locations_desc"));
            //add the location to the field
            emailGroup.setLocation(location);
            //add the EmailGroup Bean to the ArrayList
            emailGroupList.add(emailGroup);
        }
        // close Statement and Connection
        stmt.close();
        conn.close();
        // Return the filled ArrayList
        return emailGroupList;
    }
    
    
    public static EmailGroup getById(Connection conn, String id) throws SQLException{
        
        String query = "SELECT * \n" +
        "FROM \n" +
        "  app.email_groups\n" +
        "WHERE\n" +
        "  email_groups_id=" + id + ";";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        EmailGroup emailGroup = new EmailGroup();
        if(rs.next()){
            emailGroup.setId(rs.getString("email_groups_id"));
        }else{
            emailGroup.setId("");
        }
        
        return emailGroup;
    }
}
