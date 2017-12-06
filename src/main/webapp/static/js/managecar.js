$(document).ready(function () {
    $("#modalAddCar").modal({
        backdrop:false,
        show:false
    });

    $("#CarTable").bootstrapTable({
        columns:[
            {
                field:'car.cno',
                checkbox:true
            },
            {
                field:'car.cid',
                title:'车辆编码',
                sortable:true
            },
            {
                field:'car.cname',
                title:'车辆名称',
                sortable:false
            },
            {
                field:'car.cprice',
                title:'车辆价格',
                sortable:true,
                editable:{
                    type:"text",
                    title:"车辆价格",
                    width:"6%",
                    align:"center",
                    validate:function (value) {
                        if(!value)
                        {
                            return "不能为空";
                        }
                        if(!isNaN(value))
                        {
                            return "输入必须为数字";
                        }
                    }
                }
            },
            {
                field:'car.cage',
                title:'车龄',
                sortable:true,
                editable:{
                    type:"text",
                    title:"车龄",
                    width:"6%",
                    align:"center",
                    validate:function (value) {
                        if(!value)
                        {
                            return "不能为空";
                        }
                        if(!isNaN(value))
                        {
                            return "输入必须为数字";
                        }
                    }
                }
            },
            {
                field:"car.cstate",
                title:"汽车状态",
                sortable:false,
                validate:function (value) {
                    if(value==1)
                    {

                    }
                }
            },
            {
                field:"car.cpicture",
                title:""
            },
            {
                field:'car.info',
                title:'xinxi',
                sortable:false,
                editable:{
                    type:"text",
                    title:"xinxi",
                    width:"6%",
                    align:"center",
                    validate:function (v) {
                        if(!v)
                        {
                            return "Not null";
                        }
                    }
                }
            },
        ]
    })
})
