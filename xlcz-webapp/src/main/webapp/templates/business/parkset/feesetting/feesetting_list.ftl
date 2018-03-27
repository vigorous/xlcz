<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>费率列表</title>
    <#include "../../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">园区设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">费率列表</a>
    </div>
    <div class="main">
        <div class="clear-fix">
            <div class="button-group-left" style="float: left;">
                <input class="btn" type="button" value="保存" onclick="save()"/>
                <input class="btn" type="button" value="刷新" onclick="reload()"/>
            </div>
        </div>
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="费率设置">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/feesetting/feeSettingList.do"
                             idField="id" showPager="false" pageSize="30" allowAlternating="true"
                             editNextOnEnterKey="true"
                             multiSelect="true" allowCellEdit="true" allowCellSelect="true">
                            <div property="columns">
                            <#--<div type="checkcolumn"></div>-->
                                <div type="indexColumn" width="10">序号</div>
                                <div field="id" width="80">费率设置ID
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="feeCode" width="80">费率代码
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="feeName" width="80">费率名称
                                <#--<input property="editor" class="mini-textbox" style="width:100%;" height="30"/>-->
                                </div>
                                <div field="feeValue" width="100">费率值
                                    <input id="feeValue" property="editor" class="mini-textbox" style="width:100%;"
                                           vtype="float" height="30"/>
                                </div>
                                <div field="remark" width="100">备注
                                    <input property="editor" class="mini-textarea" style="width:98%;" height="30"/>
                                </div>
                                <div field="active" width="5"></div>
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
<script src="${baseUrl}/scripts/business/parkset/feesetting.js"></script>
<script>
    mini.parse();
    var grid = mini.get("datagrid1");
    //隐藏费率设置ID字段、费率代码
    grid.hideColumn(1);
    grid.hideColumn(2);
    grid.load();

    grid.on("beforeload", function (e) {
        if (grid.getChanges().length > 0) {
            if (mini.confirm("有修改的数据未保存，是否取消本次操作？")) {
                e.cancel = true;
            }
            /*showMsgBox('提示', "有修改的数据未保存，是否取消本次操作？", 'mark', function (action) {
                if (action == 'cancel') {
                    e.cancel = true;
                }
            });*/
        }
    });

    /** 单元格编辑提交前 */
    grid.on("cellcommitedit", function (e) {
        var editor = e.editor;
        if (e.field == "feeValue") {
            editor.validate();
            if (editor.isValid() == false) {
                showMsgBox('提示', editor.getErrorText(), 'fail');
                e.cancel = true;
            } else if (editor.getText() == '' || editor.getText() == null) {
                e.cancel = true;
            } else {
                var value = parseFloat(editor.getText()).toFixed(2);
                e.value = value;
            }
        }

    });
</script>
</body>

</html>