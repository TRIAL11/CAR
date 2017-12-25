<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/18
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/car/staffMainPage">Car</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/car/staffMainPage">首页</a></li>
                <%
                    if(session.getAttribute("staff")==null){
                %>
                <li><a href="/car/staffMainPage">平台简介</a> </li>
                <%}
                else{%>
                <li><a href="/car/staffMainPage">公司概况</a></li>
                <li><a href="/car/manageCar">车辆管理</a></li>
                <li><a href="/car/manageStaff">业务人员管理</a></li>
                <%}%>
                <li><a><span class="glyphicon glyphicon-earphone"></span><span style="font-size: 20px">1888-8888</span></a></li>
            </ul>
        </div>
        <div class="navbar-right">
            <%
                if(session.getAttribute("staff") == null){%>
            <ul class="nav navbar-nav">
                <li><a href="/car/home">返回用户界面</a></li>
            </ul>
            <%}
            else{%>
            <ul class="nav navbar-nav">
                <li><a>欢迎</a></li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        ${sessionScope.staff.sname}<b class="caret"></b>
                    </a>

                    <ul class="dropdown-menu" style="min-width: 120px;">
                        <li><a href="/car/staffOut.do" style="color: red">安全退出</a></li>
                    </ul>
                </li>
            </ul>
            <%}
            %>
        </div>
    </div>
</nav>
