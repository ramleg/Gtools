<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Connection"%>
<%@page import="com.corp.globant.MODEL.dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <%@include file="webs/commonHead.html" %>
  <%
      Connection conn = ConnectionManager.getConnection();
    %>
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
    
<div class="container-fluid" style="width: 90%">
  <div class="panel panel-primary">
    <div class="panel-heading">Alta de Sites</div>
    <div class="panel-body">
        <form class="form-horizontal" role="form" id="form-sites">
         <div class="form-group"> 
          <label class="control-label col-sm-2" for="ddl_pais">Country: </label> 
          <div class="col-sm-10" style="width:40%">
           <select class="form-control" id="ddl_pais">
               <%
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
           <div class="col-sm-10" style="left: 0px; top: 0px; width: 58%">
            <input type="text" class="form-control" id="txt_site" value="" data-bvStrict="notEmpty" placeholder="Site name" style="width: 100%">
            <div class="help-block error-message">Required Field</div>
           </div>
         </div>
         <div class="row form-group">
           <label class="control-label col-sm-2" for="txt_site_ou">Site OU: </label>
           <div class="col-sm-10" style="left: 0px; top: 0px; width: 58%">
            <input type="text" class="form-control" id="txt_site_ou" value="" data-bvStrict="notEmpty" placeholder="Site OU" style="width: 100%">
            <div class="help-block error-message">Required Field</div>
           </div>
         </div>
        <div class="row form-group">
           <label class="control-label col-sm-2" for="txt_site_sap">Site SAP: </label>
           <div class="col-sm-10" style="left: 0px; top: 0px; width: 58%">
            <input type="text" class="form-control" id="txt_site_sap" value="" data-bvStrict="notEmpty" placeholder="Site SAP" style="width: 100%">
            <div class="help-block error-message">Required Field</div>
           </div>
        </div>    
        <div class="col-sm-9">
          <button id="btn-submit" type="button" class="btn btn-primary pull-right">Submit</button>
        </div>
       </form>
    </div>
  </div>
</div>

<div class="container-fluid" style="width: 90%">
  <div class="panel panel-primary">
    <div class="panel-heading">Listado de Sites</div>
    <div class="panel-body">   
        <div id="div-grilla" class="container-fluid table-responsive">
          <table id="grid-sites" class="table2excel js-dynamitable table table-bordered table-hover">
            <thead>
              <tr class="success"> <!--Encabezado mas botones de Asc y Desc-->
                <th id="ID" class="hidden" style="text-align:center;width:10%">ID<span class="js-sorter-desc glyphicon glyphion-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="site" style="text-align:center;width: auto;background-color: #C1D736">Site <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="site_ou" style="text-align:center;width: auto;background-color: #C1D736">SAP <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="site_sap" style="text-align:center;width: auto;background-color: #C1D736">AD <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>    
              </tr>
            </thead>
            <tbody>
                <%
                       ArrayList tableSites = SiteDAO.getAll(conn);
                       pageContext.setAttribute("sites", tableSites);
                %>
                <c:forEach items="${sites}" var="current">
                    <tr>
                    <td class="hidden"><c:out value="${current.id}"/></td>
                    <td><c:out value="${current.desc}"/></td>
                    <td><c:out value="${current.sap_desc}"/></td>
                    <td><c:out value="${current.ad_desc}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
           </table> 
        </div> 
        <div class="container-fluid">
            <button id="btn-export" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-export"></span> Export file .XLS</button>
            <br>
        </div>
    </div>
  </div>
</div>
        
 <!-- Funcion de Exportacion -->
 <script>
 $("#btn-export").click(function(){
   $("#grid-sites").table2excel({ filename: "Export Sites"
   });
 });
 </script>

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