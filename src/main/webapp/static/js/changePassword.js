function emptyPass() {
    $("#modalPass [type='password']").each(function () {
        $(this).val("");
    });
    $(".error-if").each(function () {
        $(this).html("");
    });
    $(".login-body.user-acc").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");
    });
    $("#modalPass.error-message").html("");
}

var PassFlag=[];
$(document).ready(function () {
    $("#modalPass [name='oldPass']").bind("change",function () {
        var oldPass=$(this).val();
        $.ajax({
            url:"/car/changePass.judge",
            type:"POST",
            dataType:"json",
            data:{
                Upassword:oldPass
            },
            success:function (data) {
                if(data.message!=="right")
                {
                    var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                    var prompt = "<span class=\"register-error-message\">密码错误</span>";
                    $("#oldPass .error-if").html(icon + prompt);
                    $("#oldPass").addClass("has-error");
                    PassFlag[0] = false;
                }
                else
                {
                    $("#oldPass").removeClass("has-error");
                    var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                    $("#oldPass .error-if").html(icon);
                    $("#oldPass").addClass("has-success");
                    PassFlag[0] = true;
                }
            },
            error:function (xhr) {
                console.log(xhr.responseText);
                PassFlag[0]=false;
            }
        });
    });

    $("#modalPass [name='newPass']").bind("change",function () {
        var newPass=$(this).val();
        if(newPass.length<6||newPass.length>12)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">密码长度6-12位</span>";
            $("#newPass .error-if").html(icon + prompt);
            $("#newPass").addClass("has-error");
            PassFlag[1] = false;
        }
       else
        {
            $("#newPass").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#newPass .error-if").html(icon);
            $("#newPass").addClass("has-success");
            PassFlag[1] = true;
        }
    });

    $("#modalPass [name='passAgain']").bind("change",function () {
        var passAgain=$(this).val();
        if(passAgain!==$("#modalPass [name='newPass']").val())
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">两次输入结果不同</span>";
            $("#passAgain .error-if").html(icon + prompt);
            $("#passAgain").addClass("has-error");
            PassFlag[2] = false;
        }
        else
        {
            $("#modalPass [name='passAgain']").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#passAgain .error-if").html(icon);
            $("#passAgain").addClass("has-success");
            PassFlag[2] = true;
        }
    });
    
    $("#updatePass").click(function () {
        var flag=true;
        for(var i=0;i<PassFlag.length;i++)
        {
            if(PassFlag[i]===false)
            {
                flag=false;
                break;
            }
        }
        var oldPass=$("#modalPass [name='oldPass']").val();
        var newPass=$("#modalPass [name='newPass']").val();
        var passAgain=$("#modalPass [name='passAgain']").val();
        if(oldPass.length!==0&&newPass.length!==0&&passAgain.length!==0)
        {
            if(flag===false)
            {
                $("#modalPass .error-message").html("<div class='alert alert-danger login-message'>Error</div>");
            }
            else
            {
                $.ajax({
                    url:"/car/changePass.do",
                    type:"POST",
                    dataType:"json",
                    data:{Upassword:newPass},
                    success:function (data) {
                    if(data.message==="success")
                    {
                        $("#modalPass .error-message").html("<div class='alert alert-success login-message'>Success</div>");
                        window.location.href = "/car/home";
                    }
                },
                    error:function (xhr) {
                        console.log(xhr.responseText);
                    }
                });
            }
        }
        else {
            $("#modalPass .error-message").html("<div class='alert alert-danger login-message'>Wrong</div>");
        }
    });

})