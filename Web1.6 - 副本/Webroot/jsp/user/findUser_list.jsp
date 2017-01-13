<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示账户</title>

</head>
<body>
	<table>
		<tr>
			<th>账户名称</th>
			<th>账户密码</th>

		</tr>

		<tr>
			<th>${use.username}</th>
			<th>${use.password}</th>
		</tr>
	</table>
</body>
</html>