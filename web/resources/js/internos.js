$(function (){//'DocumentReady' Block

var ctr = {
        start:$('#start-int'),
        finish:$('#finish-int'),
        country:$('#ddl-country'),
        status:$('#ddl-status'),
        submit:$('#btn-submit')
    };

ctr.submit.on('click',frmSubmit);


function frmSubmit(){
    
    var $JsonData = {
        nrostart:ctr.start.val(),
        nrofinish:ctr.finish.val(),
        country:ctr.country.find(':selected').text(),
        status:ctr.status.find(':selected').text()
    };    
    
    var $errors = check_data($JsonData);
    
    if(Object.keys($errors).length == 0){
        
        $.ajax({
        type: 'POST',
        url: '',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            
        }
        });
        
    }else{
        toggleAlert('Errors:',$errors, 'alert-danger');
    }
}

function check_data(Json){  
    var $errors = {};
        
    if(Json.nrostart==''||Json.nrofinish==''||Json.country==''||Json.status=='')
        $errors.error1=' * Empty Field';
    if(Json.nrofinish <= Json.nrostart)
        $errors.error2='* Incorrect Range';
    return $errors;
    
}

function toggleAlert(title, items, format){
    $('.modal-body').find('p').remove();
    $('.modal-title').text(title);
    $('#modal-color').addClass(format);
    for(var key in items)
        $('.modal-body').append('<p>' + items[key] + '</p>');
    $('.modal').modal('toggle');
    
}

})

