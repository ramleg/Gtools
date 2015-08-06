<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.corp.globant.MODEL.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.corp.globant.MODEL.PaisDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <%@include file="webs/commonHead.html" %>

<script> //SUBMIT
  $(document).ready(function(){
    $("#btn-submit").click(function(){
      $("#modal-submit").modal();
    });
  });
</script>
  
</head>
<body>
 
<%@include file="webs/mainMenu.html" %> <!-- Llama al menu-->
    
<div class="container">
    <form class="form-horizontal" role="form" id="form-sites">
       
     <div class="form-group"> 
      <label class="control-label col-sm-2" for="pais">Pais: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="ddl_pais">
           <%
               Connection conn = ConnectionManager.getConnection();
               ArrayList ddlPais = PaisDAO.getAll(conn);
               pageContext.setAttribute("paises", ddlPais);
           %>
            <c:forEach items="${paises}" var="current">
               <option value="<c:out value="${current.id}"/>"><c:out value="${current.desc}"/></option>
            </c:forEach>
       </select>
      </div>
     </div>
       
      <div class="row form-group">
       <label class="control-label col-sm-2" for="txt_site">Site Name: </label>
       <div class="col-sm-10" style="left: 0px; top: 0px; width: 400px">
        <input type="text" class="form-control" id="txt_site" value="" data-bvStrict="notEmpty" placeholder="Site name" style="width: 100%">
        <div class="help-block error-message">Required Field</div>
       </div>
      </div>
      <div class="row form-group">
       <label class="control-label col-sm-2" for="txt_site_ou">Site OU: </label>
       <div class="col-sm-10" style="left: 0px; top: 0px; width: 50%">
        <input type="text" class="form-control" id="txt_site_ou" value="" data-bvStrict="notEmpty" placeholder="Site OU" style="width: 100%">
        <div class="help-block error-message">Required Field</div>
       </div>
      </div>
 
      <div class="row form-group">
       <label class="control-label col-sm-2" for="txt_site_sap">Site SAP: </label>
       <div class="col-sm-10" style="left: 0px; top: 0px; width: 50%">
        <input type="text" class="form-control" id="txt_site_sap" value="" data-bvStrict="notEmpty" placeholder="Site SAP" style="width: 100%">
        <div class="help-block error-message">Required Field</div>
       </div>
      </div>
        
       <div class="col-sm-8">
        <button id="btn-submit" type="button" class="btn btn-success pull-right">Submit</button>
       </div>
        
   </form>
</div>

<div class="container" style="width:90%">
  <div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%;background-color:black">
    </div>
  </div>
</div>

<div id="div-grilla" class="container table-responsive">
  <table id="grid-sites" class="table2excel js-dynamitable table table-bordered table-hover">
    <thead>
      <tr class="success"> <!--Encabezado mas botones de Asc y Desc-->
        <th id="ID" style="text-align:center;width:15%">ID<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="site" style="text-align:center;width:30%">Site <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="site_ou" style="text-align:center">Site OU <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="site_sap" style="text-align:center">Site SAP <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>    
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Laminar</td>
        <td>Mendoza 123</td>
        <td>Mendoza 123</td>
      </tr>
    </tbody>
   </table> 
</div> 
<div class="container">
 <button id="btn-export" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-export"></span> Export file .XLS</button>
 <!-- Funcion de Exportacion -->
 <script>
 $("#btn-export").click(function(){
   $("#grid-sites").table2excel({ filename: "Export Sites"
   });
 });
 </script>
 <br>
</div>

<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<!--Funcion de busqueda en grilla-->
<script>
  $(document).ready( function () {
    $('#grid-sites').bdt();
  });
</script>
<!--Funcion de validaciones-->
<script type="text/javascript">
 $(function(){
  $('#form-sites').bValidator();
 });
</script>
  <!-- Modal-Submit -->
  <div class="modal fade" id="modal-submit" role="dialog">
    <div class="modal-dialog modal-sm">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <div class="alert alert-success">
              <strong>Site submitted successfully</strong> 
            </div>
            <div class="modal-footer">
             <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>              
        </div>  
      </div>
    </div>    
  </div>

</body>
</html>