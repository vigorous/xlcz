/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/

/** 查询 */
function search() {
    var roleName = mini.get('roleName').getValue();
    grid.load({roleName: roleName})
}

/** 重置 */
function reset() {
    mini.get("roleName").setValue();
}

/** 新增页面 */
function toAdd() {
    mini.open({
        targetWindow: window.parent,
        url: _G.baseUrl + "/role/toAdd.do",
        title: "新增",
        width: 800,
        height: 600,
        onload: function () {
            var iframe = this.getIFrameEl();
        },
        ondestroy: function (action) {
            grid.reload();
        }
    });
}

/** 新增 */
function add() {
    //校验表单数据
    var form = new mini.Form("#addForm");
    var flag = form.validate();
    if (!flag) {
        return;
    }
    //获取表单数据
    var data = form.getData();

    //获取树形数据
    var tree = mini.get("tree");
    var nodes = tree.getCheckedNodes(true);
    //角色菜单
    var roleMenuArr = new Array();
    for (var i = 0; i < nodes.length; i++) {
        var roleMenu = createRoleMenu(roleId, nodes[i].id);
        roleMenuArr.add(roleMenu);
    }
    var roleMenuJson = JSON.stringify(roleMenuArr);
    data.roleMenuJson = roleMenuJson;

    $.ajax({
        url: _G.baseUrl + "/role/addRole.do",
        data: data,
        type: "post",
        success: function (data) {
            data = mini.decode(data);
            if (data.code == 0) {
                showMsgBox('新增', msg.message, 'fail');
            } else {
                showMsgBox('新增', msg.message, 'success', function () {
                    closeWindow();
                });
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}

/** 编辑页面 */
function toEdit() {
    var rows = grid.getSelecteds();
    if (rows.length <= 0 || rows.length > 1) {//未选中一条记录
        showMsgBox('修改', '请选择一条记录!');
    } else {
        var role = rows[0];
        mini.open({
            targetWindow: window.parent,
            url: _G.baseUrl + "/role/toEdit.do?id=" + role.id,
            title: "修改",
            width: 800,
            height: 700,
            onload: function () {
                var iframe = this.getIFrameEl();
            },
            ondestroy: function (action) {
                grid.reload();
            }
        });
    }
}

/** 编辑 */
function edit() {
    //校验表单数据
    var form = new mini.Form("#editForm");
    var flag = form.validate();
    if (!flag) {
        return;
    }
    var data = form.getData();
    var roleId = data.id;//角色ID

    //获取树形数据
    var tree = mini.get("tree");
    var nodes = tree.getCheckedNodes(true);
    //角色菜单
    var roleMenuArr = new Array();
    for (var i = 0; i < nodes.length; i++) {
        var roleMenu = createRoleMenu(roleId, nodes[i].id);
        roleMenuArr.add(roleMenu);
    }
    var roleMenuJson = JSON.stringify(roleMenuArr);
    data.roleMenuJson = roleMenuJson;

    $.ajax({
        url: _G.baseUrl + "/role/editRole.do",
        data: data,
        type: "post",
        success: function (data) {
            data = mini.decode(data);
            if (data.code == 0) {
                showMsgBox('修改', msg.message, 'fail');
            } else {
                showMsgBox('修改', msg.message, 'success', function () {
                    closeWindow();
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}

/** 删除 */
function del() {
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
        showMsgBox("删除", "你确定要删信息吗，删除不可恢复?", function (action) {
            if (action == 'ok') {
                var ids = [];
                for (var i = 0; i < rows.length; i++) {
                    var row = rows[i];
                    ids.push(row.id);
                }
                var id = ids.join(",");
                $.ajax({
                    url: _G.baseUrl + "/role/delRoles.do?ids=" + id,
                    success: function (text) {
                        grid.reload();
                    },
                    error: function () {
                    }
                });
            }
        });
    } else {
        showMsgBox("删除", "请选择要删除的记录!");
    }
}