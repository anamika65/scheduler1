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
					         	<td colspan="3" style="color: red;"><form:errors path="*" cssStyle="color : red;"/> ${errors} </td>
					         </tr>
					         <tr>
					         	<td style="text-align: left; padding-top: 10px;">Time period</td>
					         	<td style="text-align: left; padding-top: 10px; "> :&nbsp;
					         		<select name="month" id="month">
									  <option value="01">January</option>
									  <option value="02">February</option>
									  <option value="03">March</option>
									  <option value="04" selected>April</option>
									  <option value="05">May</option>
									  <option value="06">June</option>
									  <option value="07">July</option>
									  <option value="08">August</option>
									  <option value="09">September</option>
									  <option value="10">October</option>
									  <option value="11">November</option>
									  <option value="12">December</option>
									</select> 
								</td>
								<td style="text-align: left; padding-top: 10px; ">&nbsp;&nbsp;
									<select name="year" id="year">
									  <option value="2000">2000</option>
									  <option value="2001">2001</option>
									  <option value="2002">2002</option>
									  <option value="2003">2003</option>
									  <option value="2004">2004</option>
									  <option value="2005">2005</option>
									  <option value="2006">2006</option>
									  <option value="2007">2007</option>
									  <option value="2008">2008</option>
									  <option value="2009">2009</option>
									  <option value="2010">2010</option>
									  <option value="2011">2011</option>
									  <option value="2012">2012</option>
									  <option value="2013">2013</option>
									  <option value="2014" selected>2014</option>
									  <option value="2015">2015</option>
									  <option value="2016">2016</option>
									  <option value="2017">2017</option>
									  <option value="2018">2018</option>
									  <option value="2019">2019</option>
									  <option value="2020">2020</option>
									</select> 
								</td>
					         </tr>
					    	<tr>
					         	<td style="text-align: left;">&nbsp;</td>
					         	<td colspan="2" style="text-align: left; ">&nbsp;&nbsp;&nbsp;<span class="label label-warning">Any previous record of this time period will be deleted</span></td>
					         </tr>
					         <tr>
						         <td style = "vertical-align: baseline; padding-top: 10px; white-space: pre; text-align: left;">File</td>
						         <td style = "padding-top: 10px; text-align: left;"> :&nbsp;&nbsp;<form:input type="file" path="file" onchange="if (this.files && this.files[0]) {document.getElementById('updoadBtn').style.display = 'block';} else {document.getElementById('updoadBtn').style.display = 'none';}"/> </td>
					         	 <td id = "updoadBtn" style = "display:none; text-align: left; ">&nbsp;&nbsp;
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