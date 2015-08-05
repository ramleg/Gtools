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
         
<div class="container">
 <h3 style="text-align:center">Importación interno libres</h3>
 <br>
 <form class="form-horizontal" role="form">
    <div class="col-sm-1">
     <button id="btn-select" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-file"></span> Select file </button>
    </div>
    <div class="col-sm-9">  
     <input type="text" class="form-control" id="txt-file" placeholder="Import file">
    </div> 
    <div class="col-sm-2">  
     <button id="btn-import" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-import"></span> Import</button>    
    </div>
 </form>
</div>

<div class="container">
 <br> 
 <br>
  <div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%;background-color:black">
    </div>
  </div>
</div>

<div id="div-grilla"class="container table-responsive">
  <table id="grid-user" class="js-dynamitable table table-bordered table-hover">
    <thead>
      <tr class="success" style="width:auto"> <!--Encabezado mas botones de Asc y Desc-->
        <th id="txt-argentina" style="text-align:center">Argentina<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-usa" style="text-align:center">USA<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-uruguay" style="text-align:center">Uruguay<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-colombia" style="text-align:center">Colombia<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-peru" style="text-align:center">Peru<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-mexico" style="text-align:center">Mexico<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-brasil" style="text-align:center">Brasil<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
        <th id="txt-india" style="text-align:center">India<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>          
      </tr>
    </thead>
    <tbody>
      <tr style="text-align:center">
        <td>12563</td>
        <td>25632</td>
        <td>36521</td>
        <td>44563</td>
        <td>23652</td>
        <td>49632</td>
        <td>75632</td>
        <td>63263</td>
      </tr>
      <tr style="text-align:center">
        <td>16356</td>
        <td>24695</td>
        <td>34523</td>
        <td>45632</td>
        <td>28965</td>
        <td>41256</td>
        <td>78963</td>
        <td>61256</td>
      </tr>
      <tr style="text-align:center">
        <td>13652</td>
        <td>26523</td>
        <td>38965</td>
        <td>41236</td>
        <td>29563</td>
        <td>45715</td>
        <td>71256</td>
        <td>67563</td>
      </tr>
      <tr style="text-align:center">
        <td>16932</td>
        <td>25563</td>
        <td>36652</td>
        <td>44584</td>
        <td>24523</td>
        <td>45632</td>
        <td>75894</td>
        <td>66356</td>
      </tr>
      <tr style="text-align:center">
        <td>15482</td>
        <td>24712</td>
        <td>35892</td>
        <td>44523</td>
        <td>24445</td>
        <td>49652</td>
        <td>77895</td>
        <td>69541</td>
      </tr>
      <tr style="text-align:center">
        <td>19632</td>
        <td>25684</td>
        <td>31254</td>
        <td>47895</td>
        <td>24562</td>
        <td>46548</td>
        <td>78951</td>
        <td>63579</td>
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

</body>
</html>