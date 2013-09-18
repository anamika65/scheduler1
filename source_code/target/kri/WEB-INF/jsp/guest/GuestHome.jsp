<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/birt.tld" prefix="birt"%>

<html>		
<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<link href="../resources/bootstrap/extension/datepicker.css" rel="stylesheet"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="../resources/bootstrap/extension/bootstrap-progressbar.js"></script>
<script src="../resources/bootstrap/extension/bootstrap-datepicker.js"></script>
<script src="../resources/js/date.format.js"></script>
<script src="<c:url value='/scheduler/resources/js/specialty.js'/>"></script>
<script src="<c:url value='/scheduler/resources/js/jquery.cookie.js'/>"></script>
<script src="<c:url value='/scheduler/resources/js/guest.home.js'/>"></script>

<head>
	<title>Schedule View</title>
</head>
			
<body>
	<div class="wrap">
	
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerViewSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerGoAdministration" value="../administration/home" scope="session"/>	
		
		<c:remove var="headerViewAdministration" scope="session"/>	
		<c:remove var="headerGoSchedule" scope="session"/>	
		<c:remove var="headerModule" scope="session"/>	
		
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>

		<table class="homepageTable" style="width:100%;">
			<tr style="height:40px;"/>
			
			<tr>
				<td style="width:70px;"/>
				
				<td style="width:250px;">
					Choose date for viewing the schedule:
				</td>
				<%
					DateFormat pickerFormatter = new SimpleDateFormat("dd-MM-yyyy");
					DateFormat birtFormatter = new SimpleDateFormat("yyyy-MM-dd");
					Date currentDate = null;
					if (request.getParameter("scheduledate") != null) {
						currentDate = birtFormatter.parse(request.getParameter("scheduledate")); 
					} else { 
						currentDate = new Date();
					}
				%>
				<td>
					<div class="input-append date datepicker" data-date='<%= pickerFormatter.format(currentDate) %>' data-date-format="dd-mm-yyyy" id="datePicker">
						<input name="reportDate" class="span2" size="16" type="text" readonly="" value='<%=  pickerFormatter.format(currentDate) %>'>
						<span class="add-on"><i class="icon-th"></i></span>
					</div>
				</td>
				<td>
					<a id="showCurrentSch" href="../schedule/fileDownload" class="btn btn-primary" role= "button">?</a>
				</td>
				<td class="floatRight">
					<a id="showCurrentSch" href=../schedule/view?scheduledate=<%= birtFormatter.format(currentDate) %> class="btn btn-primary birt-button" role="button"> Show schedule </a>
				</td>

				<td style="width:50px;"/>							
	        </tr>
		</table>
		
		<table class="homepageTable" style="width:100%;">
			<tr>					
				<td style="width:120px;"/>
				
				<td class="textAlignCenter"> 		
					<birt:viewer id="birtViewer" reportDesign="Generated_Schedule.rptdesign"
						baseURL="${birtURL}"
						pattern="run"
						height="600"
						width="1050"
						format="pdf"
						showParameterPage="false"
						scrolling="auto"
						pageOverflow="2"
						>
						<%
						if (request.getParameter("scheduledate") != null) {
						%>
							<birt:param name="scheduledate" value='<%= request.getParameter("scheduledate") %>'></birt:param>
						<%
						} else {
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						 %>
							<birt:param name="scheduledate" value='<%=  dateFormat.format(new Date()) %>'></birt:param>
						<%}%>
						<birt:param name="selectedSpecialty" value="${specialtyId}"></birt:param>
					</birt:viewer>
				</td>	
				
				<td style="width:120px;"/>							
			</tr>
			
			<tr style="height:50px;"/>
		</table>
		
		<table class="homepageTable" style="width:100%;">
			<tr>					
				<td style="width:100px;"/>
				<td>
					<%
					DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
					String birtURL = "http://localhost:8080/birt";
					if(request.getAttribute("birtURL") != null) { 
						birtURL = request.getAttribute("birtURL").toString();
					}
					if (request.getParameter("scheduledate") != null) {
						out.println("<a href='" + birtURL + "/run?__pageoverflow=2&__report=Generated_Schedule.rptdesign&__masterpage=true&__format=pdf&__parameterpage=false&scheduledate=" + request.getParameter("scheduledate")+ "'" + " role='button' class='btn birt-button' >Download as pdf</a>");
					} else {
						out.println("<a href='" + birtURL + "/run?__pageoverflow=2&__report=Generated_Schedule.rptdesign&__masterpage=true&__format=pdf&__parameterpage=false&scheduledate=" + dateFormat2.format(new Date())+ "'" + " role='button' class='btn birt-button' >Download as pdf</a>");
					}
					%>
				</td>
			</tr>
			
			<tr style="height:10px;"/>
			
			<tr>
				<td style="width:100px;"/>
				<td>
					<%
					if (request.getParameter("scheduledate") != null) {
						out.println("<a href='" + birtURL + "/run?__pageoverflow=2&__report=Generated_Schedule.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&scheduledate=" + request.getParameter("scheduledate")+ "'" + " role='button' class='btn birt-button' >Download as xls</a>");
					} else {
						out.println("<a href='" + birtURL + "/run?__pageoverflow=2&__report=Generated_Schedule.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&scheduledate=" + dateFormat2.format(new Date())+ "'" + " role='button' class='btn birt-button' >Download as xls</a>");
					}
					%>
			   	</td>
			</tr>	

			<tr style="height:50px;"/>
		</table>
		
		<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
						
	</div>
	<div style = "height:30px"></div>
</body>

</html>