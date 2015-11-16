package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.*;
import com.corp.globant.VIEW.beans.FrmUserAdd;
import java.sql.*;
import java.util.ArrayList;
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
            hire.setDomainUser("hires_domain_users");
            hire.setStatus("hires_status_fk");
        }
        stmt.close();
        return hire;
    }
    
    public static ArrayList<Hire> getAllmini (Connection conn) throws SQLException{
        
        ArrayList<Hire> hiresList = new ArrayList<Hire>();
        
        String query = "SELECT \n" +
        "hires.hires_id,\n" +
        "hires.hires_name,\n" +
        "hires.hires_lastname,\n" +
        "hires.hires_domain_user,\n" +
        "email_domains.email_domains_desc,\n" +
        "countries.countries_desc,\n" +
        "positions.positions_desc,\n" +
        "locations.locations_desc\n" +
        "FROM app.hires\n" +
        "INNER JOIN app.countries ON countries.countries_id = hires.hires_country_fk\n" +
        "INNER JOIN app.positions ON positions.positions_id = hires.hires_position_fk\n" +
        "INNER JOIN app.locations ON locations.locations_id = hires.hires_location_fk\n" +
        "INNER JOIN app.email_domains ON email_domains.email_domains_id = hires.hires_email_domain_fk\n" +
        "WHERE hires.hires_status_fk !=6\n" +  
        "ORDER BY hires.hires_id;";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Hire hire = new Hire();
            // Arma el objeto Hire
            hire.setId(rs.getString("hires_id"));
            hire.setName(rs.getString("hires_name"));
            hire.setLastname(rs.getString("hires_lastname"));
            hire.setDomainUser(rs.getString("hires_domain_user"));
            hire.setEmailDomian(new EmailDomain("",rs.getString("email_domains_desc")));
            hire.setCountry(new Country("", rs.getString("countries_desc")));
            hire.setPosition(new Position("", rs.getString("positions_desc")));
            hire.setLocation(new Location("", rs.getString("locations_desc")));
            
            
            hiresList.add(hire);
        }
        stmt.close();
        return hiresList;
        
    }
    
    public static void create(Connection conn, Hire hire) throws SQLException{
        
        String query = "BEGIN;"
                + "INSERT INTO app.hires"
                + "("
                + "hires_name, "
                + "hires_lastname, "
                + "hires_id_number, "
                + "hires_domain_user, "
                + "hires_position_fk, "
                + "hires_location_fk, "
                + "hires_email_domain_fk, "
                + "hires_email_group_fk, "
                + "hires_phone_number_fk, "
                + "hires_country_fk, "
                + "hires_subdomain_fk,"
                + "hires_desc"
                + ") " 
                + "VALUES "
                + "("
                + "'" + hire.getName() + "', "
                + "'" + hire.getLastname() + "', "
                + "'" + hire.getIdNumber() + "', "
                + "'" + hire.getDomainUser() + "', "
                + hire.getPosition().getId() + ", "
                + hire.getLocation().getId() + ", "
                + hire.getEmailDomian().getId() + ", "
                + hire.getEmailGroup().getId() + ", "
                + hire.getPhoneNumber() + ", "
                + hire.getCountry().getId() + ", "
                + hire.getSubDomain().getId()+ ", "
                + "'" + hire.getDescription() + "'"
                + ");"
                
                + "WITH new_values AS (\n" +
                "SELECT * FROM app.telephony \n" +
                "WHERE (telephony_user_assigned IS NULL AND telephony_countries_fk = " + hire.getCountry().getId() + ")\n" +
                "ORDER BY telephony_number LIMIT 1\n" +
                ")\n" +
                "UPDATE app.telephony AS up\n" +
                "SET telephony_user_assigned = '" + hire.getDomainUser() + "'\n" +
                "FROM new_values nv\n" +
                "WHERE nv.telephony_number = up.telephony_number;"
                + "COMMIT;";
        
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }
    
    public static void disable(Connection conn, Hire hire) throws SQLException {
        
        
        
    }
}
