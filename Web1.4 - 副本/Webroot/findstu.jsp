<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示学生</title>

</head>
<body>
     <table>
        <tr>
            <th>头像</th>
            <th>学生姓名</th>
            <th>学生学号</th>
            <th>性别</th>
            
            </tr>
                <tr>
                   <th><img  src=${student.src} width="80px" height="70px"/></th>	
						<th>${student.name}</th>	
						<th>${student.number}</th>	
						<th>${student.src==true?"男":"女"}
						</th>
                </tr>
     </table>
</body>
</html>