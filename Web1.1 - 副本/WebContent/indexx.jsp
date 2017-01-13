<%@page import="java.sql.ResultSet"%>
<%@page import="java.awt.image.RescaleOp"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.Connection" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>监听器</title>
</head>
<body>
     <h1><a href="<%=request.getContextPath()%>/two.jsp">two.jsp</a>this is lisener</h1>
      <%
         Connection con =(Connection)application.getAttribute("con");
         PreparedStatement ps = con.prepareStatement("select * from student");
         ResultSet rs  = ps.executeQuery();
         
         out.println("姓名"+"&nbsp;&nbsp;"+"学号"+"<br>");
         while(rs.next()){
        	 out.println(rs.getString("name") +"&nbsp;&nbsp;&nbsp;"+rs.getInt("number")+"<br>");
         }
         rs.close();
      %>
</body>
</html>