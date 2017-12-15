<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/3
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/car/home">Car</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/car/home">logo</a></li>
                <li><a href="/car/home">首页</a> </li>
                <li><a href="#">平台简介</a></li>
                <li><a href="/car/rentMainPage">我要租车</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a><span class="glyphicon glyphicon-earphone"></span><span style="font-size: 20px">1888-8888</span></a></li>
            </ul>
        </div>
        <div class="navbar-right">
            <%
                if(session.getAttribute("user") == null){%>
            <ul class="nav navbar-nav">
                <li><a href="/car/staffMainPage">管理员登录</a></li>
                <li><a href="#" data-toggle="modal" data-target="#modalRegister"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                <li><a href="#" data-toggle="modal" data-target="#modalLogin" ><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
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



