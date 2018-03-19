<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <#include "../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">用户列表&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">用户新增</a>
    </div>
    <div class="main">
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="用户信息">
                    <form id="addForm" class="form">
                        <table class="form-all margin-top-1" border="0" cellspacing="1" cellpadding="0">
                            <tr>
                                <td width="20%">
                                    <div class="form-label">用户名称</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="userName" name="userName" class="mini-textbox" height="30"
                                               emptyText="请输入用户名称" value="" maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">密码</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="password" name="password" class="mini-password" height="30"
                                               emptyText="请输入密码" maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">姓名</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="name" name="name" class="mini-textbox" height="30"
                                               emptyText="请输入姓名" value="" maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">部门</div>
                                </td>
                                <td width="40%">
                                    <div class="form-input">
                                        <input id="deptCombo" name="deptId" class="mini-combobox" textField="deptName"
                                               valueField="id" url="${baseUrl}/dept/deptJson.do"
                                               onvaluechanged="onDeptChanged" height="30" emptyText="请输入部门"
                                               maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">角色</div>
                                </td>
                                <td width="40%">
                                    <div class="form-input">
                                        <input id="roleCombo" name="roleId" class="mini-combobox" textField="roleName"
                                               valueField="id" height="30" emptyText="请输入角色" maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="button-group-center">
                        <input class="btn" type="button" value="确定" onclick="add()"/>
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
<script src="${baseUrl}/scripts/system/common/zjport.js"></script>
<script src="${baseUrl}/scripts/system/user/user.js"></script>
<script>
    mini.parse();
</script>
</body>

</html>