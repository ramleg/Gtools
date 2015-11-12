package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.EmailDomain;
import com.corp.globant.MODEL.beans.Flag;
import com.corp.globant.MODEL.beans.Hire;
import com.corp.globant.MODEL.beans.SubDomain;
import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.EmailDomainDAOpsql;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author ramiro.acoglanis
 */
@WebServlet(name = "GetEmailDomain", urlPatterns = {"/GetEmailDomain"})
public class GetEmailDomain extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<EmailDomain> responseList = new ArrayList();
        response.setContentType("application/json; charset=utf8");
        
        try {
                Flag flag = new Gson().fromJson(request.getReader(), Flag.class);
                responseList = EmailDomainDAOpsql.getAllBySubdomain(ConnectionManager.getConnection(), flag.getFlag());
                
        } catch (Exception ex) {
            Logger.getLogger(GetSubDomainList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(responseList));
            out.flush();
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
