/*function emptyStaffLogin() {
    $(".staffLogin-text [name='Saccount']").val("");
    $(".staffLogin-text [name='Spaw']").val("");
    $("#error-m").html("");
}*/

$(document).ready(function () {
    $("#staffLoginButton").click(function () {
        var Saccount=$(".staffLogin-text [name='Saccount']").val();
        var Spaw=$(".staffLogin-text [name='Spaw']").val();
        $.ajax({
            url:"/car/staffLogin.do",
            type:"POST",
            dataType:"json",
            data: {
                Saccount:Saccount,
                Spaw:Spaw
            },
            success:function (data) {
                if(data.meg === "passerror"){
                    $("#error-m").html("<div class='alert alert-danger login-message'>密码错误</div>");
                } else if(data.meg === "null"){
                    $("#error-m").html("<div class='alert alert-danger login-message'>账号不存在</div>");
                } else if(data.meg === "ok" ){
                    $("#error-m").html("<div class='alert alert-success login-message'>登录成功</div>");
                    window.location.href = "/car/staffMainPage";
                }
            },
            error:function (xhr) {
                console.log(xhr.responseText);
            }
        });
    });
});