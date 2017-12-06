$(document).ready(function () {
    $("#modalAddStaff").modal({
        backdrop:false,
        show:false
    });

    $('#StaffTable').bootstrapTable({
        columns:[
            {
                field:'staff.sno',
                checkbox:true
            },
            {
                field:'staff.dno',
                title:'部门编码',
                sortable:false,
            },
            {
                field:'staff.sname',
                title:'业务人员编码',
                sortable:true,
                editable:{
                    type:"text",
                    title:"业务人员编码",
                    width:"6%",
                    align:"center",
                    validate:function (v) {
                        if(!v)
                        {
                            return "不能为空";
                        }
                    }
                }
            },
            {
                field:'staff.sphone',
                title:'业务人员电话',
                sortable:false,
                editable:{
                    type:"text",
                    title:"业务人员电话",
                    width:"8%",
                    align:"center",
                    validate:function (v) {
                        if(!v)
                        {
                            return "不能为空";
                        }
                    }
                }
            },
            {
                field:'staff.saccount',
                title:'人员账号',
                sortable:false,
                editable:{
                    type:"text",
                    title:"人员账号",
                    width:"6%",
                    align:"right",
                    validate:function (v) {
                        if(!v)
                        {
                            return "不能为空";
                        }
                    }
                }
            },
            {
                field:'staff.spaw',
                title:'人员密码',
                sortable:false,
                editable:{
                    type:"text",
                    title:"人员密码",
                    width:"6%",
                    align:"right",
                    validate:function (v) {
                        if(!v)
                        {
                            return "不能为空";
                        }
                    }
                },
                searchable:false
            }
        ],
        url:"/car/staffTable.do",
        method:"post",
        striped:false,
        clickToSelect:false,
        cache:false,
        pagination: true,
        sidePagination: 'client',
        pageNumber:1,
        pageSize:7,
        pageList: [5, 10, 20, 50],
        search: true,
        showRefresh: true,
        showToggle: true,
        clickToSelect: true,
        paginationLoop: false,
        paginationPreText: "previous",
        paginationNextText: "next",
        height: 440,
        onEditableSave:function (field,row,oldValue,$el) {
            if(field==="staff.sname")
            {
                row.staff.sname=row[field];
            }
            else if(field==="staff.sphone")
            {
                row.staff.sphone=row[field];
            }
            else if(field==="staff.saccount")
            {
                row.staff.saccount=row[field];
            }
            else if(field==="staff.spaw")
            {
                row.staff.spaw=row[field];
            }

            $.ajax({
                type:"POST",
                url:"/car/EditableStaff.do",
                dataType: "json",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(row.staff),
                success:function (data) {
                    var opt={
                        url:"/car/staffTable.do",
                        silent:true,
                        query:{
                            type:1,
                            level:2
                        }
                    };
                    $('#StaffTable').bootstrapTable('refresh',opt)
                    alert("success");
                },
                error:function (xhr) {
                    console.log(xhr.responseText);
                }
            });
        }
    });

    $("#staff-dep").bind("change",judgeDep);
    $("#staff-name").bind("change",judgeName);
    $("#staff-phone").bind("change",judgePhone);
    $("#staff-account").bind("change",judgeAccount);
    $("#staff-paw").bind("change",judgePaw);

    $("#addTableConfirm").bind("click",addTable);
    $("#delete-staff").bind("click",deleteTable);
    $(".close").bind("click", clearForm);
});

var flag=[false,false,false,false,false];

