<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>New Hires Add</title>
  <%@include file="common/commonHead.html" %>
  <link href="resources/css/forms.css" rel="stylesheet" type="text/css"/>
  <script src="resources/js/hires-add.js"></script>
</head>
<body>
<%@include file="common/mainMenu.jsp" %>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">Add User</div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" id="frm-hireadd" name="FrmUserAdd">
                
            <div class="form-group">
                <label class="control-label col-sm-4" for="ddl-suborg">Sub Organization: </label> 
              <div class="col-sm-8">
                <select class="form-control" id="ddl-suborg"  style="width:50%"></select>                
              </div>
            </div> 
                
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-name">First Name: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-name" data-bvStrict="notEmpty" placeholder="First Name" style="width: 50%">
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
              <label class="control-label col-sm-4" for="txt-idnumber">Identification Number: </label>
              <div class="col-sm-8"> 
               <input type="text" class="form-control" id="txt-idnumber" data-bvStrict="notEmpty" placeholder="DNI/Passport/etc.." style="width: 25%" >
               <div class="help-block error-message">Required Field</div>
              </div>
            </div>
               
            <div class="row form-group">
              <label class="control-label col-sm-4" for="txt-username">Domain Name: </label>
              <div class="col-sm-4"> 
                  <input type="text" class="form-control verdex" id="txt-username" data-bvStrict="notEmpty" placeholder="User Name" maxlength="17" oninput="func_mail()">
               <div class="help-block error-message">Required Field</div>      
              </div>
              <div class="col-sm-2">
                  <button id="btn-check" type="button" class="btn btn-success pull-left" data-complete-text="User OK">CheckUser</button>
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
               
            <div class="form-group"> 
              <label class="control-label col-sm-4" for="ddl-country">Country: </label> 
              <div class="col-sm-8">
              <select class="form-control" id="ddl-country"  style="width:50%"></select>
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
    
  <!-- Modal-Submit 
  <div class="modal fade" id="modal-submit" role="dialog">
    <div class="modal-dialog modal-sm">
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
 -->
</div>
</body>

</html>
