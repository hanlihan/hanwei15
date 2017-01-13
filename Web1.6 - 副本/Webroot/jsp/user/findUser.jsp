<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查找</title>
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
<body> 
       <form action="./user_find.do" method="post"  onsubmit="return check() && isDigit()">
                请输入管理账号ID:<input  type="text" name="id" placeholder="请输入管理账号ID"/><br><br> 
         <span id="msg" style="color:red;font-size:10px">${eorrey}</span><br><br> 
         <input type="submit" value="查找">
      </form>
</body>
</html>