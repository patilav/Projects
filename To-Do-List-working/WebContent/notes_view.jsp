<%@page import="java.awt.image.ImageProducer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import="bean.NotesBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Blob"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
	

<body class="metro"onload="focusOnLogin()">
		<div class="mainDiv">
		<!-- header starts -->
		<div class="header">
			<img src="images/Asha_photo_1_Fotor.jpg" alt="MyOrganizer"/>
		</div>
			<a href="logout.jsp"
			class="element icon-exit image-button image-left place-right">Sign
			Out</a> <span class="element-divider place-right"></span> <a
			href="success_customer.jsp"
			class="element icon-exit image-button image-left place-right">Home</a>
		
		<!-- header ends -->
		<div style="background-color:white">

	<%
		List<NotesBean> nblist = (List<NotesBean>)session.getAttribute("images");
	%>
	<center>
		<%
			if(nblist.size() > 0){
		%>
		<s:form action="openNotesEdit" name="notesEditForm" id="notesEditForm">
			<s:hidden name="notes_id" id="notes_id" value=""></s:hidden>
		</s:form>
		<table border="1">
			<tr>
				<td colspan="7" class="formHeader"><center>My Notes</center></td>
			</tr>
			<tr>
				<th>Title</th>
				<th>Text</th>
				<th>Image</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
				Iterator listIterator = (Iterator)nblist.iterator();
					NotesBean nbean = null;
					while(listIterator.hasNext())
					{
				nbean = (NotesBean)listIterator.next();
				Blob imgBlob = nbean.getImagePath();
				FileOutputStream outputStream = new FileOutputStream(new File("C:\\NEU-SEM1\\DBMS\\DB_Project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\To-Do-List-workingmyImages\\"+nbean.getName()+".png"));
				byte[] buffer = new byte[1];
				InputStream is = imgBlob.getBinaryStream();
				while(is.read(buffer) > 0){
					outputStream.write(buffer);
				}
				outputStream.close();
			%>
			<tr>
				<td><%=nbean.getName()%></td>
				<td><%=nbean.getText()%></td>
				<td><img src="myImages/<%=nbean.getName()%>.png"
					style="width: 150px; height: auto" /></td>
				<td><a href="javascript:fnEdit('<%=nbean.getNotes_id()%>')"><img
						style="width: 15px; height: 15px" src="images/edit.png" /></a></td>
				<td><a href="javascript:fnDelete('<%=nbean.getNotes_id()%>')"><img
						style="width: 15px; height: 15px" src="images/delete.png" /></a></td>
			</tr>

			<%
				}
			%>
		</table>
		<%
			}
			else{
				
			}
		%>
	</center>				</div>
					</div>
				</div>
			</div>
			<!-- add an appointment ends -->
			<!-- footer starts -->			
			<nav class="navigation-bar light footer" align="center">
				<nav class="navigation-bar-content">
					<ul>
						<li><a href="success_customer.jsp">BACK</a></li>
					</ul>
				</nav>
			</nav>
			<p class="footer" align="center">Copyright ©2014 -  My Organizer - All rights reserved.</p>
			<!-- footer ends -->
		</div>
</body>


	<script>
		function fnEdit(id) {
			document.getElementById('notes_id').value = id;
			form = document.getElementById('notesEditForm');
			form.submit();
		}

		function fnDelete(id) {
			retVal = confirm("Are you sure you want to delete this Note?");
			if (retVal == true) {
				document.getElementById('notes_id').value = id;
				form = document.getElementById('notesEditForm');
				form.action = "deleteNotes";
				form.submit();
			}
			return false;
		}
	</script>
</html>