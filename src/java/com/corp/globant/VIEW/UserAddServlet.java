package com.corp.globant.VIEW;

import com.corp.globant.VIEW.beans.FrmUserAdd;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ramiro.acoglanis
 */
public class UserAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FrmUserAdd frmUserAdd = new Gson().fromJson(request.getReader(), FrmUserAdd.class);
        Gson gg = new Gson();
        ArrayList list = new ArrayList();
        list.add(frmUserAdd);
        list.add(frmUserAdd);
        list.add(frmUserAdd);
        System.out.println(gg.toJson(list));
        
        response.setContentType("application/json; charset=utf8");
        response.getWriter().print(list);
    }
}
