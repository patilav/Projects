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
<script src="js/docs.js"></script>
<script src="js/github.info.js"></script>
<script src="js/metro-tab-control.js"></script>
<script src="js/metro-calendar.js"></script>
<script src="js/metro-datepicker.js"></script>
<!-- AM added/end -->
</head>

<body class="metro" onload=="focusOnLogin()">
	<div class="mainDiv">
		<!-- header starts -->
		<div class="header">
			<img src="images/Asha_photo_1_Fotor.jpg" alt="MyOrganizer" />
		</div>
		<a href="logout.jsp"
			class="element icon-exit image-button image-left place-right">Sign
			Out</a> <span class="element-divider place-right"></span> <a
			href="success_customer.jsp"
			class="element icon-exit image-button image-left place-right">Home</a>

		<!-- header ends -->
		<div style="background-color: white">
			<table align="center">
				<tr>
					<td align="center" style="vertical-align: top"><s:form
							action="openEventEdit" name="eventEditForm" id="eventEditForm">
							<s:hidden name="eventId" id="eventId" value=""></s:hidden>
						</s:form> <s:form>
							<s:if test="%{eventlist.isEmpty()}">
								<h4 style="color: rgb(121, 0, 0);">No Events scheduled for
									the user!</h4>
							</s:if>
							<s:else>
								<table border="1">
									<tr>
										<td colspan="7" class="formHeader">List of events</td>
									</tr>
									<tr>
										<th>Event Name</th>
										<th>Venue</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Occurence</th>
										<th>Edit</th>
										<th>Delete</th>
									</tr>
									<s:iterator value="eventlist">
										<tr>
											<td><s:property value="name" /></td>
											<td><s:property value="venue" /></td>
											<td><s:property value="startDate" /></td>
											<td><s:property value="endDate" /></td>
											<td><s:property value="occurrence" /></td>
											<td><a href="javascript:fnEdit('${eventId}')"><img
													style="width: 15px; height: 15px" src="images/edit.png" /></a></td>
											<td><a href="javascript:fnDelete('${eventId}')"><img
													style="width: 15px; height: 15px" src="images/delete.png" /></a></td>
										</tr>
									</s:iterator>
								</table>
							</s:else>
						</s:form></td>
				</tr>
			</table>

			<!-- footer starts -->
			<nav class="navigation-bar light footer" align="center"> <nav
				class="navigation-bar-content">
			<ul>
				<li><a href="success_customer.jsp">BACK</a></li>
			</ul>
			</nav> </nav>
			<p class="footer" align="center">
				Copyright ©2014 - 2015 My Organizer All rights
				reserved.
			</p>
			<!-- footer ends -->
		</div>
		<script src="js/hitua.js"></script>
		<script>
			function fnEdit(id) {
				document.getElementById('eventId').value = id;
				form = document.getElementById('eventEditForm');
				form.submit();
			}
			
			function fnDelete(id) {
				retVal = confirm("Are you sure you want to delete this event?");
				if (retVal == true) {
					document.getElementById('eventId').value = id;
					form = document.getElementById('eventEditForm');
					form.action = "deleteEvent";
					form.submit();
				}
				return false;
			}
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