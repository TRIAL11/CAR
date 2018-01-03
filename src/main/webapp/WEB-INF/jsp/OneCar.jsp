<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/3
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>车辆详细信息</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/oneCar.css" type="text/css">
</head>
<body style="padding-top: 76px;padding-left: 50px">
<jsp:include page="userComm/header.jsp"></jsp:include>

<!--JudgeMessage hidden-->
<input type="hidden" id="ucode" value="${sessionScope.user.ucode}">
<input type="hidden" id="cno" value="${requestScope.car.cno}">

<div class="container-fluid">
    <div class="row">
        <div class="custom-self-bar">
            <a href="/car/rentMainPage" class="carMainPage">首页</a>&nbsp;> &nbsp;<a href="#" class="carNamePage">${requestScope.car.cname}</a>
        </div>
        <br>
        <div class="car-message">
            <div class="car-picture col-md-6 col-md-offset-1">
                <img src="${requestScope.car.cpicture}" width="630px" height="420px" />
            </div>
            <div class="col-md-5">
                <div class="car-name-detail">
                    <h3>${requestScope.car.cname}</h3>
                </div>
                <br>
                <div class="car-some-detail row">
                    <ul>
                        <div class="col-md-4 verticalLine"><li class="car-look-detail"><div class="typeBox">${requestScope.car.clook}</div><div class="comm"> 人浏览</div></li></div>
                        <div class="col-md-4 verticalLine"><li class="car-good-detail"><div class="typeBox">${requestScope.car.cgood}</div><div class="comm"> 人觉得不错</div></li></div>
                        <div class="col-md-4"><li class="car-bad-detail"><div class="typeBox">${requestScope.car.cbad}</div> <div class="comm"> 人觉得不值</div></li></div>
                    </ul>
                </div>
                <br>
                <div class="car-other-detail row">
                    <div class="col-md-6">
                        <div>表显里程:<span class="car-long-detail"> &nbsp;${requestScope.car.clong}</span></div>
                    </div>
                    <div class="col-md-6">
                        <div>现价:<span class="car-price-detail"> &nbsp;¥${requestScope.car.cprice}</span> (元/小时)</div>
                    </div>
                </div>
                <br>
                <div class="serviceGuarantee">
                    <a href="#" ><img src="${pageContext.request.contextPath}/static/jpg/serviceGuarantee.png"></a>
                </div>
                <br>
                <div class="userOperationButton row">
                    <div class="RentButton col-md-6">
                        <c:choose>
                            <c:when test="${requestScope.car.cstate==0}">
                                <a class="btn btn-lg btn-primary" href="#" data-toggle="modal" data-target="#modalRent" style="width: 150px">立即租借</a>
                            </c:when>
                            <c:when test="${requestScope.car.cstate==1}">
                                <button type="button" class="btn btn-lg btn-warning" disabled="disabled">已被租借</button>
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="consultationButton col-md-6">
                        <a href="#" class="btn btn-lg btn-default" style="width: 150px">在线咨询</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--模态框-->
<div id="modalRent" class="modal fade" role="dialog" aria-labelledby="modalLabelRent" aria-hidden="true">
    <div class="modal-dialog modal-rent">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabelRent">租借确认单</h4>
            </div>
            <form action="/car/addOrderList/${user.ucode} +${car.cno}" method="post">
                <div class="modal-body rent-body">
                    <div class="sure-car">
                        <p>尊敬的&nbsp;<a href="#" class="sure-car-username">${sessionScope.user.uname}</a> &nbsp;用户,您将租用我们公司的&nbsp;<a href="#" style="color: black;font-size: 120%">${requestScope.car.cname}</a>&nbsp;,租借单价为<span class="sure-car-price">${requestScope.car.cprice}</span>(元/小时)</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-info" id="rentButton">确认租借</button>
                </div>
            </form>
        </div>
    </div>
</div>
<footer class="footer navbar-fixed-bottom" style="background-color: #F5F5F5; height: 40px">
    <div class="container">
        <p class="text-muted" style="line-height: 45px;text-align: center">CopyRight &copy; Trial11 2017</p>
    </div>
</footer>
</body>
</html>


