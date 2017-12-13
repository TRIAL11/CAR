/*
$(document).ready(function () {

    //如果未登录跳转
    $("#rentButton").click(function () {
        var checkMessage=JudgeMessage();
        console.log(checkMessage);
        if(checkMessage.message==="right")
        {
            window.location.href="/car/userOrderList";
        }
        else
        {
            window.location.href="/car/home";
        }
    });

    function JudgeMessage() {
        var ucode=$("#ucode").val();
        var cno=$("#cno").val();
        var checkMessage;
        if(cno&&ucode)
        {
            checkMessage={
                "message":"right",
                "ucode":ucode,
                "cno":cno,
            }
        }
        else
        {
            checkMessage={
                "message":"wrong",
            }
        }
        return checkMessage;
    }
});
*/
