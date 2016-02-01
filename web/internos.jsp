<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proy-NewHires</title>
  <meta charset="utf-8">
  <%@include file="common/commonHead.html" %>

  <!--<script src='resources/js/test-select.js'></script>
  <script src="resources/js/hires-add.js"></script>
  <link href='resources/css/custom-select.css' rel='stylesheet' />-->
  
</head>
<body>

<%@include file="common/mainMenu.jsp" %>

<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#grid">Internal Numbers</a></li>
    <li><a data-toggle="tab" href="#import">Import CSV</a></li>
    <li><a data-toggle="tab" href="#new">New Internal</a></li>
  </ul>
</div>

<div class="tab-content container-fluid"> 
    <br>
    <br>
    <div id="grid" class="tab-pane fade in active container">
        <div class="panel panel-body panel-primary">
            <div id="div-grilla"class="container-fluid table-responsive">
                <table id="grid-internos" class="table table-bordered table-hover js-dynamitable">
                    <thead>
                        <tr class="success" style="width:auto"> <!--Encabezado mas botones de Asc y Desc-->
                            <th id="txt-argentina" style="text-align:center">Internal<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                            <th id="txt-usa" style="text-align:center">User<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                            <th id="txt-uruguay" style="text-align:center">Country<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>
                            <th id="txt-colombia" style="text-align:center">Status<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc glyphicon glyphicon-chevron-up pull-right"></span></th>         
                        </tr>
                    </thead>
                    <tbody>
                  <tr style="text-align:center">
                    <td>12563</td>
                    <td></td>
                    <td>Argentina</td>
                    <td>Not asigned</td>
                  </tr>
                  <tr style="text-align:center">
                    <td>16356</td>
                    <td>juan.perez</td>
                    <td>Argentina</td>
                    <td>Asigned</td>
                  </tr>
                  <tr style="text-align:center">
                    <td>26523</td>
                    <td>luis.perez</td>
                    <td>Uruguay</td>
                    <td>Asigned</td>
                  </tr>
                  <tr style="text-align:center">
                    <td>44584</td>
                    <td></td>
                    <td>Colombia</td>
                    <td>Not asigned</td>
                  </tr>
                </tbody>
               </table>
            </div>
        </div>
    </div>  
    <div id="import" class=" tab-pane fade container">
        <div class="panel panel-body panel-primary">           
            <form class="form-horizontal row" role="form" style="margin: 30px auto;overflow: hidden;width: 90%">
                <div class="col-md-2 col-sm-2">
                 <button id="btn-select" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-file"></span> Select file </button>
                </div>
                <div class=" col-md-8 col-sm-8">  
                 <input type="text" class="form-control" id="txt-file" placeholder="Import file">
                </div> 
                <div class="col-md-2 col-sm-2">  
                 <button id="btn-import" type="button" class="btn btn-primary pull-left"><span class="glyphicon glyphicon-import"></span> Import</button>    
                </div>
            </form>
        </div>
    </div>
    <div id="new" class="tab-pane fade container">
        <div class="panel panel-body panel-primary">
            <form class="form-horizontal row" role="form" style="margin: 15px;width: 90%">
                <div class="row form-group">
                    <label class="control-label col-md-1 col-sm-1" for="range">Range</label>
                    <div class="form-inline col-md-11 col-sm-11" role="form">
                        <div class="row form-group col-md-2 col-sm-2">
                            <input class="form-control" type="text" id="start-int" placeholder="Start" style="width: 100%;text-align: center">
                        </div>
                        <div class="row form-group col-md-9 col-sm-9">
                            <input class="form-control pull-left" type="text" id="finish-int" placeholder="Finish" style="width: 18%;text-align: center">
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <label class="control-label col-sm-1" for="country">Country</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="ddl-country" style="width: 30.8%">
                          <option value="">Argentina</option>
                          <option value="">Brazil</option>
                          <option value="">USA</option>
                          <option value="">India</option>
                          <option value="">Colombia</option>
                          <option value="">Etc</option>
                        </select> 
                    </div>
                </div>
                <div class=" row form-group">
                    <label class="control-label col-sm-1" for="status">Status</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="ddl-country" style="width: 30.8%">
                          <option value="">Free</option>
                          <option value="">Do not use</option>
                          <option value="">Assigned</option>
                          <option value="">Others</option>
                        </select> 
                    </div>
                </div>
                <div class="row form-group" style="width: 35%">
                    <button id="btn-submit" type="button" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-save"></span> Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!--<div class="container-fluid">
    <form>
        <select id="ddl-country" class="custom-select">
        </select>
        <script>
            $(function() {
              $("#ddl-country").autocomplete();
            });
        </script>
    </form>
</div>-->

<!--<script src="resources/js/JQuery/dynamitable.jquery.min.js"></script>
<script src="resources/js/JQuery/jquery.bdt.js"></script>

<script>
  $(document).ready( function () {
    $('#grid-internos').bdt();
  });
</script>-->

</body>
</html>