<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示学生</title>

</head>
<body>
	<table>
		<tr>
			<td>头像</td>
			<td>姓名</td>
			<td>学号</td> 
			<td>性别</td>
		</tr>
                
		<tr>
		    <td><c:if test="${empty student.src }">
						<img src="${pageContext.request.contextPath}/images/y.jpg"
							width="60px" height="60px" />
					</c:if> <c:if test="${!empty student.src }">
						<img src="${pageContext.request.contextPath}${student.src}"
							width="60px" height="60px" />
					</c:if></td>
			
			<td>${student.name}</td>
			<td>${student.number}</td>
			<td>
			<c:if test="${student.sex == true}">男</c:if>
			<c:if test="${student.sex == false}">女</c:if>
			</td>
		</tr>
	</table>
</body>
</html>