$(document).ready(function () {

});

function emptyPay() {
    $(".user-pay [name='userReturnTime']").val("");
    $(".user-pay [name='userPayMoney']").val("");
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
            $(".user-pay [name='userLendTime']").val(rent.rlend);
            $(".user-pay [name='carUnitPrice']").val(rent.cprice);
        },
        error:function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function calPriceButton() {
    var nowTime=new Date().getTime();
    var userLendTime=$(".return-body [name='userLendTime']").val();
    var carUnitPrice=$(".return-body [name='carUnitPrice']").val();
    $(".user-pay [name='userReturnTime']").val(nowTime);
    var timeDif=nowTime-userLendTime;
    var shouldPay=carUnitPrice*(timeDif/(1000*60*60));
    //保留一位小数，便于计算
    shouldPay=shouldPay.toFixed(1);
    $(".user-pay [name='userPayMoney']").val(shouldPay);
}