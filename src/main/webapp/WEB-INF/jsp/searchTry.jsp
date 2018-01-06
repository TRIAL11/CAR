<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2018/1/4
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="userComm/HeadFile.jsp"></jsp:include>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/rentMainPage.css" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/searchCar.js"></script>
</head>
<body style="padding: 80px">
<jsp:include page="userComm/header.jsp"></jsp:include>
<input id="searchText" type="hidden" value="${searchText}">

<div class="searchCarByText" id="searchCarByTAndP" v-cloak>
    <!--顶部筛选框-->
    <div class="searchCarByPrice">
        <!--
        <div class="orderPrice">
            <button class="btn btn-primary" id="orderBtn" type="button" @click="orderCar" style="width: 150px">
                <span class="fa fa-sort" v-if="order==''"></span>
                <span class="fa fa-sort-asc" v-if="order=='asc'"></span>
                <span class="fa fa-sort-desc" v-if="order=='desc'"></span>
                根据价格排序
            </button>
        </div>-->
        <div class="te">
            <h4 style="margin-left: 70px">价格区间填写</h4>
        </div>
        <div class="input-group" style="margin-left: 70px;text-align: center;width: 400px">
            <input class="form-control" type="text"  maxlength="9" placeholder="请输入" v-model="minPrice" @input="priceFilter">
            <span class="input-group-addon">-</span>
            <input class="form-control" type="text"  maxlength="9" placeholder="请输入" v-model="maxPrice" @input="priceFilter">
        </div>
    </div>
    <br>
    <hr>

    <!---->
    <div class="searchCarBody" id="searchCarBody">
            <div v-for="(car,index) in cars">
        <div class="begin-car col-md-12" style="margin: 30px">
            <div class="col-md-3" style="text-align: center"><img :src="car.cpicture" width="235px" height="140px" class="car-picture"></div>
            <div class="col-md-3"><p class="car-name">{{ car.cname }}</p></div>
            <div class="col-md-2"><p class="car-long">{{ car.clong }}</p></div>
            <div class="col-md-2">
                <p class="car-price">
                    {{ car.cprice }}
                </p></div>
            <div class="detailButton col-md-2 ">
                <a :href="car.href" class="car-link"><button type="button" class="btn btn-lg">详细信息</button></a>
            </div>
        </div>
    </div>
</div>


    <!--车辆展示框
    <div class="col-md-12">
        <div class="begin-car">
            <div class="searchCarBody" id="searchCarBody">
                <div v-for="(car,index) in cars">
                    <div class="searchCar-border">
                        <a :href="car.href" class="car-search-link">
                            <div class="searchCar-one">
                                <div class="col-md-3" style="text-align: center">
                                    <img :src="car.cpicture" width="235px" height="140px" class="car-picture"></div>
                                <div class="col-md-3"><p class="car-name">{{ car.cname }}</p></div>
                                <div class="col-md-2"><p class="car-long">{{ car.clong }}</p></div>
                                <div class="col-md-2"> <p class="car-price">{{ car.cprice }}</p></div>
                                <div class="detailButton col-md-2 ">
                                <a :href="car.href" class="car-link"><button type="button" class="btn btn-lg">详细信息</button></a>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>-->

    <!--分页-->
    <div class="page-list" style="text-align: center">
        <ul class="pagination">
            <li><a href="javascript:void(0)" @click="goPrePage">前一页</a></li>
            <li class="active" v-for="index in getLength()" v-if="index === pageNum"><a href="javascript:void(0)">{{ index }}</a></li>
            <li v-else><a href="javascript:void(0)" @click="toPage">{{ index }}</a></li>
            <li><a href="javascript:void(0)" @click="goNextPage">后一页</a></li>
        </ul>
    </div>
</div>
</body>
</html>
