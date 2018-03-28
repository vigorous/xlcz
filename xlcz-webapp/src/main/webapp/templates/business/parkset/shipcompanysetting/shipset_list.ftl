<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>船公司识别设置</title>
    <#include "../../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">园区设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">船公司识别设置</a>
    </div>
    <div class="main">
        <div class="container">
            <div class="mini-clearfix form-search form-all">
                <div class="mini-col-6">
                    <div class="mini-col-2 form-label">船公司名称</div>
                    <div class="mini-col-10">
                        <div class="form-input">
                            <input id="shippingCompany" class="mini-textbox" name="shippingCompany" height="30"/>
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
                <input class="btn" type="button" value="删除" onclick="del()"/>
            </div>
        </div>
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="船公司识别设置">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/ship/shipSettingList.do"
                             idField="id" pageSize="10" allowAlternating="true" editNextOnEnterKey="true"
                             multiSelect="true">
                            <div property="columns">
                                <div type="checkcolumn" width="15"></div>
                                <div type="indexColumn" width="15">序号</div>
                                <div field="id" width="80">ID</div>
                                <div field="shippingCompany" width="80">船公司名称</div>
                                <div field="codeRule" width="80">提单编号规则</div>
                                <div field="remark" width="100">备注</div>
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
<script src="${baseUrl}/scripts/business/parkset/shipset.js"></script>
<script>
    mini.parse();
    var grid = mini.get("datagrid1");
    //隐藏ID字段
    grid.hideColumn(2);
    grid.load();

    /*grid.on("beforeload", function (e) {
        if (grid.getChanges().length > 0) {
            if (mini.confirm("有修改的数据未保存，是否取消本次操作？")) {
                e.cancel = true;
            }
        }
    });

    /!** 单元格编辑提交前 *!/
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

    });*/
</script>
</body>

</html>