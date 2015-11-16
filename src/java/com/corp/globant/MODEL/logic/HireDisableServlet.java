package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.*;
import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.HiresDAOpsql;
import com.corp.globant.VIEW.beans.FrmUserAdd;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Ram
 */
@WebServlet(name = "HireDisableServlet", urlPatterns = {"/HireDisableServlet"})
public class HireDisableServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=utf-8");
        FrmUserAdd frmUserAdd = new Gson().fromJson(request.getReader(), FrmUserAdd.class);
        Hire hire = buildHire(frmUserAdd);
        JsonParser parser = new JsonParser();
        JsonObject comeBack = new JsonObject();
        
        try {
            HiresDAOpsql.disable(ConnectionManager.getConnection(), hire);
            comeBack = (JsonObject)parser.parse("{\"sucsess\": \"User Disabled\"}");
        } catch (Exception ex) {
            comeBack = (JsonObject)parser.parse("{\"error\": \"Error while disabling the User\"}");
            Logger.getLogger(HireDisableServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            response.getWriter().print(comeBack);
            out.flush();
        }
        
    }

    private static Hire buildHire(FrmUserAdd frm){
        Hire hire = new Hire();
        //Set Name
        hire.setName(frm.getName());
        //Set LastName
        hire.setLastname(frm.getLastName());
        //Set ID Number
        hire.setIdNumber(frm.getIdNumber());
        //Set DomainUser
        hire.setDomainUser(frm.getDomainUser());
        //Set eMail
        hire.setEmailDomian(new EmailDomain(frm.getEmailDomain()));
        //Set EmailGroup
        hire.setEmailGroup(new EmailGroup(frm.getEmailGroup()));
        //Set Position
        hire.setPosition(new Position(frm.getPosition()));
        //Set Location
        hire.setLocation(new Location(frm.getLocation()));
        //Set Country
        hire.setCountry(new Country(frm.getCountry()));
        //Set SubDomain
        hire.setSubDomain(new SubDomain(frm.getSubDomain()));
        //Set Description
        hire.setDescription(frm.getDescription());
        
        return hire;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
