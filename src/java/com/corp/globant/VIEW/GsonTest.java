package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;

public class GsonTest extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Gson gson = new Gson();
        User user = gson.fromJson(req.getReader(), User.class);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getLastname());
        System.out.println(user.getDomainUser());
        System.out.println(user.getRol());
        
//        resp.setContentType("application/json");
//        resp.getWriter().write("{\"key\":\"hello\",\"key2\":\"world\"}");
    }
}