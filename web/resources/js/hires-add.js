$(function (){//'DocumentReady' Block
    //$('.selectpicker').selectpicker();
    
    getList('GetSuborgList',$('#ddl-suborg'));
    getList('GetPositionList',$('#ddl-position'));
    getList('GetLocationList',$('#ddl-location'));
    getList('GetEmailGroupList',$('#ddl-emailgroup'));
    getList('GetCountryList',$('#ddl-country'));
    //validator
    $('#frm-hireadd').bValidator();
    //submit
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
        email:$('#txt-email').val(),
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
            if (typeof data.error === "undefined"){
                alert('Success: ' + data.name);
            }else{
                alert('Error: ' + data.error);
            }
        }
    });
    
}// Close login function

//Asigna Mail
function func_mail(){
 $("#txt-email").val($("#txt-username").val() + $("#ddl-suborg option:selected").val());//"@globant.com");
}
//Asigna OU Position
function func_position_ad(){
 $("#txt-ouorg").val($("#ddl-position option:selected").text());
}
