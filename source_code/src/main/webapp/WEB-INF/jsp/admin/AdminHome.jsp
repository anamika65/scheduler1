<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<html>

<script src="../resources/js/admin.home.js"></script>

<head>
	<title>Administration Home</title>
</head>
	
<body>
	<div class="wrap">
	
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>
				
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
		<c:remove var="headerModule" scope="session"/>	
				
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>
		
		<table  class="homepageTable" style="width:100%;">	
			<tr style="height:70px;"/>
			
			<c:if test="${ not empty scheduleSuccess}">
				<div class="alert alert-success" style="width:950px;margin: 20px 40px 0px 100px;">
					<button class="close" data-dismiss="alert" type="button">×</button>
					<strong class="leftIdentSmall">Schedule for current month was generated successfully!</strong>
					<a href="../schedule/view">Click here to view the schedule!</a>
				</div>
			</c:if>
			
			<tr style="height:40px;"></tr>
			<tr>					
				<td style="width:100px;"/>
								
				<td> 
					<!-- Button to trigger modal -->
				    <a href="#myModal" role="button" data-toggle="modal">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/generate_schedule.png"/>
						  <img class="top resizeImg" src="../resources/images/generate_schedule_bw.png"/>
						</div>
					</a>
     
				    <!-- Modal -->
				    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					    <div class="modal-header">
						    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						    <h3 id="myModalLabel">Generate schedule</h3>
					    </div>
					    
					    <div class="modal-body">
					    	<br/>
					    	<br/>
					   		<p>
					   		Generate schedule for current month?
					   		</p>
					    	<br/>
					    	<br/>
					    	
					    </div>
					    
					    <div class="modal-footer">
						    <button id="cancelScheduleButton" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						    <a id="scheduleButton" href="../administration/schedule" class="btn btn-primary">Generate</a>
						    <div id="waitingAnimation" style="text-align:left">
					    		Generation in progress, please wait...<img alt="activity indicator" src="../resources/images/ajax-loader.gif">
					    	</div>
					    </div>
				    </div>
				    
					<br>
					<p class="textAlignCenter"> Generate schedule </p> 
				</td>
				
				<td class="textAlignCenter"> 
					<a href="../administration/decisionsupport">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/edit_schedule.png"/>
						  <img class="top resizeImg" src="../resources/images/edit_schedule_bw.png"/>
						</div>
					</a>
					<br>
					Decision support
				</td>
				
				<td class="textAlignCenter"> 
					<a href="../administration/progress">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/residents.png"/>
						  <img class="top resizeImg" src="../resources/images/residents_bw.png"/>
						</div>
					</a>
					<br>
					Residents and <br>training progress
				</td>	
				
				<td style="width:90px;"/>							
			</tr>
			
			<tr style="height:30px;"/>

			<tr>					
				<td style="width:110px;"/>
				
				<td class="textAlignCenter"> 
<!-- 				<img src = "../resources/images/catalogues_bw.png" class="resizeImg"/> -->
					<a href="../administration/catalogues">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/catalogues.png"/>
						  <img class="top resizeImg" src="../resources/images/catalogues_bw.png"/>
						</div>
					</a>
					<br>
					Catalogues
				</td>
				
				<td class="textAlignCenter"> 
				<sec:authorize ifAllGranted="ROLE_ADMIN">
					<a href="../administration/import">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/import.png"/>
						  <img class="top resizeImg" src="../resources/images/import_bw.png"/>
						</div>
					</a>
					<br>
					Import 
				</sec:authorize>
				</td>

				<td class="textAlignCenter"> 
				<sec:authorize ifAllGranted="ROLE_ADMIN">
					<a href="../administration/settings">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/settings.png"/>
						  <img class="top resizeImg" src="../resources/images/settings_bw.png"/>
						</div>
					</a>
					<br>
					Settings
				</sec:authorize>	
				</td>	
						
			</tr>
			
			<tr style="height:30px;"/>
		<sec:authorize ifAllGranted="ROLE_ADMIN">			
			<tr>					
				<td style="width:110px;"/>
				<td class="textAlignCenter"> 
					<a href="../administration/crud">
						<div id="cf" class="resizeImgContainer">
						  <img class="bottom resizeImg" src="../resources/images/crud.png"/>
						  <img class="top resizeImg" src="../resources/images/crud_bw.png"/>
						</div>
					</a>
					<br>
					User Management 
				</td>
				</tr>
			<tr style="height:40px;"/>
		</sec:authorize>
		</table>
		<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>
	</div>
	<div style = "height:30px"></div>
</body>
</html>