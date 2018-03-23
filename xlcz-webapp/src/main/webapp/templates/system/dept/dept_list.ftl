<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门列表</title>
    <#include "../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">系统设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">部门列表</a>
    </div>
    <div class="main">
        <div class="container">
            <div class="mini-clearfix form-search form-all">
                <div class="mini-col-6">
                    <div class="mini-col-2 form-label">部门名称</div>
                    <div class="mini-col-10">
                        <div class="form-input">
                            <input id="deptName" class="mini-textbox" name="deptName" height="30"/>
                        </div>
                    </div>
                </div>
                <div class="mini-col-6">
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
                <input class="btn" type="button" value="删除" onclick="delDept()"/>
            </div>
        </div>
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="部门列表">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/dept/deptList.do" idField="id"
                             pageSize="10" allowAlternating="true" editNextOnEnterKey="true" editNextRowCell="true"
                             multiSelect="true">
                            <div property="columns">
                                <div type="checkcolumn" width="10"></div>
                                <div type="indexColumn" width="10">序号</div>
                                <div field="deptName" width="100">部门名称
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="deptDesc" width="200">部门描述
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                            <#--<div field="active" width="150">操作</div>-->
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
<script src="${baseUrl}/scripts/system/dept/dept.js"></script>
<script>
    $(".button-drop").on("click", function () {
        if ($(this).find(".drop-body").is(":visible")) {
            $(this).find(".drop-body").hide();
            $(this).find(".drop").removeClass("drop-active");
        } else {
            $(this).find(".drop-body").show();
            $(this).find(".drop").addClass("drop-active");
        }
    })
</script>
<script>
    mini.parse();
    var grid = mini.get("datagrid1");
    grid.load();
    grid.on("drawcell", function (e) {
        var record = e.record,
                uid = record._uid,
                column = e.column,
                field = e.field,
                value = e.value;
        var s = ' <a title="修改" href="javascript:editRow(\'' + uid + '\')" ><img class="table-icon" src="${baseUrl}/images/modify.png"/></a>' +
                ' <a title="删除" href="javascript:delRow(\'' + uid + '\')"><img class="table-icon" src="${baseUrl}/images/delete.png"/></a>';
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
    }, 100)

    function editRow(row_uid) {
        var row = grid.getRowByUID(row_uid);
        if (row) {
            grid.cancelEdit();
            grid.beginEditRow(row);
        }
    }

    function delRow(row_uid) {
        var row = grid.getRowByUID(row_uid);
        grid.removeRow(row);
    }

    function updateRow() {
        grid.commitEdit();
    }

    function cancelRow() {
        grid.cancelEdit();
    }
</script>
</body>

</html>