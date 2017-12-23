<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/3
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/car/home">Car</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/car/home">logo</a></li>
                <li><a href="/car/home">首页</a> </li>
                <li class="bootstro"
                    data-bootstro-title='how to know us'
                    data-bootstro-content="如果您想要了解我们更多，请点击（其实就是返回了首页...）"
                    data-bootstro-width="400px"
                    data-bootstro-placement='bottom'
                    data-bootstro-step='4'><a href="#">平台简介</a></li>
                <li class="bootstro"
                    data-bootstro-title='how to rent a car'
                    data-bootstro-content="如果您已经登录，请点击此处进入汽车挑选界面"
                    data-bootstro-width="400px"
                    data-bootstro-placement='bottom'
                    data-bootstro-step='2'><a href="/car/rentMainPage">我要租车</a></li>
                <li><a href="#">联系我们</a></li>
                <li class="bootstro"
                    data-bootstro-title='how to phone us'
                    data-bootstro-content="如果您在租车时遇到什么问题，可以拨打我们的客服热线!我们会有工作人员全天24小时在线（骗你的，根本木有人）"
                    data-bootstro-width="400px"
                    data-bootstro-placement='bottom'
                    data-bootstro-step='3'><a><span class="glyphicon glyphicon-earphone"></span><span style="font-size: 20px">1888-8888</span></a></li>
            </ul>
        </div>
        <div class="navbar-right">
            <%
                if(session.getAttribute("user") == null){%>
            <ul class="nav navbar-nav">
                <li><a href="/car/staffMainPage">管理员登录</a></li>
                <li class="bootstro"
                    data-bootstro-title='how to register'
                    data-bootstro-content="首先您需要有一个我们网站的账号，如果没有请先注册"
                    data-bootstro-width="400px"
                    data-bootstro-placement='bottom' data-bootstro-step='0'><a href="#" data-toggle="modal" data-target="#modalRegister"><span class="glyphicon glyphicon-user"></span>注册</a></li>
                <li class="bootstro"
                    data-bootstro-title='how to login'
                    data-bootstro-content="如果您已经拥有了我们平台的账号，请先登录，如果忘记密码请在登录界面找到‘忘记密码’的链接"
                    data-bootstro-width="400px"
                    data-bootstro-placement='bottom'
                    data-bootstro-step='1'><a href="#" data-toggle="modal" data-target="#modalLogin" ><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
            </ul>
            <%}
            else{%>
            <ul class="nav navbar-nav">
                <li><a>欢迎</a></li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class=" glyphicon glyphicon-user"></span>
                        ${sessionScope.user.uname}<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" style="min-width: 120px;">
                        <li><a href="/car/userInfo">个人中心</a></li>
                        <li><a href="/car/userOrderList">查询订单</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#modalPass">修改密码</a></li>
                        <li class="divider"></li>
                        <li><a href="/car/logout.do">安全退出</a></li>
                    </ul>
                </li>
            </ul>
            <%}
            %>
        </div>
    </div>
</nav>



