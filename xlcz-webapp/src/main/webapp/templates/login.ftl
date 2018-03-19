<#assign baseUrl=request.getContextPath() />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>西柳场站管理系统</title>
</head>
<body>
<form id="loginForm" name="loginForm" action="${baseUrl}/login/login.do" method="post" onsubmit="return loginCheck();">
    userName:<input id="userName" type="text" name="userName" value=""/><br/>
    password:<input id="password" type="password" name="password" value=""><br/>
    <input type="submit" value="login"/><font color="red">${msg!}</font>
</form>
<script src="${baseUrl}/scripts/lib/jquery/jquery.min.js"></script>
<script src="${baseUrl}/scripts/login.js"></script>
</body>
</html>
