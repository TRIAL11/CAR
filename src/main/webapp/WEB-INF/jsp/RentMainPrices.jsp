<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/6
  Time: 15:37
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
</head>
<body>
<jsp:include page="userComm/header.jsp"></jsp:include>

<div class="con">
    <div class="rentHead">
        <span class="car-m">123</span>
    </div>
    <!--<div class="container-fluid">-->
    <div class="car-show">

        <!-- <div class="pagehead">
             <table class="table">
                 <thead>
                 <tr>
                     <th colspan="6">简要介绍</th>
                     <th colspan="3">里程</th>
                     <th colspan="3">价格</th>
                 </tr>
                 </thead>
             </table>
         </div>-->
        <div class="title">
            <div class="col-md-12">
                <div class="col-md-1"></div>
                <div class="thingMess col-md-3">
                    可租借车辆
                </div>
                <div class="titleName col-md-2" >
                    车辆名称
                </div>

                <div class="titleLong  col-md-1">
                    里程(公里)
                </div>
                <div class="col-md-1">
                </div>
                <div class="titlePrice col-md-1">
                    价格(元/h)
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-2">
                </div>
            </div>
        </div>

        <hr/>

        <div class="car-all">
            <c:set var="sum" value="0"></c:set>
            <c:set var="flag" value="1"></c:set>
            <c:forEach items="${cars}" var="car">
                <c:if test="${car.cstate==0&&car.cprice<10&&car.cprice>0}">
                    <c:if test="${flag==1}">
                        <div class="col-md-12">
                            <div class="begin-car">
                                <div class="col-md-3"><img src="${car.cpicture}" width="235px" height="140px" class="car-picture"></div>
                                <div class="col-md-3"><p class="car-name">${car.cname}</p></div>
                                <div class="col-md-2"><p class="car-long">${car.clong}</p></div>
                                <div class="col-md-2">
                                    <p class="car-price">
                                        ￥
                                        <fmt:formatNumber type="number" value="${car.cprice}" pattern="0.0" maxFractionDigits="1"></fmt:formatNumber>
                                    </p></div>
                                <div class="detailButton col-md-2 ">
                                    <a href="/car/oneCar/${car.cno}" class="car-link"><button type="button" class="btn btn-lg">BUTTON</button></a>
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

    <!--</div>-->
    <div class="search-more">
        <span class="search-more-font">123</span>
    </div>
</div>
</body>
</html>
