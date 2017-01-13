<%@page import="com.text.bean.Student1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.text.bean.Student"%>
<%@ page import="com.text.db.StudenttDB"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
   function b() {
	
	var userName = $("#userName").val();
	if(userName==""){
		$("#msg").text("姓名不能为空");
		return false;
	}else{
		
		return true;
	}
}
</script> 
<title>Insert title here</title>
</head>
<body style="background-image:url(./images/4.jpg);">
		<%
		String number = request.getParameter("num");  
		Student1 student = StudenttDB.getInstance().findStudentByNumber(Integer.parseInt(number));
		%>
     <div align="center">
			<h1>修改学生</h1>
     <a href="./login.jsp" style="color:blue;font-weight: bold;">返回主界面</a>
     <a href="./GetStu2.jsp" style="color:blue;font-weight: bold;">返回上一级</a>
     </div>
     <div id="min">
			<form name="loginForm" action="./upstuservlet" method="post" onsubmit="return b()" enctype="multipart/form-data">
				姓名:<input type="text" id="user" name="userName" placehoider="请输入学生姓名" value="<%=student.getName() %>"/><br/>
				性别:<input type="text" id="sex" name="sex" placehoider="请输入学生性别" value="<%=student.isSex()==true?"男":"女" %>"/><br/>
				<img src="<%=student.getSrc()%>" width="60px" height="60px">
				<input type="file" id="myfile" name="head_img" />
				<input type="hidden" name="number" value="<%=student.getNumber()%>"><br>
				<input type="submit" value="修改">
				<br> 
				<span id="msg"></span>
			</form>
		</div>
</body>
</html>