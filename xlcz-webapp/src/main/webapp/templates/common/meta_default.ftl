<#assign baseUrl=request.getContextPath()>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/default/miniui.css"/>
<link rel="stylesheet" href="${baseUrl}/scripts/lib/miniui/themes/icons.css"/>
<link rel="stylesheet" href="${baseUrl}/css/window.css"/>
<link rel="stylesheet" href="${baseUrl}/css/index.css"/>
<#--<script src="${baseUrl}/scripts/lib/jquery/jquery.min.js"></script>-->
<script language="JavaScript" type="text/JavaScript">
    var _G = {
        'baseUrl': '${baseUrl}'
    };
    /*var timeoutlogin = _G.baseUrl + "/login/toLogin.do";

    $.ajaxSetup({
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        cache: false,
        complete: function (data, TS) {
            //对返回的数据data做判断
            debugger;
            //403是后台拦截器那儿定义的，
            if (data.status == 403) {
                //session过期的话，就location到一个页面
                window.top.location.href = timeoutlogin;
                return;
            }
        }
    });*/
</script>