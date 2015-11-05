$(function (){//'DocumentReady' Block
    
    var optGroup =      $('#option-group');
    var optGlobant =    $('#opt-glb');
    var optExternals =  $('#opt-ext');
    
    var ddlSubDomain =  $('#ddl-subdomain');
    var ddlEmailDomain = $('#ddl-emaildomain');
    var ddlCountry =    $('#ddl-country');
    var ddlPosition =   $('#ddl-position');
    var ddlLocation =   $('#ddl-location');
    var ddlEmailGroup = $('#ddl-emailgroup');
    
    var txtName =       $('#txt-name');
    var txtLastname =   $('#txt-lastname');
    var txtUsername =   $('#txt-username');
    var txtIdNumber =   $('#txt-idnumber');
    var txtDescription = $('#txt-desc');
    var txtPhone =      $('#txt-phonenumber');
    
    var btnBuildUser =  $('#btn-builduser');
    var btnCheckUser =  $('#btn-checkuser');
    var btnGetPhoneNumber = $('#btn-getphonenumber');    
    var btnSubmit =     $('#btn-submit');
    var btnCancel=      $("#btn-cancel");
    //********************************//
    // Fill the Form Controls --->>>  //
    //********************************//
    getList('GetCountryList',ddlCountry);
    getList('GetPositionList',ddlPosition);
    getList('GetLocationList',ddlLocation);
    getList('GetEmailGroupList',ddlEmailGroup);
    
    //********************************//
    //Events Listeners --->>>         //
    //********************************//
    optGlobant.on('click', function(){getList('GetSubDomainList',ddlSubDomain, 'GLB');});
    optExternals.on('click', function(){getList('GetSubDomainList',ddlSubDomain, 'EXT');});
    
    txtName.on('blur', chekEmpty);
    txtName.on('keyup', chekEmpty);
    
    txtLastname.on('blur', chekEmpty);
    txtLastname.on('keyup', chekEmpty);
    
    txtUsername.on('blur', chekEmpty);
    txtUsername.on('keyup', chekEmpty);
    
    txtPhone.on('keypress',keyPressControl);
    
    btnSubmit.on('click',frmSubmit);
    
    btnCancel.on('click', function(){
        clearForm();
    });

//********************************//
// a bunch of functions --->>>    //
//********************************//
function getList($url, $ddl, $flag){

    $ddl.find('option').remove().end()
    .append
    ('<option value="">. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . </option>');
    
    var jsonData = {flag:$flag};
    console.log($flag);
    $.ajax({
        type: 'POST',
        url: $url,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(jsonData),
        success: function(data){
            setDDL(data, $ddl);
            //$ddl.val($i).change();
        },
        error: function(data){
            setDDL(data, $ddl);
        }
    });
    
}
function setDDL(json, control){
    var htmlData = '';
    for(var key in json)
        htmlData = htmlData + '<option value=' + json[key].id + ' >' + json[key].desc + '</option>';
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
    console.log(JSON.stringify($JsonData));
    
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
function chekEmpty(){
    if($(this).val()==""){
        $(this).closest('.input-group').addClass('has-error');
    }else{
        $(this).closest('.input-group').removeClass('has-error');
    }
}
function chekOnKeyUp(){
    $(this).closest('.input-group').removeClass('has-error');
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

function clearForm(){
    
    ddlSubDomain.val('').change();
    txtName.val('');
    txtLastname.val('');
    txtUsername.val('');
    ddlEmailDomain.val('').change();
    ddlCountry.val('').change();
    txtIdNumber.val('');
    ddlPosition.val('').change();
    ddlLocation.val('').change();
    ddlEmailGroup.val('').change();
    txtPhone.val('');
    txtDescription.val('');
    
    ddlSubDomain.closest('.input-group').removeClass('has-error has-success');
    txtName.closest('.input-group').removeClass('has-error has-success');
    txtLastname.closest('.input-group').removeClass('has-error has-success');
    txtUsername.closest('.input-group').removeClass('has-error has-success');
    ddlEmailDomain.closest('.input-group').removeClass('has-error has-success');
    ddlCountry.closest('.input-group').removeClass('has-error has-success');
    txtIdNumber.closest('.input-group').removeClass('has-error has-success');
    ddlPosition.closest('.input-group').removeClass('has-error has-success');
    ddlLocation.closest('.input-group').removeClass('has-error has-success');
    ddlEmailGroup.closest('.input-group').removeClass('has-error has-success');
    txtPhone.closest('.input-group').removeClass('has-error has-success');
    txtDescription.closest('.input-group').removeClass('has-error has-success');
}
});//Close the 'DocumentReady' Block


