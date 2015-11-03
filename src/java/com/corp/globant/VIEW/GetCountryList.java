package com.corp.globant.VIEW;

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
 * @since 2015-10-04
 * @author ramiro.acoglanis
 */
@WebServlet(name = "GetCountryList", urlPatterns = {"/GetCountryList"})
public class GetCountryList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList responseList = new ArrayList();
        response.setContentType("application/json; charset=utf8");
        try {
            responseList = CountryDAOpsql.getAll(ConnectionManager.getConnection());
        } catch (Exception ex) {
            Logger.getLogger(GetCountryList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(responseList));
            out.flush();
        }
    }
}
