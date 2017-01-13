<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.text.bean.Student"%>
<%@ page import="com.text.db.StudentDB"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
   function b() {
	var user = $("#number").val();
	var name = $("#name").val();
	if(user=="" || name==""){
		$("#msg").text("学号和姓名不能为空");
		return false;
	}else{
		
		return true;
	}
}
</script> 
<title>Insert title here</title>
		<%
		 StudentDB studentDB = StudentDB.getInstance();
		 
		%>
</head>
<body class="b">
     <div align="center">
     <a href="./index.jsp" style="color:blue;font-weight: bold;">返回主界面</a>
     </div>
     <div id="main">
			<h2>添加学生</h2>
			
		<!-----	<form name="loginForm" action="addstudent.servlet" method="post" onsubmit="return b()">
				学号:<input type="text" id="user" name="number"/><br/>
				姓名:<input type="text" id="name" name="name"/><br/>
				 头像:<input id="src"  name="myile" value=${sessionScope.fliesss}>	
				<% String isCheck = request.getParameter("flag");
				 if("false".equals(isCheck)){%>
					<span id="login_error">学生已存在</span>
				<% } %>
				<input type="submit" value="添加">
				<span id="msg"></span>
			</form>
			<form action="./tupian.do" method="post" enctype="multipart/form-data">
				<input type="file" name="myfile" />
			    <input type="submit" value="提交" />${result}
		    </form>---->
		  <form action="commUploadServlet.do" method="post" enctype="multipart/form-data">
			学号:<input type="text" name="number" /><br><br>
		          姓名:<input type="text" name="userName" /><br><br>
		         头像: <input type="file" name="header_url"/><br> 
			
			<input type="submit" value="提交" />${message}
		    </form>
		</div>
</body>
</html>