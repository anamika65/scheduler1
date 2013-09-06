<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<html>

<script src="<c:url value='/scheduler/resources/js/jqBootstrapValidation.js'/>"></script>
<script>
$(document).ready(function () {
	$("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); 
} );
</script>

<head>
	<title>Settings</title>
</head>
	
<body>
	<div class="wrap">
			
		<c:set var="headerLogout" value="../logout" scope="session"/>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="Settings"/>
								
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
					
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>

		<table  class="homepageTable" style="width:100%;">
			
			<tr style="height:70px;"></tr>
			
			<tr>	
				<td style="width:70px;"/>
			
				<td> 
					<form method="POST" action="../administration/settings/save">
						<fieldset>
						    <label class="control-label fontBigLabel">New training duration</label>
						    <div class="control-group">
								<div class="controls">
							    	<input name="TRAINING_DURATION" min="0" type="number" placeholder="New training duration">
							    </div>
						    </div>
						    <div style="margin:-15px 0px 0px 0px;font-style:italic;">Current training duration is: ${TRAINING_DURATION} months</div>
						  
							<br>
							<br>
													  
						    <button type="submit" class="btn">Submit</button>
						</fieldset>
					</form>				
				</td>	
				
				<td style="width:80px;"/>
			</tr>
						
		</table>
		
		<br/>
		
	    <jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>			
	</div>
	<div style = "height:30px"></div>
</body>
</html>