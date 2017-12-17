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
                            <b class="non-returnListState">
                                未归还
                            </b>
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
                                <button type="button" class="btn btn-info"><a href="#" data-toggle="modal" data-target="#modalReturn">${orderState}</a></button>
                            </td>
                        </tr>
                    </table>
                </c:if>
            </c:forEach>

            <h2 class="leftTitle" style="float: left">历史记录</h2>
            <br>
            <br>
            <div style="clear: both"></div>
            <hr>

            <div class="history-returnList">
                <table class="history-returnListTable">
                    <tbody>
                    <tr class="history-returnListTitle">
                        <td width="200px">车辆信息</td>
                        <td width="200px">车辆名称</td>
                        <td width="200px">借出时间</td>
                        <td width="150px">支付费用</td>
                        <td width="100px">订单状态</td>
                        <td width="150px">后续操作</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <!--最多显示5个历史记录-->
            <c:set var="sum" value="0"></c:set>
            <c:set var="flag" value="1"></c:set>
            <c:forEach items="${orderList1}" var="order1">
                <c:if test="${order1.rstate==1}">
                    <c:if test="${flag==1}">
                    <table class="history-returnListCatalogue">
                        <tr>
                            <td width="200px">
                                <img src="${order1.cpicture}" width="165px" height="80px">
                            </td>

                            <td width="200px">
                                <a href="/car/oneCar/${order1.cno}" class="history-returnListName" target="_blank">${order1.cname}</a>
                            </td>

                            <td width="200px">
                            <span class="history-returnListTime">
                                    <fmt:formatDate type="both" value="${order1.rlend}"></fmt:formatDate>
                            </span>
                            </td>

                            <td width="100px">
                            <span class="history-returnListUnitPrice">
                                    ${order1.rprice}
                            </span>
                            </td>

                            <td width="100px">
                                <b class="history-returnListState">
                                    已归还
                                </b>
                            </td>

                            <td width="150px">
                                <c:choose>
                                    <c:when test="${order1.rstate==0}">
                                        <c:set var="orderState1" value="确认归还"></c:set>
                                    </c:when>
                                    <c:when test="${order1.rstate==1}">
                                        <c:set var="orderState1" value="评价"></c:set>
                                    </c:when>
                                    <c:when test="${order1.rstate==2}">
                                        <c:set var="orderState1" value="已评价"></c:set>
                                    </c:when>
                                </c:choose>
                                <button type="button" class="btn btn-info">${orderState1}</button>
                            </td>
                        </tr>
                    </table>
                        <c:set var="sum" value="${sum+1}"></c:set>
                        <c:if test="${sum==5}">
                            <c:set var="flag" value="0"></c:set>
                        </c:if>
                    </c:if>

                </c:if>
            </c:forEach>

        </div>
    </div>
</div>

<!--模态框-->
<div id="modalReturn" class="modal fade" role="dialog" aria-labelledby="modalLabelReturn" aria-hidden="true">
    <div class="modal-dialog modal-return">
        <div class="modal-content">
            <div class="modal-head">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabelReturn">确认归还</h4>
            </div>
            <form action="/car/returnOrderList/${orderList.rno}" method="post">
                <div class="modal-body return-body">
                    <span class="yi">${sessionScope.user.uname}要还车啦</span>
                </div>
                <div class="modal-foot">
                    <button type="submit" class="btn btn-primary" id="returnButton">归还并支付</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
