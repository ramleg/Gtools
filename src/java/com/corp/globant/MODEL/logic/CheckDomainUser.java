package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.Errors;
import com.corp.globant.MODEL.beans.User;
import com.corp.globant.MODEL.beans.ValidateException;
import com.corp.globant.MODEL.dao.LdapDAO;
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
 * @author ramiro.acoglanis
 */
@WebServlet(name = "CheckDomainUser", urlPatterns = {"/CheckDomainUser"})
public class CheckDomainUser extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=utf8");
        User user = new Gson().fromJson(request.getReader(), User.class);
        Errors errors = new Errors();
        
        try {
            validateDomainUser(user);
        } catch (ValidateException ex) {
            errors.addError(ex.getMessage());
        }finally{
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(errors));
            out.flush();
        }
    }

    
    public void validateDomainUser(User user) throws ValidateException{
        
        Validator v = new Validator();
        
        if(user.getDomainUser().isEmpty())
            throw new ValidateException("The field is empty");
        if (!v.forbiddenCaracters(user.getDomainUser().toLowerCase(), "[^a-z.]"))
            throw new ValidateException("Forbidden characters");
        if(!v.maxLength(user.getDomainUser(), 21))
            throw new ValidateException("Too many characters");
        if(!v.dotCheck(user.getDomainUser()))
            throw new ValidateException("Dot error");
        if(v.existInDB(user.getDomainUser()))
            throw new ValidateException("User already exists in DB");
        if(v.existInAD(user.getDomainUser()))
            throw new ValidateException("User already exists in AD");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
