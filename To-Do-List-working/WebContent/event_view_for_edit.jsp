<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#500000;
color:white;
font-family : verdana;}
</style>
</head>
<body>
<s:form>
<table border="2">

<tr>
<th>EVENT NAME</th>
<th>VENUE</th>
<th>START DATE</th>
<th>END DATE</th>
<th>OCCURRENCE</th>
</tr>

<s:iterator value="eventlist">  
<tr>
<td><s:property value="name"/></td> 
<td><s:property value="venue"/></td>
<td><s:property value="startDate"/></td> 
<td><s:property value="endDate"/></td> 
<td><s:property value="occurrence"/></td> 
</tr>
</s:iterator>  
</table>
</s:form>
</body>
</html>