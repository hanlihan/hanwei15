<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>标准标签库jst1</title>
</head>
<body>
<%----
     el表达式 
                  语法    ${表达式}
              EL表达式隐式对象：
        
	   sessionScope <=>session对象
	   param <=>表单提交的参数 request.getParameter("name");
	   requestScope    
 --%>
    <c:out value="小米是个霉神"></c:out>
    <h1><c:out value="一、标签:out , EL隐式对象:  sessionScope,requestScope "></c:out></h1>
    <%
       session.setAttribute("name", "米霉神的世界？");
       request.setAttribute("number", 4444); 
    %>
    <c:out value="${sessionScope.name }"></c:out>
    <br>
    <c:out value="${requestScope['number'] }"></c:out>
    <br>
    <hr>
    <h1><c:out value="二  标签:set, el隐式对象: param"></c:out></h1>
    <c:set var="age" value="23" scope="session"/>
    <c:out value="${age }" default="20"></c:out>
    
    <form action="./index.jsp">
                        用户名:<input type="text" name="userName"/><input type="submit"
                        value="提交">
    </form>
    <c:out value="获取param值加20 = ${param.userName+20}"></c:out>
    <br>
    <hr>
    <h1><c:out value="三、set标签给javaBean属性赋值"></c:out></h1>
    <jsp:useBean id="person" class="com.ittx.entity.Person" scope="page" />
    <c:set target="${person}" property="name" value="霉神"></c:set>
    <c:out value="${person.name }"/>
    <jsp:setProperty property="name" name="person" value="死米霉神"/>
    <jsp:setProperty property="name" name="person"/>
    <br>
    <hr>
    
    <h1><c:out value="四、标签:remove catch"></c:out></h1>
    <c:set var="firstName" value="sb小米"></c:set> 
   <%----  <c:remove var="firstName"/>--%>
    <c:out value="${firstName }"></c:out>
    
    <br>
    <hr>
    <c:catch var="error">
         <c:set target="user" property="firstName" value="lili"></c:set>
    </c:catch>
    <c:out value="${error}"></c:out>
</body>
</html>