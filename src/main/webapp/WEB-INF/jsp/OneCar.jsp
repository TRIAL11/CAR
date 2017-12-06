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

</head>
<body>
<jsp:include page="userComm/header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="car-message">
        <div class="car-picture">
            <img src="${requestScope.car.cpicture}" width="500px" height="500px" />
        </div>
    </div>
</div>

<!--模态框-->
</body>
</html>
