<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<!-- AM added/end -->
</head>
<body class="metro">
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
		<!-- middle section starts -->
		<div class="tab-control place-center" style="background-color: white;"
			data-role="tab-control">
			<div class="frames">
				<div class="frame" id="_page_1">
					<div style="align: center;">
						<p>
							Click <a href="index.jsp">here</a> to login again.
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- middle section ends -->
		<!-- footer starts -->
		<nav class="navigation-bar light footer" align="center"> <nav
			class="navigation-bar-content">
		<ul>
			<li><a href="success_customer.jsp">Home</a></li>
		</ul>
		</nav> </nav>
		<p class="footer" align="center">
			Copyright ©2014 My Organizer </a> All rights reserved.
		</p>
		<!-- footer ends -->
	</div>
	<script src="js/hitua.js"></script>
</body>
</html>