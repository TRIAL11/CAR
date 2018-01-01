<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/24
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新车上架</title>
    <jsp:include page="staffComm/StaffHeaderFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/addNewCar.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/addNewCar.css" type="text/css">
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>
<div class="container">
    <div class="page-head">
        <h2>车辆信息填写</h2>
    </div>
    <div class="page-body">
        <form action="" method="post">
            <div class="addNewCar-body">

                <div class="row">
                    <div class="col-md-7">
                    <div class="form-group">
                        <input type="hidden" class="form-control" value="${sessionScope.staff.sno}">
                    </div>

                <div class="admin-add-car form-group has-feedback" id="addCarName">
                    <div class="add-car-label">
                        <label class="control-label">汽车名称</label>
                    </div>
                    <div class="add-car-text">
                        <input type="text" class="form-control" name="carName" placeholder="carName">
                        <div class="error-input"></div>
                    </div>
                </div>

                <div class="admin-add-car form-group" id="addCarType">
                    <div class="add-car-label">
                        <label>品牌</label>
                    </div>
                    <div class="add-car-text">
                        <select class="form-control" name="carType">
                            <option value="1">长安</option>
                            <option value="2">吉利</option>
                            <option value="3">华泰</option>
                            <option value="4">传祺</option>
                            <option value="5">纳智捷</option>
                            <option value="6">jeep</option>
                            <option value="7">哈弗</option>
                            <option value="8">东风风行</option>
                            <option value="9">起亚</option>
                            <option value="10">众泰</option>
                        </select>
                    </div>
                </div>

                <div class="admin-add-car form-group has-feedback" id="addCarLong">
                    <div class="add-car-label">
                        <label class="label-control">表显里程</label>
                    </div>
                    <div class="add-car-text">
                        <input type="text" class="form-control" name="carLong" placeholder="carLong">
                        <div class="error-input"></div>
                    </div>
                </div>

                <div class="admin-add-car form-group has-feedback" id="addCarPrice">
                    <div class="add-car-label">
                        <label class="label-control">车辆单价</label>
                    </div>
                    <div class="add-car-text">
                        <input type="text" class="form-control" name="carPrice" placeholder="carPrice">
                        <div class="error-input"></div>
                    </div>
                </div>
                    </div>

                    <div class="add-car-picture col-md-5">
                        <input type="text" name="carPicure">
                    </div>

                </div>

                <div class="add-car-button">
                    <button type="button" class="btn btn-default" id="addCarButton">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
