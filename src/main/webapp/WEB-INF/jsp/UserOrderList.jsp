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

</head>
<body>
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
                <li><a href="/car/userOrderList" class="return-service">归还服务</a></li>
            </ul>
        </div>

        <div class="col-md-10 col-md-offset-2 main">
                <h2 class="leftTitle" style="float: left">未归还订单</h2>
                <br>
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
                        <td width="150px">租借单价</td>
                        <td width="100px">车辆状态</td>
                        <td width="150px">归还确认</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <c:forEach items="${orderList}" var="order">
                <c:if test="${order.rstate==0}">
                    <table class="non-returnListCatalogue">
                        <tr>
                            <td width="200px">
                                <img src="${order.cpicture}" width="165px" height="80px">
                            </td>

                            <td width="200px">
                                <a href="/car/oneCar/${order.cno}" class="non-returnListName" target="_blank">${order.cname}</a>
                            </td>

                            <td width="200px">
                            <span class="non-returnListTime">
                                    <fmt:formatDate type="both" value="${order.rlend}"></fmt:formatDate>
                            </span>
                            </td>

                            <td width="100px">
                            <span class="non-returnListUnitPrice">
                                    ${order.cprice}
                            </span>
                            </td>

                            <td width="100px">
                            <span class="non-returnListState">
                                未归还
                            </span>
                            </td>

                            <td width="150px">
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
                                <button type="button" class="btn btn-highlight btn-primary" id="non-returnButton">${orderState}</button>
                            </td>
                        </tr>
                    </table>
                </c:if>
            </c:forEach>

            <h2 class="leftTitle" style="float: left">历史记录</h2>
            <br>
            <br>
            <div style="clear: both"></div>

            <div class="history-returnList">
                <table class="history-returnListTable">
                    <tbody>
                    <tr class="history-returnListTitle">
                        <td width="200px">车辆信息</td>
                        <td width="200px">车辆名称</td>
                        <td width="200px">借出时间</td>
                        <td width="150px">租借单价</td>
                        <td width="100px">车辆状态</td>
                        <td width="150px"></td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</body>
</html>
