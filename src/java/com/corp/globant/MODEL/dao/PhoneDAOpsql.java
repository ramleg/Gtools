package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.Country;
import com.corp.globant.MODEL.beans.PhoneNotFoundException;
import com.corp.globant.MODEL.beans.PhoneNumber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramiro.acoglanis
 */
public class PhoneDAOpsql {

    public static PhoneNumber reserve (Connection conn, String countryFk)throws SQLException{
        
        PhoneNumber reservedNumber = new PhoneNumber();
        Statement stmt = conn.createStatement();
        ResultSet rs;
        String query;
        
        query =  "SELECT * FROM app.telephony\n" +
                 "WHERE (telephony_reserved = false AND telephony_countries_fk = " + countryFk + ")\n" +
                 "ORDER BY telephony_number LIMIT 1;";
        
        rs = stmt.executeQuery(query);
        rs.next();
        reservedNumber.setNumber(rs.getString("telephony_number"));
        query =  
                "UPDATE app.telephony\n" +
                "SET telephony_reserved = true\n" +
                "WHERE telephony_number = " + reservedNumber.getNumber()
                + ";";
        
        stmt.executeUpdate(query);
//        
        stmt.close();
        
        return reservedNumber;
    }
    
    public static void unreserved (Connection conn, String reservedNum) throws PhoneNotFoundException, SQLException{

        PhoneNumber reservedNumber = new PhoneNumber();
        Statement stmt;
        String query;
        
            query = "SELECT telephony_number FROM app.telephony WHERE telephony_number=" + reservedNum + ";";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()){
                
                query = "UPDATE app.telephony\n" +
                "SET telephony_reserved = false\n" +
                "WHERE telephony_number = " + reservedNum +";";
                stmt.executeUpdate(query);
                stmt.close();
            }else{
                stmt.close();
                throw new PhoneNotFoundException();
            }
        
        
    }
    
}
