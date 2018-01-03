$(document).ready(function () {
    window.operateEvents={
        "click .btn": function (e, value, row, index) {
            window.open("/car/Admin/" + row.car.cno);
        }
    };

    $("#CarTable").bootstrapTable({
        columns:[
            {
                field:'car.cno',
                checkbox:true,
                sortable:true
            },
            {
                field:"staff.sname",
                title:'管理员名称',
                sortable:true
            },
            {
                field:'cartype.tname',
                title:'车辆类型',
                sortable:true
            },
            {
                field:'car.cname',
                title:'车辆名称',
                sortable:true
            },
            {
                field:'car.clong',
                title:'表显里程',
                sortable:true,
                width:"8%"
            },
            {
                field:'car.cstate',
                title:'车辆状态',
                sortable:true,
                width:"8%",
                formatter: function (value) {
                    if(value==1)
                    {
                        return "<span style='color: #EA0000'>已租借</span>";
                    }
                    else
                    {
                        return "闲置";
                    }
                },
            },
            {
                field:'car.cprice',
                title:'车辆价格',
                sortable:true,
            },
            {
                field:'car.clook',
                title:'浏览次数',
                sortable:true
            },
            {
                field:'car.cgood',
                title:'好评',
                sortable:true
            },
            {
                field:'car.cbad',
                title:'差评',
                sortable:true
            },
            {
                width:"8%",
                formatter: function () {
                    return "<button type='button' class='btn btn-primary'>编辑</button>";
                },
                events: operateEvents
            }],
        striped: true,      //是否显示行间隔色
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,     //是否启用分页
        sortable: true,      //是否启用排序
        sortOrder: 'asc',     //排序方式
        pageNumber:1,      //table初始化时显示的页数
        pageSize:10,      //页面大小
        method : 'post',  // 向服务器请求方式
        contentType : "application/x-www-form-urlencoded", // 如果是post必须定义
        url:"/car/PageCarTable",
        //dataType:"json",
        queryParamsType:"",
        sidePagination: "server",     //服务端分页
        pageList: [5, 10, 20, 50],
        search: true,
        showRefresh: true,
        showToggle: true,
        showColumns: true,
        clickToSelect: true,
        paginationLoop: false,
        paginationPreText: "previous",
        paginationNextText: "next",
        height: 430,
    });

    $("#delete-car").bind("click",deleteCar);
});

function deleteCar() {
    var arr=($('#CarTable').bootstrapTable('getSelections'));
    var array=new Array();
    if(arr.length!==0)
    {
        for(var i=0;i<arr.length;i++)
        {
            array.push(arr[i].car);
        }
        $.ajax({
            url:"/car/deleteCarByNo.do",
            type:"POST",
            dataType: "json",
            data: JSON.stringify(array),
            success:function (data) {
                if(data.message==="right")
                {
                    alert("right");
                    window.location.href="/car/manageCar";
                }
            },
            error:function (xhr) {
                console.log(xhr.responseText);
            }
        });
    }
}