<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<html>
<script type="text/javascript">
$(document).ready(function() {
	$('#button').button();

	$('#button').click(function() {
	    $(this).button('loading');
	});
	

});
</script>
<head>
	<title>Import</title>
</head>
	
<body>
	<div class="wrap">
			
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="Import"/>
								
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
					
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>

		<table  class="homepageTable" style="width:100%;">
			<tr>
				<td style="width:50px;"/>
				<td style="width:950px;">
		    		<legend class="legendFont">Import operations</legend>
		    	</td>
		    	<td class="buttonRight"/>
			</tr>
		</table>
		<div></div>
		<table  class="homepageTable" style="width:100%;">
			<div style="width:1000px;margin:20px 40px 0px 100px;">
				<c:if test="${not empty error}">
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert" type="button">×</button>
						<strong class="leftIdentSmall">${error}</strong>
					</div>
				</c:if>
				<%
				    if (request.getParameter("resName") == null) {
				        out.println("");
				    } else {
				        out.println("<div class=\"alert alert-error\" id=\"customError\"><button class=\"close\" data-dismiss=\"alert\" type=\"button\">×</button><strong class=\"leftIdentSmall\">Resident not found : "+request.getParameter("resName")+". Please add this resident before import.</strong></div>");
				    }
				%>
				
			</div>
			
			<div style="width:1000px;margin:20px 40px 0px 100px;">
			<c:if test="${ not empty success}">
				<div class="alert alert-success">
					<button class="close" data-dismiss="alert" type="button">×</button>
					<strong class="leftIdentSmall">File ${success} uploaded sucessfully.</strong>
					<a href="../administration/progress">Resident progress was updated!</a>
				</div>
			</c:if>
			</div>
			
			<tr style="height:30px;"/>
			<tr>					
				<td style="width:60px;"/>
				<td class="textAlignCenter"> 
					<form:form commandName="uploadForm" action="../administration/import/save" enctype="multipart/form-data" method="POST">
			 		    <table>
					         <tr>
					         	<td colspan="2" style="color: red;"><form:errors path="*" cssStyle="color : red;"/> ${errors} </td>
					         </tr>
					         <tr>
						         <td style = "vertical-align: baseline; padding-top: 10px; white-space: pre;">File:     </td>
						         <td style = "padding-top: 10px;"> <form:input type="file" path="file" onchange="if (this.files && this.files[0]) {document.getElementById('updoadBtn').style.display = 'block';} else {document.getElementById('updoadBtn').style.display = 'none';}"/> </td>
					         	 <td id = "updoadBtn" style = "display:none">
					         	 	<button id="button" class="btn btn-primary" data-loading-text="Processing..." type="submit" >Upload File</button>
					         	 </td>
					         </tr>
					        </table>
					</form:form>
				</td>	
				<td style="width:70px;"/>
			</tr>
			<tr style="height:100px;"/>
		</table>
		<table  class="homepageTable" style="width:700px;">
			<tr>					
				<td style="width:60px;"/>
				<td class="legendFont"> File Structure </td>
			</tr>
			<tr style="height:10px;"/>
			<tr>
				<td/>
				<td>
					<table class="table table-bordered">
						<thead>
		                <tr>
		                  <th style="width:60px;">OPSC01</th>
		                  <th style="width:60px;">OPSC02</th>
		                  <th style="width:60px;">OPDatum</th>
		                  <th style="width:60px;">OP1</th>
		                  <th style="width:60px;">OP2</th>
		                  <th style="width:60px;">ASS1</th>
		                </tr>
		              </thead>
		              <tbody>
						<tr>
							<td> Text</td>
							<td> Text</td>
							<td> Date (dd/mm/yyyy)</td>
							<td> Text</td>
							<td> Text</td>
							<td> Text</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
			
	</div>
	<div style = "height:30px"></div>
</body>
</html>