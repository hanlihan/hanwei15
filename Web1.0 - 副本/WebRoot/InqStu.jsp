<%@page import="com.text.bean.Student1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.text.bean.Student"%>
<%@ page import="com.text.db.StudentDB"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css"></link>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function check() {
	var number = $("#number").val();

	if (number == "" ) {
		$("#msg").text("学号不能为空！");
		return false;
	} else{
		return true;
	}

}
/*数字检查*/
function isDigit(){
	var num = $("#number").val();  //12fd
    var code;  
    for (var i = 0; i < num.length; i++) {  
        //charAt()获取指定位置字符串,charCodeAt()返回该字符串的编码  
           //0的ASCII是48,9的ASCII是57  
        var code = num.charAt(i).charCodeAt(0);  
        if (code < 48 || code > 57) {  
        	$("#msg").text("学号只能包含0-9的数字！");
            return false;
        } 
        
    }  
    return true;
	
}
</script>        
       
</head>
<body class="d">
      <h1>查找学生界面</h1>
      <div align="center"><a href="./index.jsp" style="color:blue;font-weight: bold;">返回主界面</a></div>     
     <div class="e">
	     <form action="Instudent.jsp" onsubmit="return check() && isDigit()">
	      
	               请输入学生学号:<input id="number" type="text" name="number" placeholder="请输入学生学号"/>
	                 <input type="submit" value="查找"/>
	      <span id="msg"></span> 
	     </form>
    </div>
</body>
</html>