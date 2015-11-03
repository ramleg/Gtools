package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.Flag;
import com.corp.globant.MODEL.beans.SubDomain;
import com.corp.globant.MODEL.dao.*;
import com.google.gson.*;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 *
 * @author ramiro.acoglanis
 */
@WebServlet(name = "GetSubDomainList", urlPatterns = {"/GetSubDomainList"})
public class GetSubDomainList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<SubDomain> responseList = new ArrayList();
        response.setContentType("application/json; charset=utf8");
        
        try {
                Flag flag = new Gson().fromJson(request.getReader(), Flag.class);
                responseList = SubDomainDAOpsql.getAllbyCategory(ConnectionManager.getConnection(), flag.getFlag());
        } catch (Exception ex) {
            Logger.getLogger(GetSubDomainList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(responseList));
            out.flush();
        }
    }
}
