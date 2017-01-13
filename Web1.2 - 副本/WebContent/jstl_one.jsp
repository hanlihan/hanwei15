<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
     <h1>if标签</h1>
     <form action="./jstl_one.jsp">
     <input type="text" name="score">
     <input type="submit" value="提交">
     </form>
     <c:if test="${param.score>=90}" var="result">
        <c:out value="成绩优异"></c:out>
     </c:if>
     <c:out value="${result}"></c:out>
</body>
</html>