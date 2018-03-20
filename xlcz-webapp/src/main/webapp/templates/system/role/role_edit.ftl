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
                    <div class="mini-clearfix special-form-head">
                        <div class="special-form-head-left">基础信息</div>
                        <div class="special-form-head-right">
                            <div class="group-hr"></div>
                        </div>
                    </div>
                    <form id="editForm" class="form">
                        <table class="form-all margin-top-1" border="0" cellspacing="1" cellpadding="0">
                            <input id="id" name="id" style="display: none" class="mini-textbox" value="${r.id!}"/>
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

                    <div class="mini-clearfix special-form-head">
                        <div class="special-form-head-left">权限信息</div>
                        <div class="special-form-head-right">
                            <div class="group-hr"></div>
                        </div>
                    </div>
                    <form action="" class="form" id="form2">
                        <ul id="tree" class="mini-tree" url="${baseUrl}/menu/allRoleMenuTree.do?roleId=${r.id!}"
                            style="width:780px;height:350px;padding:5px;" showTreeIcon="true" textField="menuName"
                            idField="id" parentField="pid" resultAsTree="false" showCheckBox="true"
                            checkRecursive="true" expandOnLoad="true" onbeforenodecheck="onBeforeNodeCheck"
                            allowSelect="false" enableHotTrack="false">
                        </ul>

                    <#--<ul id="tree3" class="mini-tree" style="width:300px;padding:5px;"
                        showTreeIcon="true" textField="text" idField="id" showCheckBox="true">
                    </ul>-->
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
<script src="${baseUrl}/scripts/system/role/role.js"></script>
<script>
    /** 解析miniui控件 */
    mini.parse();

    function onBeforeNodeCheck(e) {
        var tree = e.sender;
        var node = e.node;
        if (tree.hasChildren(node)) {
            //e.cancel = true;
        }
    }

    /*var tree3 = mini.get("tree3");
    tree3.loadData([
        { id: "lists", text: "Lists", expanded: false,
            children: [
                { id: "datagrid", text: "DataGrid" },
                { id: "tree", text: "Tree" },
                { id: "treegrid", text: "TreeGrid " }
            ]
        },
        { id: "layouts", text: "Layouts", expanded: false,
            children: [
                { id: "panel", text: "Panel" },
                { id: "splitter", text: "Splitter" },
                { id: "layout", text: "Layout " }
            ]
        },
        { id: "navigations", text: "Navigations", expanded: false,
            children: [
                { id: "pager", text: "Pager",checked:1 },
                { id: "tabs", text: "Tabs",checked:0 },
                { id: "navbar", text: "NavBar" },
                { id: "menu", text: "Menu" }
            ]
        }
    ]);*/
</script>
</body>

</html>