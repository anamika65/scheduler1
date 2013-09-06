<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<link href="<c:url value='/resources/styles/body.css'/>" rel="stylesheet"  type="text/css" />
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link href="../resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
<script src="../resources/js/jquery-1.8.3.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>

<head>
	<title>Log in</title>
</head>

<div  class="wrap">

	<c:remove var="headerLogout" scope="session"/>		
	<c:remove var="headerGoSchedule" scope="session"/>
	<c:remove var="headerGoAdministration" scope="session"/>	
	<c:remove var="headerViewAdministration" scope="session"/>		
	<c:remove var="headerViewSchedule" scope="session"/>
	<c:remove var="headerModule"/>		
	
	<%@include file="/WEB-INF/jsp/common/header.jspf"%>
	
	<div>
		<c:if test="${not empty error}">
			<div class="alert alert-error" style="width:850px; height: 20px; margin: 20px 40px 0px 150px;">
				${error}
			<br />
			<br />
			</div>
		</c:if>
	</div>
	
	<div style="width:900px;margin:30px 0px 0px 150px;">
		<form class="form-horizontal" action="../j_spring_security_check" method="post">
		
			<legend>Login Information</legend> 
			
			<br/>
		
			<div class="control-group">
			    <label class="control-label" for="j_username">Username</label>			    			    
			    <div class="controls">
					<input type="text" name="j_username" id="j_username" placeholder="Username">
			    </div>			    
			</div>
			
			<div class="control-group">
			    <label class="control-label" for="j_password">Password</label>
			    <div class="controls">
			 	   <input type="password" name="j_password" id="j_password" placeholder="Password">
			    </div>
			</div>
		
			<div class="control-group">
				<div class="controls">
<!-- 				    <label class="checkbox"> -->
<!-- 						<input type="checkbox"> Remember me -->
<!-- 				    </label> -->
				    <button id="submit" type="submit" class="btn btn-primary">Login</button>
				    <script type="text/javascript">
						Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
					</script>
				</div>
		    </div>
		    
		</form>
		
		<br/>
		
		<div style="font-size:10px">
			<p>Valid username/passwords are:</p>
			<ul>
				<li>keith/melbourne</li>
				<li>erwin/leuven</li>
				<li>jeremy/atlanta</li>
				<li>scott/rochester</li>
			</ul>
		</div>
		
		<br/>
		<br/>
	</div>
	
	<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
						
</div>

<div style = "height:30px"></div>

</html>