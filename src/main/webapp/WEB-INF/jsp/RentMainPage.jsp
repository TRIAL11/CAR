<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>租车主页面</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/rentMainPage.css" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/rentMainPage.js"></script>
</head>
<body style="padding-top: 70px;overflow: scroll;padding-left: 10px">
<jsp:include page="userComm/header.jsp"></jsp:include>

<div class="con">
    <!--<div class="container-fluid">-->
    <!--查找待填-->
    <div class="search">
        <div class="input-group col-md-2" style="margin-left: 77px">
            <input type="text" class="form-control" placeholder="Search" id="searchText"/>
            <span class="input-group-btn">
                <button class="btn btn-success" type="button" id="buttonFind">查找</button>
            </span>
        </div>
    </div>
    <hr>
    <div class="car-show">
        <div class="title">
            <div class="col-md-12">
                <div class="col-md-1"></div>
                <div class="thingMess col-md-3">
                    可租借车辆
                </div>
                <div class="titleName col-md-2" >
                    车辆名称
                </div>
                <div class="titleLong  col-md-2">
                    里程(公里)
                </div>
                <div class="titlePrice col-md-1">
                    价 &nbsp;格(￥/h)
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-2"></div>
            </div>
        </div>
        <hr/>
        <div class="car-all">
            <c:set var="sum" value="0"></c:set>
            <c:set var="flag" value="1"></c:set>
            <c:forEach items="${cars}" var="car">
                <c:if test="${car.cstate==0}">
                    <c:if test="${flag==1}">
                        <div class="col-md-12">
                            <div class="begin-car">
                                <div class="col-md-3" style="text-align: center"><img src="${car.cpicture}" width="235px" height="140px" class="car-picture"></div>
                                <div class="col-md-3"><p class="car-name">${car.cname}</p></div>
                                <div class="col-md-2"><p class="car-long">${car.clong}</p></div>
                                <div class="col-md-2">
                                    <p class="car-price">
                                        ￥
                                        <fmt:formatNumber type="number" value="${car.cprice}" pattern="0.0" maxFractionDigits="1"></fmt:formatNumber>
                                    </p></div>
                                <div class="detailButton col-md-2 ">
                                    <a href="/car/oneCar/${car.cno}" class="car-link"><button type="button" class="btn btn-lg">详细信息</button></a>
                                </div>
                            </div>
                        </div>
                        <c:set var="sum" value="${sum+1}"></c:set>
                        <c:if test="${sum==20}">
                            <c:set var="flag" value="0"></c:set>
                        </c:if>
                    </c:if>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="userComm/footer.jsp"></jsp:include>
</body>
</html>