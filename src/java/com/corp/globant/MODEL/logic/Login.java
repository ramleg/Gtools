package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.LdapDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ram
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String user = request.getParameter("txt-username");
        String passwd = request.getParameter("txt-passwd");
        
        try {
            if(validateUser(user)){
                System.out.println("usuario validado");
                LdapDAO.getContext(user, passwd);
                response.sendRedirect("home.jsp");
            }else{
                System.out.println("usuario incorrecto");
                response.sendRedirect("http://localhost:8080/Gtools");
            }
        } catch(NamingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Invalid Password");
            response.sendRedirect("http://localhost:8080/Gtools");
        } catch(Exception ex){
            System.out.println("General Exception");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validateUser (String user) throws Exception{
        
        Connection conn = ConnectionManager.getConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT user_domain FROM app.users WHERE user_domain='" + user + "'";
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()){
            stmt.close();
            return true;
        }else{
            stmt.close();
            return false;
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
