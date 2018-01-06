<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2018/1/6
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>
</head>
<body style="padding: 200px">
<jsp:include page="userComm/header.jsp"></jsp:include>
<div id="app">
    <p>{{ message }}</p>
</div>

<script>
    new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue.js!'
        }
    })
</script>
</body>
</html>
