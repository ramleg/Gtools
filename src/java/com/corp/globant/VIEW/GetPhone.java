package com.corp.globant.VIEW;

import com.corp.globant.MODEL.beans.PhoneNotFoundException;
import com.corp.globant.MODEL.beans.PhoneNumber;
import com.corp.globant.MODEL.dao.ConnectionManager;
import com.corp.globant.MODEL.dao.CountryDAOpsql;
import com.corp.globant.MODEL.dao.PhoneDAOpsql;
import com.corp.globant.VIEW.beans.PhoneData;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ramiro.acoglanis
 */
@WebServlet(name = "GetPhone", urlPatterns = {"/GetPhone"})
public class GetPhone extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=utf8");
        PhoneNumber reservedNumber = new PhoneNumber();
        HttpSession session = request.getSession();
        
        if(session.getAttribute("sessionReservedPhone")== null){
            session.setAttribute("sessionReservedPhone", "");
        }
        
        PhoneData phoneData = new Gson().fromJson(request.getReader(), PhoneData.class);

        try {
            Connection conn = ConnectionManager.getConnection();
            
            if (phoneData.getNumber().equals("")){

                if(session.getAttribute("sessionReservedPhone").equals("")){
                    
                    reservedNumber = PhoneDAOpsql.reserve(conn, phoneData.getCountyId());
                    session.setAttribute("sessionReservedPhone", reservedNumber.getNumber());
                    
                    
                }else{
                    reservedNumber.setNumber(session.getAttribute("sessionReservedPhone").toString());
                    session.setAttribute("sessionReservedPhone", "");
                }
                
            }else{
                PhoneDAOpsql.unreserved(conn, phoneData.getNumber());
            }
            
        } catch (PhoneNotFoundException ex) {
            System.out.println("Phone Not Found");
            reservedNumber.setNumber(session.getAttribute("sessionReservedPhone").toString());
        }
        catch (SQLException ex) {
            Logger.getLogger(GetCountryList.class.getName()).log(Level.SEVERE, null, ex);
        }    
        catch (Exception ex) {
            Logger.getLogger(GetCountryList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(reservedNumber));
            out.flush();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
