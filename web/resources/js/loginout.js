$(function (){
   
   var $username = $('#username');
   var $passwd = $('#passwd');
      
   $("#loginBtn").click(function(){
                    login($username.val(), $passwd.val());
                });
});//Close the 'DocumentReady' Block


function login($username, $passwd){
    
    var userData={id:'0', name: '$username',lastname: '$passwd', userId:'us',rol:'asd'};
    
    $.ajax({
        
        type: 'POST',
        url: 'http://localhost:8080/Gtools/Login',
        dataType: 'json',
        contentType: 'application/json',
        data: userData,
        //timeout : 30000,
        success: function(data){
            console.log(data);
        }
    });
    
}// Close login function