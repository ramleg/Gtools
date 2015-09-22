<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.corp.globant.MODEL.beans.*"%>
<%   User userLogged = (User) session.getAttribute("UserLogged");  %>
<nav class="navbar navbar-inverse" style="background-color:#C1D736">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                
      </button>
        <img src="resources/img/Logo.JPG" alt="GlOBANT">
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
          <li class="dropdown"><a href="home.jsp" style="color:black">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background-color:#C1D736;color:black">Users<span class="caret"></span></a>
          <ul class="dropdown-menu" style="background-color:#C1D736">
              <li><a href="abm-users.jsp">Alta Usuarios</a></li>
            <li><a href="import-nh.jsp">Import Users</a></li>
            <li><a href="search-users.jsp">Search users</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background-color:#C1D736;color:black">Positions<span class="caret"></span></a>
          <ul class="dropdown-menu" style="background-color:#C1D736">
              <li><a href="positions.jsp">Alta Positions</a></li>
            <li><a href="#">Search Positions</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background-color:#C1D736;color:black">Sites<span class="caret"></span></a>
          <ul class="dropdown-menu" style="background-color:#C1D736">
              <li><a href="abm-sites.jsp">Alta Sites</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background-color:#C1D736;color:black">Internos<span class="caret"></span></a>
          <ul class="dropdown-menu" style="background-color:#C1D736">
              <li><a href="internos.jsp">Import Internos</a></li>
          </ul>
        </li>
        <li class="dropdown">
            <a href="" style="background-color:#C1D736;color:black">Test Grillas</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li><a style="color:black"><span class="glyphicon glyphicon-user" style="color:black"></span><%= userLogged.getUserId() %></a></li>
        <li><a href="Login" style="color:black"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div> 
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-sm">
          <!-- Modal content-->
            <div class="modal-content" style="background-color:#C1D736">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
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
                        <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-log-in"></span> Login</button>
                    </form>     
                </div>
            </div>
        </div>
    </div>
    <!-- Fin Modal -->
  </div>
</nav>