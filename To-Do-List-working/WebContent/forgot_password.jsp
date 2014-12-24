<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Organizer</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<link href="jquery-ui.css" rel="stylesheet">
		<!-- AM added/start -->
		<link href="css/metro-bootstrap.css" rel="stylesheet">
		<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">
		<link href="css/iconFont.css" rel="stylesheet">
		<link href="css/docs.css" rel="stylesheet">
		<link href="js/prettify.css" rel="stylesheet">
		<!-- Load JavaScript Libraries -->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.widget.min.js"></script>
		<script src="js/jquery.mousewheel.js"></script>
		<script src="js/prettify.js"></script>
		<script src="js/carousel.js"></script>		
		<!-- Metro UI CSS JavaScript plugins -->
		<script src="js/load-metro.js"></script>
		<!-- Local JavaScript -->
		<script src="js/docs.js"></scri0pt>
		<script src="js/github.info.js"></script>
		<script src="js/metro-tab-control.js"></script>
		<script src="js/metro-calendar.js"></script>
		<script src="js/metro-datepicker.js"></script>
		<!-- AM added/end -->
	</head>
	
<body class="metro"onload="focusOnLogin()">
		<div class="mainDiv">
		<!-- header starts -->
		<div class="header">
			<img src="images/Asha_photo_1_Fotor.jpg" alt="MyOrganizer"/>
		</div>
		<!-- header ends -->
		<div style="background-color:white">
			<table align="center">
	
			<tr>
				<td colspan="2" style="text-align: center"><h2>Task
						Scheduler</h2></td>
			</tr>
			<tr>
				<td colspan="2"><hr /></td>
			</tr>
			<tr>
				<td style="border-right: 2px dotted #888888; vertical-align: top;"
					width="50%">
					<%if(session.getAttribute("secretQuestion") == null && session.getAttribute("message") == null)
						{%>
					<table>
						<tr>
							<td class="formHeader">Username</td>
						</tr>
						<tr>
							<td><s:form action="secret_question" method="post">
									<s:textfield id="1" name="username" label="Username" value=""></s:textfield>
									<s:submit></s:submit>
								</s:form></td>
						</tr>		
						
					</table><%} %>
					
<%
if(session.getAttribute("secretQuestion") != null)
{%>
<table>
					<tr>
							<td class="formHeader">Secret Question</td>
						</tr>
						<tr>
							<td>
					
	
		<s:form action="setNewPassword" method="post">
		<%=session.getAttribute("secretQuestion") %>	
		<s:textfield  id="1" name="secretAnswer" label="Answer"></s:textfield>
		<s:submit></s:submit>
		</s:form>
		<%} 
			session.setAttribute("secretQuestion", null);%>

					</td>
					</tr>
					</table>
					
					
					<%if(session.getAttribute("message") == "done") 
					{
					%>
<table>
		<tr>
							<td class="formHeader">Set New Password</td>
						</tr>
						<tr>
							<td>
							<s:form action="changePassword" method="post">
							<s:password id="1" name="password" label="New Password"></s:password>
							<s:submit></s:submit>
							</s:form>

</table>
					<%} session.setAttribute("message", null);%>
</td>
</tr>
</table>
</div>
<!-- footer starts -->			
			<nav class="navigation-bar light footer" align="center">
				<nav class="navigation-bar-content">
					<ul>
						<li><a onclick="goBack()">BACK</a></li>
					</ul>
				</nav>
			</nav>
			<p class="footer" align="center">Copyright ©2014 - 2015 <a href="#"> My Organizer </a> All rights reserved.</p>
			<!-- footer ends -->
		</div>
		<script>
				function goBack() {
					window.history.back()
				}
			
				function focusOnLogin()
				{
				var id = document.getElementById('1');
				id.focus();
				}
		</script>
		
</body>

</html>