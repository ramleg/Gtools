$(function (){//'DocumentReady' Block
    //$('.selectpicker').selectpicker();
    
    getList('GetSuborgList',$('#ddl-suborg'));
    getList('GetPositionList',$('#ddl-position'));
    getList('GetLocationList',$('#ddl-location'));
    getList('GetEmailGroupList',$('#ddl-emailgroup'));
    getList('GetCountryList',$('#ddl-country'));
    
   $("#btn-submit").click(function(){frmSubmit();});
                
});//Close the 'DocumentReady' Block

function getList($url, $ddl){
    
    $.ajax({
        type: 'GET',
        url: $url,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function(data){
            setDDL(data, $ddl);
        },
        error: function(){
            setDDL(data, $ddl);
        }
    });
}
function setDDL(json, control){
    var htmlData = '';
    for(var key in json[0])
        htmlData = htmlData + '<option value=' + json[0][key].id + ' >' + json[0][key].desc + '</option>';
    control.append(htmlData);
}



function frmSubmit(){

    var $JsonData = {
        subOrganization:$('#ddl-suborg').val(),
        name:$('#txt-name').val(),
        lastName:$('#txt-lastname').val(),
        identificationNumber:$('#txt-idnumber').val(),
        domainName:$('#txt-username').val(),
        position:$('#ddl-position').val(),
        location:$('#ddl-location').val(),
        emailGroup:$('#ddl-emailgroup').val(),
        phoneNumber:$('#txt-phonenumber').val(),
        country:$('#ddl-country').val()
    };
    
    $.ajax({
        type: 'POST',
        url: 'HireAdd',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            if (typeof data.error === "undefined") {
                alert("No Errors Here");
            }else{
                alert(data.error);
            }
        }
    });
    
}// Close login function

    
 $(function(){
  $('#frm-hireadd').bValidator();
 });
//Asigna Mail
    function func_mail(){
     $("#txt-mail").val($("#txt-username").val() + $("#ddl_suborg option:selected").val());//"@globant.com");
    }
    
//Asigna OU Position
    function func_position_ad(){
     $("#txt-ou-org").val($("#ddl_position option:selected").val());
    }
    
//CHECK BUTTON
    $(document).ready(function(){
      $("#btn_check").click(function(){
        $(this).button('Cheking').delay(1000).queue(function(){
          $(this).button('complete');
          $(this).dequeue();
        });        
      });  
    });
  
//SUBMIT
    $(document).ready(function(){
      $("#btn-submit").click(function(){
        $("#modal-submit").modal();
      });
    });
