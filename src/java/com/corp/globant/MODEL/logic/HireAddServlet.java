package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.dao.*;
import com.corp.globant.MODEL.beans.*;
import com.corp.globant.MODEL.logic.*;
import com.corp.globant.VIEW.beans.*;
import com.google.gson.*;
import java.io.*;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
/**
 *
 * @author ramiro.acoglanis
 */
@WebServlet (name="HireAddServlet", urlPatterns={"/HireAdd"})
public class HireAddServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=utf-8");
        FrmUserAdd frmUserAdd = new Gson().fromJson(request.getReader(), FrmUserAdd.class);
        
        Hire hire = buildHire(frmUserAdd);
        JsonParser parser = new JsonParser();
        JsonObject comeBack = (JsonObject)parser.parse("{\"data\": \"HireAddServlet\"}");
        
        try {
            hire = new ValidateHire().validate(hire);
            System.out.println(hire.getName());
            System.out.println(hire.getLastname());
            System.out.println(hire.getDomainUser());
            System.out.println(hire.getEmail());
            System.out.println(hire.getCountry());
            System.out.println(hire.getIdNumber());
            System.out.println(hire.getPosition());
            
            
            HiresDAOpsql.create(ConnectionManager.getConnection(), hire);
            
            comeBack = (JsonObject)parser.parse(new Gson().toJson(hire));
        } catch (ValidateException ex) {
            comeBack.addProperty("error",ex.getMessage());
        } catch (Exception ex) {
            comeBack.addProperty("error",ex.getMessage());
        }finally{
            response.getWriter().print(comeBack);
            out.flush();
        }
    }
    
    
    public static Hire buildHire(FrmUserAdd frm){
        Hire hire = new Hire();
        //Set Name
        hire.setName(frm.getName());
        //Set LastName
        hire.setLastname(frm.getLastName());
        //Set ID Number
        hire.setIdNumber(frm.getIdentificationNumber());
        //Set DomainUser
        hire.setDomainUser(frm.getDomainUser());
        //Set eMail
        hire.setEmail(frm.getEmail());
        //Set EmailGroup
        hire.setEmailGroup(new EmailGroup(frm.getEmailGroup()));
        //Set Position
        hire.setPosition(new Position(frm.getPosition()));
        //Set Location
        hire.setLocation(new Location(frm.getLocation()));
        //Set Phone Number
        hire.setPhoneNumber(frm.getPhoneNumber());
        //Set Country
        hire.setCountry(new Country(frm.getCountry()));
        //Set SubOrg
        hire.setSuborg(new SubOrg(frm.getSubOrganization()));
        
        return hire;
    }
    
}
