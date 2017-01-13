<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加管理员</title>
<script src="js/jquery.js"></script>
<script>
	function check() {
		var user = $("#user").val(); //获取表单元素值
		var number = $("#number").val();
		if (user == "" || number == "") {
			$("#msg").text("姓名,学号不能为空！");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
     <form action="./adduser.do" method="post"  onsubmit="return check()">
                	<input type="hidden" name="id" value="${user.id}"/>
                	<c:if test="${type != 'modify' }">
                	账户名称:<input type="text" name="userName" id="user" value="${user.username }"><br><br>
                	</c:if>
                	<c:if test="${type == 'modify' }">
                           <input type="hidden" name="name" id="name" value="${user.username}">                	
                	</c:if>
                	账户密码：<input type="text" name="passWord" id="number" value="${user.password }"><br><br>
                	管理员权限:<input type="text" name="Number" value="${user.number}"><br><br>
                	<span id="msg" style="color:red;font-size:10px">${error}</span><br><br>
                	<input type="submit" value="添加">
     </form>
</body>
</html>