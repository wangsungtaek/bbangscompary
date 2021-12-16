$("#btn_contactUs").click(function(){

    let name = $("#name").val();
    let email = $("#email").val();
    let subject = $("#subject").val();
    let message = $("#message").val();

    console.log(name);

    $.ajax({
        url: "/contactUs",
        data: {
            name: name,
            email: email,
            subject: subject,
            message: message
        },
        method: "POST",
        dataType: "json",
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        success: function(result) {
            console.log("완료");
        },
        error: function() {
            console.log("에러");
        }
    })

});
