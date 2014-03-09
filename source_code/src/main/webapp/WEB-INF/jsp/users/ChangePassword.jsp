<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>
<html>
<script
	src="<c:url value='/scheduler/resources/js/script.js'/>"></script>
<head>
    <title>Change Password</title>
</head>
<body>

<div  class="wrap">

	<%-- <c:remove var="headerLogout" scope="session"/> --%>		
	<c:remove var="headerGoSchedule" scope="session"/>
	<c:remove var="headerGoAdministration" scope="session"/>	
	<c:remove var="headerViewAdministration" scope="session"/>		
	<c:remove var="headerViewSchedule" scope="session"/>
	<c:remove var="headerModule"/>		
	<%@include file="/WEB-INF/jsp/common/header.jspf"%>
	
	<div style="width:900px;margin:30px 0px 0px 150px;">
		<c:url var="changeUrl" value="../schedule/changepassword/save" />
					<form id="changePasswordForm" method="POST" action="${changeUrl}">
		
			<legend>Change Password</legend> 
			<br/>
			<div class="control-group">
			    <label class="control-label" >Current Password</label>			    			    
			    <div class="controls">
					<input type="password" name="curPassword" id="c_password" placeholder="Current Password"><span class="mappingSuggestion1 miniSugg"></span>
			    </div>			    
			</div>
			
			<div class="control-group">
			    <label class="control-label" >New Password</label>
			    <div class="controls">
			 	   <input type="password" name="newPassword" id="new_password" placeholder="Password">
			    </div>
			</div>
			
			<div class="control-group">
			    <label class="control-label" >Repeat Password</label>
			    <div class="controls">
			 	   <input type="password" name="repeatPassword" id="repeat_password" placeholder="Repeat Password"><span class="mappingSuggestion2 miniSugg"></span>
			    </div>
			</div>
		
			<div class="control-group">
				<div class="controls">
				    <button id="submit" type="submit" class="btn btn-primary">Change</button>
				    <script type="text/javascript">
						Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
					</script>
				</div>
		    </div>
		    
		</form>
		
		<br/>		
	</div>

	<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
	
</div>

<div style = "height:30px"></div>

</body>
</html>