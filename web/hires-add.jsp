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
<div class="container">
    <div class="main row">
    <div class="col-sm-12 col-md-10 col-lg-10">
    <div class="panel panel-primary">
        <div class="panel-heading">Add User</div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" id="frm-hireadd" name="FrmUserAdd">
                
            <div class="form-group">
                <label class="control-label col-sm-4" for="ddl-suborg">Domain / SubOrg: </label> 
              <div class="col-sm-8">
                <select class="form-control" id="ddl-suborg"  style="width:50%"></select>
              </div>
            </div> 
                
            <div class="form-group"> 
              <label class="control-label col-sm-4" for="ddl-country">Country: </label> 
              <div class="col-sm-8">
                  <select class="form-control" id="ddl-country"  style="width:50%">
                      <option value=""> - - - </option>
                  </select>
              </div>
            </div>
                 
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-name">First Name: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control text-capitalize" id="txt-name" data-bvStrict="notEmpty" placeholder="First Name" style="width: 50%">
               <span class="help-block error-message">Required Field</span>
              </div>
            </div>
                
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-lastname">Last Name: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control text-capitalize" id="txt-lastname" placeholder="Last Name" data-bvStrict="notEmpty" style="width: 50%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-idnumber">Identification Number: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control text-uppercase" id="txt-idnumber" data-bvStrict="notEmpty" placeholder="DNI/Passport/etc.." style="width: 50%" >
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-2 text-lowercase" for="txt-username">Domain Name: </label>
              <div class="col-sm-6"> 
                  <input type="text" class="form-control verdex" id="txt-username" data-bvStrict="notEmpty" placeholder="User Name" maxlength="17" oninput="func_mail()" style="width: 100%">
               <div class="help-block error-message">Required Field</div>      
              </div>
              <div class="col-sm-4">
                  <button id="btn-check" type="button" class="btn btn-success pull-left" data-complete-text="User OK">CheckUser</button>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-email">Email: </label>
              <div class="col-sm-8"> 
               <input type="text" Disabled class="form-control" id="txt-email" data-bvStrict="notEmpty" placeholder="mail" style="width: 50%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="form-group"> 
              <label class="control-label col-sm-4" for="ddl-position">Position: </label> 
              <div class="col-sm-8">
                  <select class="form-control" id="ddl-position"  style="width:50%" onchange="func_position_ad()"></select>
              </div>
            </div>
                 
            <div class="row form-group"> 
              <label class="control-label col-sm-4" for="txt-ouorg">OU Organization: </label> 
              <div class="col-sm-8">
               <input type="text" id="txt-ouorg" Disabled class="form-control" data-bvStrict="notEmpty" placeholder="OU Organization" style="width: 50%">
              </div>
            </div>
               
            <div class="row form-group"> 
              <label class="control-label col-sm-4" for="ddl-location">Location: </label> 
              <div class="col-sm-8">
                   <select class="form-control" id="ddl-location" style="width: 50%"></select>
              </div>
            </div>
               
            <div class="row form-group"> 
              <label class="control-label col-sm-4" for="ddl-emailgroup">Email Group: </label> 
              <div class="col-sm-8">
               <select class="form-control" id="ddl-emailgroup" style="width: 50%"></select>
              </div>
            </div>
              
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-phonenumber">Phone Number: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-phonenumber" data-bvStrict="notEmpty" placeholder="Nro Interno" style="width:14%">
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <div class="col-sm-5">
                <button id="btn-submit" type="button" class="btn btn-primary pull-right">Submit</button> 
              </div>
              <div class="col-sm-3">
                <button id="btn-clear" type="reset" class="btn btn-danger pull-right">Clear Fields</button>
              </div>
            </div> 

           </form>
        </div>
    </div>
    </div>
    </div>
</div>
</body>

</html>
