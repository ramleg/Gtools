
package com.corp.globant.VIEW;

import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.HiresDAOpsql;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "GetHiresList", urlPatterns = {"/GetHiresList"})
public class GetHiresList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList responseList = new ArrayList();
        response.setContentType("application/json; charset=utf8");
        try {
            responseList = HiresDAOpsql.getAllmini(ConnectionManager.getConnection());
        } catch (Exception ex) {
            Logger.getLogger(GetLocationList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(responseList));
            out.flush();
        }
        
       
    }

}
