<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.text.Li.User"%>
<%@page import="java.util.ArrayList"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>HttpSessionLisetner拦截器之统计在线人数和在线用户信息</title>
</head>
<body>
<h1>
		HttpSessionLisetner拦截器之统计在线人数和在线用户信息
	</h1>
	<h2>
		在线人数是 :<%=application.getAttribute("online")%></h2>
	<h2>
		用户信息 :<br>
		<hr>
		<%
		ArrayList<User> userList = (ArrayList<User>) application.getAttribute("userLists");
	    if(userList != null){
	    	for(User user : userList){
	    		out.println("IP :"+user.getIp()+"<br>");
	    		out.println("创建时间  :"+user.getTime()+"<br>");
	    		out.println("sessionId :"+user.getSessionId()+"<br><hr>");
	    	}
	    }
	
	
	%>
	</h2>
</body>
</html>