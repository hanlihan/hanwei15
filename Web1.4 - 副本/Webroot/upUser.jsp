<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改管理界面</title>
</head>
<body>
       
     <div id="min">
			<form name="loginForm" action="./upUser_list.do" method="post" onsubmit="return b()">
			    <input type="hidden" name="id" value="${user.id}"/>
				姓名:<input type="text" id="name" name="name"  value="${user.username}"/><br/>
				密码:<input type="text" id="password" name="password"  value="${user.password}"/><br/>
				    <input type="text" id="number" name="number"  value="${user.number}"/><br/>
				
				<span id="msg" style="color:red;font-size:10px">${error}</span><br><br>
				<input type="submit" value="修改">
				<br> 
				<span id="msg"></span>
			</form>
		</div>
</body>
</html>