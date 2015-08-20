<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.corp.globant.MODEL.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.corp.globant.MODEL.PaisDAO"%>
<%@page import="com.corp.globant.MODEL.SiteDAO"%>
<%@page import="com.corp.globant.MODEL.PositionDAO"%>
<%@page import="com.corp.globant.MODEL.Sub_OrgDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <%@include file="webs/commonHead.html" %>
</head>
<body>
<%@include file="webs/mainMenu.html" %>
<%
  Connection conn = ConnectionManager.getConnection();
%>
<div class="container"> 
    
    <div class="panel panel-primary">
        <div class="panel-heading">Add User</div>
        <div class="panel-body">
            
           <form class="form-horizontal" role="form" id="form-user">
               
            <div class="form-group"> 
              <label class="control-label col-sm-4" for="ddl_suborg">Sub Organization: </label> 
              <div class="col-sm-8">
                 <select class="form-control" id="ddl_suborg"  style="width:50%">
                   <%
                    ArrayList ddl_suborg = Sub_OrgDAO.getAll(conn);
                    pageContext.setAttribute("suborg", ddl_suborg);
                   %>
                   <c:forEach items="${suborg}" var="current"> 
                    <option id="opt_suborg" value="<c:out value="${current.dom}"/>">
                     <c:out value="${current.desc}"/>
                    </option>
                 </c:forEach>
              </select>   
              </div>
            </div> 
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-firstname">First Name: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-firstname" data-bvStrict="notEmpty" placeholder="First Name" style="width: 50%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-lastname">Last Name: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-lastname" placeholder="Last Name" data-bvStrict="notEmpty" style="width: 50%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-dni">DNI/Passport/etc: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-dni" data-bvStrict="notEmpty" placeholder="DNI/Passport/etc.." style="width: 25%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-username">Domain Name: </label>
              <div class="col-sm-4"> 
                  <input type="text" class="form-control" id="txt-username" data-bvStrict="notEmpty" placeholder="User Name" style="width: 100%; background-color:aqua" maxlength="17" oninput="func_mail()">
               <div class="help-block error-message">Required Field</div>      
              </div>
              <div class="col-sm-2">
                  <button id="btn_check" type="button" class="btn btn-success pull-left" data-complete-text="User OK">CheckUser</button>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-mail">Email: </label>
              <div class="col-sm-8"> 
               <input type="text" Disabled class="form-control" id="txt-mail" data-bvStrict="notEmpty" placeholder="mail" style="width: 50%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="form-group"> 
              <label class="control-label col-sm-4" for="ddl_position">Position: </label> 
              <div class="col-sm-8">
                  <select class="form-control" id="ddl_position"  style="width:50%" onchange="func_position_ad()">
                 <%
                   ArrayList ddlPosition = PositionDAO.getAll(conn);
                   pageContext.setAttribute("positions", ddlPosition);
                 %>
                 <c:forEach items="${positions}" var="current"> 
                    <option id="opt_position" value="<c:out value="${current.ou}"/>">
                        <c:out value="${current.desc}"/>
                    </option>
                 </c:forEach>
              </select>
              </div>
            </div>
                 
            <div class="row form-group"> 
              <label class="control-label col-sm-4" for="txt-ou-org">OU Organization: </label> 
              <div class="col-sm-8">
               <input type="text" id="txt-ou-org" Disabled class="form-control" data-bvStrict="notEmpty" placeholder="OU Organization" style="width: 50%">
              </div>
            </div>
               
            <div class="row form-group"> 
              <label class="control-label col-sm-4" for="ddl-site">Site: </label> 
              <div class="col-sm-8">
                   <select class="form-control" id="ddl_site" style="width: 50%">
                       <%
                           ArrayList ddlSite = SiteDAO.getAll(conn);
                           pageContext.setAttribute("sites", ddlSite);
                       %>
                        <c:forEach items="${sites}" var="current">
                           <option value="<c:out value="${current.id}"/>"><c:out value="${current.desc}"/></option>
                        </c:forEach>
                   </select>
              </div>
            </div>
               
            <div class="row form-group"> 
              <label class="control-label col-sm-4" for="id-sitemail">site Mail: </label> 
              <div class="col-sm-8">
               <select class="form-control" id="id-mail" style="width: 50%">
                <option>Cordoba mail</option>
                <option>Laminar Mail</option>
                <option>Bogota mail</option>
                <option>Rosario Mail</option>
                <option>Pune Mail</option>
                <option>etc....</option>
               </select>
              </div>
            </div>
              
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-interno">Nro Interno: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-interno" data-bvStrict="notEmpty" placeholder="Nro Interno" style="width:14%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="form-group"> 
              <label class="control-label col-sm-4" for="ddl_pais">Country: </label> 
              <div class="col-sm-8">
              <select class="form-control" id="ddl_pais"  style="width:50%">
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
              <div class="col-sm-5">
                <button id="btn-submit" type="button" class="btn btn-primary pull-right">Submit</button> 
              </div>
              <div class="col-sm-3">
                <button id="btn-cancel" type="reset" class="btn btn-danger pull-right">Cancel</button>
              </div>
            </div> 

           </form>
        </div>
    </div>
    
  <!-- Modal-Submit -->
  <div class="modal fade" id="modal-submit" role="dialog">
    <div class="modal-dialog modal-sm">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <div class="alert alert-success">
              <strong>User Submitted successfully</strong> 
            </div>
            <div class="modal-footer">
             <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>              
        </div>  
      </div>
    </div>    
  </div> 
 
</div>

<script type="text/javascript">
    
 $(function(){
  $('#form-user').bValidator();
 });
//Asigna Mail
    function func_mail(){
     $("#txt-mail").val($("#txt-username").val() + $("#ddl_suborg option:selected").val());//"@globant.com");
    }
    
//Asigna OU Position
    function func_position_ad(){
     $("#txt-ou-org").val($("#ddl_position option:selected").val());
    }
    
//CHECK BUTTON
    $(document).ready(function(){
      $("#btn_check").click(function(){
        $(this).button('Cheking').delay(1000).queue(function(){
          $(this).button('complete');
          $(this).dequeue();
        });        
      });  
    });
  
//SUBMIT
    $(document).ready(function(){
      $("#btn-submit").click(function(){
        $("#modal-submit").modal();
      });
    });
  
</script>



</body>

</html>
