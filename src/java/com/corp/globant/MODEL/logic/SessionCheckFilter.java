package com.corp.globant.MODEL.logic;

import com.corp.globant.MODEL.beans.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author ramiro.acoglanis
 */
public class SessionCheckFilter implements Filter {

  private String contextPath;

  @Override
  public void init(FilterConfig fc) throws ServletException {
    contextPath = fc.getServletContext().getContextPath();
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;  

    if (req.getSession().getAttribute("UserLogged") == null) { //checks if there's a LOGIN_USER set in session...
        res.sendRedirect("LoginPage"); //or page where you want to redirect
    } else {
      User user = (User) req.getSession().getAttribute("UserLogged");
      String userRol = user.getRol();
      if (!userRol.equals("ADMIN")){ //check if user type is not admin
        res.sendRedirect("LoginPage"); //or page where you want to  
      }
      fc.doFilter(request, response);
    }
  }
  @Override
  public void destroy() {
  }
}