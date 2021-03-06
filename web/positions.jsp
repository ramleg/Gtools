<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.corp.globant.MODEL.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.corp.globant.MODEL.PositionDAO"%>
<%@page import="com.corp.globant.MODEL.OuPositionsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <meta charset="utf-8">
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
  <style type="text/css">
  .auto-style1 {
	  position: relative;
	  min-height: 1px;
	  float: left;
	  width: 100%;
	  margin-bottom: 0px;
	  padding-left: 15px;
	  padding-right: 15px;
  }
  </style>

</head>
<body>

<%@include file="webs/mainMenu.html" %>
  
<div class="container-fluid" style="width: 90%">
  <div class="panel panel-primary">
    <div class="panel-heading">Alta de Posiciones</div>
    <div class="panel-body">
      <form class=" row form-horizontal" role="form" id="form-positions">
         <div class="form-group"> 
          <label class="control-label col-sm-4" for="id-uoorg">UO Positions: </label> 
          <div class="col-sm-8" style="width: 40%">
           <select class="form-control" id="id-uoorg">
                 <%
                   ArrayList ddlOuPosition = OuPositionsDAO.getAll(conn);
                   pageContext.setAttribute("oupositions", ddlOuPosition);
                 %>
                 <c:forEach items="${oupositions}" var="current"> 
                    <option id="opt_ouposition" value="<c:out value="${current.id}"/>"><c:out value="${current.desc}"/> -- [ <c:out value="${current.ou}"/> ]
                    </option>
                 </c:forEach>
           </select>
          </div>
         </div>  
         <div class="form-group">
          <label class="control-label col-sm-4" for="txt-position">New Position: </label>
          <div class="col-sm-8" style="width: 40%"> 
           <input type="text" class="form-control" id="txt-position" data-bvStrict="notEmpty" placeholder="Position">
           <div class="help-block error-message">Required Field</div>
          </div>
          <div>
           <button id="btn-submit" type="button" class="btn btn-primary pull-left">Submit</button>
          </div>
         </div>
       </form>
    </div>
  </div>
</div>

<div class="container-fluid" style="width: 90%">
    <div class="panel panel-primary">
        <div class="panel-heading">Alta de Posiciones</div>
        <div class="panel-body">
            <div id="div-grilla" class="container table-responsive" style="width:90%">
              <table id="grid-user" class="js-dynamitable table table-bordered table-hover">
                <thead>
                  <tr class="success" style="width:auto"> <!--Encabezado mas botones de Asc y Desc-->  
                    <th id="txt-desc-pos" style="text-align:center;background-color: #C1D736">Positions<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-ou-pos" style="text-align:center;background-color: #C1D736">OU Positions<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>    
                  </tr>
                </thead>
                <tbody>
                    <%
                           ArrayList tablePositions = PositionDAO.getAll(conn);
                           pageContext.setAttribute("positions", tablePositions);
                    %>
                    <c:forEach items="${positions}" var="current">
                        <tr>
                        <td class="hidden"><c:out value="${current.id}"/></td>
                        <td><c:out value="${current.desc}"/></td>
                        <td><c:out value="${current.ou}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
               </table> 
            </div> 
        </div>
    </div>
</div>

<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<script>
  $(document).ready( function () {
    $('#grid-user').bdt();
  });
</script>
<!--Funcion de validaciones-->
<script type="text/javascript">
 $(function(){
  $('#form-positions').bValidator();
 });
</script>
     
  <!-- Modal-Submit -->
  <div class="modal fade" id="modal-submit" role="dialog">
    <div class="modal-dialog modal-sm">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <div class="alert alert-success">
              <strong>Position submitted successfully</strong> 
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
