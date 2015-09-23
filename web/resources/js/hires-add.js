$(function (){
      
   $("#btn-submit").click(function(){
                    //llamar a la funcion de envio
                    frmSubmit();
                });
                
});//Close the 'DocumentReady' Block


function frmSubmit(){
    
    
    var $JsonData = {
        subOrganization:$("#"),
        firstName:'',
        lastName:'',
        identificationNumber:'',
        domainName:'',
        email:'',
        position:'',
        areaOU:'',
        location:'',
        emailGroup:'',
        phoneNumber:'',
        country:''
    };
    
    
    $.ajax({
        
        type: 'POST',
        url: 'http://localhost:8080/Gtools/Login',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        //timeout : 30000,
        success: function(data){
            console.log(data);
        }
    });
    
}// Close login function

    
 $(function(){
  $('#form-user').bValidator();
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
  