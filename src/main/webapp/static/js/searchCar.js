$(document).ready(function () {
    var searchText = $("#searchText").val();
    vFindCar(searchText);
});

function vFindCar(searchText) {
    var find = new Vue({
        el:"#searchCarByTAndP",
        data: {
            searchText: "",
            cars: "",
            total: "",
            pageNum: "",
            pageSize: "",
            order: "",
            minPrice: "",
            maxPrice: ""
        },
        mounted: function () {
            this.searchText = searchText;
            getPageCar(this, 1, 5, this.order, this.minPrice, this.maxPrice)
        },
        methods: {
            getLength: function () {
                var length, arr = [];
                if (this.total % this.pageSize === 0) {
                    length = parseInt(this.total / this.pageSize);
                } else {
                    length = parseInt(this.total / this.pageSize) + 1;
                }
                for (var i = 1; i <= length; i++) {
                    arr.push(i);
                }
                return arr;
            },

            toPage: function (event) {
                var pageNum = event.target.text;
                if(pageNum === this.pageNum) {
                    return;
                } else {
                    getPageCar(this, pageNum, 5, this.order, this.minPrice, this.maxPrice);
                    $(".pagination li").eq(this.pageNum).removeClass("active");
                    $(".pagination li").eq(pageNum).addClass("active");
                }
            },
            goPrePage: function () {
                if(this.pageNum === 1) {
                    return;
                } else {
                    getPageCar(this, this.pageNum - 1, 20, this.order, this.minPrice, this.maxPrice);
                    $(".pagination li").eq(this.pageNum).removeClass("active");
                    $(".pagination li").eq(this.pageNum - 1).addClass("active");
                }
            },
            goNextPage: function () {
                if (this.pageNum === this.getLength().length) {
                    return;
                } else {
                    getPageCar(this, this.pageNum + 1, 5, this.order, this.minPrice, this.maxPrice);
                    $(".pagination li").eq(this.pageNum).removeClass("active");
                    $(".pagination li").eq(this.pageNum + 1).addClass("active");
                }
            },
            orderCar:function () {
                var order = this.order;
                if(order === "") {
                    this.order = "asc";
                } else if(order === "asc") {
                    this.order = "desc";
                } else if(order === "desc") {
                    this.order = "asc";
                }
                getPageCar(this, this.pageNum , 5, this.order, this.minPrice, this.maxPrice);
            },
            priceFilter:function () {
                getPageCar(this, this.pageNum , 5, this.order, this.minPrice, this.maxPrice);
            }
        }
    });
}

function getPageCar(find, pageNum, pageSize, pageOrder, minPrice, maxPrice) {
    if(minPrice === "") {
        minPrice = 0;
    } else {
        minPrice = parseFloat(minPrice);
        if(isNaN(minPrice)) {
            minPrice = 0;
        }
    }
    if(maxPrice === "") {
        maxPrice = 9999999;
    } else {
        maxPrice = parseFloat(maxPrice);
        if(isNaN(maxPrice)) {
            maxPrice = 9999999;
        }
    }
    $.ajax({
        url:"/car/Search/PageCar",
        type:"POST",
        dataType:"json",
        data:{
            searchText: find.searchText,
            pageNum: pageNum,
            pageSize: pageSize,
            pageOrder: pageOrder,
            minPrice: minPrice,
            maxPrice: maxPrice
        },
        success:function (data) {
            find.cars = data.car;
            find.total = data.total;
            find.pageNum = parseInt(pageNum);
            find.pageSize = pageSize;
            for(i in find.cars) {
                find.cars[i].href = "/car/oneCar/" + find.cars[i].cno;
            }
        },
        error:function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

