<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.corp.globant.MODEL.beans.*"%>
<%   User userLogged = (User) session.getAttribute("UserLogged");  %>
<link rel="stylesheet" href="resources/css/navbar.css">
<nav class="navbar navbar-inverse">
    
    <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <img src="resources/img/gtools1.png" alt="Gtools"/>
    </div>
    
    

    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
         <li class="dropdown"><a href="home.jsp">Home</a></li>
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Hires<span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="AddNH">Single New Hires</a></li>
              <li><a href="UpdateNH">Update & Delete</a></li>
            <li><a href="">Process Overview</a></li>
          </ul>
         </li>
        <!--<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: #000">Positions<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="positions.jsp">Alta Positions</a></li>
            <li><a href="#">Search Positions</a></li>
          </ul>
        </li>-->
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Sites<span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="abm-sites.jsp">Alta Sites</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Internos<span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="internos.jsp">Import Internos</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li><a style="color: #000"><span class="glyphicon glyphicon-user" ></span> <%= userLogged.getDomainUser()%></a></li>
        <li><a href="Logout" style="color: #000"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div> 
  </div>
</nav>