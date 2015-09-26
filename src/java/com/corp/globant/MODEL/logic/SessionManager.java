package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.*;
import com.corp.globant.MODEL.dao.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author Ram
 */
@WebServlet (name="LoginServlet", urlPatterns={"/Login", "/Logout"})
public class SessionManager extends HttpServlet {
    
    private HttpSession session;
    private String contextPath;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // LOG OUT **************************************************************
        session = request.getSession(false);
        RequestDispatcher requestDispatcher; 

        if (session != null) {
            User user = (User) session.getAttribute("UserLogged");
            System.out.println("Closing session for: " + user.getDomainUser());
            session.invalidate();
            response.sendRedirect("LoginPage");
        }else{
            response.sendRedirect("LoginPage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //LOG IN ****************************************************************
        contextPath = getServletContext().getContextPath();

        try {
                Connection conn = ConnectionManager.getConnection();
                // Valida el usuario contra la Base de Datos interna
                User user = UserDAOpsql.getByUserDomain(conn, request.getParameter("txt-username"));
                // Valida usuario y contraseña contra el Dominio AD
                LdapDAO.validateUser(user.getDomainUser(), request.getParameter("txt-passwd"));

                HttpSession session = request.getSession(false);
                session.setAttribute("UserLogged", user);
                System.out.println("Login Session for: " + user.getDomainUser());
                response.sendRedirect("Home");
                //request.getRequestDispatcher("Home").forward(request, response);
            }
        catch(SQLException ex){
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Invalid User");
            response.sendRedirect("LoginPage");
        }
        catch(NamingException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Invalid Password");
            response.sendRedirect("LoginPage");
        }
        catch (Exception ex){
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Database connection error");
            response.sendRedirect("LoginPage");
        }
        finally{
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
