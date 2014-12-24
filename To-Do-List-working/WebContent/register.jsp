<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Organizer</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div>
		<table align="right">
			<tr>
				<td><a href="index.jsp"><button>Back to the Login Page</button></a></td>
			</tr>
		</table>
	</div>
	<br>
	<br>
	<hr>
	<br>
	<center>
		<table>
			<tr>
				<td class="formHeader">New Users - Registration Form</td>
			</tr>
			<tr>
				<td><s:form id="registerForm" name="registerForm"
						action="register">
						<s:textfield name="username" label="Username"></s:textfield>
						<s:textfield name="fname" label="First Name"></s:textfield>
						<s:textfield name="lname" label="Last Name"></s:textfield>
						<s:textfield id="dob" name="dob" label="Date of Birth"></s:textfield>
						<s:password name="password" label="Password"></s:password>
						<s:password name="confirmPassword" label="Confirm Password"></s:password>
						<s:textfield name="secretQuestion" label="Secret Question"></s:textfield>
						<s:textfield name="secretAnswer" label="Answer"></s:textfield>
						<s:submit value="Register" onclick="javascript:fnRegister()"></s:submit>
					</s:form></td>
			</tr>
		</table>
	</center>
</body>
</html>