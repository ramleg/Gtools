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

    public static PhoneNumber getOneByCountry (Connection conn, String countryFk)throws Exception{

        String query =  "BEGIN;"
                        + "SELECT * FROM app.telephony "
                        + "WHERE (telephony_reserved = false AND telephony_countries_fk = 1) "
                        + "ORDER BY telephony_number LIMIT 1; "
//                        + "WITH new_values AS "
//                        + "("
//                        + "SELECT * FROM app.telephony "
//                        + "WHERE (telephony_reserved = false AND telephony_countries_fk = 1) "
//                        + "ORDER BY telephony_number LIMIT 1"
//                        + ")"
//                        + "UPDATE app.telephony AS up "
//                        + "SET telephony_reserved = true "
//                        + "FROM new_values nv "
//                        + "WHERE nv.telephony_number = up.telephony_number;"
                        + "COMMIT;";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.first();
        PhoneNumber reservedNumber = new PhoneNumber();
        reservedNumber.setNumber(rs.getString("telephony_number"));
        
        System.out.println(rs.getString("telephony_number"));
        
        stmt.close();
        
        return reservedNumber;
    }
    
    
}
