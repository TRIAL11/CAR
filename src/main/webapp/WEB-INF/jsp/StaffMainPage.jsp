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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/staffMainPage.js"></script>
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>

<!--模态框登录-->
<div id="modalStaffLogin" class="modal fade" role="dialog" aria-labelledby="modalLabelStaffLogin" aria-hidden="true">
    <div class="modal-dialog modal-staffLogin">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptyStaffLogin()">&times;</button>
                <h4 class="modal-title" id="modalLabelStaffLogin">管理员登录</h4>
            </div>
            <form action="" method="post">
                <div class="modal-body modal-staffLoginBody">
                    <div style="padding: 50px 50px 30px">
                        <div class="staffLogin-text">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" name="Saccount" class="form-control" placeholder="Account">
                            </div>
                        </div>
                    <br>
                    <br>
                        <div class="staffLogin-text">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span> </span>
                                <input type="password" name="Spaw" class="form-control" placeholder="Password">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="error-m" id="error-m"></div>
                    <button type="button" class="btn btn-primary" id="staffLoginButton">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
