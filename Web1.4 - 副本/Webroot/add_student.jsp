<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
<script src="js/jquery.js"></script>
<script>
	function check() {
		var user = $("#name").val(); //获取表单元素值
		var number = $("#number").val();
		if (user == "" || number == "") {
			$("#msg").text("姓名,学号不能为空！");
			return false;
		} else {
			return true;
		}
	}
</script>
<style type="text/css">
body {
	background-color: #f5f5f5;
}

#container {
	margin-top: 50px;
	margin-left: 100px;
}
</style>
</head>
<body id="container">
	<form action="./add_student.do" method="post" enctype="multipart/form-data" onsubmit="return check()" >
		学号:<input type="text" name="number" id="number"/><br> <br> 
		姓名:<input type="text" name="userName"  id="user"/><br> <br> 
		性别:<select name="sex">
				<option value="1">男</option>
				<option value="0">女</option>
			</select><br> <br> 
		头像: <input type="file" name="header_url" /><br> 
			<span id="msg" style="color:red;font-size:10px">${error}</span><br><br>
		<input type="submit"value="提交" />
	</form>
	
</body>
</html>