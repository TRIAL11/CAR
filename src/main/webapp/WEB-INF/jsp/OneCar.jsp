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
    <script src="${pageContext.request.contextPath}/static/js/oneCar.js"></script>

</head>
<body style="padding: 70px;overflow: scroll">
<jsp:include page="userComm/header.jsp"></jsp:include>

<!--JudgeMessage-->
<input type="hidden" id="ucode" value="${sessionScope.user.ucode}">
<input type="hidden" id="cno" value="${requestScope.car.cno}">

<div class="container-fluid">
    <div class="car-message">
        <div class="car-picture">
            <img src="${requestScope.car.cpicture}" width="600px" height="300px" />
        </div>
    </div>
    <div class="RentButton">
        <button type="button" class="btn btn-lg"><a href="#" data-toggle="modal" data-target="#modalRent">立即租借</a></button>
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
                    <span class="jia">name</span>
                    <b>${sessionScope.user.uname}</b>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-info" id="rentButton">确认租借</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>


