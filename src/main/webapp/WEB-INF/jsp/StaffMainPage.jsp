<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/18
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页面</title>
    <jsp:include page="staffComm/StaffHeaderFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/staffLoginOrOut.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/staffMainPage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/staffMainPage.css" type="text/css">
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>
<div class="container-fluid" style="text-align: center">
    <%
        if(session.getAttribute("staff")==null){
    %>
    <form action="" method="post">
        <div class="staffLogin-text">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                <input type="text" name="Saccount" class="form-control" placeholder="Account">
            </div>
        </div>
        <br>
        <div class="staffLogin-text">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span> </span>
                <input type="password" name="Spaw" class="form-control" placeholder="Password">
            </div>
        </div>
        <br>
        <div class="error-m" id="error-m"></div>
        <button type="button" class="btn btn-primary" id="staffLoginButton">登录</button>
    </form>
    <%}
    else{%>
    <h1><center>欢迎${sessionScope.staff.sname}</center></h1>
    <br>
    <br>
    <div class="notice-message">
    <h2>公告:</h2>
    <br>
    <h3><a href="#" class="notice">请各位管理员注意,今天依旧放假&nbsp;!</a> </h3>
    <h3><a href="#" class="notice">请各位管理员注意,明天还是放假&nbsp;!</a> </h3>
    <h3><a href="#" class="notice">请各位管理员注意,后天仍然放假&nbsp;!</a> </h3>
    </div>
    <%}
    %>
</div>

</body>
</html>
