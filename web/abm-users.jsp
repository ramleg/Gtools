<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <meta charset="utf-8">
  <%@include file="webs/commonHead.html" %>

<script> //CHECK BUTTON
  $(document).ready(function(){
    $("#btn_check").click(function(){
      $(this).button('Cheking').delay(1000).queue(function(){
        $(this).button('complete');
        $(this).dequeue();
      });        
    });  
  });
</script>
<script> //SUBMIT
  $(document).ready(function(){
    $("#btn-submit").click(function(){
      $("#modal-submit").modal();
    });
  });
</script>
<script> //CAMPOS OBLIGATORIOS
  $(document).ready(function(){  

    $("#txt-firstname").blur(function(){
     if ($("#txt-firstname").val() == "" || $("#txt-firstname").val() == null) {   
         $("#modal-alert").modal();
     };
    });
    $("#txt-lastname").blur(function(){
     if ($("#txt-lastname").val() == "" || $("#txt-lastname").val() == null) {   
         $("#modal-alert").modal();
     };
    });
    $("#txt-dni").blur(function(){
     if ($("#txt-dni").val() == "" || $("#txt-dni").val() == null) {   
         $("#modal-alert").modal();
     };
    });
    $("#txt-username").blur(function(){
     if ($("#txt-username").val() == "" || $("#txt-username").val() == null) {   
         $("#modal-alert").modal();
     };
     $("#txt-mail").val($("#txt-username").val() + "@globant.com") ; 
    });
    $("#txt-position").blur(function(){
     if ($("#txt-position").val() == "" || $("#txt-position").val() == null) {   
         $("#modal-alert").modal();
     };
    });
    $("#txt-interno").blur(function(){
     if ($("#txt-interno").val() == "" || $("#txt-interno").val() == null) {   
         $("#modal-alert").modal();
     };
    });
 
  });
</script>

</head>

<body>

<%@include file="webs/mainMenu.html" %>

<div class="container-fluid">
   <form class="form-horizontal" role="form">
     
     <div class="form-group"> 
      <label class="control-label col-sm-2" for="id-org" style="width:200px">Sub Organization: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="id-org">
        <option>Globant</option>
        <option>Verizon</option>
        <option>Contrators</option>
        <option>Teletech</option>
        <option>EA Games</option>
        <option>etc....</option>
       </select>
      </div>
     </div>  
     
     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-firstname" style="width:200px">First Name: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-firstname" placeholder="First Name" style="width: 100%">
      </div>
     </div>
     
     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-lastname" style="width:200px">Last Name: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-lastname" placeholder="Last Name" style="width: 100%">
      </div>
     </div>
     
     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-dni" style="width:200px">DNI/Passport/etc: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-dni" placeholder="DNI/Passport/etc.." style="width: 100%">
      </div>
     </div>
     
     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-username" style="width:200px">Domain Name: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-username" placeholder="User Name" style="width: 100%; background-color:aqua" maxlength="17">
      </div>
      <div>
       <button id="btn_check" type="button" class="btn btn-success" data-complete-text="User OK">CheckUser</button>
      </div>
     </div>
     
     <div class="form-group"> 
      <label class="control-label col-sm-2" for="id-uoorg" style="width:200px">UO Organization: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="id-uoorg">
        <option>Development</option>
        <option>Facilities</option>
        <option>QC</option>
        <option>PeoppleCare</option>
        <option>Teception</option>
        <option>etc....</option>
       </select>
      </div>
     </div>

     <div class="form-group"> 
      <label class="control-label col-sm-2" for="id-site" style="width:200px">Site: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="id-site">
        <option>AR/Cba/Capitalinas</option>
        <option>AR/BsAs/Laminar</option>
        <option>CO/Bog/CorpCenter</option>
        <option>EU/NY/HW</option>
        <option>IN/Pune/Amar Apex</option>
        <option>etc....</option>
       </select>
      </div>
     </div>

     <div class="form-group"> 
      <label class="control-label col-sm-2" for="id-sitemail" style="width:200px">site Mail: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="id-mail">
        <option>Cordoba mail</option>
        <option>Laminar Mail</option>
        <option>Bogota mail</option>
        <option>Rosario Mail</option>
        <option>Pune Mail</option>
        <option>etc....</option>
       </select>
      </div>
     </div>
     
     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-mail" style="width:200px">Email: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-mail" placeholder="mail" style="width: 100%">
      </div>
     </div>

     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-position" style="width:200px">Position: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-position" placeholder="Position" style="width: 100%">
      </div>
     </div>
     
      <div class="form-group">
      <label class="control-label col-sm-2" for="txt-interno" style="width:200px">Nro Interno: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-interno" placeholder="Nro Interno" style="width: 100%">
      </div>
     </div>

     <div class="form-group"> 
      <label class="control-label col-sm-2" for="id-pais" style="width:200px">Pais: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="id-pais">
        <option>Argentina</option>
        <option>Colombia</option>
        <option>Peru</option>
        <option>Brazil</option>
        <option>India</option>
        <option>etc....</option>
       </select>
      </div>
     </div>

     <div class="form-group"style="width:400px">
      <button id="btn-submit" type="button" class="btn btn-success pull-left">Submit</button>
      <button id="btn-cancel" type="reset" class="btn btn-danger pull-right">Cancel</button>
     </div>
      
   </form>
   
 <!-- alertas -->
  <!-- Modal-alerta -->
  <div class="modal fade" id="modal-alert" role="dialog">
    <div class="modal-dialog modal-sm">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <div class="alert alert-danger">
              <strong>Este campo es obligatorio</strong> 
            </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>  
      </div>
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

</body>

</html>
