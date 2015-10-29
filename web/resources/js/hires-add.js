$(function (){//'DocumentReady' Block
    
    var optGlobant = $('#opt-globant');
    var optExternals = $('#opt-externals');
    var ddlSubDomain = ('#ddl-subdomain');
    var txtName = $('#txt-name');
    var txtLastname = $('#txt-lastname');
    var txtUsername = $('#txt-username');
    var ddlEmailDomain = $('#ddl-emaildomain');
    var btnBuildUser = $('#btn-builduser');
    var btnCheckUser = $('#btn-checkuser');
    var ddlCountry = $('#ddl-country');
    var txtIdNumber = $('#txt-idnumber');
    var ddlPosition = $('#ddl-position');
    var ddlLocation = $('#ddl-location');
    var ddlEmailGroup = $('#ddl-emailgroup');
    var txtPhone = $('txt-phonenumber');
    var btnGetPhoneNumber = $('#btn-getphonenumber');
    var txtDescription = $('#txt-desc');
    var btnSubmit = $('#btn-submit');
    var btnCancel= $("#btn-cancel");
    
    //********************************//
    // Fill the Form Controls --->>>  //
    //********************************//
    getList('GetSuborgList',ddlSubDomain,1);
    getList('GetCountryList',ddlCountry);
    getList('GetPositionList',ddlPosition);
    getList('GetLocationList',ddlLocation);
    getList('GetEmailGroupList',ddlEmailGroup);
    
    //********************************//
    //Events Listeners --->>>         //
    //********************************//
    btnSubmit.on('click',frmSubmit);
    txtPhone.on('keypress',keyPressControl);
    txtName.on('blur',chekOnBlur(txtName));
    txtDescription.on('keypress',function(e){
        console.log(e.keyCode);
    });





//********************************//
// a bunch of functions --->>>    //
//********************************//
function getList($url, $ddl, $i){
    $.ajax({
        type: 'GET',
        url: $url,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function(data){
            setDDL(data, $ddl);
            $ddl.val($i).change();
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
// Submit DATA ----->>>
function frmSubmit(){

    var $JsonData = {
        subOrganization:$("#ddl-suborg option:selected").val(),
        name:$('#txt-name').val(),
        lastName:$('#txt-lastname').val(),
        identificationNumber:$('#txt-idnumber').val(),
        domainName:$('#txt-username').val(),
        email:$('#txt-username').val() + '@' + $('#ddl-emaildomain option:selected').text() ,
        position:$('#ddl-position').val(),
        location:$('#ddl-location').val(),
        emailGroup:$('#ddl-emailgroup').val(),
        phoneNumber:$('#txt-phonenumber').val(),
        country:$('#ddl-country').val(),
        description:$('#txtarea-desc').val()
    };
    alert(JSON.stringify($JsonData));
    $.ajax({
        type: 'POST',
        url: 'HireAdd',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            if (typeof data.error === "undefined"){
                alert('Success: ' + data.email);
            }else{
                alert('Error: ' + data.error);
            }
        }
    });
    
}
function keyPressControl(e){
    if(!(e.keyCode >=48 && e.keyCode <=57))
        e.preventDefault();
}
function chekOnBlur(control){
    if(control.val()==""){
        control.closest('.input-group').addClass('has-error');
    }else{
        control.closest('.input-group').removeClass('has-error');
    }
}
function chekOnKeyUp(id){
    $('#'+ id).closest('.input-group').removeClass('has-error');
}



function allowJustNumbers(e){
    
    // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
             // Allow: Ctrl+C
            (e.keyCode == 67 && e.ctrlKey === true) ||
             // Allow: Ctrl+X
            (e.keyCode == 88 && e.ctrlKey === true) ||
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
}

});//Close the 'DocumentReady' Block


