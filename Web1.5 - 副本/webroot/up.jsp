<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-  8">
<title>s</title>
</head>
<body>
  		<a>我是蔡大爷的大爷的是多大的订单达大道上的</a>
  		<s:form>
  		   <s:textfield name="name" value="张三" label="姓名"></s:textfield>
  		   <s:textfield name="passWord" value="123"  label="密码"></s:textfield>
  		   <s:reset></s:reset>
  		   <s:submit value="提交"></s:submit>
  		</s:form>
</body>
</html>