<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>日志列表</title>
    <#--<link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/default/miniui.css"/>
    <link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/icons.css"/>
    <link rel="stylesheet" href="${baseUrl}/css/base.css"/>
    <link rel="stylesheet" href="${baseUrl}/css/explain.css"/>-->
    <#include "../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">系统设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">日志列表</a>
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
                    <div class="mini-col-4 form-label">登录日期</div>
                    <div class="mini-col-8">
                        <div class="form-input">
                            <input height="30" id="loginTime" name="loginTime" class="mini-datepicker"
                                   showPopupOnClick="true" allowInput="false"/>
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
            <div class="button-drop">
                <span>常用功能</span>
                <span class="drop"></span>
                <div class="drop-body">
                    <div id="exportFile" onclick="exportFile();">导出</div>
                </div>
            </div>
        </div>
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="日志列表">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/log/logList.do" idField="id"
                             pageSize="10" allowAlternating="true" editNextOnEnterKey="true" editNextRowCell="true"
                             multiSelect="true">
                            <div property="columns">
                                <div type="indexColumn" width="10">序号</div>
                                <div field="userName" width="100">用户名称
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="name" width="100">姓名
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="roleName" width="100">角色名称
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="ip" width="100">IP地址
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="loginTime" width="100" renderer="formatD">登录时间
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
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

    /** 查询 */
    function search() {
        var userName = mini.get("userName").getValue();
        var loginTime = mini.formatDate(mini.get("loginTime").getValue(), 'yyyy-MM-dd');
        // console.log("loginTime:" + loginTime);
        grid.load({userName: userName, loginTime: loginTime})
    }

    /** 重置 */
    function reset() {
        mini.get("userName").setValue('');
        mini.get("loginTime").setValue('')
    }

    /** 日期格式化 */
    function formatD(e) {
        if (e.value != null && e.value != '') {
            var value = new Date(e.value);
            if (value) return mini.formatDate(value, 'yyyy-MM-dd HH:mm:ss');
        } else {
            return e.value;
        }
    }

    /** 导出excel */
    function exportFile() {
        var userName = mini.get("userName").getValue();
        var loginTime = mini.formatDate(mini.get("loginTime").getValue(), 'yyyy-MM-dd');
        window.location.href = _G.baseUrl + "/log/excel.do?userName=" + userName + "&loginTime=" + loginTime;
    }
</script>
</body>

</html>