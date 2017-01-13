<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.ArrayList"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示</title>
</head>
<body>
<table>
          <tr>
           		<th>账户名称</th>
           		<th>账户密码</th>
           		<th colspan="2">操作</th>
           </tr>
             <c:forEach items="${userLists}" var="use">
	          <tr>
	                <th><c:out value="${use.username }"></c:out></th>
	                <th><c:out value="${use.password }"></c:out></th>
	                <th><a href="./user_delete.do?id=${use.id}">删除</a></th>
	                <th><a href="./user_update.do?id=${use.id}">修改</a></th>
	          </tr>
        </c:forEach>
      </table>
</body>
</html>