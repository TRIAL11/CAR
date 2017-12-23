$(document).ready(function () {

});

function emptyPay() {
    $(".user-pay [name='userReturnTime']").val("");
    $(".user-pay [name='userPayMoney']").val("");
    $(".user-pay [name='userReturnTimeHid']").val("");
    $(".user-pay [name='userLendTimeHid']").val("");
    $(".user-pay [name='orderListId']").val("");
    $(".error-i").html("");
}

function getOrderMessage(rno) {
    $.ajax({
        url:"/car/getMappingOrder.do",
        type:"POST",
        dataType:"json",
        data:{
            rno:rno
        },
        success:function (rent) {
            var rLend=dateChange(rent.rlend);

            $(".user-pay [name='userRentCarName']").val(rent.cname);

            $(".user-pay [name='orderListId']").val(rent.rno);
            $(".user-pay [name='userLendTimeHid']").val(rent.rlend);
            $(".user-pay [name='userLendTime']").val(rLend);
            $(".user-pay [name='carUnitPrice']").val(rent.cprice);
        },
        error:function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function calPriceButton() {
    var nowTime=new Date().getTime();
    var Rreturn=dateChange(nowTime);
    var userLendTime=$(".user-pay [name='userLendTimeHid']").val();
    var carUnitPrice=$(".user-pay [name='carUnitPrice']").val();
    $(".user-pay [name='userReturnTime']").val(Rreturn);
    $(".user-pay [name='userReturnTimeHid']").val(nowTime);
    var timeDif=nowTime-userLendTime;
    var shouldPay=carUnitPrice*(timeDif/(1000*60*60));
    //保留一位小数，便于计算
    shouldPay=shouldPay.toFixed(1);
    $(".user-pay [name='userPayMoney']").val(shouldPay);
    var rno=$(".user-pay [name='orderListId']").val();
    var sPrice=$(".user-pay [name='userPayMoney']").val();
    $.ajax({
        url:"/car/returnTime.do",
        Type:"POST",
        dataType:"json",
        data:{
            rno:rno,
            sPrice:sPrice
        },
        success:function (data) {
            if(data.message==="ok")
            {
                $("#error-i").html("<div class='alert alert-success warn-message'>可以支付</div>");
                $("#returnButton").attr("disabled",false);
            }
            else
            {
                $("#error-i").html("<div class='alert alert-danger warn-message'>余额不足请先充值一定金额，<a href='/car/rechargeCenter'>去充值</a></div>");
                $("#returnButton").attr("disabled",true);
            }
        },
        error:function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function dateChange(timeStamp) {
    var date=new Date(timeStamp);
    var year=date.getFullYear();
    var month=date.getMonth()+1;
    if(month<10)
    {
        month="0"+month;
    }
    var day=date.getDate();
    if(day<10)
    {
        day="0"+day;
    }
    var hour=date.getHours();
    if(hour<10)
    {
        hour="0"+hour;
    }
    var min=date.getMinutes();
    if(min<10)
    {
        min="0"+min;
    }
    var sec=date.getSeconds();
    if(sec<10)
    {
        sec="0"+sec;
    }
    return year+"-"+month+"-"+ day +" "+hour+":"+min+":" +sec;
}