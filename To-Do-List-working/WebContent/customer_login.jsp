<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#500000;
	color:white;
	font-family : verdana;
}
</style>
</head>
<body>
<center>
<h1 id="admin">CUSTOMER SECTION</h1>

<HR>
&nbsp;&nbsp;
<div>

<h2>Login</h2>

<br>
<br>

<s:form action="login" method="post">
<s:textfield name="username" label="USERNAME"></s:textfield>
<s:password name="password" label="PASSWORD"></s:password>
<s:submit></s:submit>
</s:form>
</div>
</center>
</body>
</html>