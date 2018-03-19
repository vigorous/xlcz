<head>
</head>
<body>
	<input type="button" value="添加" onclick="window.location.href='addUser.jspa';">
	<table>
		<tr align="center">
			<th width=100>用户名</th>
			<th width=100>密码</th>
			<th width=200>操作</th>
		</tr>
		<#if users?has_content>
			<#list users as user>
			<tr align="center">
				<td width=100>${user.userName!}</td>
				<td width=100>${user.password!}</td>
				<td width=200>
					<a href="viewUser.jspa?userId=${user.id!}">查看</a>
					<a href="editUser.jspa?userId=${user.id!}">修改</a>
					<a href="deleteUser.jspa?userId=${user.id!}">删除</a>
				</td>
			</tr>
			</#list>
		</#if>
	</table>
	<#--<form id="pageForm" name="pageForm" action="listUserByPage.jspa">
		第<input id="start" name="start" value="${userSo.start!}">页， 每页<input id="pageSize" name="pageSize" value="${userSo.pageSize!}">条
		<input type="submit" value="分页查询">
		<input type="button" value="查询所有" onclick="window.location.href='listUser.jspa';">
	</form>-->
</body>