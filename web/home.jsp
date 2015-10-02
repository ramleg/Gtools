<%-- 
    Document   : home
    Created on : Sep 19, 2015, 12:12:06 PM
    Author     : Ramiro Acoglanis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.corp.globant.MODEL.dao.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="webs/commonHead.html" />
    </head>
    <body>
        <%@include file="webs/mainMenu.jsp" %>
        <!--<object data="webs/loginForm.html"></object>-->
        
    <div class="container">
     <div class="panel panel-danger">
      <div class="panel-heading">Active Directory Alerts</div>
      <div class="panel-body">Alerts list</div>
     </div>
     <div class="panel panel-danger">
      <div class="panel-heading">Database Alerts</div>
      <div class="panel-body">Alerts list</div>
     </div>
    </div>
    </body>
</html>
