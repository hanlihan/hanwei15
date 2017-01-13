 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ognl测验</title>
</head>
<body>
<!--              显示valueStack的值 -->
     <s:property value="name"/><br><br>
     <s:property value="user.name"/><br><br>
     <s:property value="user.password"/><br><br>
     <hr>
     <s:iterator value="list" var="u">
       <s:property value="#u.name"/>
       <s:property value="#u.password "/>
     </s:iterator>
     <s:debug></s:debug>
</body>
</html>