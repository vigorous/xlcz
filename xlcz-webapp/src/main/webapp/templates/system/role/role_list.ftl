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
        <a href="#" class="prev">系统设置&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">角色列表</a>
    </div>
    <div class="main">
        <div class="container">
            <div class="mini-clearfix form-search form-all">
                <div class="mini-col-6">
                    <div class="mini-col-2 form-label">角色名称</div>
                    <div class="mini-col-10">
                        <div class="form-input">
                            <input id="roleName" class="mini-textbox" name="roleName" height="30"/>
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
                <div title="角色列表">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/role/roleList.do" idField="id"
                             pageSize="10" allowAlternating="true" editNextOnEnterKey="true" multiSelect="true">
                            <div property="columns">
                                <div type="checkcolumn"></div>
                                <div type="indexColumn">序号</div>
                                <div field="id" width="80">角色ID
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="roleName" width="80">角色名称
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="roleDesc" width="80">角色描述
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                                <div field="deptName" width="100">部门名称
                                    <input property="editor" class="mini-textbox" style="width:100%;" height="30"/>
                                </div>
                            <#--<div field="active" width="80">操作</div>-->
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
<script src="${baseUrl}/scripts/system/role/role.js"></script>
<script>
    mini.parse();
    var grid = mini.get("datagrid1");
    //隐藏角色ID字段
    grid.hideColumn(2);
    grid.load();
</script>
</body>

</html>