$(document).ready(function () {
    disableUserInfo(true);

    $("#changeUserInfo").click(function () {
        disableUserInfo(false);
    });

    var status=[];
    $(".user-into-form [name='Uname']").bind("change",function () {
        var Uname=$(this).val();
        if(Uname.length<2||Uname.length>8)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"error-message\">昵称长度2-6位</span>";
            $("#groupName .error-if").html(icon + prompt);
            $("#groupName").addClass("has-error");
            status[0] = false;
        }
        else
        {
            $("#groupName .error-if").html("");
            $("#groupName").removeClass("has-error");
            status[0] = true;
        }
        updateUserInfo(status);
    });

    $(".user-into-form [name='Uphone']").bind("change",function () {
        var Uphone=$(this).val();
        if(Uphone.length!=11)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"error-message\">请输入正确的手机号码</span>";
            $("#groupTel .error-if").html(icon + prompt);
            $("#groupTel").addClass("has-error");
            status[1] = false;
        }
        else
        {
            $("#groupTel .error-if").html("");
            $("#groupTel").removeClass("has-error");
            status[1] = true;
        }
        updateUserInfo(status);
    });

    $(".user-into-form [name='Uid']").bind("change",function () {
        var Uid=$(this).val();
        if(Uid.length!=18)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"error-message\">身份证号格式错误</span>";
            $("#groupIdCard .error-if").html(icon + prompt);
            $("#groupIdCard").addClass("has-error");
            status[2] = false;
        }
        else
        {
            $("#groupIdCard.error-if").html("");
            $("#groupIdCard").removeClass("has-error");
            status[2]=true;
        }
        updateUserInfo(status);
    });
    
    $(".user-into-form [name='Uemail']").bind("change",function () {
        var Uemail=$(this).val();
        var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if(reg.test(Uemail))
        {
            $.ajax({
                url:"/car/UpEmail.do",
                type:"POST",
                dataType:"json",
                data:{Uemail:Uemail},
                success:function (data) {
                    if(data.message==="error")
                    {
                        var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                        var prompt = "<span class=\"error-message\">该邮箱已被使用</span>";
                        $("#groupEmail .error-if").html(icon + prompt);
                        $("#groupEmail").addClass("has-error");
                        status[3] = false;
                    }
                    else
                    {
                        $("#groupEmail .error-if").html("");
                        $("#groupEmail").removeClass("has-error");
                        status[3] = true;
                    }
                },
                error:function (xhr) {
                    console.log(xhr.responseText);
                    status[3] = false;
                }
            });
        }
        else
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"error-message\">邮箱格式错误</span>";
            $("#groupEmail .error-if").html(icon + prompt);
            $("#groupEmail").addClass("has-error");
            status[3] = false;
        }
        updateUserInfo(status);
    });
});

function disableUserInfo(status) {
    $(".user-info-form input").each(function () {
        $(this).attr("disabled", status);
    });
}

function updateUserInfo(status) {
    var flag = true;
    for(var i = 0; i<status.length; i++) {
        if(status[i] === false) {
            flag = false;
            break;
        }
    }
    if(flag === true) {
        $("#saveChange").attr("disabled", false);
    } else {
        $("#saveChange").attr("disabled", true);
    }
}

function saveMessage() {
    alert("修改成功");
}