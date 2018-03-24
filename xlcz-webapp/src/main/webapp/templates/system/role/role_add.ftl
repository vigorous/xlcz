<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色列表</title>
    <#include "../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">角色列表&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">角色新增</a>
    </div>
    <div class="main">
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="角色信息">
                    <div class="mini-clearfix special-form-head">
                        <div class="special-form-head-left">基础信息</div>
                        <div class="special-form-head-right">
                            <div class="group-hr"></div>
                        </div>
                    </div>
                    <form id="addForm" class="form">
                        <table class="form-all margin-top-1" border="0" cellspacing="1" cellpadding="0">
                            <tr>
                                <td width="20%">
                                    <div class="form-label">部门</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="deptCombo" name="deptId" class="mini-combobox" textField="deptName"
                                               valueField="id" url="${baseUrl}/dept/deptJson.do" height="30" emptyText="请输入部门"
                                               maxlength="45" required/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%">
                                    <div class="form-label">角色名称</div>
                                </td>
                                <td width="80%">
                                    <div class="form-input">
                                        <input id="roleName" name="roleName" class="mini-textbox" height="30"
                                               emptyText="请输入角色名称" value="" maxlength="45" required/>
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
                                               emptyText="请输入角色描述" value="" maxlength="45"/>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>

                    <div class="mini-clearfix special-form-head">
                        <div class="special-form-head-left">权限信息</div>
                        <div class="special-form-head-right">
                            <div class="group-hr"></div>
                        </div>
                    </div>
                    <div>
                        <ul id="tree" class="mini-tree" url="${baseUrl}/menu/allMenuTree.do"
                            style="width:780px;height:350px;padding:5px;" showTreeIcon="true" textField="menuName"
                            idField="id" parentField="pid" resultAsTree="false" showCheckBox="true"
                            checkRecursive="true" expandOnLoad="true" allowSelect="false" enableHotTrack="false">
                        </ul>
                    </div>
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
<script src="${baseUrl}/scripts/system/role/role.js"></script>
<script>
    mini.parse();
</script>
</body>

</html>