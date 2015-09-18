$(function (){
   
   var $username = $('#username');
   var $passwd = $('#passwd');
      
   $("#loginBtn").click(function(){
                    login($username.val(), $passwd.val());
                });
});//Close the 'DocumentReady' Block


function login($username, $passwd){
    
    var userData={userId:'ramiro.acoglanis'};
    
    $.ajax({
        
        type: 'POST',
        url: 'http://localhost:8080/Gtools/Login',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(userData) ,
        //timeout : 30000,
        success: function(data){
            console.log(data);
        }
    });
    
}// Close login function