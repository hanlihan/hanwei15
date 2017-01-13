<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add</title>
</head>
<body>
	<a>我是蔡大爷的大爷</a>
	<form action="./testStrutsAction.do" method="post">
		姓名:<input type="text" name="name">${Names}<br>
		密码:<input type="text" name="password">${Passwords}<br> <br>
<%-- 		<s:fielderror> --%>
<%-- 			<s:param>testName</s:param> --%>
 
<%-- 			<s:param>Password</s:param> --%>
<%-- 		</s:fielderror> --%>
		<input type="submit" value="提交"><br>
	</form>
	<!--   		<form action="./testuser.do" method="post"> -->
	<!-- 	  		姓名:<input type="text" name="name"> -->
	<!-- 	  		密码:<input type="text" name="password"> -->
	<!--   		<input type="submit" value="提交"> -->
	<!--   		</form> -->
</body>
</html>