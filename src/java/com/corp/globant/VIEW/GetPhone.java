package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.PhoneNumber;
import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.CountryDAOpsql;
import com.corp.globant.MODEL.dao.PhoneDAOpsql;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ramiro.acoglanis
 */
@WebServlet(name = "GetPhone", urlPatterns = {"/GetPhone"})
public class GetPhone extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=utf8");
        PhoneNumber reservedNumber = new PhoneNumber();
        try {
            reservedNumber = PhoneDAOpsql.getOneByCountry(ConnectionManager.getConnection(),"1");
        } catch (Exception ex) {
            Logger.getLogger(GetCountryList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(reservedNumber));
            out.flush();
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
