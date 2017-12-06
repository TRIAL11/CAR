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
    <title>业务人员管理中心</title>
    <jsp:include page="staffComm/StaffHeaderFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/managestaff.js"></script>
</head>
<body>
<jsp:include page="staffComm/StaffHeader.jsp"></jsp:include>

<div class="container">
    <h1 class="page-head">员工管理</h1>
    <div id="toolbar">
        <div class="btn-group">
            <button class="btn btn-default" data-toggle="modal" data-target="#modalAddStaff">
                <i class="fa fa-plus fa-lg"></i> 增加
            </button>
            <button class="btn btn-default" id="delete-staff">
                <i class="fa fa-trash fa-lg"></i> 删除
            </button>
        </div>
    </div>
    <table id="StaffTable" data-toolbar="#toolbar"></table>
</div>

<!--模态框-->
<div id="modalAddStaff" class="modal fade" role="dialog" aria-labelledby="modalLabelAddStaff" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabelAddStaff">添加管理员</h4>
            </div>
            <div class="modal-body">

                <div class="row staff-add form-group has-feedback" id="staffdep">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="staff-dep" class="control-label">所属部门</label>
                    </div>
                    <div class="col-md-5">
                        <input id="staff-dep" type="text" class="form-control"/>
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row staff-add form-group has-feedback" id="staffname">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="staff-name" class="control-label">管理员编码</label>
                    </div>
                    <div class="col-md-5">
                        <input id="staff-name" type="text" class="form-control"/>
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row staff-add form-group has-feedback" id="staffphone">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="staff-phone" class="control-label">管理员电话</label>
                    </div>
                    <div class="col-md-5">
                        <input id="staff-phone" type="text" class="form-control"/>
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row staff-add form-group has-feedback" id="staffaccount">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="staff-account" class="control-label">管理员账号</label>
                    </div>
                    <div class="col-md-5">
                        <input id="staff-account" type="text" class="form-control"/>
                        <div class="feed-back"></div>
                    </div>
                </div>

                <div class="row staff-add form-group has-feedback" id="staffpaw">
                    <div class="col-md-3 col-md-offset-2">
                        <label for="staff-paw" class="control-label">管理员密码</label>
                    </div>
                    <div class="col-md-5">
                        <input id="staff-paw" type="text" class="form-control"/>
                        <div class="feed-back"></div>
                    </div>
                </div>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="addTableConfirm" disabled="disabled">确认</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
