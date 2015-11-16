$(function (){//'DocumentReady' Block
    
    var opt = {
        group:$('#option-group'),
        glb:$('#opt-glb'),
        ext:$('#opt-ext')
    };
    var txt = {
        name:$('#txt-name'),
        lastname:$('#txt-lastname'),
        domainUser:$('#txt-username'),
        idNumber:$('#txt-idnumber'),
        description:$('#txt-desc')
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
    getHiresTable();
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
    ddl.subDomain.on('change',function(){
        if (chekSelect()){
            getList('GetEmailDomain',ddl.emailDomain, ddl.subDomain.find(':selected').val());
        }else{
            ddl.emailDomain.find('option').remove().end()
            .append
            ('<option value="">. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . </option>');
        }
        
    });
    ddl.subDomain.on('blur',chekSelect);
    
    //-----------------------------------
    txt.name.on('blur', chekName);
    txt.name.on('keyup', chekName);
    //-----------------------------------
    txt.lastname.on('blur', chekName);
    txt.lastname.on('keyup', chekName);
    //-----------------------------------
    txt.domainUser.on('blur', chekUserName);
    txt.domainUser.on('keyup', chekUserName);
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
    btn.checkUser.on('click',checkDomainUser);
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
function getHiresTable(){
    $('#panel-2').slideUp(function(){
           $('#table-hires').find('tr').remove();
            $.ajax({
                type: 'GET',
                url: 'GetHiresList',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                success: function(data){
                    console.log(JSON.stringify(data));
                    setTable(data);
                }
            });
           $('#panel-2').slideDown('slow');
        });
}

function setTable (json){
    
    $('#table-hires').append('<tr><th>User</th><th>Full Name</th><th>Position</th><th>Location</th><th></th></tr>');
    
    for(var key in json){
        $('#table-hires').append('<tr><td>' + json[key].domainUser + '@' + json[key].emailDomian.desc + '</td><td>' + json[key].name + ', ' + json[key].lastname + '</td><td>' + json[key].position.desc + '</td><td>' + json[key].location.desc + '</td><td class="rojo"><span class="glyphicon glyphicon-remove"></span></td></tr>');
    }
    
}
    


// Submit DATA ----->>>
function frmSubmit(){
    
    var $JsonData = {
        subDomain:ddl.subDomain.find(':selected').val(),
        name:txt.name.val(),
        lastName:txt.lastname.val(),
        idNumber:txt.idNumber.val(),
        domainUser:txt.domainUser.val(),
        emailDomain:ddl.emailDomain.find(':selected').val() ,
        position:ddl.position.find(':selected').val(),
        location:ddl.location.find(':selected').val(),
        emailGroup:ddl.emailGroup.find(':selected').val(),
        country:ddl.country.find(':selected').val(),
        description:txt.description.val()
    };    
    
    var $errors = checkSubmit($JsonData);
    if(!Object.keys($errors).length > 0){
        
        $.ajax({
        type: 'POST',
        url: 'HireAdd',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            btn.submit.toogleClass('disabled');
            if (typeof data.error === "undefined"){
                clearForm();
                getHiresTable();
            }else{
                toggleAlert('Server side Error:', data);
            }
            btn.submit.toogleClass('disabled');
        }
        });
        
    }else{
        toggleAlert('Form Error:',$errors);
    }
        
    
    
}
function toggleAlert(title, errors){
    
    $('.modal-body').find('p').remove();
    $('.modal-title').text(title);
    for(var key in errors)
        $('.modal-body').append('<p>' + errors[key] + '</p>');
    $('.modal').modal('toggle');
    
}
function checkSubmit($JsonData){
    
    var $errors = {};
        
    if(!chekEmpty($JsonData.subDomain))
        $errors.subDomain='[Sub Domain]';
    if(!chekEmpty($JsonData.name))
        $errors.name='[Name]';
    if(!chekEmpty($JsonData.lastName))
        $errors.lastName='[Last Name]';
    if(!chekEmpty($JsonData.idNumber))
        $errors.idNumber='[ID Number]';
    if(!chekEmpty($JsonData.domainUser))
        $errors.domainUser='[Domain User]';
    if(!chekEmpty($JsonData.emailDomain))
        $errors.emailDomain='[Email Domain]';
    if(!chekEmpty($JsonData.position))
        $errors.position='[Position]';
    if(!chekEmpty($JsonData.location))
        $errors.location='[Location]';
    if(!chekEmpty($JsonData.emailGroup))
        $errors.emailGroup='[Email Group]';
    if(!chekEmpty($JsonData.country))
        $errors.country='[Country]';
    
    return $errors;
}
function checkDomainUser(){
    
    var $JsonData = {
        domainUser:txt.domainUser.val()
    };
    
    $.ajax({
        type: 'POST',
        url: 'CheckDomainUser',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            showUserCheck(data);
        }
                
    });
}



function showUserCheck(data){
    if (typeof data.errors[0] === 'undefined'){
        btn.checkUser.closest('.input-group').removeClass('has-error');
        btn.checkUser.closest('.input-group').addClass('has-success');
        btn.checkUser.text(' Ok ');
    }else{
        btn.checkUser.closest('.input-group').removeClass('has-success');
        btn.checkUser.closest('.input-group').addClass('has-error');
        txt.domainUser.val('');
        txt.domainUser.attr("placeholder", data.errors[0]);
        btn.checkUser.text(' Bad ');
    }
}
function chekUserName(){
    
    btn.checkUser.text('Check');
    txt.domainUser.attr("placeholder", 'user');
    
    if(chekEmpty($(this).val())){
        $(this).closest('.input-group').removeClass('has-error');
        $(this).closest('.input-group').addClass('has-success');
    }else{
        $(this).closest('.input-group').removeClass('has-success');
        $(this).closest('.input-group').addClass('has-error');
    }
}
function chekSelect(){
    if(chekEmpty($(this))){
        $(this).closest('.input-group').removeClass('has-error');
        $(this).closest('.input-group').addClass('has-success');
        return true;
    }else{
        $(this).closest('.input-group').removeClass('has-success');
        $(this).closest('.input-group').addClass('has-error');
        return false;
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
    
    if(chekEmpty($(this).val())){
        $(this).closest('.input-group').removeClass('has-error');
        $(this).closest('.input-group').addClass('has-success');
    }else{
        $(this).closest('.input-group').removeClass('has-success');
        $(this).closest('.input-group').addClass('has-error');
    }
    
}
function chekPhone(){
    
    if(chekEmpty(txt.phone)){
        txt.phone.closest('.input-group').removeClass('has-error');
        txt.phone.closest('.input-group').addClass('has-success');
    }else{
        txt.phone.closest('.input-group').removeClass('has-success');
        txt.phone.closest('.input-group').addClass('has-error');
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
    btn.checkUser.text('Check');
    txt.domainUser.attr("placeholder",'user');
}
});//Close the 'DocumentReady' Block


