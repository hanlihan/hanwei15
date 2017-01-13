<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body>
        <form action="stu.do" method="post" enctype="multipart/form-data">
<!--                               姓名:<input type="text" name="name"><br> -->
<!--                               学号:<input type="text" name="number"><br> -->
            <input type="hidden" name="id" value="${stus.id}"> 
                              姓名:<input type="text" name="name" value="${stus.name }"><br>
                              学号:<input type="text" name="number" value="${stus.number}"><br>                 
                              姓别:<select name="sex"><br>
                  <option value="1">男</option>
                  <c:if test="${stus.sex == true || empty stus.sex}">
                  <option value="1" selected="selected">男</option>
                  <option value="0">女</option>
                  </c:if>
                  <c:if test="${stus.sex == false }">
                  <option value="1">男</option>
			      <option value="0" selected="selected">女</option>
                  </c:if>
               </select><br><br>
                              头像:<input type="file" name="myfile"><br>
                              ${message}<br><br>
                <input type="submit" value="添加"><br>
        </form>
</body>
</html>