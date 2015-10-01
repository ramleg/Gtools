$(function (){//'DocumentReady' Block

    frmPopulate();
   $("#btn-submit").click(function(){
        frmSubmit();
    });
                
});//Close the 'DocumentReady' Block


function setDDlist($dataType, $ddl){
    
    var data = {dataType:$dataType};
    
    $.ajax({
        type: 'GET',
        url: 'GetList',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function(data){
            alert(data);
        },
        error: function(){
            alert('error');
        }
    });
    
    
}


function frmPopulate(){

    $.ajax({
        type: 'GET',
        url: 'HireAdd',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function(data){
            setDDL(data[0],$('#ddl-suborg'),'desc');
            setDDL(data[1],$('#ddl_position'),'desc');
            setDDL(data[2],$('#ddl-location'),'desc');
            setDDL(data[3],$('#ddl-country'),'desc');
        },
        error: function(){
            alert('error');
        }
    });
}

function setDDL(bigJson, control, prop){

    var htmlData = '';
    
    for(var key in bigJson){
        var dataBuffer = {};
        for(var props in bigJson[key]){
            if(prop !== props){
                dataBuffer[props]=bigJson[key][props];
            }else{
                //dataBuffer[props]=bigJson[key][props];
                var value = bigJson[key][props];
            }
        }
        htmlData = htmlData + '<option data-gtools-' + control.attr('id') + '=' + JSON.stringify(dataBuffer) + ' >' + value + '</option>';
    }
    control.append(htmlData);
    
    
}



function frmSubmit(){

    var $JsonData = {
        subOrganization:'Globant',
        firstName:'Peter',
        lastName:'Capusotto',
        identificationNumber:'123456789',
        domainName:'peter.capusotto',
        email:'peter.capusotto@globant.com',
        position:'Java Dev',
        areaOU:'OU=Developer, DC=Globant, DC=Com',
        location:'AR/Ros/Museion',
        emailGroup:'rosario@globant.com',
        phoneNumber:'14600',
        country:'Argentina'
    };
    
    $.ajax({
        type: 'POST',
        url: 'HireAdd',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
           alert(data);
        }
    });
    
}// Close login function

    
 $(function(){
  $('#frm-useradd').bValidator();
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
