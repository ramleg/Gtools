package com.corp.globant.MODEL.dao;

import com.corp.globant.MODEL.beans.Country;
import com.corp.globant.MODEL.beans.PhoneNumber;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ramiro.acoglanis
 */
public class PhoneDAOpsql {

    public static PhoneNumber reserve (Connection conn, String countryFk)throws Exception{

        PhoneNumber reservedNumber = new PhoneNumber();
        Statement stmt = conn.createStatement();
        ResultSet rs;
        String query;
        
        query =  "SELECT * FROM app.telephony\n" +
                 "WHERE (telephony_reserved = false AND telephony_countries_fk = 1)\n" +
                 "ORDER BY telephony_number LIMIT 1;";
        
        rs = stmt.executeQuery(query);
        rs.next();
        reservedNumber.setNumber(rs.getString("telephony_number"));
        System.out.println(reservedNumber.getNumber());
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
    
    
}
