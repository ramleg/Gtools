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
        
        FrmUserAdd frmUserAdd = new Gson().fromJson(request.getReader(), FrmUserAdd.class);
        response.setContentType("application/json; charset=utf-8");
        
        
        
        
        System.out.println(new ValidateHire().validate(null));
        
        
    }
    
    
    public static Hire buildHire(Connection conn, FrmUserAdd frm) throws SQLException{
                
        Hire hire = new Hire();
        Statement stmt = conn.createStatement();
        ResultSet rs;
        //Set Name
        hire.setName(frm.getName());
        //Set LastName
        hire.setLastname(frm.getLastName());
        //Set DomainUser
        hire.setDomainUser(frm.getDomainUser());
        //Set Email
        
        return new Hire();
    }
    
}
