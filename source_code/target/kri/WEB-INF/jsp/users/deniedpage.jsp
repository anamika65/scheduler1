<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<link href="<c:url value='/resources/styles/body.css'/>" rel="stylesheet"  type="text/css" />
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link href="../resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
<script src="../resources/js/jquery-1.8.3.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Access Denied</title>
</head>

<div  class="wrap">

	<%-- <c:remove var="headerLogout" scope="session"/> --%>		
	<c:remove var="headerGoSchedule" scope="session"/>
	<c:remove var="headerGoAdministration" scope="session"/>	
	<c:remove var="headerViewAdministration" scope="session"/>		
	<c:remove var="headerViewSchedule" scope="session"/>
	<c:remove var="headerModule"/>		
	
	<%@include file="/WEB-INF/jsp/common/header.jspf"%>
	
	<table>
		<div style="width:900px;margin:100px 0px 0px 150px;">
	
			<legend>Access denied</legend>
		
			<div class="append-bottom">Only admins can see this page!</div>
			
			<br>
			
			<div>
				<a class="btn btn-primary" href="<c:url value='/scheduler/login'/>">Login</a>
			</div>		
		</div>
	</table>
			
	<div style="height:198px"> </div>
	
	<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
						
</div>
<div style = "height:30px"></div>

</html>