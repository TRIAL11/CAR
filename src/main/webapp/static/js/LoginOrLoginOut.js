//登录清空
function emptyLogin() {
    $(".login-text [name='Uaccount']").val("");
    $(".login-text [name='Upassword']").val("");
    $("#error-message").html("");
}

$(document).ready(function () {
    $("#modalLogin").modal({
        backdrop:false,
        show:false
    });

    $("#loginButton").click(function () {
        var Uaccount=$(".login-text [name='Uaccount']").val();
        var Upassword=$(".login-text [name='Upassword']").val();

        $.ajax({
            url:"/car/login.do",
            type:"POST",
            dataType:"json",
            data: {
                Uaccount:Uaccount,
                Upassword:Upassword
            },
            success:function (data) {
                if(data.meg === "passError"){
                    $("#error-message").html("<div class='alert alert-danger login-message'>密码错误</div>");
                } else if(data.meg === "null"){
                    $("#error-message").html("<div class='alert alert-danger login-message'>账号不存在</div>");
                } else if(data.meg === "ok" ){
                    $("#error-message").html("<div class='alert alert-success login-message'>登录成功</div>");
                    window.location.href = "/car/home";
                }
            },
            error:function (xhr) {
                console.log(xhr.responseText);
            }
        });
    });
});
