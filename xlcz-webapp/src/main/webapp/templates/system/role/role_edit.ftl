<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色修改</title>
    <#include "../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">角色列表&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">角色修改</a>
    </div>
    <div class="main">
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="角色信息">
                    <form id="editForm" class="form">
                        <table class="form-all margin-top-1" border="0" cellspacing="1" cellpadding="0">
                            <input id="id" name="id" style="display: none" class="mini-textbox" value="${role.id!}"/>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">角色名称</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="roleName" name="roleName" class="mini-textbox" height="30"
                                               emptyText="请输入角色名称" value="${r.roleName!}" maxlength="45"
                                               allowInput="false" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">角色描述</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="roleDesc" name="roleDesc" class="mini-textbox" height="30"
                                               emptyText="请输入角色描述" value="${r.roleDesc!}" maxlength="45"/>
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
<script src="${baseUrl}/scripts/system/common/zjport.js"></script>
<script src="${baseUrl}/scripts/system/role/role.js"></script>
<script>
    mini.parse();
</script>
</body>

</html>