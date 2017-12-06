$(document).ready(function () {

    $("#modalRegister").modal({
        backdrop:false,
        show:false
    });

    var flag=[];
    $(".register-body [name='Uaccount']").bind("change",function () {
        var Uaccount=$(this).val();
        if(Uaccount.length<4||Uaccount.length>6)
        {
            var icon="<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt="<span class=\"register-error-message\">账号为4-6位</span>";
            $("#groupAcc.error-if").html(icon+prompt);
            $("#groupAcc").addClass("has-error");
            flag[0]=false;
        }
        else
        {
            $.ajax({
                url:"/car/register.Uaccount",
                type:"POST",
                dataType:"json",
                data:{Uaccount:Uaccount},
                success:function (data) {
                    if(data.message==="right")
                    {
                        $("#groupAcc").removeClass("has-error");
                        var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                        $("#groupAcc .error-if").html(icon);
                        $("#groupAcc").addClass("has-success");
                        flag[0] = true;
                    }
                    else
                    {
                        var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                        var prompt = "<span class=\"register-error-message\">该账号已被注册</span>";
                        $("#groupAcc .error-if").html(icon + prompt);
                        $("#groupAcc").addClass("has-error");
                        flag[0] = false;
                    }
                },
                error:function (xhr) {
                    console.log(xhr.responseText);
                    flag[0]=false;
                }
            });
        }
    });

    $(".register-body [name='Upassword']").bind("change",function () {
        var Upassword=$(this).val();
        if(Upassword.length<6||Upassword.length>12)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">密码长度6-12位</span>";
            $("#groupPass .error-if").html(icon + prompt);
            $("#groupPass").addClass("has-error");
            flag[1] = false;
        }
        else
        {
            $("#groupPass").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#groupPass .error-if").html(icon);
            $("#groupPass").addClass("has-success");
            flag[1] = true;
        }
    });

    $(".register-body [name='Uname']").bind("change",function () {
        var Uname=$(this).val();
        if(Uname.length<2||Uname.length>8)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">昵称长度2-8位</span>";
            $("#groupName .error-if").html(icon + prompt);
            $("#groupName").addClass("has-error");
            flag[2]=false;
        }
        else
        {
            $("#groupName").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#groupName .error-if").html(icon);
            $("#groupName").addClass("has-success");
            flag[2]=true;
        }
    })

    $(".register-body [name='Uphone']").bind("change",function () {
        var Uphone=$(this).val();
        if(Uphone.length!=11)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">手机号码格式错误</span>";
            $("#groupPhone .error-if").html(icon + prompt);
            $("#groupPhone").addClass("has-error");
            flag[3] = false;
        }
        else
        {
            $("#groupPhone").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#groupPhone .error-if").html(icon);
            $("#groupPhone").addClass("has-success");
            flag[3]=true;
        }
    });

    $(".register-body [name='Uid']").bind("change",function () {
        var Uid=$(this).val();
        if(Uid.length!=18)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">身份证格式错误</span>";
            $("#groupId .error-if").html(icon + prompt);
            $("#groupId").addClass("has-error");
            flag[4] = false;
        }
        else
        {
            $("#groupId").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#groupId .error-if").html(icon);
            $("#groupId").addClass("has-success");
            flag[4]=true;
        }
    });

    $(".register-body [name='Uemail']").bind("change",function () {
        var Uemail=$(this).val();
        var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if(reg.test(Uemail))
        {
            $.ajax({
                url:"/car/register.Uemail",
                type:"POST",
                dataType:"json",
                data:{Uemail:Uemail},
                success:function (data)
                {
                    if(data.message==="error")
                    {
                        var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                        var message = "<span class=\"register-error-message\">该邮箱已被使用</span>";
                        $("#groupEmail .error-if").html(icon + message);
                        $("#groupEmail").addClass("has-error");
                        flag[5] = false;
                    }
                    else
                    {
                        $("#groupEmail").removeClass("has-error");
                        var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                        $("#groupEmail .error-if").html(icon);
                        $("#groupEmail").addClass("has-success");
                        flag[5] = true;
                    }
                },
                error:function (xhr) {
                    console.log(xhr.responseText);
                    flag[5]=false;
                }
            });
        }
        else
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">邮箱格式错误</span>";
            $("#groupEmail .error-if").html(icon + message);
            $("#groupEmail").addClass("has-error");
            flag[5] = false;
        }
    });

    $("#registerButton").click(function () {
        var Uaccount=$(".register-text [name='Uaccount']").val();
        var Upassword=$(".register-text [name='Upassword']").val();
        var Uname=$(".register-text [name='Uname']").val();
        var Uphone=$(".register-text [name='Uphone']").val();
        var Uid=$(".register-text [name='Uid']").val();
        var Uemail=$(".register-text [name='Uemail']").val();

        if(Uaccount!==""&&Upassword!==""&&Uname!==""&&Uphone!==""&&Uid!==""&&Uemail!=="")
        {
            var flagx=true;
            for(var i=0;i<flag.length;i++)
            {
                if(flag[i]===false)
                {
                    flagx=false;
                    break;
                }
            }
            if(flagx===true)
            {
                $.ajax({
                    url:"/car/register.do",
                    type:"POST",
                    dataType:"json",
                    data:{
                        Uaccount:Uaccount,
                        Upassword:Upassword,
                        Uname:Uname,
                        Uphone:Uphone,
                        Uid:Uid,
                        Uemail:Uemail
                    },
                    success:function (data) {
                        console.log(data.meg);
                        if(data.meg === "null"){
                            $("#error-message-register").html("<div class='alert alert-danger register-message'>该账号已被注册</div>");
                        }
                        else if(data.meg === "emailError"){
                            $("#error-message-register").html("<div class='alert alert-danger register-message'>该邮箱已被注册</div>");
                        } else if(data.meg === "right"){
                            $("#error-message-register").html("<div class='alert alert-success register-message'>注册成功</div>");
                            $.post("/car/register.in", {Uaccount: Uaccount}, function () {
                                window.location.href = "/car/home";
                            });
                        }
                    },
                    error: function (xhr) {
                        console.log(xhr.responseText);
                    }
                });
            } else {
                $("#error-message-register").html("<div class='alert alert-danger register-message'>请处理错误项</div>");
            }
        }
        else{
            $("#error-message-register").html("<div class='alert alert-danger register-message'>请填写完注册项</div>");
        }
    });

});

function emptyRegister() {
    $(".register-text [name='Uaccount']").val("");
    $(".register-text [name='Upassword']").val("");
    $(".register-text [name='Uname']").val("");
    $(".register-text [name='Uphone']").val("");
    $(".register-text [name='Uid']").val("");
    $(".register-text [name='Uemail']").val("");
    $("#error-message-register").html("");
    $(".error-if").each(function () {
        $(this).html("");
    });
    $(".register-body .user-acc").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");
    });
}