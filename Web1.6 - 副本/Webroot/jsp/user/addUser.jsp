<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加账户</title>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	function check() {
		var user = $("#user").val(); //获取表单元素值
		var number = $("#number").val();
		if (user == "" || number == "") {
			$("#msg").text("账户名称,账户密码不能为空！");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<form action="./user_Add.do" method="post" onsubmit="return check()">
		<input type="hidden" name="id" value="${user.id}"/>
                	<c:if test="${empty user.id }">
                	账户名称:<input type="text" name="username" id="user" value="${user.username }"><br><br>
                	</c:if>
                	<c:if test="${!empty user.id }">
                           <input type="hidden" name="username" id="name" value="${user.username}">                	
                	</c:if>
		账户密码：<input type="text" name="password" id="number" value="${user.password}"><br>
		<br> <span id="msg" style="color: red; font-size: 10px">${error}</span><br>
		<br> <input type="submit" value="提交">
	</form>
</body>
</html>