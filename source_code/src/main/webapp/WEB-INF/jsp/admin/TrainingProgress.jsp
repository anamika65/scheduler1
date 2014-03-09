<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<link href="<c:url value="/resources/styles/body.css" />" rel="stylesheet"  type="text/css" />
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link href="../resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
<link href="../resources/bootstrap/extension/bootstrap-progressbar.min.css" rel="stylesheet"/>
<link href="../resources/bootstrap/extension/datepicker.css" rel="stylesheet"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="../resources/js/jquery-1.8.3.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="../resources/bootstrap/extension/bootstrap-progressbar.js"></script>
<script src="../resources/bootstrap/extension/bootstrap-datepicker.js"></script>

<script src="<c:url value='/scheduler/resources/js/jqBootstrapValidation.js'/>"></script>
<script src="<c:url value='/scheduler/resources/js/training.progress.js'/>"></script>

<script src="<c:url value='/scheduler/resources/js/specialty.js'/>"></script>
<script src="<c:url value='/scheduler/resources/js/jquery.cookie.js'/>"></script>
<script type="text/javascript">
$(function(){
	var OK = 0;
	//check already exist username
	$("#usr_name").blur(function(){
		if($.trim($("#usr_name").val()).length >0){
			var userName = $.trim($(this).val());
			$.ajax({
				url : "../administration/crud/checkUser",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
				data : "usrNameValue="+ userName,
				type : "POST",//request type, can be GET
				cache : false,//do not cache returned data
			}).done(function(data) {
				// -1,0 : Password doesn't exist, others : Password found
				if (data == "1") {
					// ask user to enter passwords
					$(".mappingSuggestion1").html("User Name Already Exist.Choose Another")
											.css("color","#aa0000");	
				}
				else{
					$(".mappingSuggestion1").html("User Name Available")
					.css("color","#00aa00");
					OK = 1;
				}
			});
		}
	});
	$( "#userRegistrationForm" ).submit(function( event ) {
		  if ( OK == 1 ) { //all are ok
		    return;
		  }
		  event.preventDefault();
		});
	
}); 
 
</script>

<head>
	<title>Training progress</title>
</head>

<%
	DateFormat pickerFormatter = new SimpleDateFormat("dd-MM-yyyy");
%>

