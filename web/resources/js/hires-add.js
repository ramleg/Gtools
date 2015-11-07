$(function (){//'DocumentReady' Block
    
    var opt = {
        group:$('#option-group'),
        glb:$('#opt-glb'),
        ext:$('#opt-ext')
    };
    var txt = {
        name:$('#txt-name'),
        lastname:$('#txt-lastname'),
        username:$('#txt-username'),
        idNumber:$('#txt-idnumber'),
        description:$('#txt-desc'),
        phone:$('#txt-phonenumber')
    };
    var ddl = {
        subDomain:$('#ddl-subdomain'),
        emailDomain:$('#ddl-emaildomain'),
        country:$('#ddl-country'),
        position:$('#ddl-position'),
        location:$('#ddl-location'),
        emailGroup:$('#ddl-emailgroup')
    };
    var btn = {
        buildUser:$('#btn-builduser'),
        checkUser:$('#btn-checkuser'),
        phoneNumber:$('#btn-getphonenumber'), 
        submit:$('#btn-submit'),
        cancel:$("#btn-cancel")
    };
    
    //********************************//
    // Fill the Form Controls --->>>  //
    //********************************//
    getList('GetCountryList',ddl.country);
    getList('GetPositionList',ddl.position);
    getList('GetLocationList',ddl.location);
    getList('GetEmailGroupList',ddl.emailGroup);
    
    //********************************//
    //Events Listeners --->>>         //
    //********************************//
    opt.glb.on('click', function(){
        getList('GetSubDomainList',ddl.subDomain, 'GLB');
        chekSubDomain;
    });
    opt.glb.on('blur',chekSubDomain);
    //-----------------------------------
    opt.ext.on('click', function(){
        getList('GetSubDomainList',ddl.subDomain, 'EXT');
        chekSubDomain;
    });
    opt.ext.on('blur',chekSubDomain);
    //-----------------------------------
    ddl.subDomain.on('change',chekSelect);
    ddl.subDomain.on('blur',chekSelect);
    //-----------------------------------
    txt.name.on('blur', chekName);
    txt.name.on('keyup', chekName);
    //-----------------------------------
    txt.lastname.on('blur', chekName);
    txt.lastname.on('keyup', chekName);
    //-----------------------------------
    txt.username.on('blur', chekName);
    txt.username.on('keyup', chekName);
    //-----------------------------------
    ddl.emailDomain.on('change',chekSelect);
    ddl.emailDomain.on('blur',chekSelect);
    //-----------------------------------
    ddl.country.on('change',chekSelect);
    ddl.country.on('blur',chekSelect);
    //-----------------------------------
    txt.idNumber.on('blur', chekName);
    txt.idNumber.on('keyup', chekName);
    //-----------------------------------
    ddl.position.on('change',chekSelect);
    ddl.position.on('blur',chekSelect);
    //-----------------------------------
    ddl.location.on('change',chekSelect);
    ddl.location.on('blur',chekSelect);
    //-----------------------------------
    ddl.emailGroup.on('change',chekSelect);
    ddl.emailGroup.on('blur',chekSelect);
    //-----------------------------------
    txt.phone.on('blur', chekName);
    txt.phone.on('keyup', chekName);
    txt.phone.on('keypress',onlyNumeric);
    //-----------------------------------
    //btn.checkUser.on('over', )
    //-----------------------------------
    btn.phoneNumber.on('click',reservePhoneNumber);
    //-----------------------------------
    btn.submit.on('click',frmSubmit);
    //-----------------------------------
    btn.cancel.on('click', clearForm);

//********************************//
// a bunch of functions --->>>    //
//********************************//
function getList($url, $ddl, $flag){

    $ddl.find('option').remove().end()
    .append
    ('<option value="">. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . </option>');
    
    var jsonData = {flag:$flag};
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

function reservePhoneNumber(){
    
    var $JsonData = {
      country:1  
    };
    
    $.ajax({
        type: 'POST',
        url: 'GetPhone',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            console.log(JSON.stringify(data));
            btn.phoneNumber.val(data.number);
        }
    });
    
}

function chekSelect(){
    if(chekEmpty($(this))){
        $(this).closest('.input-group').removeClass('has-error');
        $(this).closest('.input-group').addClass('has-success');
    }else{
        $(this).closest('.input-group').removeClass('has-success');
        $(this).closest('.input-group').addClass('has-error');
    }
}
function chekSubDomain(){
    if(chekEmpty(ddl.subDomain)){
        ddl.subDomain.closest('.input-group').removeClass('has-error');
        ddl.subDomain.closest('.input-group').addClass('has-success');
    }else{
        ddl.subDomain.closest('.input-group').removeClass('has-success');
        ddl.subDomain.closest('.input-group').addClass('has-error');
    }
}

function chekName(){
    
    if(chekEmpty($(this))){
        $(this).closest('.input-group').removeClass('has-error');
        $(this).closest('.input-group').addClass('has-success');
    }else{
        $(this).closest('.input-group').removeClass('has-success');
        $(this).closest('.input-group').addClass('has-error');
    }
    
}

function onlyNumeric(e){
    if(!(e.keyCode >=48 && e.keyCode <=57))
        e.preventDefault();
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
    
    for(var attr in txt){
        txt[attr].val('');
        txt[attr].closest('.input-group').removeClass('has-error has-success');
    }
    for(var attr in ddl){
        ddl[attr].val('').change();
        ddl[attr].closest('.input-group').removeClass('has-error has-success');
    }

}
});//Close the 'DocumentReady' Block


