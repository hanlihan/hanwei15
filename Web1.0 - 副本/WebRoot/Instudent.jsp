<%@page import="com.text.db.StudenttDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.text.bean.Student1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
		<%
		    String number = request.getParameter("number");  
		    Student1 student = StudenttDB.getInstance().findStudentByNumber(Integer.parseInt(number));
		%>
</head>
<body>
		<div align="center">
		<a href="./Sstudent.html" style="color:blue;font-weight: bold;">返回主界面</a>
		</div>
 			<div class="emp_contaner">
            		<h3>学生信息</h3>
          	</div>  
       <div id="min">     
            <table>
                <tr>
                   <th>学生学号</th>  
                   <th>学生姓名</th>
                   <th>性别</th>
                </tr>
                	
                <tr>
                     <th><%=student!=null?student.getNumber():"" %></th>
                     <th><%=student!=null?student.getName():"" %></th>
                     <th><%=student!=null?(student.isSex()==true?"男":"女"):"" %></th>
                   <%---<th><a href=""></a></th>---%>
                </tr>
                	
            </table>
       </div>
</body>
</html>