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
 
<%@include file="webs/mainMenu.html" %> <!-- Llama  menu-->
    
<div class="container">
   <form class="form-horizontal" role="form">
    <div>
      <div class="form-group">
       <label class="control-label col-sm-2" for="site">Site Name: </label>
       <div class="col-sm-10" style="left: 0px; top: 0px; width: 400px"> 
        <input type="text" class="form-control" id="txt-site" value="" placeholder="site" style="width: 100%">
       </div>
       <div>
        <button id="btn-submit" type="button" class="btn btn-success pull-left">Submit</button>
       </div>
      </div>
    </div>
   </form>
</div>

<div id="div-grilla"class="container table-responsive">
  <table id="grid-sites" class="table2excel js-dynamitable table table-bordered table-hover">
    <thead>
      <tr class="success"> <!--Encabezado mas botones de Asc y Desc-->
        <th id="ID-site" style="text-align:center;width:15%">ID<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt_site" style="text-align:center;width:30%">Site <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt_direccion" style="text-align:center">Direccion <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>

      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Laminar</td>
        <td>Mendoza 123</td>
      </tr>
      <tr>
        <td>2</td>
        <td>SouthPark</td>
        <td>san Luis 6325</td>
      </tr>
      <tr>
        <td>3</td>
        <td>NorthPark</td>
        <td>Madero 4589</td>
      </tr>
        <tr>
            <td>6</td>
            <td>Cordoba</td>
            <td>San juan 5623</td>
        </tr>
        <tr>
            <td>20</td>
            <td>Brasil</td>
            <td>xxxx 5566</td>
        </tr>
        <tr>
            <td>4</td>
            <td>Peru</td>
            <td>Altiplano 5236</td>
        </tr>
        <tr>
            <td>8</td>
            <td>Uruguay</td>
            <td>Frontera 4563</td>
        </tr>
      <tr>
        <td>1</td>
        <td>Rosario</td>
        <td>Av. Madres Plaza de Mayo 3020</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Tucuman</td>
        <td>Ni idea 1234</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Bogota</td>
        <td>xx f f 6666</td>
      </tr>
    </tbody>
   </table> 
</div> 

<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<script>
  $(document).ready( function () {
    $('#grid-sites').bdt();
  });
</script>

<div class="container">
<button id="btn-export" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-export"></span> Export file .XLS</button>
<script>
 $("#btn-export").click(function(){
   $("#grid-sites").table2excel({ filename: "Export Sites"
   });
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

</div>

</body>
</html>