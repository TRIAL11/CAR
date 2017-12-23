<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/17
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户个人中心</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <link href="${pageContext.request.contextPath}/static/css/userInfo.css" rel="stylesheet" type="text/css">
</head>
<body style="padding: 70px">
<jsp:include page="userComm/header.jsp"></jsp:include>

<script>
    $(document).ready(function () {
        $(".nav-sidebar li").each(function () {
            $(this).removeClass("active");
        });
        $(".user-info").parent().addClass("active");
    });
</script>
    <!--用户中心部分-->
    <!--局部刷新部分-->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/car/userInfo" class="user-info">个人中心</a></li>
                <li><a href="/car/rechargeCenter" class="recharge-center">充值中心</a></li>
                <li><a href="/car/userOrderList" class="return-service">租还服务</a></li>
            </ul>
        </div>

        <div class="col-md-10 col-md-offset-2 main">
            <div class="user-into-fix">
                <h2>
                    <div style="padding-left: 350px;">用户基本信息</div></h2>
                <div class="user-into-form">

                    <form action="/car/upUserInfo" method="post">
                        <div style="padding-left: 120px;margin: 30px">
                            <div class="row user-info-form-fix">
                                <div class="form-group has-feedback" id="groupUcode">
                                    <div>
                                        <input type="hidden" readonly="readonly" class="form-control" name="Ucode" value="${sessionScope.user.ucode}"/>
                                    </div>
                                </div>
                            </div></div>

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
                            </div></div>

                        <div style="padding-left: 120px;margin: 30px">
                            <div class="row user-info-form-fix">
                                <div class="form-group has-feedback" id="groupName">
                                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                                        <label class="control-label">昵称</label>
                                    </div>
                                    <div class="col-md-5">
                                        <input type="text" class="form-control" name="Uname" value="${sessionScope.user.uname}"/>
                                        <div class="error-if">
                                        </div>
                                    </div>
                                </div>
                            </div></div>

                        <div style="padding-left: 120px;margin: 30px">
                            <div class="row user-info-form-fix">
                                <div class="form-group has-feedback" id="groupTel">
                                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                                        <label class="control-label">手机号码</label>
                                    </div>
                                    <div class="col-md-5">
                                        <input type="text" class="form-control" name="Uphone" value="${sessionScope.user.uphone}"/>
                                        <div class="error-if">
                                        </div>
                                    </div>
                                </div>
                            </div></div>

                        <div style="padding-left: 120px;margin: 30px">
                            <div class="row user-info-form-fix">
                                <div class="form-group has-feedback" id="groupIdCard">
                                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                                        <label class="control-label">身份证号</label>
                                    </div>
                                    <div class="col-md-5">
                                        <input type="text" class="form-control" name="Uid" value="${sessionScope.user.uid}"/>
                                        <div class="error-if">
                                        </div>
                                    </div>
                                </div>
                            </div></div>

                        <div style="padding-left: 120px;margin: 30px">
                            <div class="row user-info-form-fix">
                                <div class="form-group has-feedback" id="groupEmail">
                                    <div class="col-md-2" style="float: left; line-height: 30px; margin-right: 15px;">
                                        <label class="control-label">邮箱</label>
                                    </div>
                                    <div class="col-md-5">
                                        <input type="text" class="form-control" name="Uemail" value="${sessionScope.user.uemail}"/>
                                        <div class="error-if">
                                        </div>
                                    </div>
                                </div>
                            </div></div>

                        <div style="padding-left: 300px">
                            <h6><div style="color:red">注意:修改信息后点击修改，确认信息无误后再保存!</div> </h6>
                        </div>
                        <br>
                        <div style="padding-left: 350px">
                            <div class="buttons">
                                <button type="button" style="margin-right: 50px;" class="btn btn-danger" id="changeUserInfo">修改</button>
                                <button type="submit" class="btn btn-success" id="saveChange" disabled="disabled" onclick="saveMessage()">保存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
