<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门修改</title>
    <#--<link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/default/miniui.css"/>
    <link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/icons.css"/>
    <link rel="stylesheet" href="${baseUrl}/css/base.css"/>
    <link rel="stylesheet" href="${baseUrl}/css/explain.css"/>-->
    <#include "../../common/meta_zjport.ftl"/>
</head>

<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">部门列表&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">部门新增</a>
    </div>
    <div class="main">
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="部门信息">
                    <form id="addForm" class="form">
                        <table class="form-all margin-top-1" border="0" cellspacing="1" cellpadding="0">
                            <tr>
                                <td width="20%">
                                    <div class="form-label">部门名称</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="deptName" name="deptName" class="mini-textbox" height="30"
                                               emptyText="请输入部门名称" value="" maxlength="50" required="true"/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">部门描述</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="deptDesc" name="deptDesc" class="mini-textbox" height="30"
                                               emptyText="请输入部门描述" value="" maxlength="1000"/>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="button-group-center">
                        <input class="btn" type="button" value="确定" onclick="addDept()"/>
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
<script src="${baseUrl}/scripts/system/dept/dept.js"></script>
<script>
    mini.parse();
</script>
</body>

</html>