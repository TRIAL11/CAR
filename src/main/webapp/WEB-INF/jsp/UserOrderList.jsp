<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/7
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户订单表</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <link href="${pageContext.request.contextPath}/static/css/userInfo.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/orderList.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/orderList.js"></script>
</head>
<body style="padding: 70px;overflow: scroll">
<jsp:include page="userComm/header.jsp"></jsp:include>

<script>
    $(document).ready(function () {
        $(".nav-sidebar li").each(function () {
            $(this).removeClass("active");
        });
        $(".return-service").parent().addClass("active");
    });
</script>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/car/userInfo" class="user-info">个人中心</a></li>
                <li><a href="/car/rechargeCenter" class="recharge-center">充值中心</a></li>
                <li><a href="/car/userOrderList" class="return-service">租还服务</a></li>
            </ul>
        </div>

        <div class="col-md-10 col-md-offset-2 main">
            <h2 class="leftTitle" style="float: left">未完成订单</h2>
            <br>
            <!--修饰用，功能未实现-->
            <div class="search">
                <div class="input-group col-md-3" style="float: right">
                    <input type="text" class="form-control" placeholder="Search"/>
                    <span class="input-group-btn">
                            <button class="btn btn-success" type="button">查找</button>
                        </span>
                </div>
            </div>
            <div style="clear:both"></div>
            <hr>

            <div class="non-returnList">
                <table class="non-returnListTable">
                    <tbody>
                    <tr class="non-returnListTitle">
                        <td width="200px">车辆信息</td>
                        <td width="200px">车辆名称</td>
                        <td width="200px">借出时间</td>
                        <td width="100px">租借单价</td>
                        <td width="100px">车辆状态</td>
                        <td width="150px">归还确认</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <c:forEach items="${order}" var="order">
                <c:if test="${order.rstate==0}">
                    <table class="non-returnListCatalogue">
                        <tr>
                            <td width="200px">
                                <img src="${order.cpicture}" width="165px" height="80px">
                            </td>

                            <td width="200px">
                                <a href="/car/oneCar/${order.cno}" class="non-returnListName" target="_blank">${order.cname}</a>
                            </td>

                            <td width="200px" style="text-align: center">
                            <span class="non-returnListTime">
                                    <fmt:formatDate type="both" value="${order.rlend}"></fmt:formatDate>
                            </span>
                            </td>

                            <td width="100px" style="text-align: center">
                            <span class="non-returnListUnitPrice" style="text-align: center">
                                    ${order.cprice}
                            </span>
                            </td>

                            <td width="100px" style="text-align: center">
                                <b class="non-returnListState">
                                    未归还
                                </b>
                            </td>

                            <td width="150px" style="text-align: center">
                                <c:choose>
                                    <c:when test="${order.rstate==0}">
                                        <c:set var="orderState" value="确认归还"></c:set>
                                    </c:when>
                                    <c:when test="${order.rstate==1}">
                                        <c:set var="orderState" value="评价"></c:set>
                                    </c:when>
                                    <c:when test="${order.rstate==2}">
                                        <c:set var="orderState" value="已评价"></c:set>
                                    </c:when>
                                </c:choose>
                                <a class="btn btn-primary" onclick="getOrderMessage(${order.rno})" href="#" data-toggle="modal" data-target="#modalReturn">${orderState}</a>
                            </td>
                        </tr>
                    </table>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>


<!--模态框-->
<div id="modalReturn" class="modal fade" role="dialog" aria-labelledby="modalLabelReturn" aria-hidden="true">
    <div class="modal-dialog modal-return">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptyPay()">&times;</button>
                <h4 class="modal-title" id="modalLabelReturn">归还确认单</h4>
            </div>
            <form action="/car/returnCar" method="post">
                <div class="modal-body return-body">
                    <div class="user-pay form-group" id="orderId">
                        <input type="hidden" class="form-control" name="orderListId" readonly="readonly">
                    </div>
                    <div class="user-pay form-group" id="userHid">
                        <input type="hidden" class="form-control" name="userLendTimeHid" readonly="readonly">
                    </div>
                    <div class="user-pay form-group" id="userHidden">
                        <input type="hidden" class="form-control" name="userReturnTimeHid" readonly="readonly">
                    </div>
                    <div class="ReturnWarn">
                        <h4>&nbsp;&nbsp;尊敬的 &nbsp;<span class="CarRentName" style="font-size: 130%;color: #0099CC;"> ${sessionScope.user.uname}</span>&nbsp;&nbsp;用户,感谢您租用我们公司的车辆，请在归还前仔细查看车辆信息以及您的账户余额,结算后余额不足将无法支付</h4>
                    </div>
                    <hr>
                    <div class="user-pay form-group" id="userCarName">
                        <label>车辆名称信息:</label>
                        <input type="text" class="form-control" name="userRentCarName" readonly="readonly">
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="user-pay form-group" id="userLT">
                                <label>借出时间:</label>
                                <input type="text" class="form-control" name="userLendTime" readonly="readonly">
                            </div>
                            <div class="user-pay form-group" id="userRT">
                                <label>归还时间:</label>
                                <input type="text" class="form-control" name="userReturnTime" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="user-pay form-group" id="userUP">
                                <label>车辆单价(元/小时)</label>
                                <input type="text" class="form-control" name="carUnitPrice" readonly="readonly">
                            </div>
                            <div class="user-pay form-group" id="userPM">
                                <label>总计:</label>
                                <input type="text" class="form-control" name="userPayMoney" readonly="readonly">
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <div class="error-i" id="error-i">
                    </div>
                    <button type="button" class="btn btn-primary " onclick="calPriceButton()">结算</button>
                    <button type="submit" class="btn btn-info" id="returnButton" disabled="disabled">支付</button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="userComm/footer.jsp"></jsp:include>
</body>
</html>