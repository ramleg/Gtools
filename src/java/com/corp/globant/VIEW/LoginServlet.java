package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;

public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str;
        while((str = br.readLine()) != null ){
            sb.append(str);
        }
        System.out.print("--->str" +sb.toString());
        Gson gson = new Gson();
        System.out.print("--->" + req.getReader());
        User user = gson.fromJson(req.getReader(), User.class);
        System.out.println(user.getName());
        
        //System.out.println(sb.toString());
        
        resp.setContentType("application/json");
        resp.getWriter().write("{\"key\":\"hello\",\"key2\":\"world\"}");
    }
}