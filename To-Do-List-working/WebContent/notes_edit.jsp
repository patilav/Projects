<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("index.jsp");
	} else {
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate");
	}
%>
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
				<s:url action="homePage.action" var="homePageURL"></s:url>
				<td>Welcome <%=session.getAttribute("name")%></td>
				<td><s:a href="%{homePageURL}"><button>Home</button></s:a></td>
				<td><a href="logout.jsp"><button>Sign out</button></a></td>
			</tr>
		</table>
		<br> <br>
		<hr>
		
		<div class="tab-control place-center" style="background-color:white;" data-role="tab-control">
				<ul class="tabs">
					<li class="active"><a href="#_page_1"> EDIT NOTES </a></li>
				</ul>
				<div class="frames">
					<div class="frame" id="_page_1">
						<div>
						
			
		<s:form action="notesEdit"  enctype="multipart/form-data">
						<s:hidden name="notes_id" value="%{#session.notesBean.notes_id}" />
						<s:textfield id="1" name="name" label="Title"
							value="%{#session.notesBean.name}"></s:textfield>
						<s:textfield id="text" name="text" label="Text"
							value="%{#session.notesBean.text}"></s:textfield>
						<s:file name="userImage" label="Upload Image"></s:file>
						<s:file name="userImage2" ></s:file>
						<s:file name="userImage3" ></s:file>
						<s:file name="userImage4" ></s:file>
						<s:file name="userImage5" ></s:file>							
						<s:submit align="center" value="Edit" />
					</s:form>
					
					</div>
					</div>
				</div>
			</div>
			<!-- add an appointment ends -->
			<!-- footer starts -->			
			<nav class="navigation-bar light footer" align="center">
				<nav class="navigation-bar-content">
					<ul>
						<li><a onclick="goBack()">BACK</a></li>
					</ul>
				</nav>
			</nav>
			<p class="footer" align="center">Copyright ©2014 -  My Organizer - All rights reserved.</p>
			<!-- footer ends -->
		</div>
</body>
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
</html>