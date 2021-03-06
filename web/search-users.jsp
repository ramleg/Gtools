<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <meta charset="utf-8">
  <%@include file="webs/commonHead.html" %>
</head>
<body>
  
<%@include file="webs/mainMenu.html" %>   

<div class="container-fluid">
    <div class="panel panel-primary">
        <div class="panel-heading">User List</div>
        <div class="panel-body">
            <div id="div-grilla"class="container-fluid table-responsive" style="width:95%">
              <table id="grid-user" class="js-dynamitable table table-bordered table-hover">
                <thead>
                  <tr class="success" style="width:auto"> <!--Encabezado mas botones de Asc y Desc-->
                    <th id="txt-nombre" style="text-align:center;background-color: #C1D736">First name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-apellido" style="text-align:center;background-color: #C1D736">Last name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-dni" style="text-align:center;background-color: #C1D736">DNI<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-user" style="text-align:center;background-color: #C1D736">user name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-UO" style="text-align:center;background-color: #C1D736">OU Org<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-position" style="text-align:center;background-color: #C1D736">Position <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-site" style="text-align:center;background-color: #C1D736">Site<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-mailgroup" style="text-align:center;background-color: #C1D736">Mail group<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>      
                    <th id="txt-interno" style="text-align:center;width:auto;background-color: #C1D736">Interno<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                    <th id="txt-pais" style="text-align:center;background-color: #C1D736">Pais<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>      
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Lorena</td>
                    <td>Rodriguez</td>
                    <td style="text-align:center">56320445</td>
                    <td>lorena.rodriguez</td>
                    <td>Developer</td>
                    <td>Web UI Developer</td>
                    <td>Laminar</td>
                    <td>laminar-mailgroup</td>
                    <td style="text-align:center">12563</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Pedro</td>
                    <td>Garcia</td>
                    <td style="text-align:center">30652985</td>
                    <td>pedro.garcia</td>
                    <td>QC</td>
                    <td>Test Automation</td>
                    <td>Cordoba Capitalinas</td>
                    <td>cordoba-mailgroup</td>
                    <td style="text-align:center">19856</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>
                  <tr>
                    <td>Juan</td>
                    <td>Perez</td>
                    <td style="text-align:center">123456789</td>
                    <td>juan.perez</td>
                    <td>Developer</td>
                    <td>Java Developer</td>
                    <td>Rosario Nordlink</td>
                    <td>rosario-mailgroup</td>
                    <td style="text-align:center">15265</td>
                    <td>Argentina</td>
                  </tr>

                </tbody>
               </table> 
            </div> 
        </div>
    </div>  
</div>    

<!--<div class="container-fluid" style="width:95%">
 <button id="btn-export" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-export"></span> Export file .XLS</button>
 <script>
  $("#btn-export").click(function(){
   $("#grid-user").table2excel({ filename: "Export NewHires"});
  });
 </script>
</div>-->


<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<script>
  $(document).ready( function () {
    $('#grid-user').bdt();
  });
</script>

</body>
</html>
