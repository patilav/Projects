<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="util.JSPUtil"%>
<%@ page import="bean.EventBean"%>
<%@ page import="bean.AppointmentBean"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("index.jsp");
	} else {
		response.setHeader("Cache-Control",
		"no-cache, no-store, must-revalidate");
	}
	
	Calendar todayCal = Calendar.getInstance();
	
	String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(todayCal.getTime());
	
	Calendar cal = Calendar.getInstance();
	String sel_month = (String)session.getAttribute("display_month");
	if(sel_month != null && sel_month != ""){
		cal.set(Calendar.MONTH, Integer.parseInt(sel_month)-1);
	}
		String sel_year = (String)session.getAttribute("display_year");
	if(sel_year != null && sel_year != ""){
		cal.set(Calendar.YEAR, Integer.parseInt(sel_year));
	}
	cal.set(Calendar.DAY_OF_MONTH, 1);
	int firstDay = cal.get(Calendar.DAY_OF_WEEK);
	firstDay = firstDay - 1;
	int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	String displayMonthName = new SimpleDateFormat("MMMM").format(cal
	.getTime());
	String displayMonth = new SimpleDateFormat("MM").format(cal
	.getTime());
	String displayYear = new SimpleDateFormat("YYYY").format(cal
	.getTime());
	String displayDate = null;
	String[] monthNames = { "January", "February", "March", "April",
	"May", "June", "July", "August", "September", "October",
	"November", "December" };
	
	List eventList = (List) session.getAttribute("eventlist");
	Iterator iterator = eventList.iterator();
	Iterator dateIterator = null;
	EventBean evntBean = null;
	List dateList = null;
	HashMap dateMap = new HashMap();
	String date = null;
	List<String> evntList = null;
	while (iterator.hasNext()) {
		evntBean = (EventBean) iterator.next();
		dateList = JSPUtil.getAllDatesInRange(evntBean.getStartDate(),
		evntBean.getEndDate());
		dateIterator = dateList.iterator();
		while (dateIterator.hasNext()) {
	date = (String) dateIterator.next();
	if (dateMap.containsKey(date)) {
		evntList = (LinkedList) dateMap.get(date);
	} else {
		evntList = new LinkedList<String>();
	}
	evntList.add(evntBean.getName());
	dateMap.put(date, evntList);
		}
	}
	
	System.out.println(dateMap);
	
	List appointmentList = (List) session.getAttribute("appointmentlist");
	Iterator iterator2 = appointmentList.iterator();
	Iterator dateIterator2 = null;
	AppointmentBean appBean = null;
	List dateList_app = null;
	HashMap dateMap_app = new HashMap();
	String date_app = null;
	List<String> appList = null;
	while (iterator2.hasNext()) {
		appBean = (AppointmentBean) iterator2.next();
		dateList_app = JSPUtil.getAllDatesInRange(appBean.getDateOfAppointment(),appBean.getDateOfAppointment());
		dateIterator2 = dateList_app.iterator();
		while (dateIterator2.hasNext()) {
	date_app = (String) dateIterator2.next();
	if (dateMap_app.containsKey(date_app)) {
		appList = (LinkedList) dateMap_app.get(date_app);
	} else {
		appList = new LinkedList<String>();
	}
	appList.add(appBean.getName());
	dateMap_app.put(date_app, appList);
		}
	}
	
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Organizer</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Gorditas">
		<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans">
		<script type="text/javascript">
			$(document).ready(function() {
			    $( '.dropdown' ).hover(
			        function(){
			            $(this).children('.sub-menu').slideDown(200);
			        },
			        function(){
			            $(this).children('.sub-menu').slideUp(200);
			        }
			    );
			}); // end ready
			
		</script>
		<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
		<!-- AM added starts -->
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
			<!-- nav bar for user and logout starts -->
			<nav class="navigation-bar light">
				<nav class="navigation-bar-content">
					<div class="element">
						<button  class="element icon-user image-button image-left place-right">
						Welcome <%=session.getAttribute("name")%>
						</button>
					</div>
					<a href="logout.jsp" class="element icon-exit image-button image-left place-right">Sign Out</a>
					<span class="element-divider place-right"></span>
					
						 
						<a href="success_customer.jsp" class="element icon-exit image-button image-left place-right">Home</a>
					
				</nav>
			</nav>
			<!-- nav bar for user and logout ends -->
			<!-- middle section starts-->
			<!-- sidebar starts -->
			<div style="height:100%; width:22%; float:left;">
				<nav class="sidebar light">
					<ul>
						<li>
							<a class="dropdown-toggle icon-calendar" href="#">Events</a>
							<ul class="dropdown-menu" data-role="dropdown">
								<li><a class="icon-plus" href="event_add.jsp">  Add events</a></li>
								<!-- <li><a class="icon-pencil" href="event_edit.jsp">  Edit Events</a></li>
								<li><a class="icon-remove" href="">  Delete Events</a></li> -->
								<li><a class="icon-pencil" href="<s:url action="viewEvents"/>">View Events</a></li>
							</ul>
						</li>
						<li>
							<a class="dropdown-toggle icon-clock" href="#">Appointments</a>
							<ul class="dropdown-menu" data-role="dropdown">
								<li><a class="icon-plus" href="appointment_add.jsp">  Add Appointments</a></li>
								<li><a class="icon-pencil" href="<s:url action="viewAppointments"/>">View Appointments</a></li>
								
							</ul>
						</li>
						<li>
							<a class="dropdown-toggle icon-copy" href="#">Notes</a>
							<ul class="dropdown-menu" data-role="dropdown">
								<li><a class="icon-plus" href="notes_add.jsp">Add Notes</a></li>
								
								<li><a class="icon-pencil"  href="<s:url action="notesView"/>">View Notes</a></li>
								
								
		
							</ul>
						</li>
					</ul>
				</nav>
			</div>
			<!-- sidebar ends -->
			<!-- calender starts -->
			<div style="height:100%; width:78%; float:left;">
				<table width="100%">
					<tr>
						<td width="65%">
							<center>
								<table align="center">
									<tr>
										<td>
											<s:form name="getCalendar" id="getCalendar"
												action="displayCal">
												<s:hidden name="month" id="month" value=""></s:hidden>
												<s:hidden name="year" id="year" value=""></s:hidden>
											</s:form>
											<table>
												<tr>
													<td rowspan="2"><button class="button warning medium" onclick="javascript:fnGetPrevMonth()">&lt;&lt;</button>
													</td>
													<td>
														<select class="dropdown-toggle" id="displayMonth">
															<%
																String selectedString = "";
																for (int i = 1; i <= 12; i++) {
																	selectedString = "";
																	if(monthNames[i-1].equals(displayMonthName)){
																		selectedString = " selected";
																	}
																%>
															<option value="<%=i%>" <%=selectedString%>><%=monthNames[i-1]%></option>
															<%
																}
																%>
														</select>
													</td>
													<td>
														<select id="displayYear">
															<%
																for (int i = Integer.parseInt(displayYear) - 25; i <= Integer.parseInt(displayYear) + 25; i++) {
																	selectedString  = "";									
																	if(Integer.parseInt(displayYear) == i){
																		selectedString = " selected";
																	}
																%>
															<option value="<%=i%>" <%=selectedString%>><%=i%></option>
															<%
																}
																%>
														</select>
													</td>
													<td rowspan="2"><button class="button warning medium" onclick="javascript:fnGetNextMonth()">&gt;&gt;</button>
													</td>
												</tr>
												<tr>
													<td colspan="2"><button class="button warning medium" onclick="javascript:fnGetSelectedMonth()">GO</button>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<br>
								<table style="border: 1px black;" width="50%">
									<tr>
										<td class="calClassHeader">Sun</td>
										<td class="calClassHeader">Mon</td>
										<td class="calClassHeader">Tue</td>
										<td class="calClassHeader">Wed</td>
										<td class="calClassHeader">Thurs</td>
										<td class="calClassHeader">Fri</td>
										<td class="calClassHeader">Sat</td>
									</tr>
									<tr>
										<%
											int count = firstDay;
											for (int i = 1; i <= firstDay; i++) {
											%>
										<td class="calClassEmpty"></td>
										<%
											}
											for (int i = 1; i <= daysOfMonth; i++) {
												if (i < 10){
														displayDate = displayYear+"-"+displayMonth+"-0"+i;
												}
												else{
													displayDate = displayYear+"-"+displayMonth+"-"+i;
												}
												String styleClass = "calClass";
												if(displayDate.equals(todayDate)){
													styleClass = "todayCalClass";
												}
											%>
										<td class="<%=styleClass%>">
											<%=i%> <%
												if(dateMap.containsKey(displayDate)){
													evntList = (LinkedList)dateMap.get(displayDate);
													iterator = evntList.iterator();
												%>
											<table width="100%">
												<%
													String event = null;
																																												while(iterator.hasNext()){
																																													event = (String)iterator.next();
													%>
												<tr>
													<td class="eventClass"><%=event%></td>
												</tr>
												<%
													}
													%>
											</table>
											<%
												}
											
											if(dateMap_app.containsKey(displayDate)){
								      			appList = (LinkedList)dateMap_app.get(displayDate);
								      			iterator2 = appList.iterator();
								      			
								      			
								      			%>
								      			
								      								<table width="100%">
																	<%
																		String app = null;
																	while(iterator2.hasNext()){
																	app = (String)iterator2.next();
																	%>
																			
																	<tr>
																					<td class="appClass"><%=app%></td>
																	</tr>
																	<%
																		}
																	%>
																</table> <%
								 
								      		}
												    		count++;
												    			if (count % 7 == 0 || i == daysOfMonth) {
												%>
										</td>
									</tr>
									<%
										}
																									}
										%>
								</table>
							</center>
						</td>
					</tr>
				</table>
			</div>
			<!-- calender ends -->
			<!-- footer starts -->
			<div style="height:100%; width:100%; clear:both">
				<nav class="navigation-bar light" align="center">
					<nav class="navigation-bar-content">
						<ul>
							<li><a href="#"></a></li>
						</ul>
					</nav>
				</nav>
				<p class="footer" align="center">Copyright ©2014 - 2015 <a href="#"> My Organizer </a> All rights reserved.</p>
			</div>
			<!-- footer ends -->		
		</div>
		<div class="box">
			<input type="hidden" id="hd_displayMon" value="<%=displayMonth %>" />
			<input type="hidden" id="hd_displayYear" value="<%=displayYear %>" />
			<div id="boxHeader">
				<div id="headerTitle" style="position: relative;">
					<!-- <div id="left" style="margin-right: 201px;">
						<img style="float: left" width=80px height=80px alt="calenderPic"
							src="images/calender1.png">
						<h1 style="float: left">&nbsp;MyOrganiser</h1>
					</div> -->
				</div>
				<div id="homeLink" align="right">
					<s:url action="homePage.action" var="homePageURL"></s:url>
					Welcome
					<%=session.getAttribute("name")%>
					<s:a href="%{homePageURL}">
						Home
					</s:a>
					<a href="logout.jsp">Sign out</a>
				</div>
			</div>
			<br> <br> <br>
			<hr>
			<br>
		</div>
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
			
			function fnGetNextMonth() {
				var form = document.getElementById('getCalendar');
				mon = document.getElementById('hd_displayMon').value;
				year = document.getElementById('hd_displayYear').value;
				document.getElementById('month').value = parseInt(mon) + 1;
				document.getElementById('year').value = year;
				form.submit();
			}
			
			function fnGetPrevMonth() {
				var form = document.getElementById('getCalendar');
				mon = document.getElementById('hd_displayMon').value;
				year = document.getElementById('hd_displayYear').value;
				document.getElementById('month').value = parseInt(mon) - 1;
				document.getElementById('year').value = year;
				form.submit();
			}
			
			function fnGetSelectedMonth() {
				var form = document.getElementById('getCalendar');
				monthObj = document.getElementById('displayMonth');
				document.getElementById('month').value = monthObj.options[monthObj.selectedIndex].value;
				yearObj = document.getElementById('displayYear');
				document.getElementById('year').value = yearObj.options[yearObj.selectedIndex].value;
				form.submit();
			}
		</script>
		<script src="js/hitua.js"></script>
	</body>
</html>