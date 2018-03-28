<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>船公司识别设置修改</title>
    <#include "../../../common/meta_zjport.ftl"/>
</head>

<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">船公司识别设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">修改</a>
    </div>
    <div class="main">
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="船公司识别信息">
                    <form id="editForm" class="form">
                        <input id="id" name="id" style="display: none" class="mini-textbox" value="${ship.id!}"/>
                        <table class="form-all margin-top-1" border="0" cellspacing="1" cellpadding="0">
                            <tr>
                                <td width="20%">
                                    <div class="form-label">船公司名称</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="shippingCompany" name="shippingCompany" class="mini-textbox"
                                               height="30" emptyText="请输入船公司名称" value="${ship.shippingCompany!}"
                                               maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">提单编号规则</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="codeRule" name="codeRule" class="mini-textbox" height="30"
                                               emptyText="请输入提单编号规则" value="${ship.codeRule!}" maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">备注</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="remark" name="remark" class="mini-textarea" height="30"
                                               emptyText="请输入备注" value="${ship.remark!}" maxlength="1000"/>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="button-group-center">
                        <input class="btn" type="button" value="确定" onclick="edit()"/>
                        <input class="btn-primary" type="button" value="取消" onclick="closeWindow()"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${baseUrl}/scripts/lib/jquery/jquery.min.js"></script>
<script src="${baseUrl}/scripts/lib/miniui/miniui.js"></script>
<script src="${baseUrl}/scripts/lib/miniui/fixheight.js"></script>
<script src="${baseUrl}/scripts/common/form.js"></script>
<script src="${baseUrl}/scripts/system/common/zjport.js"></script>
<script src="${baseUrl}/scripts/business/parkset/shipset.js"></script>
<script>
    mini.parse();
</script>
</body>

</html>