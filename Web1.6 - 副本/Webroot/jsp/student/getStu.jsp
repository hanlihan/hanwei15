<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示学生</title>
</head>
<body>
	<table>
		<tr width="100%" border="0" bgcolor="#cccccc">
			<td>头像</td>
			<td>姓名</td>
			<td>学号</td>
			<td>性别</td>
			<td colspan="2">操作</td>
		</tr>
		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${studentlist}" var="stu">
			<%
				if (c == 1) {
						color = "red";
						c = 0;
					} else {
						color = "break";
						c = 1;
					}
			%>
			<tr bgcolor="<%=color%>">
				<td><c:if test="${empty stu.src }">
						<img src="${pageContext.request.contextPath}/images/y.jpg"
							width="60px" height="60px" />
					</c:if> <c:if test="${!empty stu.src }">
						<img src="${pageContext.request.contextPath}${stu.src}"
							width="60px" height="60px" />
					</c:if></td>
				<td><c:out value="${stu.name }"></c:out></td>
				<td><c:out value="${stu.number }"></c:out></td>
				<td><c:if test="${ stu.sex == true }">男</c:if> <c:if
						test="${ stu.sex == false }">女</c:if></td>
				<td><a href="stu_delete.do?number=${stu.number }">删除</a></td>
				<td><a href="stu_update.do?number=${stu.number }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>