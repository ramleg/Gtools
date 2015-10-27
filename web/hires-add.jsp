<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>New Hires Add</title>
  <%@include file="common/commonHead.html" %>
  <link href="resources/css/gtools-hiresadd.css" rel="stylesheet" type="text/css"/>
  <script src="resources/js/hires-add.js"></script>
</head>
<body>
<%@include file="common/mainMenu.jsp" %>

<div class="container-fluid">

    
    <div class="main row">
        <!-- PANEL 1 -->
        <div class="col-xs-12 col-sm-12 col-md-8">
            <div class="panel panel-primary">
            <div class="panel-heading">User Data</div>
            <div class="panel-body">
                <div class="container-fluid">
                    
                    <form class="form-inline">
                        
                        <div class="row has-success">
                            <div class="input-group col-sm-12 col-md-10">
                                <div class="input-group-addon">
                                    <div class="radio col-md-3">
                                    <label><input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked> Globant</label>
                                    </div>
                                    <div class="radio col-md-2 disabled" >
                                        <label><input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" disabled> Contractor / External</label>
                                    </div>
                                </div>
                                <select class="form-control" id="ddl-suborg">
                                    <option>. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . </option>
                                </select>
                            </div>
                        </div>
                        
                        <br>
                        
                        <div class="row">
                                <div class="input-group col-sm-12 col-md-5">
                                    <div class="input-group-addon">></div>
                                    <input class="form-control text-capitalize" id="txt-name" type="text" placeholder="Name">
                                </div>
                                <div class="input-group col-sm-12 col-md-5">
                                    <div class="input-group-addon">></div>
                                    <input class="form-control text-capitalize" id="txt-lastname" type="text" placeholder="Lastname">
                                </div>
                                
                        </div>
                        
                        <br><br>
                        
                        <div class="row">
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon"><b>></b></div>
                                <input class="form-control text-lowercase" id="txt-username" placeholder="User">
                            </div>
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon">@</div>
                                <select class="form-control" id="ddl-emaildomain">
                                    <option>globant.com</option>
                                </select>
                                <div class="input-group-addon">Check</div>
                            </div>
                        </div>
                        
                        <br><br>
                        
                        <div class="row">
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon">Country</div>
                                <select class="form-control" id="ddl-country"><option value="">. . . . . . . . . . . . . . . . . . . . . . . .</option></select>
                            </div>
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon">></div>
                                <input class="form-control text-uppercase" id="txt-idnumber" type="text" placeholder="ID Number">
                            </div>
                        </div>
                        
                        <br><br>
                        
                        <div class="row">
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon">Position</div>
                                <select class="form-control" id="ddl-position"><option value="">. . . . . . . . . . . . . . . . . . . . . . . .</option></select>
                            </div>
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon">Location</div>
                                <select class="form-control" id="ddl-location"><option value="">. . . . . . . . . . . . . . . . . . . . . . . .</option></select>
                            </div>
                        </div>
                        
                        <br><br>
                        
                        <div class="row">
                            <div class="input-group col-sm-12 col-md-5">
                                <div class="input-group-addon">eMailGroup</div>
                                <select class="form-control" id="ddl-emailgroup"><option value="">. . . . . . . . . . . . . . . . . . . . . . . .</option></select>
                            </div>
                            <div class="input-group col-sm-12 col-md-5">
                            <div class="input-group-addon">Phone</div>
                            <input class="form-control" id="txt-phonenumber" type="text" placeholder="Phone">
                                <div class="input-group-addon">++</div>
                            </div>
                        </div>
                        
                        <br><br>
                        
                        <div class="row">
                            <div class="input-group col-sm-12 col-md-10">
                                <div class="input-group-addon">></div>
                                <textarea id="txtarea-desc" class="form-control" placeholder="Description"></textarea>
                            </div>
                        </div>
                        
                        <br><br>
                        
                        <div class="row">
                            <div class="input-group col-xs-12 col-sm-12 col-md-2">
                                <button id="btn-submit" type="button" class="btn btn-block btn-primary">Submit</button>
                            </div>
                            <div class="input-group col-xs-12 col-sm-12 col-md-2 col-md-offset-6">
                                <button id="btn-cancel" type="button" class="btn btn-block btn-danger">Clear / Cancel</button>
                            </div>
                        </div>
                    </form>
                </div>
                
            </div>
            </div>
        </div>
        
        
        <!-- PANEL 2 -->
        <div class="col-xs-12 col-sm-12 col-md-4">
            <div class="panel panel-primary">
            <div class="panel-heading">Logs</div>
            <div class="panel-body">
            
            hola
            
            </div>    
            </div>
            </div>
    </div>
</div>


</body>

</html>