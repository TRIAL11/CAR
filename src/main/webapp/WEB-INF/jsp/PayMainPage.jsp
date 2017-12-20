<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/17
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/orderList.js"></script>
</head>
<body>
<jsp:include page="userComm/header.jsp"></jsp:include>
<h2>支付成功，感谢您的光临</h2>
<a href="/car/userOrderList">返回用户订单界面</a>
</body>
</html>
