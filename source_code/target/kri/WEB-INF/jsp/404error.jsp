<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page Not Found</title>
</head>

<div  class="wrap">
	
	<c:set var="headerImage" value="errorPage" scope="session"/>
	
	<c:remove var="headerLogout" scope="session"/>		
	<c:remove var="headerGoSchedule" scope="session"/>
	<c:remove var="headerGoAdministration" scope="session"/>	
	<c:remove var="headerViewAdministration" scope="session"/>		
	<c:remove var="headerViewSchedule" scope="session"/>
	<c:remove var="headerModule"/>		
	
	<%@include file="/WEB-INF/jsp/common/header.jspf"%>
	
	<c:remove var="headerImage"/>
	
	<table>
		<div style="width:900px;margin:100px 0px 0px 150px;">
	
			<legend>Page Not Found</legend>
		
			<div class="append-bottom">
				Please go <a href="<c:url value='/scheduler/schedule/view'/>">Home</a>!
			</div>
			
			<br>
				
		</div>
	</table>
	<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
						
</div>
<div style = "height:30px"></div>

</html>