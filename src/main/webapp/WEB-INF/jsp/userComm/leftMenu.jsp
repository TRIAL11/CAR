<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/21
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .panel-group{max-height:770px;overflow: auto;}
    .leftMenu{margin:10px;margin-top:5px;}
    .leftMenu .panel-heading{font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
    .leftMenu .panel-heading span{position:absolute;right:10px;top:12px;}
    .leftMenu .menu-item-left{padding: 2px; background: transparent; border:1px solid transparent;border-radius: 6px;}
    .leftMenu .menu-item-left:hover{background:#C4E3F3;border:1px solid #1E90FF;}
</style>
    <div class="col-md-2">
        <div class="panel-group table-responsive" role="tablist">
            <!--异步刷新暂未实现，待考虑-->
            <div class="panel panel-primary leftMenu">
                <!-- 利用data-target指定要折叠的分组列表 -->
                <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                    <h4 class="panel-title">
                        基本信息(待填)
                        <span class="glyphicon glyphicon-chevron-up right"></span>
                    </h4>
                </div>
                <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <!-- 利用data-target指定URL -->
                            <button class="menu-item-left" data-target="test2.html">
                                <span class="glyphicon glyphicon-triangle-right"></span><a href="/car/userInfo"> 异步刷新待填</a>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
            <!--panel end-->
            <div class="panel panel-primary leftMenu">
                <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                    <h4 class="panel-title">
                        充值中心
                        <span class="glyphicon glyphicon-chevron-down right"></span>
                    </h4>
                </div>
                <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <button class="menu-item-left">
                                <span class="glyphicon glyphicon-triangle-right"></span><a href="/car/rechargeCenter">余额查询与充值</a>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="panel panel-primary leftMenu">
                <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                    <h4 class="panel-title">
                        租车服务
                        <span class="glyphicon glyphicon-chevron-down right"></span>
                    </h4>
                </div>
                <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <button class="menu-item-left">
                                <span class="glyphicon glyphicon-triangle-right"></span>我的订单
                            </button>
                        </li>
                        <li class="list-group-item">
                            <button class="menu-item-left">
                                <span class="glyphicon glyphicon-triangle-right"></span>功能待填
                            </button>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
<script>
    $(function(){
        $(".panel-heading").click(function(e){
            $(this).find("span").toggleClass("glyphicon-chevron-up");
            $(this).find("span").toggleClass("glyphicon-chevron-down");
        });
    });
</script>
