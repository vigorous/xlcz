<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
//    System.out.println("path = " + path);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>西柳场站管理系统</title>
</head>
<body>
<script type="text/javascript">
    window.top.location.href = "<%=path%>/login/toLogin.do";
</script>
</body>
</html>
