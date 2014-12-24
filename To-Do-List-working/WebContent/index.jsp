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
		<!-- AM added/end -->
	</head>
	<body class="metro">
		<div class="mainDiv">
			<!-- header starts -->
			<div class="header">
				<img src="images/Asha_photo_1_Fotor.jpg" alt="MyOrganizer"/>
			</div>
			<!-- header ends -->
			<!-- carousel starts-->
			<div class="slides">
				<div class="carousel slides" data-role="carousel" data-param-effect="slowdown" data-param-direction="left" data-param-period="3500" data-param-markers="off">
					<div class="slides">
						<div class="slide image" style="align:center;" id="slide1">
							<img src="images/slide1.jpg"/>
						</div>
						<div class="slide image" id="slide2">
							<img src="images/slide2.jpg"/>
						</div>
						<div class="slide image" id="slide3">
							<img src="images/slide3.jpg"/>
						</div>
						<div class="slide image" id="slide4">
							<img src="images/slide4.jpg"/>
						</div>
						<div class="slide image" id="slide5">
							<img src="images/slide5.jpg"/>
						</div>
						<div class="slide image" id="slide6">
							<img src="images/slide6.jpg"/>
						</div>
						<div class="slide image" id="slide7">
							<img src="images/slide7.jpg"/>
						</div>
						<div class="slide image" id="slide8">
							<img src="images/slide8.jpg"/>
						</div>
					</div>
					<span class="control left bg-color-darken">&#8249;</span>
					<span class="control right bg-color-darken">&#8250;</span>
				</div>
			</div>
			<!-- carousel ends -->
			<!-- middle section starts-->
			<div class="tab-control place-center" style="background-color:white;" data-role="tab-control">
				<ul class="tabs">
					<li class="active"><a href="#_page_1">SIGN IN</a></li>
					<li><a href="#_page_2">REGISTER</a></li>
				</ul>
				<div class="frames">
					<div class="frame" id="_page_1">
						<div>
						
							<s:form action="login" method="post">
								<p>Already a member ?</p>
					
								<s:div class="input-control text" data-role="input-control">
									<s:textfield name="username" label="Username"></s:textfield>
									<!-- <input type="text" placeholder="type user name"> -->
									<!-- <button class="btn-clear" tabindex="-1"></button> -->
								</s:div>
								
								<s:div class="input-control password" data-role="input-control">
									<s:password name="password" label="Password" cssClass="btn-reveal"></s:password>
									<!-- <input type="password" placeholder="type password" autofocus> -->
									<!-- <button class="btn-reveal" tabindex="-1"></button> -->
								</s:div>
								<s:div>
									<!-- <input type="submit" class="button warning large" value="Login"> -->
									<s:submit class="button warning large"></s:submit>
								</s:div>
								<s:div style="margin-top: 20px">
								</s:div>
							</s:form>
							<s:a href="forgot_password.jsp" cssStyle="align: center">Forgot Password?</s:a>
							
							
							<!--<s:form action="login" method="post">
										<s:textfield name="username" label="Username"></s:textfield>
										<s:password name="password" label="Password"></s:password>
										<s:submit></s:submit>
									</s:form>-->
						</div>
					</div>
					<div class="frame" id="_page_2">
						<div>
						
						
					<!-- 	<s:form id="registerForm" name="registerForm">
										<s:textfield name="username" label="Username"></s:textfield>
										<s:textfield name="fname" label="First Name"></s:textfield>
										<s:textfield name="lname" label="Last Name"></s:textfield>
										<s:textfield id="dob" name="dob" label="Date of Birth"
											readonly="false"></s:textfield>
										<s:password name="password" label="Password"></s:password>
										<s:password name="confirmPassword" label="Confirm Password"></s:password>
										<s:textfield name="secretQuestion" label="Secret Question"></s:textfield>
										<s:textfield name="secretAnswer" label="Answer"></s:textfield>
										<s:submit value="Register" onclick="javascript:fnRegister()"></s:submit>
									</s:form> -->
						
						
						
						
						
						
							<s:form id="registerForm" name="registerForm">
								<p>New user registration</p>
							
								
									<s:textfield name="username" label="Username"></s:textfield>
								<!-- 	<button class="btn-clear" tabindex="-1"></button> -->
								
							
								
									<s:textfield name="fname" label="First Name"></s:textfield>
									<!-- <button class="btn-clear" tabindex="-1"></button> -->
								
							
								
								<s:textfield name="lname" label="Last Name"></s:textfield>
									<!-- <button class="btn-clear" tabindex="-1"></button> -->
								
							
								
								<s:textfield id="dob" name="dob" label="Date of Birth"
											readonly="true"></s:textfield>
								<!-- 	<button class="btn-clear" tabindex="-1"></button> -->
								
							
							<s:textfield name="homePhone" label="Home Phone"></s:textfield>
							<s:textfield name="workPhone" label="Work Phone"></s:textfield>
							<s:textfield name="mobilePhone" label="Mobile Phone"></s:textfield>
							
								
										<s:password name="password" label="Password"></s:password>
									<!-- <button class="btn-reveal" tabindex="-1"></button> -->
								
							
								
								<s:password name="confirmPassword" label="Confirm Password"></s:password>
									<!-- <button class="btn-reveal" tabindex="-1"></button> -->
								
							
								
									<s:textfield name="secretQuestion" label="Secret Question"></s:textfield>
									<!-- <button class="btn-clear" tabindex="-1"></button> -->
								
							
								
								<s:textfield name="secretAnswer" label="Answer"></s:textfield>
									<!-- <button class="btn-clear" tabindex="-1"></button> -->
											
									
								
								
									<s:submit value="Register" onclick="javascript:fnRegister()"></s:submit>
								
								<div style="margin-top: 20px">
								</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
			<!-- middle section ends-->
			<!-- footer starts -->			
			<p class="footer" align="center">Copyright ©2014 - 2015 My Organizer All rights reserved.</p>
			<!-- footer ends -->
		</div>
		<script src="external/jquery/jquery.js"></script>
		<script src="jquery-ui.js"></script>
		<script>
			var today = new Date();
			
			$("#dob").datepicker({
				inline : true,
				dateFormat : "yy-mm-dd",
				rangeLow : today.getFullYear() + today.getMonth() + today.getDay()
			});
			
			function fnRegister() {
				var form = document.getElementById("registerForm");
				form.action = "register";
				form.submit();
			}
		</script>
		<script src="js/hitua.js"></script>
	</body>
</html>