<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
	<title>Decision support</title>
</head>
	
<body>
	<div class="wrap">
	
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="Edit Schedule"/>		
								
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
			
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>
		
		
<%-- 		<c:set var="chosenSpecialty" value="Edit Schedule"/>	 --%>
		
		<table id="zebraTable" class="table table-hover centeredTableNoTop"  style="width:1100px;">
 			<thead> 				
				<tr style="font-size:12px">
					<th> </th>
					<th>ID</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" />
				<!-- Iterate each item in the list and display the position and fields -->
				<c:forEach items="${specialties}" var="specialty">
					<tr>
						<td>
							<c:set var="count" value="${count + 1}"/>
							<c:out value="${count}" />
						</td>					
						<td><c:out value="${specialty.specialtyID}" /></td>
						<td><c:out value="${specialty.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
						
		<div style="height:300px"> </div>

		<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
			
	</div>
	<div style = "height:30px"></div>
</body>
</html>