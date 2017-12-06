<%--
  Created by IntelliJ IDEA.
  User: zjf
  Date: 2017/11/21
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="modalRecharge" role="dialog" aria-labelledby="modalLabelRecharge" aria-hidden="true">
    <div class="modal-dialog modal-recharge">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptyRec()">&times;</button>
                <h4 class="modal-title" id="modalLabelRecharge">充值中心</h4>
            </div>
            <form action="" method="post">
                <div class="modal-body recharge-body">
                    <div style="padding-left: 90px">
                        <div class="row user-rec form-group has-feedback" id="inputMoney">
                            <div class="rec-label">
                                <label class="control-label">充值金额</label>
                            </div>
                            <div class="col-md-5">
                                <input type="text" class="form-control" name="inputMoney" placeholder="Money"/>
                                <div class="error-if">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div style="padding-left: 90px">
                        <div class="row user-rec form-group has-feedback" id="checkRec">
                            <div class="rec-label">
                                <label class="control-label">输入密码</label>
                            </div>
                            <div class="col-md-5">
                                <input type="password" class="form-control" name="checkRec" placeholder="Password"/>
                                <div class="error-if">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <div class="error-mes" id="error-mes">
                    </div>
                    <button type="button" class="btn btn-primary" id="updateRec">确认充值</button>
                </div>
            </form>
        </div>
    </div>
</div>