function judgeDep() {
    var dep=$("#staff-dep").val();
    if(dep.length===3)
    {
        $("#staffdep").addClass("has-success");
        $("#staffdep").removeClass("has-error");
        $("#staffdep .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[0] = true;
    }
    else
    {
        $("#staffdep").addClass("has-error");
        $("#staffdep").removeClass("has-success");
        $("#staffdep .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">不存在此部门</span>");
        flag[0] = false;
    }
    buttonActive();
}

function judgeName() {
    var name=$("#staff-name").val();
    if(name.length===5)
    {
        $("#staffname").addClass("has-success");
        $("#staffname").removeClass("has-error");
        $("#staffname .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[1] = true;
    }
    else
    {
        $("#staffname").addClass("has-error");
        $("#staffname").removeClass("has-success");
        $("#staffname .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">编码不合法</span>");
        flag[1] = false;
    }
    buttonActive();
}

function judgePhone() {
    var phone=$("#staff-phone").val();
    if(phone.length===5)
    {
        $("#staffphone").addClass("has-success");
        $("#staffphone").removeClass("has-error");
        $("#staffphone .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[2] = true;
    }
    else
    {
        $("#staffphone").addClass("has-error");
        $("#staffphone").removeClass("has-success");
        $("#staffphone .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">电话5位</span>");
        flag[2] = false;
    }
    buttonActive();
}

function judgeAccount() {
    var account=$("#staff-account").val();
    if(account.length>4&&account.length<8)
    {
        $("#staffaccount").addClass("has-success");
        $("#staffaccount").removeClass("has-error");
        $("#staffaccount .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[3] = true;
    }
    else
    {
        $("#staffaccount").addClass("has-error");
        $("#staffaccount").removeClass("has-success");
        $("#staffaccount .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">账号4-8位</span>");
        flag[3] = false;
    }
    buttonActive();
}

function judgePaw() {
    var paw=$("#staff-paw").val();
    if(paw.length>4&&paw.length<8)
    {
        $("#staffpaw").addClass("has-success");
        $("#staffpaw").removeClass("has-error");
        $("#staffpaw .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[4] = true;
    }
    else
    {
        $("#staffpaw").addClass("has-error");
        $("#staffpaw").removeClass("has-success");
        $("#staffpaw .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">密码4-8位</span>");
        flag[4] = false;
    }
    buttonActive();
}

function clearForm() {
    $("#modalAddStaff .form-group").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");

        $(this).find("input").val("");
        $(this).find(".feed-back").html("");
        $("#addTableConfirm").attr("disabled", true);
        flag = [false, false, false, false,false];
    });
}

function buttonActive() {
    var flagx=true;
    for(var i=0;i<flag.length;i++)
    {
        if(!flag[i])
        {
            flagx=false;
            break;
        }
    }
    if(flagx) {
        $("#addTableConfirm").attr("disabled", false);
    } else {
        $("#addTableConfirm").attr("disabled", true);
    }
}

function addTable() {
    var Dno=$("#staff-dep").val();
    var Sname=$("#staff-name").val();
    var Sphone=$("#staff-phone").val();
    var Saccount=$("#staff-account").val();
    var Spaw=$("#staff-paw").val();
    $.ajax({
        url:"/car/addStaffTable.do",
        type:"POST",
        dataType:"json",
        data:{
            Dno:Dno,
            Sname:Sname,
            Sphone:Sphone,
            Saccount:Saccount,
            Spaw:Spaw
        },
        success:function (data) {
            if(data.errorLog==="right")
            {
                var opt={
                    url:"/car/staffTable.do",
                    silent:true,
                    query:{
                        type:1,
                        level:2
                    }
                };
                $("#modalAddStaff").modal('hide');
                alert("success");
                clearForm();
                $('#StaffTable').bootstrapTable('refresh',opt);
            }
        },
        error:function (xhr) {
            console.log(xhr.responseText);
        }
    });
    flag[false,false,false,false,false];
}

function deleteTable() {
    var arr=($('#StaffTable').bootstrapTable('getSelections'));
    var array=new Array();
    if(arr.length!==0)
    {
        for(var i=0;i<arr.length;i++)
        {
            array.push(arr[i].staff);
        }
        $.ajax({
            url:"/car/deleteStaffTable.do",
            type:"POST",
            contentType:"application/json",
            dataType: "json",
            data: JSON.stringify(array),
            success:function (data) {
                var opt={
                    url:"/car/staffTable.do",
                    silent: true,
                    query: {
                        type: 1,
                        level: 2
                    }
                };
                $('#StaffTable').bootstrapTable('refresh', opt);
                alert("删除成功");
            },
            error:function (xhr) {
                console.log(xhr.responseText);
            }
        });
    }
}

function emptyModal() {
    $(this).removeClass("has-success");
    $(this).removeClass("has-error");

    $(this).find("input").val("");
    $(this).find(".feed-back").html("");
    $("#addTableConfirm").attr("disabled", true);
    flag = [false,false, false, false, false];
}