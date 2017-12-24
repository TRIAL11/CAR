<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/12/3
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>车辆详细信息</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/static/js/oneCar.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/oneCar.css" type="text/css">
</head>
<body style="padding-top: 100px;overflow: scroll;padding-left: 50px">
<jsp:include page="userComm/header.jsp"></jsp:include>

<!--JudgeMessage-->
<input type="hidden" id="ucode" value="${sessionScope.user.ucode}">
<input type="hidden" id="cno" value="${requestScope.car.cno}">

<div class="container-fluid">
    <div class="row">
        <div class="car-message">
            <div class="car-picture col-md-6 col-md-offset-1">
                <img src="${requestScope.car.cpicture}" width="630px" height="420px" />
            </div>
            <div class="car-name-detail">
                <h3>${requestScope.car.cname}</h3>
            </div>
            <div class="RentButton">
                <c:choose>
                    <c:when test="${requestScope.car.cstate==0}">
                        <a class="btn btn-lg btn-primary" href="#" data-toggle="modal" data-target="#modalRent">立即租借</a>
                    </c:when>
                    <c:when test="${requestScope.car.cstate==1}">
                        <button type="button" class="btn btn-lg btn-warning" disabled="disabled">已被租借</button>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<!--模态框-->
<div id="modalRent" class="modal fade" role="dialog" aria-labelledby="modalLabelRent" aria-hidden="true">
    <div class="modal-dialog modal-rent">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabelRent">租借确认单</h4>
            </div>
            <form action="/car/addOrderList/${user.ucode} +${car.cno}" method="post">
                <div class="modal-body rent-body">
                    <span class="jia">name</span>
                    <b>${sessionScope.user.uname}</b>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-info" id="rentButton">确认租借</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    (function() {
        var Modal = {};
//解决Modal弹出时页面左右移动问题
        Modal.adjustBody_beforeShow = function(){
            var body_scrollHeight = $('body')[0].scrollHeight;
            var docHeight = document.documentElement.clientHeight;
            if(body_scrollHeight > docHeight){
                $('header').css({
                    'overflow' : 'hidden',
                    'padding-right' : '17px'
                });
                console.log("1");
                $('.modal').css({'overflow-y':'hidden'})
            }else{
                $('body').css({
                    'overflow' : 'auto',
                    'margin-right' : '0'
                });
                console.log("2");
                $('.modal').css({'overflow-y':'auto'})
            }
        }
        Modal.adjustBody_afterShow = function(){
            var body_scrollHeight = $('body')[0].scrollHeight;
            var docHeight = document.documentElement.clientHeight;
            if(body_scrollHeight > docHeight){
                $('header').css({
                    'overflow' : 'hidden',
                    'padding-right' : '0'
                });
                console.log("3");
            }else{
                $('body').css({
                    'overflow' : 'auto',
                    'margin-right' : '0'
                });
                console.log("4");
            }
        }
        $(' .modal').modal('hide');
        $('.modal ').on('show.bs.modal', function (event) {
            Modal.adjustBody_beforeShow();
        });
        $('.modal').on('hidden.bs.modal', function (event) {
            Modal.adjustBody_afterShow();
        });
    })();

</script>
</body>
</html>


