$(function (){//'DocumentReady' Block
    //$('.selectpicker').selectpicker();
    
    getList('GetSuborgList',$('#ddl-suborg'),1);
    getList('GetPositionList',$('#ddl-position'));
    getList('GetLocationList',$('#ddl-location'));
    getList('GetEmailGroupList',$('#ddl-emailgroup'));
    getList('GetCountryList',$('#ddl-country'));
    //submit
    $("#btn-submit").click(function(){frmSubmit();});
    //validation
    $('#txtarea-desc').on('keypress',function(e){
        console.log(e.keyCode);
    });
    $('#txt-phonenumber').on('keypress',keyPressControl);
                
});//Close the 'DocumentReady' Block

function keyPressControl(e){
    if(!(e.keyCode >=48 && e.keyCode <=57))
        e.preventDefault();
    
}

function chekOnBlur(id){
    if($('#'+ id).val()==""){
        $('#'+ id).closest('.input-group').addClass('has-error');
    }else{
        $('#'+ id).closest('.input-group').removeClass('has-error');
    }
}

function chekOnKeyUp(id){
    $('#'+ id).closest('.input-group').removeClass('has-error');
}

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
    
}// Close login function


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

