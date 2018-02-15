$(document).ready(function() {
    $("#createBuddy-form").submit(function(event){
        event.preventDefault();
        $.ajax({
            url:"http://localhost:5151/buddyinfos",
            type:"POST",
            data: '{"name": "'+ $("#buddyName").val() + '", "phoneNumber": "' + $("#buddyPhoneNumber").val() + '"}',
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(){
                location.reload();
            }
        })
    });
});