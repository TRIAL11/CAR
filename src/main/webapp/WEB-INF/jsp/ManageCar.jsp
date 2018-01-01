<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/24
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>车辆管理中心</title>
    <jsp:include page="staffComm/StaffHeaderFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/managecar.js"></script>
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>

<div class="container">
    <h1 class="page head">车辆信息管理</h1>
    <div class="toolbar">
        <div class="btn-group">
            <a class="btn btn-default" href="/car/addNewCar" target="_blank">
                <i class="fa fa-plus fa-lg"></i> 增加
            </a>
            <button class="btn btn-default" id="delete-car">
                <i class="fa fa-trash fa-lg"></i> 删除
            </button>
        </div>
    </div>
    <div class="table-body">
    <table id="CarTable" data-toolbar="#toolbar" ></table>
    </div>
</div>

</body>
</html>
