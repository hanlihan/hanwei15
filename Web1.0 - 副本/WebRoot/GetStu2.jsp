<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.text.bean.Student1"%>
<%@ page import="com.text.db.StudenttDB"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生列表</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
  
  <%
   StudenttDB studentDB = StudenttDB.getInstance();
   ArrayList<Student1> studentList = studentDB.getAllStudent();
   session.setAttribute("list", studentList);
  %>
</head>

<body class="c">
       <div class="emp_contaner">
            <h3><c:out value="学生列表界面"></c:out></h3>
       </div>     
		<div align="center">
		<a href="./index.jsp" style="color:blue;font-weight: bold;">返回主界面</a>
		</div>
       <div>     
            <table>
                <tr>
                   <th>学生头像</th>
                   <th>学生学号</th>
                   <th>学生姓名</th>
                    <th>性别</th>
                   <th colspan="2">操作</th>
                </tr>
                <c:forEach  items="${sessionScope.list}" var="student">
               	
                <tr>  
                     <th><img src=${student.src} width="80px" height="70px"/></th>
                     <th><c:out value="${student.number}"></c:out></th>
                     <th><c:out value="${student.name}"></c:out></th>
                     <th><c:if test="${student.sex == true}">男</c:if>
                         <c:if test="${student.sex == false}">女</c:if>
                     </th>
					 <td><a href="<%=request.getContextPath()%>/delestu.servlet?num=<c:out value="${ student.getNumber()}"></c:out>">删除</a></td>
					 <td><a href="<%=request.getContextPath()%>/upStu.jsp?num=<c:out value="${student.getNumber() }"></c:out>">修改</a></td> 
                     
                   <%---<th><a href=""></a></th>---%>
                </tr>
                	</c:forEach>
            </table>
       </div>
</body>
</html>