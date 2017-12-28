<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/28
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册界面</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/Register.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css" type="text/css">
</head>
<body>
<jsp:include page="userComm/header.jsp"></jsp:include>
<div class="container-fluid">
    <h2 class="user-register-head">
        用户注册界面
    </h2>

</div>
<!--页脚-->
<footer class="footer navbar-fixed-bottom" style="background-color: #F5F5F5; height: 40px">
    <div class="container">
        <p class="text-muted" style="line-height: 45px;text-align: center">CopyRight &copy; Trial11 2017</p>
    </div>
</footer>

</body>
</html>
