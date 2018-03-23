/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。
 ***************************************************************************/

$(function () {
    /** enter键事件监听 */
    $("#deptName").bind("keydown", function (e) {
        if (e.keyCode == 13) {
            search();
        }
    });
})


/** 查询 */
function search() {
    var deptName = mini.get("deptName").getValue();
    grid.load({deptName: deptName})
}

/** 重置 */
function reset() {
    mini.get("deptName").setValue('');
}

/** 去新增页面 */
function toAdd() {
    console.log("_G.baseUrl:", _G.baseUrl);
    mini.open({
        targetWindow: window.parent,
        url: _G.baseUrl + "/dept/toAdd.do",
        title: "新增",
        width: 800,
        height: 330,
        onload: function () {
            var iframe = this.getIFrameEl();
        },
        ondestroy: function (action) {
            grid.reload();
        }
    });
}

/** 新增部门 */
function addDept() {
    var form = new mini.Form("#addForm");
    var flag = form.validate();
    if (!flag) {
        return;
    }
    var data = form.getData();

    $.ajax({
        url: _G.baseUrl + "/dept/addDept.do",
        data: data,
        type: "post",
        success: function (data) {
            data = mini.decode(data);
            if (data.code == 2 || data == 0) {
                showMsgBox('新增', data.message, 'fail');
            } else {
                showMsgBox('新增', data.message, 'success', function () {
                    closeWindow();
                });
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            //mini.alert(jqXHR.responseText);
        }
    });
}

/** 去修改页面 */
function toEdit() {
    var rows = grid.getSelecteds();
    if (rows.length <= 0 || rows.length > 1) {//未选中一条记录
        showMsgBox('修改', '请选择一条记录!');
    } else {
        var dept = rows[0];
        mini.open({
            targetWindow: window.parent,
            url: _G.baseUrl + "/dept/toEdit.do?id=" + dept.id,
            title: "修改",
            width: 800,
            height: 330,
            onload: function () {
                var iframe = this.getIFrameEl();
            },
            ondestroy: function (action) {
                grid.reload();
            }
        });
    }

}

/** 修改部门 */
function editDept() {
    var form = new mini.Form("#editForm");
    var flag = form.validate();
    if (!flag) {
        return;
    }
    var data = form.getData();

    $.ajax({
        url: _G.baseUrl + "/dept/editDept.do",
        data: data,
        type: "post",
        success: function (msg) {
            console.log("msg:", msg);
            closeWindow();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            //console.log("testStatus:", testStatus);
            mini.alert(jqXHR.responseText);
        }
    });

}


/** 删除部门 */
function delDept() {
    var rows = grid.getSelecteds();
    console.table(rows);
    if (rows.length > 0) {
        showMsgBox("删除", "你确定要删信息吗，删除不可恢复?", "mark", function (action) {
            if (action == 'ok') { //删除
                var ids = [];
                for (var i = 0; i < rows.length; i++) {
                    var row = rows[i];
                    ids.push(row.id);
                }
                var id = ids.join(",");
                $.ajax({
                    url: _G.baseUrl + "/dept/delDept.do?ids=" + id,
                    success: function (data) {
                        data = mini.decode(data);
                        if (data.code == 0) {
                            showMsgBox('删除', data.message, 'fail');
                        } else {
                            showMsgBox('删除', data.message, 'success', function () {
                                grid.reload();
                            });
                        }
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

/** 关闭弹窗 */
function closeWindow() {
    window.CloseOwnerWindow("cancel");
}
