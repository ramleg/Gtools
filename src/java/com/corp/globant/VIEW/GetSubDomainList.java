package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.Pinchila;
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
//        Pinchila flag = new Gson().fromJson(request.getReader(), Pinchila.class);
        Pinchila flag = new Pinchila();
        flag.setPinchi("GET");
        try {
                
                Connection conn = ConnectionManager.getConnection();
                responseList = SubDomainDAOpsql.getAllbyCategory(conn, flag.getPinchi());
                System.out.println(responseList.get(1));
        } catch (Exception ex) {
            Logger.getLogger(GetSubDomainList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(responseList));
            out.flush();
        }
    }
}
