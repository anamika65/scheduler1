<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
			
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="Settings"/>
								
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
					
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>

		<table  class="homepageTable" style="width:100%;">
			
			<tr style="height:70px;"></tr>
			<sec:authorize ifAllGranted="ROLE_ADMIN">
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
			</sec:authorize>
				
			<tr>	
				<td style="width:70px;"/>
				<td>&nbsp;</td>
				<td style="width:80px;"/>
			</tr>
			<tr>	
				<td style="width:70px;"/>
				<td><hr /></td>
				<td style="width:80px;"/>
			</tr>
			<tr>	
				<td style="width:70px;"/>
				<td><h3>Difficult Operations</h3></td>
				<td style="width:80px;"/>
			</tr>
			<tr>	
				<td style="width:70px;"/>
				<td>
				<table class="table table-hover" style="width:100%;">
				<thead>
				<tr>
					<th>ID</th>
					<th>Operation Date</th>
					<th>OPSC01</th>
					<th>OPSC02</th>
					<th>Op1</th>
					<th>Op2</th>
					<th>Assistant</th>
					<th>Operated As</th>
					<th>Credit as Difficult</th>
					<th>&nbsp;</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${difficultOperations}" var="difficultOperation">
				<tr>
					<td>${difficultOperation.dSuppOpId}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${difficultOperation.opDate}" /></td>
					<td>${difficultOperation.opsc1}</td>
					<td>${difficultOperation.opsc2}</td>
					<td>${difficultOperation.op1}</td>
					<td>${difficultOperation.op2}</td>
					<td>${difficultOperation.ass1}</td>
					<td>
						<c:if test="${difficultOperation.op1 == nameUser}">Op1</c:if> 
						<c:if test="${difficultOperation.op2 == nameUser}">Op2</c:if>
						<c:if test="${difficultOperation.ass1 == nameUser}">Ass1</c:if>
					</td>
					<td>
						<c:if test="${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
							<input type="checkbox" name="opscToCount" value="OPSC01"> OPSC01 
						</c:if>
						<c:if test="${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
							<input type="checkbox" name="opscToCount" value="OPSC02"> OPSC02 
						</c:if>
						
						<c:if test="${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
							<input type="checkbox" name="opscToCount" value="OPSC01"> OPSC01 
						</c:if>
						<c:if test="${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
							<input type="checkbox" name="opscToCount" value="OPSC02"> OPSC02 
						</c:if>
						
						<c:if test="${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
							<input type="checkbox" name="opscToCount" value="OPSC01"> OPSC01 
						</c:if>
						
						<c:if test="${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
							<input type="checkbox" name="opscToCount" value="OPSC02"> OPSC02 
						</c:if>
					</td>
					<td><input type="submit" value="Save" class="btn btn-primary"></td>
				</tr>
				</c:forEach> 
				</tbody>
				</table>
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