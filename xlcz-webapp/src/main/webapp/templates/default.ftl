<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>西柳场站管理系统</title>
    <#--<link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/default/miniui.css"/>-->
    <#--<link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/icons.css"/>-->
    <#--<link rel="stylesheet" href="${baseUrl}/css/window.css"/>-->
    <#--<link rel="stylesheet" href="${baseUrl}/css/index.css"/>-->
    <#include "common/meta_default.ftl"/>
</head>
<body>
<div class="warp">
    <div class="head">
        <div class="logo"></div>
        <div class="remind">
            <a class="clock" href="javascript:void(0);">
                <span class="circle">5</span>
            </a>
        <#--<a class="close" onclick="logout()"></a>-->
            <a class="close" href="${baseUrl}/login/logout.do"></a>
            <a class="headPicture" title="用户id" href="javascript:void(0);"></a>
            <a class="who" href="javascript:void(0);">欢迎您,<span id="who">${user.userName!}</span></a>
        </div>
    </div>
    <div class="main">
        <div class="mini-splitter" style="width: 100%;height: 100%;">
            <div size="180" showCollapseButton="true">
                <div class="nav"><#--http://localhost:8080/xlcz-webapp/-->
                    <div id="leftTree" class="mini-outlookmenu" url="${baseUrl}/menu/menuList.do"
                         onitemselect="onItemSelect"
                         idField="id" parentField="pid" textField="text" borderStyle="border:0" floatable="false"></div>
                </div>
            </div>
            <div>
                <div class="container">
                    <div class="iframe">
                        <iframe id="mainframe" frameborder="0" name="main" border="0"></iframe>
                    </div>
                    <div class="foot">—— 浙江电子口岸有限公司 Copyright © 2017 ——</div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${baseUrl}/scripts/lib/jquery/jquery.min.js"></script>
<script src="${baseUrl}/scripts/lib/miniui/miniui.js"></script>
<script src="${baseUrl}/scripts/default.js"></script>
<script>
    mini.parse(); //渲染mini
    var $div = $("<div></div>").addClass("select-border");

    //左侧导航栏选中事件
    function onItemSelect(e) {
        var iframe = document.getElementById("mainframe");
        var item = e.item;
        console.log("baseUrl:", _G.baseUrl);
        console.log("url:", item.url);
        iframe.src = _G.baseUrl + "/" + item.url;
    }

    //选中的nav给予边框
    $(".mini-menuitem").on("click", function () {
        $(this).append($div);
        $(this).siblings().find(".select-border").remove();
    });
    //默认选中
    var tree = mini.get("leftTree");
    tree.selectNode("singleSearchExample");
    setTimeout(function () {
        $('#singleSearchExample').append($div);
    }, 100)
</script>
<script>

</script>
</body>

</html>