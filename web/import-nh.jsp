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
        <div class="panel-heading">User import</div>
        <div class="panel-body">
            <br>
             <form class="form-horizontal" role="form">
                <div class="col-sm-2">
                 <button id="btn-select" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-file"></span> Select file</button>
                </div>
                <div class="col-sm-8">  
                 <input type="text" class="form-control" id="txt-file" placeholder="Import file">
                </div> 
                <div class="col-sm-2">  
                 <button id="btn-import" type="button" class="btn btn-primary pull-left"><span class="glyphicon glyphicon-import"></span> Import</button>    
                </div>
             </form>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="panel panel-primary">
        <div class="panel-heading">User import</div>
        <div class="panel-body">
        <div id="div-grilla"class="container-fluid table-responsive" style="width:95%">
          <table id="grid-user" class="js-dynamitable table table-bordered table-hover">
            <thead>
              <tr class="success" style="width:auto"> <!--Encabezado mas botones de Asc y Desc-->
                <th id="txt-nombre" style="text-align:center">First name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-apellido" style="text-align:center">Last name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-dni" style="text-align:center">DNI<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-user" style="text-align:center">user name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-UO" style="text-align:center">OU Org<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-position" style="text-align:center">Position <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-site" style="text-align:center">Site<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-mailgroup" style="text-align:center">Mail group<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>      
                <th id="txt-interno" style="text-align:center;width:auto">Interno<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                <th id="txt-pais" style="text-align:center">Pais<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>      
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

<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<script>
  $(document).ready( function () {
    $('#grid-user').bdt();
  });
</script>

</body>
</html>
