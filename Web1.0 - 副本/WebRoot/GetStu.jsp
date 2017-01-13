<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.text.bean.Student1"%>
<%@ page import="com.text.db.StudenttDB"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生列表</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
  
  <%
   StudenttDB studentDB = StudenttDB.getInstance();
   ArrayList<Student1> studentList = studentDB.getAllStudent();
  %>
</head>

<body class="c">
       <div class="emp_contaner">
            <h3>学生列表界面</h3>
       </div>     
		<div align="center">
		<a href="./index.jsp" style="color:blue;font-weight: bold;">返回主界面</a>
		</div>
       <div>     
            <table>
                <tr>
                   <th>学生学号</th>
                   <th>学生姓名</th>
                   <th>学生性别</th>
                   <th colspan="2">操作</th>
                </tr>
                	<% for(Student1 student:studentList){%>
                <tr>
                     <th><%=student.getNumber() %></th>
                     <th><%=student.getName() %></th>
                     <th><%=student.isSex()==true?"男":"女"%></th>
                     <td><a href="<%=request.getContextPath()%>/delestu.servlet?num=<%=student.getNumber() %>">删除</a></td>
					 <td><a href="<%=request.getContextPath()%>/upStu.jsp?num=<%=student.getNumber()%>">修改</a></td> 
                     <% %>
                   <%---<th><a href=""></a></th>---%>
                </tr>
                
                	<% }%>
            </table>
       </div>
</body>
</html>