<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生列表</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
</head>
<body class="c">
        <div>
            <table>
                <tr>
                    <th>头像</th>
                    <th>学生姓名</th>
                    <th>学生学号</th>
                    <th>性别</th>
                    <th colspan="2">操作</th>
                </tr>
                   <c:forEach items="${studentLists }" var="student">
                <tr> 
						<th><c:if test="${student.src == ''}">
						  <img src=./images/y.jpg width="80px" height="70px"/>
						</c:if>
						 <c:if test="${student.src != ''}">
						 <img  src=${student.src} width="80px" height="70px"/>
						 </c:if>
						</th>	
						<th><c:out value="${student.name}"></c:out></th>	
						<th><c:out value="${student.number}"></c:out></th>	
						<th><c:if test="${student.sex == true}">男</c:if>
						    <c:if test="${student.sex == false}">女</c:if> 
						</th>	
						<td><a href="<%=request.getContextPath()%>/delestu.do?num=<c:out value="${student.number}"></c:out>">删除</a></td>	
						<td><a href="#">修改</a></td>
                     </tr>
                    </c:forEach>
            </table>
          
        </div>
</body>
</html>