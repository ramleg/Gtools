$(function (){//'DocumentReady' Block
    //$('.selectpicker').selectpicker();
    
    getList('GetSuborgList',$('#ddl-suborg'));
    getList('GetPositionList',$('#ddl-position'));
    getList('GetLocationList',$('#ddl-location'));
    getList('GetEmailGroupList',$('#ddl-emailgroup'));
    getList('GetCountryList',$('#ddl-country'));
    
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
