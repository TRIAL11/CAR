<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/27
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员编辑物品</title>
    <jsp:include page="staffComm/StaffHeaderFile.jsp"></jsp:include>
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>
<h1 style="text-align: center">车辆信息编辑</h1>
<div class="container">
<div class="car-edit-body">
    <div class="all-message row">
        <div class="col-md-6">
            <div class="car-edit-name">
                <div class="form-group has-feedback">
                    <label class="control-label">车辆名称</label>
                    <input type="text" class="form-control" name="edit-car-name" value="${requestScope.car.cname}">
                    <div class="error-edit"></div>
                </div>
            </div>
            <div class="row">
                <div class="car-edit-admin col-md-6">
                    <div class="form-group has-feedback">
                        <label class="control-label">管理人员</label>
                        <input type="text" class="form-control" name="edit-car-admin" value="${requestScope.staff.sname}" readonly="readonly">
                        <div class="error-edit"></div>
                    </div>
                </div>
                <div class="car-edit-type col-md-6">
                    <div class="form-group has-feedback">
                        <label class="control-label">品牌</label>
                        <input type="text" class="form-control" name="edit-car-type" value="${requestScope.cartype.tname}" readonly="readonly">
                        <div class="error-edit"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="car-edit-long col-md-6">
                    <div class="form-group has-feedback">
                        <label class="control-label">表显里程</label>
                        <input type="text" class="form-control" name="edit-car-long" value="${requestScope.car.clong}">
                        <div class="error-edit"></div>
                    </div>
                </div>
                <div class="car-edit-price col-md-6">
                    <div class="form-group has-feedback">
                        <label class="control-label">单价(元/小时)</label>
                        <input type="text" class="form-control" name="edit-car-price" value="${requestScope.car.cprice}">
                        <div class="error-edit"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="car-edit-state col-md-6">
                    <div class="form-group has-feedback">
                        <label class="control-label">状态</label>
                        <input type="text" class="form-control" name="edit-car-state" value="${requestScope.car.cstate}">
                        <div class="error-edit"></div>
                    </div>
                </div>
                <div class="car-state-warn col-md-6">
                    <div class="form-group has-feedback">
                        <label class="control-label">说明</label>
                        <h4 style="color: #EA0000">0:闲置   1:已出租   2:报废</h4>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="car-edit-look col-md-4">
                    <div class="form-group has-feedback">
                        <label class="control-label">浏览次数</label>
                        <input type="text" class="form-control" name="edit-car-look" value="${requestScope.car.clook}" readonly="readonly">
                        <div class="error-edit"></div>
                    </div>
                </div>
                <div class="car-edit-good col-md-4">
                    <div class="form-group has-feedback">
                        <label class="control-label">好评</label>
                        <input type="text" class="form-control" name="edit-car-good" value="${requestScope.car.cgood}" readonly="readonly">
                        <div class="error-edit"></div>
                    </div>
                </div>
                <div class="car-edit-bad col-md-4">
                    <div class="form-group has-feedback">
                        <label class="control-label">差评</label>
                        <input type="text" class="form-control" name="edit-car-bad" value="${requestScope.car.cbad}" readonly="readonly">
                        <div class="error-edit"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="text-align: center">
            <div class="row">
                <br>
                <img src="${requestScope.car.cpicture}" width="400px" height="300px">
                <br><br>
                <button type="button" class="btn btn-primary btn-lg">修改</button>
            </div>
        </div>
    </div>
    <br>
    <div class="editButtons" style="margin-left: 205px">
    <button type="button" class="btn btn-danger btn-lg" id="changeCarMessage">修改</button>
    <button type="submit" class="btn btn-success btn-lg" id="saveEdit" disabled="disabled">保存</button>
    </div>
</div>
</div>
</body>
</html>
