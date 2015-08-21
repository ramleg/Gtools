<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.corp.globant.GLBAPI.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>GTools - IST Service Desk</title>
    <jsp:include page="webs/commonHead.html" />
</head>
<body>
    <nav class="navbar navbar-inverse" style="background-color:#C1D736">
        <div class="container-fluid">
            <div class="navbar-header">
                <img src="resources/img/Logo.JPG" alt="GlOBANT">
            </div>
            <ul class="nav navbar-nav navbar-right">
              <li><a style="color:black; font-style: inherit; font-size: 18px"><span class="glyphicon glyphicon-wrench" style="color: black; "></span>  IST Service Desk </a></li>
            </ul>
        </div>
    </nav> 
      <div class="container" id="login" role="dialog">
        <div class="modal-dialog modal-sm">
          <!-- Modal content-->
          <div class="modal-content" style="background-color:#C1D736">
            <div class="modal-header">
              <h4><span class="glyphicon glyphicon-lock"></span>Login</h4>
            </div>
            <div class="modal-body"> 
              <form role="form" action="login" id="frm-modal">
               <div class="form-group">
                <label for="email">User:</label>
                <input type="text" class="form-control" id="txt-usr" placeholder="Username">
               </div>
               <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="txt-pwd" placeholder="Password">
               </div>
                  <a type="submit" class="btn btn-primary btn-block" href="main.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a>
              </form>     
            </div>
          </div>
        </div>
       </div>
    </body>
</html>