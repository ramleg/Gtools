<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.corp.globant.MODEL.dao.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
    <jsp:include page="webs/commonHead.html" />
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
            </div>
            <ul class="nav navbar-nav navbar-right">
              <li><a><span class="glyphicon glyphicon-wrench"></span>  IST Service Desk </a></li>
            </ul>
        </div>
    </nav> 
      <div class="container" id="login" role="dialog">
        <div class="modal-dialog modal-sm">
          <!-- Modal content-->
          <div class="modal-content" style="background-color:#C1D736">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4><span class="glyphicon glyphicon-lock"></span>Login</h4>
            </div>
            <div class="modal-body"> 
                <form role="form" method="POST" action="Login" id="frm-modal">
                    <div class="form-group">
                     <label for="email">User:</label>
                     <input type="text" name="txt-username" id="txt-username" class="form-control" placeholder="Username">
                    </div>
                    <div class="form-group">
                     <label for="pwd">Password:</label>
                     <input type="password" name="txt-passwd" id="txt-passwd" class="form-control" placeholder="Password">
                    </div>
                       <button type="submit" id="btn-login" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-log-in"></span> Login</button>
                </form>
            </div>
          </div>
        </div>
       </div>
    </body>
</html>