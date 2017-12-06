function emptyRec() {
    $("#modalRecharge [type='password']").each(function () {
        $(this).val("");
    })
    $(".error-if").each(function () {
        $(this).html("");
    })
    $(".recharge-body.user-rec").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");
    })
    $("#error-mes").html("");
}

var reflag=[];
$(document).ready(function () {
    $("#modalRecharge [name='inputMoney']").bind("change",function () {
        var inputMoney=$(this).val();
        if(inputMoney.length>5||inputMoney.length<2)
        {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var prompt = "<span class=\"register-error-message\">金额过大或数值不合法</span>";
            $("#inputMoney.error-if").html(icon+prompt);
            $("#inputMoney").addClass("has-error");
            reflag[0]=false;
        }
        else
        {
            $("#inputMoney").removeClass("has-error");
            var icon="<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#inputMoney.error-if").html(icon);
            $("#inputMoney").addClass("has-success");
            reflag[0]=true;
        }
    });


    $("#modalRecharge [name='checkRec']").bind("change",function () {
        var checkRec=$(this).val();
        $.ajax({
            url:"/car/changePass.judge",
            type:"POST",
            dataType:"json",
            data:{Upassword:checkRec},
            success:function (data) {
                if(data.message!=="right")
                {
                    var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                    var prompt = "<span class=\"register-error-message\">密码错误</span>";
                    $("#checkRec .error-if").html(icon + prompt);
                    $("#checkRec").addClass("has-error");
                    reflag[1] = false;
                }
                else
                {
                    $("#checkRec").removeClass("has-error");
                    var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                    $("#checkRec .error-if").html(icon);
                    $("#checkRec").addClass("has-success");
                    reflag[1] = true;
                }
            },
            error:function (xhr) {
                console.log(xhr.responseText);
                reflag[1]=false;
            }
        });
    });
    
    $("#updateRec").click(function () {
        var flag=true;
        for(var i=0;i<reflag.length;i++)
        {
            if(reflag[i]===false)
            {
                flag=false;
                break;
            }
        }
        var checkRec=$("#modalRecharge [name='checkRec']").val();
        var inputMoney=$("#modalRecharge [name='inputMoney']").val();
        if(checkRec.length!==0&&inputMoney.length!==0)
        {
            if(flag===false)
            {
                $("#error-mes").html("<div class='alert alert-danger recharge-message'>Error</div>");
            }
            else
            {
                $.ajax({
                    url:"/car/rechargeBalance.do",
                    type:"POST",
                    dataType:"json",
                    data:{Ubalance:inputMoney},
                    success:function (data) {
                        if(data.message==="success")
                        {
                            $("#error-mes").html("<div class='alert alert-success recharge-message'>Success</div>");
                            window.location.href="/car/rechargeCenter";
                        }
                    },
                    error:function (xhr) {
                        console.log(xhr.responseText);
                    }
                });
            }
        }
        else
        {
            $("#error-mes").html("<div class='alert alert-danger login-message'>请填写完整信息</div>");
        }
    });
})