$(function (){//'DocumentReady' Block
    //Envia los datos del formulario
   $("#btn-submit").click(function(){
        frmSubmit();
    });
                
});//Close the 'DocumentReady' Block


function frmSubmit(){

    var $JsonData = {
        subOrganization:'fafafa',
        firstName:'fafafa',
        lastName:'fafafa',
        identificationNumber:'fafafa',
        domainName:'ramiro.acoglanis',
        email:'fafafa',
        position:'fafafa',
        areaOU:'fafafa',
        location:'fafafa',
        emailGroup:'fafafa',
        phoneNumber:'fafafa',
        country:'fafafa'
    };
    
    $.ajax({
        type: 'POST',
        url: 'UserAdd',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($JsonData) ,
        success: function(data){
            console.log(data);
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
  