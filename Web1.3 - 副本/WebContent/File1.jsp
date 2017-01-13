<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传图片</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
<script src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){
		$(".emp_contaner img").click(function(){
			var srcPath = $(this).attr("src");
			$("#largeImg").attr("src",srcPath);
		})
	});
	
	
</script>

</head>
<body src="imagess/m1.jpg">
	<div>
		<form action="./tupian.do" method="post" enctype="multipart/form-data">
			<input type="file" name="myfile" />
		    <input type="submit" value="提交" />${result}
		</form>
	</div>
	<div id="large"></div>
	<h1>图片游览</h1>
	<p>
		<img id="largeImg" alt="Large Image" src="imagess/m1.jpg" />
	</p>
	<p class="emp_contaner">
		<!-- <a href="imagess/m1.jpg" title="m1"><img src="imagess/m1.jpg" /></a> <a
			href="imagess/m2.jpg" title="m2"><img src="imagess/m2.jpg" /></a> <a
			href="imagess/m3.jpg" title="m3"><img src="imagess/m3.jpg" /></a> <a
			href="imagess/m4.jpg" title="m4"><img src="imagess/m4.jpg" /></a> -->
			
		<img src="imagess/m1.jpg" /> 
		<img src="imagess/m2.jpg" />
		<img src="imagess/m3.jpg" />
		<img src="imagess/m4.jpg" />
	</p>

</body>
</html>