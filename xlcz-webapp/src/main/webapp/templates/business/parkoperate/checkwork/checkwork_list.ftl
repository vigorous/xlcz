<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查验作业</title>
    <#include "../../../common/meta_zjport.ftl"/>
</head>
<body>
<div class="warp">
    <div class="trace">
        <a href="#" class="prev">园区操作&nbsp;>&nbsp;</a>
        <a href="javascript:void(0);" class="now">查验作业</a>
    </div>
    <div class="main">
        <div class="container">
            <div class="mini-clearfix form-search form-all">
                <div class="mini-clearfix">
                    <div class="mini-col-4">
                        <div class="mini-col-4 form-label">场站序号</div>
                        <div class="mini-col-8">
                            <div class="form-input">
                                <input id="serialNo" class="mini-textbox" name="serialNo" height="30"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mini-clearfix">
                    <div class="mini-col-4">
                        <div class="mini-col-4 form-label">场站序号</div>
                        <div class="mini-col-8">
                            <div class="form-input">
                                <input id="serialNo" class="mini-textbox" name="serialNo" height="30"/>
                            </div>
                        </div>
                    </div>
                </div>
                <#-- 更多查询 more-search -->
                <div class="mini-clearfix more-search">
                    <div class="mini-col-4">
                        <div class="mini-col-4 form-label">场站序号</div>
                        <div class="mini-col-8">
                            <div class="form-input">
                                <input id="serialNo" class="mini-textbox" name="serialNo" height="30"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="button-group-center">
                    <a href="javascript:moreSearch();" class="more-search-button">
                        <span>展开搜索</span>
                        <img src="${baseUrl}/images/doubledownArrow.png"/>
                    </a>
                    <button class="btn" onclick="search()">查询</button>
                    <button class="btn-primary" onclick="reset()">重置</button>
                </div>
            </div>
        </div>
        <div class="clear-fix">
            <div class="button-group-left" style="float: left;">
                <input class="btn" type="button" value="作业操作" onclick="workOperate()"/>
                <input class="btn" type="button" value="补车辆信息" onclick="addCarInfo()"/>
                <input class="btn" type="button" value="补客户信息" onclick="addCustomerInfo()"/>
                <input class="btn" type="button" value="吊上" onclick="up()"/>
                <input class="btn" type="button" value="吊下" onclick="down()"/>
            </div>
        </div>
        <div class="container">
            <div id="tabs1" class="mini-tabs" activeIndex="0" plain="false">
                <div title="查验作业">
                    <div class="margin-top-1 form">
                        <div id="datagrid1" class="mini-datagrid" url="${baseUrl}/checkwork/checkWorkList.do"
                             idField="id" pageSize="10" allowAlternating="true" editNextOnEnterKey="true"
                             multiSelect="true">
                            <div property="columns">
                                <div type="checkcolumn" width="20"></div>
                                <div type="indexColumn" width="25">序号</div>
                                <div field="id">ID</div>
                                <div field="serialNo" width="80">场站序号</div>
                                <div field="entryId" width="80">报关单号</div>
                                <div field="billNo" width="100">提单号</div>
                                <div field="customerName" width="100">客户</div>
                                <div field="carNo" width="100">车牌号</div>
                                <div field="containerNo" width="100">集装箱号</div>
                                <div field="containerType" width="100">箱型</div>
                                <div field="unstuffingType" width="60">掏箱类型</div>
                                <div field="inTime" width="100">进场时间</div>
                                <div field="outTime" width="100">出场时间</div>
                                <div field="upTime" width="100">吊上时间</div>
                                <div field="downTime" width="100">吊下时间</div>
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
<script src="${baseUrl}/scripts/business/parkoperate/checkwork.js"></script>
<script>
    mini.parse();
    var grid = mini.get("datagrid1");
    //隐藏ID字段
    grid.hideColumn(2);
    grid.load();

    /** 更多查询条件 */
    function moreSearch() {
        if ($(".more-search").is(":visible")) {
            $(".more-search").hide();
            $(".more-search-button").find("span").text("展开搜索");
            $(".more-search-button").find("img").attr('src', "${baseUrl}/images/doubledownArrow.png");
        } else {
            $(".more-search").show();
            $(".more-search-button").find("span").text("收起搜索");
            $(".more-search-button").find("img").attr('src', "${baseUrl}/images/doubleUpArrow.png")
        }
    }
</script>
</body>

</html>