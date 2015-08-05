<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <meta charset="utf-8">
  <%@include file="webs/commonHead.html" %>

<script> //SUBMIT
  $(document).ready(function(){
    $("#btn-submit").click(function(){
      $("#modal-submit").modal();
    });
  });
</script>
<script> //CAMPOS OBLIGATORIOS
  $(document).ready(function(){
    
    $("#txt-position").blur(function(){
     if ($("#txt-position").val() == "" || $("#txt-position").val() == null) {   
         $("#modal-alert").modal();
         $("#txt-position").focus();
     };
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
  
<div class="container-fluid">
  <h3>Alta de Posisiones</h3>
  <br>
   <form class="form-horizontal" role="form">
     
     <div class="form-group"> 
      <label class="control-label col-sm-2" for="id-uoorg" style="width:200px">UO Organization: </label> 
      <div class="col-sm-10" style="width:400px">
       <select class="form-control" id="id-uoorg">
        <option>Development</option>
        <option>QC</option>
        <option>Peoplecare</option>
        <option>PMO</option>
        <option>Staffing</option>
        <option>Business</option>
        <option>Facilities</option>
        <option>Infrastructure</option>
        <option>Reception</option>
        <option>Others...</option>
       </select>
      </div>
     </div>  
        
     <div class="form-group">
      <label class="control-label col-sm-2" for="txt-position" style="width:200px">New Position: </label>
      <div class="col-sm-10" style="width:400px"> 
       <input type="text" class="form-control" id="txt-position" placeholder="Position" style="width: 100%">
      </div>      
      <div>
       <button id="btn-submit" type="button" class="btn btn-success pull-left">Submit</button>
      </div>
     </div>
     
   </form>
</div>

<div class="container-fluid">
 <br> 
 <br>
  <div class="progress" style="width:40%">
    <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%;background-color:black">
    </div>
  </div>
</div>

<div id="div-grilla"class="container-fluid table-responsive pull-left" style="width:40%">
  <table id="grid-user" class="js-dynamitable table table-bordered table-hover">
    <thead>
      <tr class="success" style="width:auto"> <!--Encabezado mas botones de Asc y Desc-->
        <th id="txt-uoorg" style="text-align:center">UO Org<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-position" style="text-align:center">Position<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>    
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Development</td>
        <td>Web UO Developer</td>
      </tr>
      <tr>
        <td>Development</td>
        <td>.Net Developer</td>
       </tr>
      <tr>
        <td>Development</td>
        <td>PHP Developer</td>
      </tr>
      <tr>
        <td>Staffing</td>
        <td>Recruiting</td>
      </tr>
      <tr>
        <td>QC</td>
        <td>Test automation</td>
       </tr>
      <tr>
        <td>QC</td>
        <td>QC Analyst</td>
      </tr>
      <tr>
        <td>QC</td>
        <td>QC Lead</td>
      </tr>
      <tr>
        <td>PM</td>
        <td>Project Manager</td>
       </tr>
      <tr>
        <td>People</td>
        <td>Peoplecare</td>
      </tr>
      <tr>
        <td>Staffing</td>
        <td>Receptionist</td>
      </tr>


    </tbody>
   </table> 
</div> 

<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<script>
  $(document).ready( function () {
    $('#grid-user').bdt();
  });
</script>
   
 <!-- alertas -->
  <!-- Modal-Alert obligatorios-->
  <div class="modal fade" id="modal-alert" role="dialog">
    <div class="modal-dialog modal-sm">
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
