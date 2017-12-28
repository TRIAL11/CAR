<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/8
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
</head>
<body style="padding-top: 90px;padding-bottom: 60px;overflow: scroll;">

<jsp:include page="userComm/header.jsp"></jsp:include>

<div class="container">
    <div class="jumbotron">
        <h1 class="bootstro"
            data-bootstro-title='Welcome ABC company'
            data-bootstro-content="最后祝您租车愉快，谢谢!"
            data-bootstro-width="400px"
            data-bootstro-placement='bottom'
            data-bootstro-step='6'>Welcome the ABC Car rental company</h1>
        <p class="lead">write something</p>
        <%
            if(session.getAttribute("user") == null){%>
        <b class="bootstro" data-bootstro-title='how to Demonstration again'
           data-bootstro-content="如果您还是不清楚我们的流程,请点击右边的按钮重新查看演示"
           data-bootstro-step='5'>if you do not know how to use,please click the button!</b>
        <a class="btn btn-lg btn-info" href="#" id='demo'>Click Me!</a>
        <%}
        else{%>
        <b>祝您租车愉快!</b>
        <%}
        %>
    </div>

    <!--轮播设置-->
    <div class="carousel slide" id="myCarousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active" style="text-align:center">
                <img src="${pageContext.request.contextPath}/static/jpg/hc1.png" width="100%" alt="First slide">
            </div>
            <div class="item" style="text-align: center;">
                <img src="${pageContext.request.contextPath}/static/jpg/hc2.png" width="100%" alt="Second slide">
            </div>
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;
            </a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;
            </a>
        </div>
    </div>
</div>
<!--轮播js-->
<script>
    $(document).ready(function () {
        $("#myCarousel").carousel({
            interval: 4000
        });
    })
</script>

<!--模态框 登录界面-->
<div id="modalLogin" class="modal fade" role="dialog" aria-labelledby="modalLabelLogin" aria-hidden="true">
    <div class="modal-dialog modal-login">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptyLogin()">&times;</button>
                <h4 class="modal-title" id="modalLabelLogin">用户登录</h4>
            </div>
            <form action="" method="post">
                <div class="modal-body login-body">
                    <div style="padding: 50px 50px 30px;">
                        <form class="bs-example bs-example-form" role="form">
                            <div class="login-text">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">用户名</span>
                                    <input type="text" name="Uaccount" class="form-control" placeholder="UserAccount">
                                </div>
                            </div>
                    <br>
                    <br>
                    <div class="login-text">
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon">密&nbsp;&nbsp; 码</span>
                            <input type="password" name="Upassword" class="form-control" placeholder="PassWord">
                        </div>
                    </div>
                        </form>

                        <br>
                        <div class="losePass">
                            <span class="glyphicon glyphicon-question-sign"></span><a href="#">忘记密码</a>
                        </div>
                </div>
                </div>
                <div class="modal-footer">
                    <div id="error-message" class="error-message"></div>
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="emptyLogin()">关闭</button>
                    <button type="button" class="btn btn-primary" id="loginButton">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>


<!--注册界面-->
<div class="modal fade" id="modalRegister" role="dialog" aria-labelledby="modalLabelRegister" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptyRegister()">&times;</button>
                <h4 class="modal-title" id="modalLabelRegister">用户注册</h4>
            </div>
            <form action="" method="post">
                <div class="modal-body register-body">
                    <div style="padding-left: 90px">
                    <div class="row user-acc form-group has-feedback" id="groupAcc">
                        <div class="register-label">
                            <label class="control-label">账号</label>
                        </div>
                        <div class="register-text col-md-8">
                            <input type="text" class="form-control" name="Uaccount" placeholder="UserAccount"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    </div>

                    <div style="padding-left: 90px">
                    <div class="row user-acc form-group has-feedback" id="groupPass">
                        <div class="register-label">
                            <label class="control-label">密码</label>
                        </div>
                        <div class="register-text col-md-8">
                            <input type="password" class="form-control" name="Upassword" placeholder="Password"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    </div>

                    <div style="padding-left: 90px">
                    <div class="row user-acc form-group has-feedback" id="groupName">
                        <div class="register-label">
                            <label class="control-label">昵称</label>
                        </div>
                        <div class="register-text col-md-8">
                            <input type="text" class="form-control" name="Uname" placeholder="UserName"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    </div>

                    <div style="padding-left: 90px">
                    <div class="row user-acc form-group has-feedback" id="groupPhone">
                        <div class="register-label">
                            <label class="control-label">电话号码</label>
                        </div>
                        <div class="register-text col-md-8">
                            <input type="text" class="form-control" name="Uphone" placeholder="PhoneNumber"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    </div>

                    <div style="padding-left: 90px">
                    <div class="row user-acc form-group has-feedback" id="groupId">
                        <div class="register-label">
                            <label class="control-label">ID Card</label>
                        </div>
                        <div class="register-text col-md-8">
                            <input type="text" class="form-control" name="Uid" placeholder="Id Card"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    </div>

                    <div style="padding-left: 90px">
                    <div class="row user-acc form-group has-feedback" id="groupEmail">
                        <div class="register-label">
                            <label class="control-label">邮箱</label>
                        </div>
                        <div class="register-text col-md-8">
                            <input type="email" class="form-control" name="Uemail" placeholder="123@abc.com"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <div id="error-message-register" class="error-message">
                    </div>
                    <button type="button" class="btn btn-danger" onclick="emptyRegister()">重置</button>
                    <button type="button" class="btn btn-primary" id="registerButton">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="changepwd.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/bootstro.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstro.css" type="text/css">
<script>
    $(document).ready(function () {
        $("#demo").click(function(){
            bootstro.start(".bootstro", {
                onComplete : function(params)
                {
                    alert("Reached end of introduction with total " + (params.idx + 1)+ " slides");
                },
                onExit : function(params)
                {
                    alert("您结束了演示在#" + (params.idx + 1) + " ,如果想要再次演示请点击绿色按钮");
                },
            });
        });
    })
</script>
<jsp:include page="userComm/footer.jsp"></jsp:include>
</body>
</html>
