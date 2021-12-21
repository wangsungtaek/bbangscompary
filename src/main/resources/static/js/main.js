$("#btn_contactUs").click(function(){

    let name = $("#name").val();
    let email = $("#email").val();
    let subject = $("#subject").val();
    let message = $("#message").val();

    if(name == "" || email == "" || subject == ""){
        alert("이름, 이메일, 제목을 입력해주세요.");
        return;
    }

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
            $("#name").val("");
            $("#email").val("");
            $("#subject").val("");
            $("#message").val("");
            alert("문의가 완료되었습니다.");
        },
        error: function() {
            console.log("에러");
        }
    })

});
