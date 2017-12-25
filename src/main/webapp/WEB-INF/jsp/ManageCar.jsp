<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/24
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车辆管理中心</title>
    <jsp:include page="staffComm/StaffHeaderFile.jsp"></jsp:include>
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>

<div class="container">
    <h1 class="page head">车辆信息管理</h1>
    <div class="toolbar">
        <div class="btn-group">
            <a href="/car/addNewCar" class="btn btn-default"></a>
                <i class="fa fa-plus fa-lg"></i> 增加
            </button>
            <button class="btn btn-default" id="delete-car">
                <i class="fa fa-trash fa-lg"></i> 删除
            </button>
        </div>
    </div>
    <table id="CarTable" data-toolbar="#toolbar"></table>
</div>


<!--模态框-->
<!--
<div id="modalAddCar" class="modal fade" role="dialog" aria-labelledby="modalLabelAddCar" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabelAddStaff">车辆添加</h4>
            </div>

            <div class="modal-body">

                <div class="row car-add form-group has-feedback" id="carId">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="car-id" class="control-label">车辆编码</label>
                    </div>
                    <div class="col-md-5">
                        <input id="car-id" type="text" class="form-control"/>
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row car-add form-group has-feedback" id="carName">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="car-name" class="control-label">车辆名称</label>
                    </div>
                    <div class="col-md-5">
                        <input id="car-name" type="text" class="form-control">
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row car-add form-group has-feedback" id="carPrice">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="car-price" class="control-label">价格(元/小时)</label>
                    </div>
                    <div class="col-md-5">
                        <input id="car-price" type="text" class="form-control">
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row car-add form-group has-feedback" id="carAge">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="car-age" class="control-label">车龄</label>
                    </div>
                    <div class="col-md-5">
                        <input id="car-age" type="text" class="form-control">
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row car-add form-group has-feedback" id="carPicture">

                </div>

                <div class="row car-add form-group has-feedback" id="carInfo">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="car-info" class="control-label">车辆信息</label>
                    </div>
                    <div class="col-md-5">
                        <input id="car-info" type="text" class="form-control">
                        <div class="feed-back"></div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="addCarConfirm" disabled="disabled">确认增加</button>
            </div>

        </div>
    </div>
</div>-->
</body>
</html>
