package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.dao.*;
import com.corp.globant.MODEL.beans.*;
import com.corp.globant.VIEW.beans.*;
import com.google.gson.*;
import java.io.*;
import static java.lang.System.out;
import java.sql.Connection;
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
        System.out.println(frmUserAdd.getDomainName());
        response.getWriter().print("OK");
        
        
    }
}