<body>
	<div class="wrap">

		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="Residents and training progress"/>			

		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	

		<%@include file="/WEB-INF/jsp/common/header.jspf"%>
		
		<c:if test="${userRole == 'ROLE_ADMIN' }"> 
			<table  class="homepageTable" style="width:100%;">
			    <tr>					
					<%@ include file="/WEB-INF/jsp/admin/AddResident.jspf" %>
				</tr>
			</table>
			
			<!-- counts residents in list  -->
			<c:set var="count" value="0" />
			<!-- wrapper for tabs -->
			<div class="centeredTableNoTop" style="width:1100px;">
	
				<!-- tabs for active and inactive residents -->
	            <ul id="myTab" class="nav nav-tabs">
	              <li class="active"><a href="#activeProjects" data-toggle="tab">Active</a></li>
	              <li class=""><a href="#inactiveProjects" data-toggle="tab">Inactive</a></li>
	            </ul>
	            
				<!-- tab content with active residents -->
	            <div id="myTabContent" class="tab-content">
				  <!-- active tab is the one with active residents -->
	              <div class="tab-pane fade active in" id="activeProjects">
	
					<!-- all residents are wrapped in an group that manages which body is visible -->
					<div class="accordion" id="accordion1">
						<c:forEach items="${activeProjects}" var="project">					
							<div class="accordion-group">
							    <div class="accordion-heading">
								  <!-- unique id for each project -->
							      <c:set var="collapseResident" value="collapseResident${count}" />
							      <c:set var="generateProgress" value="generateProgress${count}" />
							      <script>
									 $(document).ready(function() {
								        	$('#${generateProgress}').on('click', function(event) {        	
								        		$('#${collapseResident} .progress .bar.text-centered-1').progressbar({
								        			update: function(current_percentage) { $('#v-callback-update-1').text(current_percentage); },
								        			done: function(current_percentage) { $('#v-callback-done-1').text('done!'); },
								        			display_text: 2
								        			}); 
								        	}); 
								        });
						  		  </script>
								  <!-- collapse header -->
							      <a id="${generateProgress}" class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#${collapseResident}">
							        	<c:set var="count" value="${count + 1}"/>
										<c:out value="${count}" />. 
										<c:out value="${project.key.person.name}" /> 
								        <c:out value="${project.key.person.firstName}" /> 
								        <c:if test="${project.value[0].overdue}">
									        <span class="badge badge-important">!</span>
								        </c:if>
							      </a>
					    		</div>
	
								<!-- collapse body -->
					    		<div id="${collapseResident}" class="accordion-body collapse">
							      <div class="accordion-inner">
							      	<c:if test="${project.value[0].overdue}">
								      	<div class="alert alert-error	">
										  <button type="button" class="close" data-dismiss="alert">&times;</button>
										  <strong>Warning!</strong>
										   Training duration is not accurate, decision support cannot be provided for this resident.
										   Please change the duration or deactivate the resident.	
										</div>
								 	</c:if>
								 	Name: <b style="font-size:16px;"> <c:out value="${project.key.person.name}" /> </b>
							       	<font style="padding-left:30px;">First Name:</font> <b style="font-size:16px;"> <c:out value="${project.key.person.firstName}" /> </b>
									<font style="padding-left:30px;">Nickname: <b style="font-size:16px;"><c:out value="${project.key.person.nickname}" /></b></font>
									<ul class="dropdown nav pull-right" style="text-align: left;">
				                      <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">Manage<b class="caret"></b></a>
				                      <ul class="dropdown-menu" role="menu">
				                        <li role="presentation">
											<a role="menuitem" tabindex="-1" href="${birtURL}/frameset?__report=Generated_Status.rptdesign&projectID=${project.key.project.projectID}" target="_blank">View operations</a>
				                        </li>
				                        <li role="presentation">
				                        	<a role="menuitem" tabindex="-1" href="${birtURL}/run?__pageoverflow=2&__report=Generated_status.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&projectID=${project.key.project.projectID}">Download operations</a>
				                        </li>
				                        <li role="presentation" class="divider"></li>
				                        <li role="presentation">
				                       		<!-- Button to trigger modal to edit Person Information -->
									    	<c:set var="myEditPersonURL" value="editPerson${count}" />
											<a role="menuitem" tabindex="-1" href="#${myEditPersonURL}" role="button" data-toggle="modal">Edit</a>
				                        </li>
				                        <li role="presentation">
				                       		<!-- Button to trigger modal for entering the vacation for the current project -->
									    	<c:set var="myOnVacationUrl" value="onVacationResident${count}" />
											<a role="menuitem" tabindex="-1" href="#${myOnVacationUrl}" role="button" data-toggle="modal"> 
											Vacation leave 
											</a> 
				                        </li>
				                        <li role="presentation">
				                         	<!-- Button to trigger modal for deactivating the current project -->
									    	<c:set var="myDeactivateURL" value="deactivateResident${count}" />
											<a role="menuitem" tabindex="-1" href="#${myDeactivateURL}" role="button" data-toggle="modal"> 
											Deactivate 
											</a> 
				                         </li>
				                      </ul>
				                    </ul>
	
									<!-- Generate the URL with the dSuppOpId -->
									<c:url var="editPersonURL" value="../administration/progress/editPersonInformation?id=${project.key.project.projectID}" />
								    <form method="POST" action="${editPersonURL}">
	
		 						    <!------------------------------------- Modal for editing the current person ------------------------------------------------>
								    <div id="${myEditPersonURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									        <div class="modal-header">
									            <a class="close" data-dismiss="modal">×</a>
											    <h3 id="myModalLabel"> Edit person </h3>
										    </div>
									      	<div class="modal-body" style="text-align:left;">
												<br/>
												<table>
													<tr>
														<td class="tdCatalogueType1" style="vertical-align:baseline;">
															<label class="control-label" > Title: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="title" type="text"  value="${project.key.person.title}" required/> 
											             	</div>
											              </div>
											            </td>
											        </tr>
													<tr>
														<td class="tdCatalogueType1" style="vertical-align:baseline;">
															<label class="control-label" > Name: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="name" type="text" value="${project.key.person.name}" required/> 
											             	</div>
											              </div>
											            </td>
										            </tr>
										            <tr>
										            	<td class="tdCatalogueType1" style="vertical-align:baseline;">
														<label class="control-label" > First Name: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="firstName" type="text" value="${project.key.person.firstName}" required/> 
											             	</div>
											              </div>
											            </td>
											        </tr>
											        <tr>
											        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
															<label class="control-label" > Function: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="function" type="text" value="${project.key.person.function}" required/> 
											             	</div>
											              </div>
											            </td>
											        </tr>
											        <tr>
									            		<td class="tdCatalogueType1" style="vertical-align:baseline;">
														<label class="control-label" > Nickname: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="nickname" type="text" value="${project.key.person.nickname}" required disabled/> 
											             	</div>
											              </div>
											            </td>
										       		</tr>
										       		<tr>
											            <td class="tdCatalogueType1"> Start date: </td>
											            <td>
											            	<div class="input-append date" id="dp3" data-date="${project.key.project.startDate}" data-date-format="dd-mm-yyyy">
																<input name="startDate" class="span2" size="16" type="text" readonly="" value="${project.key.project.startDate}" disabled>
																<span class="add-on"><i class="icon-th"></i></span>
															</div>
											           	</td> 
											        </tr>
											        <tr>
											        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
															<label class="control-label" > Duration: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="duration" min="1" max="200" type="number" value="${project.key.project.duration}" required/> 
											             	</div>
											              </div>
											            </td>
											        </tr>	
											        <tr>
											        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
															<label class="control-label" > Capacity: </label>
														</td>
														<td style="vertical-align:baseline;">
											              <div class="control-group">
											              	<div class="controls">
												            	<input name="capacity" min="1" max="200" type="number" value="${project.key.project.capacity}" required/> 
											             	</div>
											              </div>
											            </td>
											        </tr>		
									            </table>
									        </div>
									        <div class="modal-footer">
									            <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
									            <input type="submit" value="Save" class="btn btn-primary" />
									        </div>
								    </div>
								    </form>
								    <!------------------------------------- End Modal for editing the current person ------------------------------------------------>
	
									<!-- Deactivate for each project -->
									<!-- Generate the URL with the projectID -->
									<c:url var="DeactivateUrl" value="../administration/progress/deactivate?id=${project.key.project.projectID}" />
									<form method="POST" action="${DeactivateUrl}">								    
				 						<!-- Modal for deactivating the current project -->
										<div id="${myDeactivateURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
												<div class="modal-header">
											    	<a class="close" data-dismiss="modal">×</a>
													<h3 id="myModalLabel"> Deactivate </h3>
												</div>
	
											    <div class="modal-body" style="text-align:left;">
													<br/>
													<p> 
														Do you want to deactivate resident
														 <c:out value="${project.key.person.name}" /> 
														 <c:out value="${project.key.person.firstName}" />?
													   	<br/>
												    </p>
											    </div>
	
											    <div class="modal-footer">
												    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
												    <input type="submit" value="Deactivate" class="btn btn-primary" />
											    </div>
										</div>
									</form>
	
									<!-- Enter Vacation for each project -->
									<!-- Generate the URL with the projectID -->
									<c:url var="OnVacationUrl" value="../administration/progress/onVacation?id=${project.key.project.projectID}" />
									<form method="POST" action="${OnVacationUrl}">								    
				 						<!-- Modal for deactivating the current project -->
										<div id="${myOnVacationUrl}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
												<div class="modal-header">
											    	<a class="close" data-dismiss="modal">×</a>
													<h3 id="myModalLabel"> Enter vacation for resident </h3>
												</div>
	
											    <div class="modal-body" style="text-align:left;">
													<br/>
													<p> 
														Please enter return date from vacation for
														 <c:out value="${project.key.person.name}" /> 
														 <c:out value="${project.key.person.firstName}" />.
													   	<br/>
												    </p>
												    <div class="input-append date datepicker" id="dpOnVacation" data-date='<%=  pickerFormatter.format(new Date()) %>' data-date-format="dd-mm-yyyy" style="width:60px">
														<input name="untilDate" class="span2" size="16" type="text" readonly="" value='<%=  pickerFormatter.format(new Date()) %>'>
														<span class="add-on"><i class="icon-th"></i></span>
													</div>
											    </div>
	
											    <div class="modal-footer">
												    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
												    <input type="submit" value="Save" class="btn btn-primary" />
											    </div>
										</div>
									</form>
	
							      	Start Date: <fmt:formatDate pattern="dd.MM.yyyy" value="${project.key.project.startDate}" />
							      	<font style="padding-left:30px">Duration:</font> <c:out value="${project.key.project.duration}" /> months
							      	<font style="padding-left:30px">Capacity:</font> <c:out value="${project.key.project.capacity}" /> operations/month 
	
							      	<br>
							      	<br>
	
					      			<c:set var="totalProgressPercent" value="0"/>
					      			<c:set var="expectedProgressPercent" value="0"/>
							      	<table>
								      <tbody> 
	
									      <tr style="border-top:2px solid white">
										    <c:forEach items="${project.value}" var="items" begin="0" step="2">
										      <td style = "padding-right:15px">
												<c:out value="${items.catalogueName}" />
			   							        <c:set var="totalProgressPercent" value="${items.progressPercentIs + totalProgressPercent}"/>
										        <c:set var="expectedProgressPercent" value="${items.progressPercentShouldBe + expectedProgressPercent}"/>
										        <div class="progress horizontal wide">
													<div id="myProgress" class="bar text-centered-1" data-percentage="${items.progressPercentIs}"></div>
												</div>
												<br>
											  </td>
										    </c:forEach>
										   </tr>
	
										   <tr style="border-top:2px solid white">
										    <c:forEach items="${project.value}" var="items" begin="1" step="2">
										      <td style = "padding-right:15px">
												<c:out value="${items.catalogueName}" />
			   							        <c:set var="totalProgressPercent" value="${items.progressPercentIs + totalProgressPercent}"/>
										        <c:set var="expectedProgressPercent" value="${items.progressPercentShouldBe + expectedProgressPercent}"/>
										        <div class="progress horizontal wide">
													<div id="myProgress" class="bar text-centered-1" data-percentage="${items.progressPercentIs}"></div>
												</div>
												<br>
											  </td>
										    </c:forEach>
										   </tr>
	
									   </tbody>
									</table>
	
									<c:set var="nrOfCatalogs" value="${fn:length(project.value)}" />
									<c:set var="totalProgressPercent" value="${totalProgressPercent / nrOfCatalogs}" />
									<c:set var="expectedProgressPercent" value="${expectedProgressPercent / nrOfCatalogs}" />
									<fmt:setLocale value="en_US" scope="session"/>
									Overall training progress: <b><fmt:formatNumber value="${totalProgressPercent}" pattern="0.0"/>%</b>
									<c:if test="${expectedProgressPercent > 100 }">
										<c:set var="expectedProgressPercent" value="100" />
									</c:if>
									<i>(expected training progress: <fmt:formatNumber value="${expectedProgressPercent}" pattern="0.0"/>%)</i>
	
									<div>
										<br>
										<i><b>Performed number of operations:</b></i>
										<br>
										 <c:forEach items="${project.value}" var="items">
										 	<c:out value="${items.catalogueName}" />: <c:out value="${items.completedOpNumber}" /> 
										 	 / <c:out value="${items.totalOpNumber}" /> <br>
										 </c:forEach>
									</div>
								  </div>
								</div>
							</div>
						</c:forEach>
					</div>					    
	              </div>
	              
				  <!-- counts residents in list  -->
				  <c:set var="count" value="1000" />
				  <!-- tab for inactive residents -->
	              <div class="tab-pane fade" id="inactiveProjects">
	
					<!-- all residents are wrapped in an group that manages which body is visible -->
	              	<div class="accordion" id="accordion2">
	              		<c:forEach items="${inactiveProjects}" var="project">              	
							<div class="accordion-group">
								<div class="accordion-heading">
								   <!-- unique id for each project -->
								   <c:set var="collapseResident" value="collapseResident${count}" />
								   <c:set var="generateProgress" value="generateProgress${count}" />
								   <script>
									$(document).ready(function() {
									       	$('#${generateProgress}').on('click', function(event) {        	
									       		$('#${collapseResident} .progress .bar.text-centered-1').progressbar({
									       			update: function(current_percentage) { $('#v-callback-update-1').text(current_percentage); },
									       			done: function(current_percentage) { $('#v-callback-done-1').text('done!'); },
									       			display_text: 2
									       			}); 
									       	}); 
									  });
								   </script>
							       <a id="${generateProgress}" class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#${collapseResident}">
							        	<c:set var="count" value="${count + 1}"/>
										<c:out value="${count-1000}" />. 
									 	<c:out value="${project.key.person.name}" /> 
							        	<c:out value="${project.key.person.firstName}" /> 
							        	<c:choose>
										    <c:when test="${empty project.key.project.deactivatedUntil}">
										 	    <font class="floatRight"><i>indefinitely</i></font>
										    </c:when>
										    <c:otherwise>
										        <font class="floatRight"><i>until: <fmt:formatDate pattern="dd-MM-yyyy" value="${project.key.project.deactivatedUntil}" /></i></font>
										    </c:otherwise>
										</c:choose>
								    </a>
							    </div>
							    <div id="${collapseResident}" class="accordion-body collapse">
							      <div class="accordion-inner">
	
								 	Name: <b style="font-size:16px;"> <c:out value="${project.key.person.name}" /> </b>
							       	<font style="padding-left:30px;">First Name:</font> <b style="font-size:16px;"> <c:out value="${project.key.person.firstName}" /> </b>
									<font style="padding-left:30px;">Nickname: <b style="font-size:16px;"><c:out value="${project.key.project.nickname}" /></b></font>
							  		<ul class="dropdown nav pull-right" style="text-align: left;">
				                      <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">Manage<b class="caret"></b></a>
				                      <ul class="dropdown-menu" role="menu">
				                        <li role="presentation">
											<a role="menuitem" tabindex="-1" href="${birtURL}/frameset?__report=Generated_Status.rptdesign&projectID=${project.key.project.projectID}" target="_blank">View operations</a>
				                        </li>
				                        <li role="presentation">
				                        	<a role="menuitem" tabindex="-1" href="${birtURL}/run?__pageoverflow=2&__report=Generated_status.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&projectID=${project.key.project.projectID}">Download operations</a>
				                        </li>
				                        <li role="presentation" class="divider"></li>
				                        <li role="presentation">
				                         	<!-- Button to trigger modal for activating the current project -->
										   	<c:set var="myActivateURL" value="activateResident${count}" />
											<a role="menuitem" tabindex="-1" href="#${myActivateURL}" role="button" data-toggle="modal"> 
											Activate 
											</a> 
				                         </li>
				                      </ul>
				                    </ul>
	
									<!-- Activate for each project -->
									<!-- Generate the URL with the catalogueID -->
									<c:url var="ActivateUrl" value="../administration/progress/activate?id=${project.key.project.projectID}" />
									<form method="POST" action="${ActivateUrl}">								    
				 						<!-- Modal for activating the current project -->
										<div id="${myActivateURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
												<div class="modal-header">
											    	<a class="close" data-dismiss="modal">×</a>
													<h3 id="myModalLabel"> Activate </h3>
												</div>
	
											    <div class="modal-body" style="text-align:left;">
													<br/>
													<p> 
														Do you want to activate resident
													 	<c:out value="${project.key.person.name}" /> 
													 	<c:out value="${project.key.person.firstName}" />?
													   	<br/>
												    </p>
											    </div>
	
											    <div class="modal-footer">
												    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
												    <input type="submit" value="Activate" class="btn btn-primary" />
											    </div>
										</div>
									</form>
	
							      	Start Date: <fmt:formatDate pattern="dd.MM.yyyy" value="${project.key.project.startDate}" /> 
							      	<font style="padding-left:30px">Duration:</font> <c:out value="${project.key.project.duration}" /> months
							      	<font style="padding-left:30px">Capacity:</font> <c:out value="${project.key.project.capacity}" /> operations/month 
	
							      	<br>
							      	<br>
	
							      	<c:set var="totalProgressPercent" value="0"/>
	
							      	<table>
								      <tbody> 
	
									      <tr style="border-top:2px solid white">
										    <c:forEach items="${project.value}" var="items" begin="0" step="2">
										      <td style = "padding-right:15px">
												<c:out value="${items.catalogueName}" />
			   							        <c:set var="totalProgressPercent" value="${items.progressPercentIs + totalProgressPercent}"/>
										        <div class="progress horizontal wide">
													<div id="myProgress" class="bar text-centered-1" data-percentage="${items.progressPercentIs}"></div>
												</div>
											  </td>
										    </c:forEach>
										   </tr>
	
										   <tr style="border-top:2px solid white">
										    <c:forEach items="${project.value}" var="items" begin="1" step="2">
										      <td style = "padding-right:15px">
												<c:out value="${items.catalogueName}" />
			   							        <c:set var="totalProgressPercent" value="${items.progressPercentIs + totalProgressPercent}"/>
										        <div class="progress horizontal wide">
													<div id="myProgress" class="bar text-centered-1" data-percentage="${items.progressPercentIs}"></div>
												</div>
											  </td>
										    </c:forEach>
										   </tr>
	
									   </tbody>
									</table>
	
									<c:set var="nrOfCatalogs" value="${fn:length(project.value)}" />
									<c:set var="overallProgressPercent" value="${totalProgressPercent / nrOfCatalogs}" />
									<fmt:setLocale value="en_US" scope="session"/>
									Overall training progress: <b><fmt:formatNumber value="${overallProgressPercent}" pattern="0.0"/>%</b>
	
									<div>
										<br>
										<i><b>Performed number of operations:</b></i>
										<br>
										 <c:forEach items="${project.value}" var="items">
										 	<c:out value="${items.catalogueName}" />: <c:out value="${items.completedOpNumber}" /> 
										 	 / <c:out value="${items.totalOpNumber}" /> <br>
										 </c:forEach>
									</div>
						      </div>
						    </div>
						</div>
					 </c:forEach>
					</div>
	
	              </div>
	            </div>
	            
	        </div>
        </c:if>
        
        
        
        
        
        
        <c:if test="${userRole == 'ROLE_USER' }"> 	
        	<table  class="homepageTable" style="width:100%;">
        		<tr>
        		<td style="width:50px;"></td>
        		<td style="width:1080px;">
		    		<legend class="legendFont">Resident Detail</legend>
		    	</td>
		    	<td class="buttonRight"></td>
			    <td style="width:50px;"></td>
		    	</tr>
			</table>
        	<div class="centeredTableNoTop" style="width:1100px;">
	        	<!-- counts residents in list  -->
				<c:set var="count" value="2000" />
				<!-- all residents are wrapped in an group that manages which body is visible -->
		        <c:forEach items="${thisProject}" var="project"> <!-- in this case this loop should run for only once -->
					  <!-- unique id for each project -->
					  <c:set var="collapseResident" value="collapseResident${count}" />
					  <c:set var="generateProgress" value="generateProgress${count}" />
					  <script>
						$(document).ready(function() {
					       	$('#${generateProgress}').on('click', function(event) {        	
					       		$('#${collapseResident} .progress .bar.text-centered-1').progressbar({
					       			update: function(current_percentage) { $('#v-callback-update-1').text(current_percentage); },
					       			done: function(current_percentage) { $('#v-callback-done-1').text('done!'); },
					       			display_text: 2
					       			}); 
					       	}); 
					 	});
					  </script>
					
					  <div class="singleProject">
					      	<c:if test="${project.value[0].overdue}">
						      	<div class="alert alert-error	">
								  <button type="button" class="close" data-dismiss="alert">&times;</button>
								  <strong>Warning!</strong>
								   Training duration is not accurate, decision support cannot be provided for this resident.
								   Please change the duration or deactivate the resident.	
								</div>
						 	</c:if>
						 	Name: <b style="font-size:16px;"> <c:out value="${project.key.person.name}" /> </b>
					       	<font style="padding-left:30px;">First Name:</font> <b style="font-size:16px;"> <c:out value="${project.key.person.firstName}" /> </b>
							<font style="padding-left:30px;">Nickname: <b style="font-size:16px;"><c:out value="${project.key.person.nickname}" /></b></font>
							<ul class="dropdown nav pull-right" style="text-align: left;">
					                   <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">Manage<b class="caret"></b></a>
					                   <ul class="dropdown-menu" role="menu">
					                     <li role="presentation">
									<a role="menuitem" tabindex="-1" href="${birtURL}/frameset?__report=Generated_Status.rptdesign&projectID=${project.key.project.projectID}" target="_blank">View operations</a>
					                     </li>
					                     <li role="presentation">
					                     	<a role="menuitem" tabindex="-1" href="${birtURL}/run?__pageoverflow=2&__report=Generated_status.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&projectID=${project.key.project.projectID}">Download operations</a>
					                     </li>
					                     <li role="presentation" class="divider"></li>
					                     <li role="presentation">
					                    		<!-- Button to trigger modal to edit Person Information -->
							    	<c:set var="myEditPersonURL" value="editPerson${count}" />
									<a role="menuitem" tabindex="-1" href="#${myEditPersonURL}" role="button" data-toggle="modal">Edit</a>
					                     </li>
					                     <li role="presentation">
					                    		<!-- Button to trigger modal for entering the vacation for the current project -->
							    	<c:set var="myOnVacationUrl" value="onVacationResident${count}" />
									<a role="menuitem" tabindex="-1" href="#${myOnVacationUrl}" role="button" data-toggle="modal"> 
									Vacation leave 
									</a> 
					                     </li>
					                     <li role="presentation">
					                      	<!-- Button to trigger modal for deactivating the current project -->
							    	<c:set var="myDeactivateURL" value="deactivateResident${count}" />
									<a role="menuitem" tabindex="-1" href="#${myDeactivateURL}" role="button" data-toggle="modal"> 
									Deactivate 
									</a> 
					                      </li>
					                   </ul>
					                 </ul>
					
							<!-- Generate the URL with the dSuppOpId -->
							<c:url var="editPersonURL" value="../administration/progress/editPersonInformation?id=${project.key.project.projectID}" />
						    <form method="POST" action="${editPersonURL}">
					
							    <!------------------------------------- Modal for editing the current person ------------------------------------------------>
						    <div id="${myEditPersonURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							        <div class="modal-header">
							            <a class="close" data-dismiss="modal">×</a>
									    <h3 id="myModalLabel"> Edit person </h3>
								    </div>
							      	<div class="modal-body" style="text-align:left;">
										<br/>
										<table>
											<tr>
												<td class="tdCatalogueType1" style="vertical-align:baseline;">
													<label class="control-label" > Title: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="title" type="text"  value="${project.key.person.title}" required/> 
									             	</div>
									              </div>
									            </td>
									        </tr>
											<tr>
												<td class="tdCatalogueType1" style="vertical-align:baseline;">
													<label class="control-label" > Name: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="name" type="text" value="${project.key.person.name}" required/> 
									             	</div>
									              </div>
									            </td>
								            </tr>
								            <tr>
								            	<td class="tdCatalogueType1" style="vertical-align:baseline;">
												<label class="control-label" > First Name: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="firstName" type="text" value="${project.key.person.firstName}" required/> 
									             	</div>
									              </div>
									            </td>
									        </tr>
									        <tr>
									        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
													<label class="control-label" > Function: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="function" type="text" value="${project.key.person.function}" required/> 
									             	</div>
									              </div>
									            </td>
									        </tr>
									        <tr>
							            		<td class="tdCatalogueType1" style="vertical-align:baseline;">
												<label class="control-label" > Nickname: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="nickname" type="text" value="${project.key.person.nickname}" required disabled/> 
									             	</div>
									              </div>
									            </td>
								       		</tr>
								       		<tr>
									            <td class="tdCatalogueType1"> Start date: </td>
									            <td>
									            	<div class="input-append date" id="dp3" data-date="${project.key.project.startDate}" data-date-format="dd-mm-yyyy">
														<input name="startDate" class="span2" size="16" type="text" readonly="" value="${project.key.project.startDate}" disabled>
														<span class="add-on"><i class="icon-th"></i></span>
													</div>
									           	</td> 
									        </tr>
									        <tr>
									        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
													<label class="control-label" > Duration: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="duration" min="1" max="200" type="number" value="${project.key.project.duration}" required/> 
									             	</div>
									              </div>
									            </td>
									        </tr>	
									        <tr>
									        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
													<label class="control-label" > Capacity: </label>
												</td>
												<td style="vertical-align:baseline;">
									              <div class="control-group">
									              	<div class="controls">
										            	<input name="capacity" min="1" max="200" type="number" value="${project.key.project.capacity}" required/> 
									             	</div>
									              </div>
									            </td>
									        </tr>		
							            </table>
							        </div>
							        <div class="modal-footer">
							            <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
							            <input type="submit" value="Save" class="btn btn-primary" />
							        </div>
						    </div>
						    </form>
						    <!------------------------------------- End Modal for editing the current person ------------------------------------------------>
					
							<!-- Deactivate for each project -->
							<!-- Generate the URL with the projectID -->
							<c:url var="DeactivateUrl" value="../administration/progress/deactivate?id=${project.key.project.projectID}" />
							<form method="POST" action="${DeactivateUrl}">								    
									<!-- Modal for deactivating the current project -->
								<div id="${myDeactivateURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-header">
									    	<a class="close" data-dismiss="modal">×</a>
											<h3 id="myModalLabel"> Deactivate </h3>
										</div>
					
									    <div class="modal-body" style="text-align:left;">
											<br/>
											<p> 
												Do you want to deactivate resident
												 <c:out value="${project.key.person.name}" /> 
												 <c:out value="${project.key.person.firstName}" />?
											   	<br/>
										    </p>
									    </div>
					
									    <div class="modal-footer">
										    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
										    <input type="submit" value="Deactivate" class="btn btn-primary" />
									    </div>
								</div>
							</form>
					
							<!-- Enter Vacation for each project -->
							<!-- Generate the URL with the projectID -->
							<c:url var="OnVacationUrl" value="../administration/progress/onVacation?id=${project.key.project.projectID}" />
							<form method="POST" action="${OnVacationUrl}">								    
									<!-- Modal for deactivating the current project -->
								<div id="${myOnVacationUrl}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-header">
									    	<a class="close" data-dismiss="modal">×</a>
											<h3 id="myModalLabel"> Enter vacation for resident </h3>
										</div>
					
									    <div class="modal-body" style="text-align:left;">
											<br/>
											<p> 
												Please enter return date from vacation for
												 <c:out value="${project.key.person.name}" /> 
												 <c:out value="${project.key.person.firstName}" />.
											   	<br/>
										    </p>
										    <div class="input-append date datepicker" id="dpOnVacation" data-date='<%=  pickerFormatter.format(new Date()) %>' data-date-format="dd-mm-yyyy" style="width:60px">
												<input name="untilDate" class="span2" size="16" type="text" readonly="" value='<%=  pickerFormatter.format(new Date()) %>'>
												<span class="add-on"><i class="icon-th"></i></span>
											</div>
									    </div>
					
									    <div class="modal-footer">
										    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
										    <input type="submit" value="Save" class="btn btn-primary" />
									    </div>
								</div>
							</form>
					
					      	Start Date: <fmt:formatDate pattern="dd.MM.yyyy" value="${project.key.project.startDate}" />
					      	<font style="padding-left:30px">Duration:</font> <c:out value="${project.key.project.duration}" /> months
					      	<font style="padding-left:30px">Capacity:</font> <c:out value="${project.key.project.capacity}" /> operations/month 
					
					      	<br>
					      	<br>
					
					    			<c:set var="totalProgressPercent" value="0"/>
					    			<c:set var="expectedProgressPercent" value="0"/>
					      	<table>
						      <tbody> 
					
							      <tr style="border-top:2px solid white">
								    <c:forEach items="${project.value}" var="items" begin="0" step="2">
								      <td style = "padding-right:15px">
										<c:out value="${items.catalogueName}" />
											        <c:set var="totalProgressPercent" value="${items.progressPercentIs + totalProgressPercent}"/>
								        <c:set var="expectedProgressPercent" value="${items.progressPercentShouldBe + expectedProgressPercent}"/>
								        <div class="progress horizontal wide">
											<div id="myProgress" class="bar text-centered-1" data-percentage="${items.progressPercentIs}"></div>
										</div>
										<br>
									  </td>
								    </c:forEach>
								   </tr>
					
								   <tr style="border-top:2px solid white">
								    <c:forEach items="${project.value}" var="items" begin="1" step="2">
								      <td style = "padding-right:15px">
										<c:out value="${items.catalogueName}" />
											        <c:set var="totalProgressPercent" value="${items.progressPercentIs + totalProgressPercent}"/>
								        <c:set var="expectedProgressPercent" value="${items.progressPercentShouldBe + expectedProgressPercent}"/>
								        <div class="progress horizontal wide">
											<div id="myProgress" class="bar text-centered-1" data-percentage="${items.progressPercentIs}"></div>
										</div>
										<br>
									  </td>
								    </c:forEach>
								   </tr>
					
							   </tbody>
							</table>
					
							<c:set var="nrOfCatalogs" value="${fn:length(project.value)}" />
							<c:set var="totalProgressPercent" value="${totalProgressPercent / nrOfCatalogs}" />
							<c:set var="expectedProgressPercent" value="${expectedProgressPercent / nrOfCatalogs}" />
							<fmt:setLocale value="en_US" scope="session"/>
							Overall training progress: <b><fmt:formatNumber value="${totalProgressPercent}" pattern="0.0"/>%</b>
							<c:if test="${expectedProgressPercent > 100 }">
								<c:set var="expectedProgressPercent" value="100" />
							</c:if>
							<i>(expected training progress: <fmt:formatNumber value="${expectedProgressPercent}" pattern="0.0"/>%)</i>
					
							<div>
								<br>
								<i><b>Performed number of operations:</b></i>
								<br>
								 <c:forEach items="${project.value}" var="items">
								 	<c:out value="${items.catalogueName}" />: <c:out value="${items.completedOpNumber}" /> 
								 	 / <c:out value="${items.totalOpNumber}" /> <br>
								 </c:forEach>
							</div>
					</div>
					<br /><br />
					<legend>Difficult Operations</legend>
					<br />
					<table class="table table-hover" style="width:100%;">
						<thead>
						<tr>
							<!-- th>ID</th -->
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
						
							<!-- First decide even if we need to show this row, check : does the user actually contribute to the difficult opetation(opsco)? -->
							<c:set var="noOfActualDiffOperationForThisUser" value="0"/>
							<c:if test="${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
								<c:set var="noOfActualDiffOperationForThisUser" value="${noOfActualDiffOperationForThisUser + 1}"/>
							</c:if>
							<c:if test="${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
								<c:set var="noOfActualDiffOperationForThisUser" value="${noOfActualDiffOperationForThisUser + 1}"/>
							</c:if>
							<c:if test="${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
								<c:set var="noOfActualDiffOperationForThisUser" value="${noOfActualDiffOperationForThisUser + 1}"/>
							</c:if>
							<c:if test="${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
								<c:set var="noOfActualDiffOperationForThisUser" value="${noOfActualDiffOperationForThisUser + 1}"/>
							</c:if>
							<c:if test="${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
								<c:set var="noOfActualDiffOperationForThisUser" value="${noOfActualDiffOperationForThisUser + 1}"/>
							</c:if>
							<c:if test="${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
								<c:set var="noOfActualDiffOperationForThisUser" value="${noOfActualDiffOperationForThisUser + 1}"/>
							</c:if>
							<!-- check end -->
							
							<c:if test="${noOfActualDiffOperationForThisUser > 0 }">
								<c:url var="chooseDiffOpUrl" value="../administration/decisionsupport/updateChosenDiffOp" />
				    			<form class="chooseDiffOpForm" method="POST" action="${chooseDiffOpUrl}">
				    			<input type="hidden" name="diffSuppOpId" value="${difficultOperation.dSuppOpId}">
								<tr>
									<!-- td>${difficultOperation.dSuppOpId}</td -->
									<td><fmt:formatDate pattern="dd-MM-yyyy" value="${difficultOperation.opDate}" /></td>
									<td>
										${difficultOperation.opsc1}
										<c:if test="${difficultOperation.OPSC01Difficulty == 2}">
											(Difficult)
										</c:if>
									</td>
									<td>
										${difficultOperation.opsc2}
										<c:if test="${difficultOperation.OPSC02Difficulty == 2}">
											(Difficult)
										</c:if>
									</td>
									<td>${difficultOperation.op1}</td>
									<td>${difficultOperation.op2}</td>
									<td>${difficultOperation.ass1}</td>
									<td>
										<c:if test="${difficultOperation.op1 == nameUser}">
											Op1<input type="hidden" name="operatedAs" value="Op1">
										</c:if> 
										<c:if test="${difficultOperation.op2 == nameUser}">
											Op2<input type="hidden" name="operatedAs" value="Op2">
										</c:if> 
										<c:if test="${difficultOperation.ass1 == nameUser}">
											Ass1<input type="hidden" name="operatedAs" value="Ass1">
										</c:if>
										
									</td>
									
									<td>
										<c:if test="${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
											<input type="checkbox" name="opscToCount" value="OPSC01" <c:if test="${fn:contains(difficultOperation.OP1ChosenDifficult, 'OPSC01')}"> checked </c:if> > OPSC01 
										</c:if>
										<c:if test="${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
											<input type="checkbox" name="opscToCount" value="OPSC02" <c:if test="${fn:contains(difficultOperation.OP1ChosenDifficult, 'OPSC02')}"> checked </c:if> > OPSC02 
										</c:if>
										
										<c:if test="${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
											<input type="checkbox" name="opscToCount" value="OPSC01" <c:if test="${fn:contains(difficultOperation.OP2ChosenDifficult, 'OPSC01')}"> checked </c:if> > OPSC01 
										</c:if>
										<c:if test="${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
											<input type="checkbox" name="opscToCount" value="OPSC02" <c:if test="${fn:contains(difficultOperation.OP2ChosenDifficult, 'OPSC02')}"> checked </c:if> > OPSC02 
										</c:if>
										
										<c:if test="${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}">
											<input type="checkbox" name="opscToCount" value="OPSC01" <c:if test="${fn:contains(difficultOperation.Ass1ChosenDifficult, 'OPSC01')}"> checked </c:if> > OPSC01 
										</c:if>
										
										<c:if test="${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}">
											<input type="checkbox" name="opscToCount" value="OPSC02" <c:if test="${fn:contains(difficultOperation.Ass1ChosenDifficult, 'OPSC02')}"> checked </c:if> > OPSC02 
										</c:if>
									</td>
									<td><input type="submit" value="Save" class="btn btn-primary"></td>
								</tr>
								</form>
							</c:if>
						</c:forEach> 
						</tbody>
					</table>
					
				</c:forEach>
				
				</div>
		</c:if>
		<br/>
		<br/>

		<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	

	</div>
	<div style = "height:30px"></div>
</body>
</html>