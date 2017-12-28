<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/21
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值中心</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <link href="${pageContext.request.contextPath}/static/css/userInfo.css" rel="stylesheet" type="text/css">

</head>
<body style="padding: 70px;overflow: scroll">
<jsp:include page="userComm/header.jsp"></jsp:include>

<script>
    $(document).ready(function () {
        $(".nav-sidebar li").each(function () {
            $(this).removeClass("active");
        });
        $(".recharge-center").parent().addClass("active");
    });
</script>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/car/userInfo" class="user-info">个人中心</a></li>
                <li><a href="/car/rechargeCenter" class="recharge-center">充值中心</a></li>
                <li><a href="/car/userOrderList" class="return-service">租还服务</a></li>
            </ul>
        </div>

    <div class="col-md-10 col-md-offset-2 main">
        <div style="padding-left:150px">
            <b style="font-size: 200%">用户充值中心</b>
        </div>
        <div style="padding-left: 120px;margin: 30px">
            <div class="row user-info-form-fix">
                <div class="form-group has-feedback" id="groupAcc">
                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                        <label class="control-label">用户名</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" readonly="readonly" class="form-control" name="Uaccount" value="${sessionScope.user.uaccount}"/>
                    </div>
                </div>
            </div>
        </div>

        <div style="padding-left: 120px;margin: 30px">
            <div class="row user-info-form-fix">
                <div class="form-group has-feedback" id="groupName">
                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                        <label class="control-label">昵称</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" readonly="readonly" class="form-control" name="Uname" value="${sessionScope.user.uname}"/>
                    </div>
                </div>
            </div>
        </div>

        <div style="padding-left: 120px;margin: 30px">
            <div class="row user-info-form-fix">
                <div class="form-group has-feedback" id="groupUbalance">
                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                        <label class="control-label">账户余额</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" readonly="readonly" class="form-control" name="Ubalance" value="${sessionScope.user.ubalance}"/>
                    </div>
                </div>
            </div>
        </div>

        <div style="padding-left: 350px">
            <div class="but">
                <button type="button" class="btn btn-default">
                    <a href="#" data-toggle="modal" data-target="#modalRecharge">充值</a>
                </button>
            </div>
        </div>
    </div>
</div>
</div>
<!--模态框-->
<jsp:include page="RechargePage.jsp"/>
<jsp:include page="userComm/footer.jsp"></jsp:include>
</body>
</html>
