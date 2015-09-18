<%-- 
    Document   : test
    Created on : Aug 21, 2015, 1:13:15 PM
    Author     : ramiro.acoglanis
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Connection"%>
<%@page import="com.corp.globant.MODEL.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="webs/commonHead.html" %>
    </head>
    <body>
        <h1>Ajax Test</h1>
        <button id="button">Ver Mensaje</button>
        <div id="salida">
            
        </div>
        
        <script>
            $(function(){
                $("#button").click(function(){
                    ajaxRequest();
                }); 
            });
            
            function ajaxRequest(){
                var $salida = $('#salida');
                $.ajax({
                  type: 'GET',
                  url: 'http://localhost:8080/Gtools/Ajax',
                  success: function(data) {
                    $salida.append('El Nombre es: ' + data.apellido);
                  },
                  error:function() {
                    alert('Error!!');
                  }
                });
            }
        </script>
        
    </body>

</html>
