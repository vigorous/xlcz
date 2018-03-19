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
        <a href="#" class="prev">系统设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">用户列表</a>
    </div>
    <div class="main">
        <div class="container">
            <div class="mini-clearfix form-search form-all">
                <div class="mini-col-4">
                    <div class="mini-col-2 form-label">用户名称</div>
                    <div class="mini-col-10">
                        <div class="form-input">
                            <input id="userName" class="mini-textbox" name="userName" height="30"/>
                        </div>
                    </div>
                </div>
                <div class="mini-col-4">
                    <div class="mini-col-2 form-label">姓名</div>
                    <div class="mini-col-10">
                        <div class="form-input">
                            <input id="name" class="mini-textbox" name="name" height="30"/>
                        </div>
                    </div>
                </div>
                <div class="mini-col-4">
                    <div class="button-group-right">
                        <input id="searchBtn" class="btn" type="button" value="查询" onclick="search()"/>
                        <input id="resetBtn" class="btn-primary" type="button" value="重置" onclick="reset()"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear-fix">
            <div class="button-group-left" style="float: left;">
                <input class="btn" type="button" value="新增" onclick="toAdd()"/>
                <input class="btn" type="button" value="修改" onclick="toEdit()"/>
                <input class="btn" type="button" value="删除" onclick="del()"/>
            </div>
        </div>
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="用户列表">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/user/userList.do" idField="id"
                             pageSize="10" allowAlternating="true" editNextOnEnterKey="true" multiSelect="true">
                            <div property="columns">
                                <div type="checkcolumn"></div>
                                <div type="indexColumn">序号</div>
                                <div field="id" width="80">用户ID
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="userName" width="80">用户名称
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="name" width="80">姓名
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div name="dId" field="deptId" displayField="deptName" width="80">部门
                                    <input property="editor" class="mini-combobox" id="deptCombo" style="width:100%;"
                                           height="30" valueField="id" textField="deptName" onvaluechanged="deptChanged"
                                           url="${baseUrl}/dept/deptJson.do"/>
                                </div>
                                <div name="rId" field="roleId" displayField="roleName" width="80">角色
                                    <input property="editor" class="mini-combobox" id="roleCombo" style="width:100%;"
                                           height="30" valueField="id" textField="roleName"/>
                                </div>
                                <div field="remark" width="100">备注
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="active" width="80">操作</div>
                            </div>
                        </div>
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
    var grid = mini.get("datagrid1");
    grid.hideColumn(2);//隐藏用户ID
    grid.load();

    grid.on("drawcell", function (e) {
        var grid = e.sender,
                record = e.record,
                uid = record._uid,
                column = e.column,
                field = e.field,
                value = e.value;
        var s = '<a title="修改" href="javascript:editRow(\'' + uid + '\')" ><img class="table-icon" src="${baseUrl}/images/modify.png"/></a>' +
                '<a title="删除" href="javascript:delRow(\'' + uid + '\')"><img class="table-icon" src="${baseUrl}/images/delete.png"/></a>';
        if (grid.isEditingRow(record)) {
            s = '<a title="保存" href="javascript:updateRow();"><img class="table-icon" src="${baseUrl}/images/save.png"/></a>' +
                    '<a title="取消" href="javascript:cancelRow()"><img class="table-icon" src="${baseUrl}/images/edit.png"/></a>'
        }
        if (column.field == "active") {
            e.cellHtml = s;
        }
    });
    setTimeout(function () {
        mini.layout();
    }, 100);

    /** 部门发生改变方法 */
    function deptChanged(e) {
        var combo = e.sender;
        var row = grid.getEditorOwnerRow(combo);
        var editor = grid.getCellEditor("rId", row);

        var id = combo.getValue();
        var url = _G.baseUrl + "/role/roleJson.do?deptId=" + id;
        editor.setUrl(url);
        editor.setValue("");
    }

    //"角色"combo的url在cellbeginedit的时候，根据前面值自动设置
    grid.on("cellbeginedit", function (e) {
        if (e.field == "roleId") {
            var editor = e.editor;
            var id = e.record.deptId;
            var url = _G.baseUrl + "/role/roleJson.do?deptId=" + id;
            editor.setUrl(url);
        }
    });

    /** 行编辑 */
    function editRow(row_uid) {
        var row = grid.getRowByUID(row_uid);
        if (row) {
            grid.cancelEdit();
            grid.beginEditRow(row);
        }
    }

    /** 取消编辑 */
    function cancelRow() {
        grid.cancelEdit();
    }

    /** 删除 */
    function delRow(row_uid) {
        var row = grid.getRowByUID(row_uid);
        // grid.removeRow(row);
        if (row) {
            parent.mini.showMessageBox({
                title: '删除',
                buttons: ["ok", "cancel"],
                html: '<div class="messageBox"><img src="../images/mark.png"/><span>你确定要删信息吗，删除不可恢复?</span></div>',
                callback: function (action) {
                    if (action == 'ok') { //删除
                        $.ajax({
                            url: "${baseUrl}/user/delUser.do",
                            data: row,
                            type: "post",
                            success: function (text) {
                                grid.reload();
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                //alert(jqXHR.responseText);
                            }
                        });
                    }
                }
            });

        }
    }

    /** 修改保存 */
    function updateRow() {
        grid.commitEdit();
        var row = grid.getChanges();
        if (row.length > 0) {
            var user = row[0];
            console.log('user --> ', user);
            if (user.id == null || user.id == '') {
                showMsgBox("修改", '用户ID丢失');
                return;
            }
            if (user.userName == '' || user.userName.trim() == '') {
                showMsgBox("修改", '用户名不能为空');
                return;
            }
            if (user.name == '' || user.name.trim() == '') {
                showMsgBox("修改", '姓名不能为空');
                return;
            }
            if (user.roleId == '' || user.roleId.toString().trim() == '') {
                showMsgBox("修改", '角色不能为空');
                return;
            }
            $.ajax({
                url: "${baseUrl}/user/editUser.do",
                data: user,
                type: "post",
                success: function (text) {
                    grid.reload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    //alert(jqXHR.responseText);
                }
            });
        }
    }


</script>
</body>

</html>