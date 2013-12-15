<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<link href="../resources/bootstrap/extension/datepicker.css" rel="stylesheet"/>

<script src="../resources/bootstrap/extension/bootstrap-datepicker.js"></script>
<script src="<c:url value='/scheduler/resources/js/jqBootstrapValidation.js'/>"></script>
<script src="<c:url value='/scheduler/resources/js/jquery.cookie.js'/>"></script>


<script>
$(document).ready(function () {
	$("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); 
	$("#zebraTable tr:nth-child(even)").addClass("zerba");
	
	/*Sakib [*/
	$(".catalogue1, .catalogue2").hide();
	
	//Empty checking for Ops code mapping
	$( "#addOperationForm" ).submit(function( event ) {
		if($.trim($("#firstOpscode").val()).length) {
			if(parseInt($("#catalogueForFirstOpscode").val()) <= 0) {
				return false;
			}
		}
		if($.trim($("#secondOpscode").val()).length) {
			if(parseInt($("#catalogueForSecondOpscode").val()) <= 0) {
				return false;
			}
		}
		return true;
	});
	
	//For First OpsCode
	$( "#firstOpscode" ).blur(function() {
		if($.trim($("#firstOpscode").val()).length) {
			var psValue1 = $.trim($("#firstOpscode").val());
			$.ajax({
			    url: "../administration/decisionsupport/checkmapping",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
			    data : "psValue=" + psValue1,
			    type: "POST",//request type, can be GET
			    cache: false,//do not cache returned data
			}).done(function(data) {
				// -1 : PSCode doesn't exist, 0 : Catalogue not mapped yet, others : Catalogue already mapped
				if(data == "-1" || data == "0") {
					$("#catalogueForFirstOpscode").find('option:selected').removeAttr("selected");
					// ask user to set catalogue
					$(".mappingSuggestion1").html("Select a Catalogue").css("color","#aa0000");
				} else {
					$("#catalogueForFirstOpscode").val(data);
					$(".mappingSuggestion1").html("Catalogue found").css("color","#00aa00");
				}
			});
			$(".catalogue1").show();
		}
		else $(".catalogue1").hide();
	});
	$( "#catalogueForFirstOpscode" ).change(function() {
		if(parseInt($("#catalogueForFirstOpscode").val()) > 0) {
			$(".mappingSuggestion1").html("Updating Catalogue...").css("color","#00aa00");
			var clValue1 = $("#catalogueForFirstOpscode").val();
			var psValue1 = $.trim($("#firstOpscode").val());
			$.ajax({
			    url: "../administration/decisionsupport/updatemapping",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
			    data : "psValue=" + psValue1 + "&clValue=" + clValue1,
			    type: "POST",//request type, can be GET
			    cache: false,//do not cache returned data
			}).done(function(data) {
				// 0 : Internal error, others : Catalogue already mapped
				if(data == "-1") {
					$("#catalogueForFirstOpscode").find('option:selected').removeAttr("selected");
					// ask user to set catalogue
					$(".mappingSuggestion1").html("Internal server error").css("color","#aa0000");
				} else {
					//$("#catalogueForFirstOpscode").val(data);
					$(".mappingSuggestion1").html("Catalogue updated").css("color","#00aa00");
				}
			});
		} else {
			// ask user to set catalogue
			$(".mappingSuggestion1").html("Select a Catalogue").css("color","#aa0000");
		}
	});
	
	//For second OpsCode
	$( "#secondOpscode" ).blur(function() {
		if($.trim($("#secondOpscode").val()).length) {
			var psValue2 = $.trim($("#secondOpscode").val());
			$.ajax({
			    url: "../administration/decisionsupport/checkmapping",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
			    data : "psValue=" + psValue2,
			    type: "POST",//request type, can be GET
			    cache: false,//do not cache returned data
			}).done(function(data) {
				// -1 : PSCode doesn't exist, 0 : Catalogue not mapped yet, others : Catalogue already mapped
				if(data == "-1" || data == "0") {
					$("#catalogueForSecondOpscode").find('option:selected').removeAttr("selected");
					// ask user to set catalogue
					$(".mappingSuggestion2").html("Select a Catalogue").css("color","#aa0000");
				} else {
					$("#catalogueForSecondOpscode").val(data);
					$(".mappingSuggestion2").html("Catalogue found").css("color","#00aa00");
				}
			});
			$(".catalogue2").show();
		}
		else $(".catalogue2").hide();
	});
	$( "#catalogueForSecondOpscode" ).change(function() {
		if(parseInt($("#catalogueForSecondOpscode").val()) > 0) {
			$(".mappingSuggestion2").html("Updating Catalogue...").css("color","#00aa00");
			var clValue2 = $("#catalogueForSecondOpscode").val();
			var psValue2 = $.trim($("#secondOpscode").val());
			$.ajax({
			    url: "../administration/decisionsupport/updatemapping",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
			    data : "psValue=" + psValue2 + "&clValue=" + clValue2,
			    type: "POST",//request type, can be GET
			    cache: false,//do not cache returned data
			}).done(function(data) {
				// 0 : Internal error, others : Catalogue already mapped
				if(data == "-1") {
					$("#catalogueForSecondOpscode").find('option:selected').removeAttr("selected");
					// ask user to set catalogue
					$(".mappingSuggestion2").html("Internal server error").css("color","#aa0000");
				} else {
					//$("#catalogueForFirstOpscode").val(data);
					$(".mappingSuggestion2").html("Catalogue updated").css("color","#00aa00");
				}
			});
		} else {
			// ask user to set catalogue
			$(".mappingSuggestion2").html("Select a Catalogue").css("color","#aa0000");
		}
	});
	/*Sakib ]*/
} );
$(document).ready(
		function() {
			$('.datepicker').datepicker();
		});
$(function(){
	$('.tooltip-test').tooltip();
});
</script>


<head>
	<title>Decision support</title>
</head>
	
<%
	DateFormat pickerFormatter = new SimpleDateFormat("dd-MM-yyyy");
%>

<body>
	<div class="wrap">
	
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="Decision Support"/>		
								
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
			
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>
		
		<table  class="homepageTable" style="width:100%;">
		    <tr>					
				<td style="width:50px;"/>
				<td style="width:950px;">
		    		<legend class="legendFont">Decision Support</legend>
		    	</td>
		   		<td class="buttonRight">

					<!-- Button to trigger modal for adding a new operation -->
					<a href="#myAddURL" class="btn btn-primary" role="button" data-toggle="modal"> Add Operation </a>
					
					<!-- URL for adding the operation; the new values will be available in controller using parameters -->
					<c:url var="addUrl" value="../administration/decisionsupport/add" />
				    <form id="addOperationForm" method="POST" action="${addUrl}">

					<!-- Modal for adding a new catalogue -->						    
				    <div id="myAddURL" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					        <div class="modal-header">
					            <a class="close" data-dismiss="modal">×</a>
							    <h3 id="myModalLabel" style="text-align:left"> Add Operation </h3>
						    </div>
						    
					        <div class="modal-body" style="text-align:left;">
								<br/>
								<div style="vertical-align:baseline;">
									<span id="editSpan">OPSC01:</span>
									<span style="vertical-align:baseline;">
										<span class="control-group">
								        	<span class="controls">
												<input id="firstOpscode" name="opsc1Add" type="text" placeholder="Type code..."  required/> 
									     	</span>
							            </span>
						            </span>
						            <span class="catalogue1" id="editSpan">Catalogue:</span>
									<span class="catalogue1" style="vertical-align:baseline;">
										<span class="control-group">
								        	<span class="controls">
												<c:if test="${filteredOpCatalogues != null}">
													<select id="catalogueForFirstOpscode" name="catalogueForFirstOpscode" >
														<option value="-1">&nbsp;</option>
														<c:forEach items="${filteredOpCatalogues}" var="opCatalogue">  
															<option value="${opCatalogue.catalogueID}"><c:out value="${opCatalogue.name}"/></option>
												     	</c:forEach> 
											     	</select> 
											     	<span class="mappingSuggestion1 miniSugg"></span>
										     	</c:if> 
									     	</span>
							            </span>
						            </span>
						            <span class="catalogue1" id="editSpan">Difficulty:</span>
									<span class="catalogue1">
										<span class="control-group">
								        	<span class="controls">
												<input type="radio" name="difficultyForFirstOpscode" value="1" checked> Normal &nbsp;&nbsp;
												<input type="radio" name="difficultyForFirstOpscode" value="2"> Difficult
									     	</span>
							            </span>
							            <br />
						            </span>
									<span id="editSpan">OPSC02:</span>
									<span style="vertical-align:baseline;">
						            	<span class="control-group">
							              	<span class="controls">
								            	<input id="secondOpscode" name="opsc2Add" type="text" placeholder="Type code..." />
							             	</span>
							            </span>
						            </span>
						            <span class="catalogue2" id="editSpan">Catalogue</span>
									<span class="catalogue2" style="vertical-align:baseline;">
										<span class="control-group">
								        	<span class="controls">
								        		<c:if test="${filteredOpCatalogues != null}">
													<select id="catalogueForSecondOpscode" name="catalogueForSecondOpscode" >
														<option value="-1">&nbsp;</option>
														<c:forEach items="${filteredOpCatalogues}" var="opCatalogue">  
															<option value="${opCatalogue.catalogueID}"><c:out value="${opCatalogue.name}"/></option>
												     	</c:forEach> 
											     	</select> 
											     	<span class="mappingSuggestion2 miniSugg"></span>
										     	</c:if> 
									     	</span>
							            </span>
						            </span>
						            <span class="catalogue2" id="editSpan">Difficulty:</span>
									<span class="catalogue2">
										<span class="control-group">
								        	<span class="controls">
												<input type="radio" name="difficultyForSecondOpscode" value="1" checked> Normal &nbsp;&nbsp;
												<input type="radio" name="difficultyForSecondOpscode" value="2"> Difficult
									     	</span>
							            </span>
							            <br />
						            </span>
						            <span id="editSpan">Operation date:</span>
						            <span style="vertical-align:baseline;">
							           	<span class="input-append date datepicker" id="dpOperationDate" data-date='<%=  pickerFormatter.format(new Date()) %>' data-date-format="dd-mm-yyyy">
											  <input name="opDateAdd" class="span2" size="16" type="text" readonly="" value='<%=  pickerFormatter.format(new Date()) %>'>
											  <span class="add-on"><i class="icon-th"></i></span>
							           	</span>
									</span> 
						           	<br><br>
									<span id="editSpan">Op1:</span>
									<span style="vertical-align:baseline;">
						            	<span class="control-group">
							            	<span class="controls">
								            	<c:if test="${nicknames != null}">
													<select name="op1Add" required>
														<c:forEach items="${nicknames}" var="nickname">  
															<option value="${nickname}"><c:out value="${nickname}"/></option>
												     	</c:forEach> 
											     	</select> 
							             			<span class="sub-controls">
											     		<input type="checkbox" name="opscToCountForOp1" value="OPSC01"> OPSC01
														<input type="checkbox" name="opscToCountForOp1" value="OPSC02"> OPSC02 
													</span>
										     	</c:if> 
							             	</span>
										</span>
						            </span>
									<span id="editSpan">Op2:</span>
									<span style="vertical-align:baseline;">
						            	<span class="control-group">
							              	<span class="controls">
								            	<c:if test="${nicknames != null}">
													<select name="op2Add">
														<c:forEach items="${nicknames}" var="nickname">  
															<option value="${nickname}"><c:out value="${nickname}"/></option>
												     	</c:forEach> 
											     	</select> 
											     	<span class="sub-controls">
											     		<input type="checkbox" name="opscToCountForOp2" value="OPSC01"> OPSC01
														<input type="checkbox" name="opscToCountForOp2" value="OPSC02"> OPSC02 
													</span>
										     	</c:if>  
							             	</span>
										</span>
						            </span>
									<span id="editSpan">Ass1:</span>
									<span style="vertical-align:baseline;">
										<span class="control-group">
							              	<span class="controls">
												<c:if test="${nicknames != null}">
													<select name="ass1Add">
														<c:forEach items="${nicknames}" var="nickname">  
															<option value="${nickname}"><c:out value="${nickname}"/></option>
												     	</c:forEach> 
											     	</select> 
											     	<span class="sub-controls">
											     		<input type="checkbox" name="opscToCountForAss1" value="OPSC01"> OPSC01
														<input type="checkbox" name="opscToCountForAss1" value="OPSC02"> OPSC02 
													</span>
										     	</c:if> 										             	
										     </span>
							              </span>
									</span>
								</div>
					        </div>
					        
					        <div class="modal-footer">
					            <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
					            <input type="submit" value="Add" class="btn btn-primary" />
					        </div>
				    </div>
				    </form>
				</td>
				<td style="width:50px;"/>
			</tr>
		</table> 

<!-- 
--	Start tabs with List of Recommended Residents + Table of Decision Support Operations
-->
		
		<!-- counts elements in list  -->
		<c:set var="count" value="0" />
		<!-- wrapper for tabs -->
		<div class="centeredTableNoTop" style="width:1100px;">
		
			<!-- tabs for decision and adding operations -->
            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#dSupportResidents" data-toggle="tab">List</a></li>
              <li class=""><a href="#dSupportOperations" data-toggle="tab">Operations</a></li>
            </ul>
            
			<!-- tab content with residents list -->
            <div id="myTabContent" class="tab-content">
			<!-- active tab is the one with residents list -->
              <div class="tab-pane fade active in" id="dSupportResidents">

				<table id="zebraTable" class="table table-hover"  style="width:1100px;">
		 			<thead> 				
						<tr style="font-size:12px">
							<th> </th>
							<th>Catalogue</th>
							<th>Residents</th>
							<th> </th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:forEach items="${residentListForCatalogues}" var="catalog">
							<c:set var="catalogNr" value="catalogNr${count}" />
							<tr>
								<td style="width: 25px;">
									<c:set var="count" value="${count + 1}"/>
									<c:out value="${count}" />
								</td>													
								<td style="width: 150px;"><c:out value="${catalog.key.name}" /></td>
								<td>
									<c:forEach items="${catalog.value}" var="items" begin="0" end="6">
										<c:set var="residentStatus" value="${(items.elapsedMonths/items.duration)-(items.completedOpNumber/items.totalOpNumber)}"/>
										<c:if test="${residentStatus > 0}">
											<span style="color: #FF5640;">
												<b><c:out value="${items.nickname}" /></b>
											</span>
										</c:if>
										<c:if test="${residentStatus <= 0}">
											<span>
												<c:out value="${items.nickname}" />
											</span>
										</c:if>
										<c:if test="${items.overdue}">
											<a class="tooltip-test" data-original-title="Training duration is not accurate. Decision support cannot be provided for this resident. Please change the duration or deactivate the resident.">
												<span class="badge badge-important">!</span>
											</a>
								        </c:if>
										<span style="white-space: pre;">      </span>
									 </c:forEach>
								</td>
								<td style="width: 50px;">
									<!-- Button to trigger modal to view the complete list of residents -->
							    	<c:set var="myResidentListURL" value="residentList${count}" />
									<a href="#${myResidentListURL}" style="font-size:12px;" role="button" data-toggle="modal"> More > </a>
				     
		 						    <!-- Modal for editing the current operation -->
								    <div id="${myResidentListURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								        <div class="modal-header">
								            <a class="close" data-dismiss="modal">×</a>
										    <h3 id="myModalLabel"> Resident Statuses</h3>
									    </div>
										    
								      	<div class="modal-body" style="text-align:left;">
									        <h5>Catalogue: <c:out value="${catalog.key.name}" /> </h5>
									        <br/>
									   		<div style="vertical-align:baseline;">
									            <c:forEach items="${catalog.value}" var="items">
									                <c:set var="tempResidentStatus" scope="session" value="${items.progressPercentShouldBe - items.progressPercentIs}"/>
													<% 
													   Object attribute = pageContext.getSession().getAttribute("tempResidentStatus");
													   Double status = (Double)attribute;
													   NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
													   DecimalFormat formatter = (DecimalFormat)nf;
													   formatter.applyPattern("#0.0");
													   pageContext.setAttribute("residentStatus", Double.parseDouble(formatter.format(status)));
													%>
													<div>
														
														<c:if test="${residentStatus > 0}">
															<span id="moreSpan" style="color: #FF5640;">
																<c:out value="${items.nickname}" />
																<c:if test="${items.overdue}">
																	<a class="tooltip-test" data-placement="right" data-original-title="Training duration is not accurate. Decision support cannot be provided for this resident. Please change the duration or deactivate the resident.">
																		<span class="badge badge-important">!</span>
																	</a>
														        </c:if>
															</span>
														</c:if>
														<c:if test="${residentStatus <= 0}">
															<span id="moreSpan">
																<c:out value="${items.nickname}" />
																<c:if test="${items.overdue}">
															        <a class="tooltip-test" data-placement="right" data-original-title="Training duration is not accurate. Decision support cannot be provided for this resident. Please change the duration or deactivate the resident.">
																		<span class="badge badge-important">!</span>
																	</a>
														        </c:if>
															</span>
														</c:if>
											            <span id="middleSpan" style = "white-space: pre;">  Necessary: <c:out value="${residentStatus}" /> %</span>
											            <span>(expected: <c:out value="${items.progressPercentShouldBe}" />%, completed: <c:out value="${items.progressPercentIs}" />%)</span>
													</div>
												 </c:forEach>
								            </div>
								            <br/>
								            <br/>
								        </div>
								        <div class="modal-footer">
								            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">OK</a>
								        </div>
								    </div>
								</td> 
							</tr>
						</c:forEach>
										
					</tbody>
				</table>
              </div>
     

<!-- 
--	Start tab with Table of Decision Support Operations
-->
         
			  <!-- counts elements in list  -->
			  <c:set var="count" value="0" />
			  <!-- tab for manually added operations -->
              <div class="tab-pane fade in" id="dSupportOperations">

				<table id="zebraTable" class="table table-hover"  style="width:1100px;">
		 			<thead> 				
						<tr style="font-size:12px">
							<th> </th>
							<th>OpDate</th>
							<th>OPSC01</th>
							<th style="color: gray">OPSC01 Catalogue</th>
							<th>OPSC02</th>
							<th>Op1</th>
							<th>Op2</th>
							<th>Ass1</th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:forEach items="${dSupportOperationsList}" var="operation">
							<c:set var="operationNr" value="operationNr${count}" />
							<tr>
								<td>
									<c:set var="count" value="${count + 1}"/>
									<c:out value="${count}" />
								</td>	
												
								<td>
									<fmt:formatDate pattern="dd.MM.yyyy" value="${operation.opDate}" />
								</td>
								<td><c:out value="${operation.opsc1}" /></td>
								<td style="color: gray"><c:out value="${operation.catalogName}" /></td>
								<td><c:out value="${operation.opsc2}" /></td>
								<td><c:out value="${operation.op1}" /></td>
								<td><c:out value="${operation.op2}" /></td>
								<td><c:out value="${operation.ass1}" /></td>
								
								<td>
									<!-- Button to trigger modal to edit operation -->
							    	<c:set var="myEditOperationURL" value="editOperation${count}" />
									<a href="#${myEditOperationURL}" style="font-size:12px;" role="button" data-toggle="modal"> Edit </a>
				     
									<!-- Generate the URL with the dSuppOpId -->
									<c:url var="editOperationURL" value="../administration/decisionsupport/editOperation?id=${operation.dSuppOpId}" />
								    <form method="POST" action="${editOperationURL}">
								    
		 						    <!-- Modal for editing the current operation -->
								    <div id="${myEditOperationURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									        <div class="modal-header">
									            <a class="close" data-dismiss="modal">×</a>
											    <h3 id="myModalLabel"> Edit operation </h3>
										    </div>
										    
									      	<div class="modal-body" style="text-align:left;">
										        <br/>
										   		<div style="vertical-align:baseline;">
													<span id="editSpan">OPSC01:</span>
													<span style="vertical-align:baseline;">
										              <span class="control-group">
										              	<span class="controls">
											            	<input name="opsc1" type="text" placeholder="Type code..."  value="${operation.opsc1}" required/> 
										             	</span>
										              </span>
										            </span>
													<span id="editSpan">OPSC02:</span>
													<span style="vertical-align:baseline;">
										              <span class="control-group">
										              	<span class="controls">
											            	<input name="opsc2" type="text" placeholder="Type code..." value="${operation.opsc2}"/> 
										             	</span>
										              </span>
										            </span>
										            <span id="editSpan">Operation date:</span>
										            <span style="vertical-align:baseline;">
										            	<c:set var="test">
											            	<fmt:formatDate pattern="dd-MM-yyyy" value="${operation.opDate}" />
										            	</c:set>
											           	<span class="input-append date datepicker" id="dpOperationDate" data-date="${test}" data-date-format="dd-mm-yyyy">
														  <input name="opDate" class="span2" size="16" type="text" readonly="" value="${test}">
														  <span class="add-on"><i class="icon-th"></i></span>
											           	</span>
													</span> 
										           	<br><br>
													<span id="editSpan">Op1:</span>
													<span style="vertical-align:baseline;">
										              <span class="control-group">
										              	<span class="controls">
											            	<c:if test="${nicknames != null}">
																<select name="op1">
																	<c:forEach items="${nicknames}" var="nickname">  
																		<c:if test="${operation.op1 == nickname}">
																			<option value="${nickname}" selected="selected"><c:out value="${nickname}"/></option>
																		</c:if>
																		<c:if test="${operation.op1 != nickname}">
																			<option value="${nickname}"><c:out value="${nickname}"/></option>
																		</c:if>
															     	</c:forEach> 
														     	</select> 
													     	</c:if> 
										             	</span>
										              </span>
										            </span>
													<span id="editSpan">Op2:</span>
													<span style="vertical-align:baseline;">
										              <span class="control-group">
										              	<span class="controls">
											            	<c:if test="${nicknames != null}">
																<select name="op2">
																	<c:forEach items="${nicknames}" var="nickname">  
																		<c:if test="${operation.op2 == nickname}">
																			<option value="${nickname}" selected="selected"><c:out value="${nickname}"/></option>
																		</c:if>
																		<c:if test="${operation.op2 != nickname}">
																			<option value="${nickname}"><c:out value="${nickname}"/></option>
																		</c:if>
															     	</c:forEach> 
														     	</select> 
													     	</c:if>  
										             	</span>
										              </span>
										            </span>
													<span id="editSpan">Ass1:</span>
													<span style="vertical-align:baseline;">
										              <span class="control-group">
										              	<span class="controls">
															<c:if test="${nicknames != null}">
																<select name="ass1">
																	<c:forEach items="${nicknames}" var="nickname">  
																		<c:if test="${operation.ass1 == nickname}">
																			<option value="${nickname}" selected="selected"><c:out value="${nickname}"/></option>
																		</c:if>
																		<c:if test="${operation.ass1 != nickname}">
																			<option value="${nickname}"><c:out value="${nickname}"/></option>
																		</c:if>
															     	</c:forEach> 
														     	</select> 
													     	</c:if> 										             	</span>
										              </span>
										            </span>
									            </div>
									        </div>
									        <div class="modal-footer">
									            <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
									            <input type="submit" value="Save" class="btn btn-primary" />
									        </div>
								    </div>
								    </form>
								</td> 
								
								<td> 
									<!-- Button to trigger modal for deleting the current dSuppOpId -->
							    	<c:set var="deleteOperationURL" value="delOperation${count}" />
									<a href="#${deleteOperationURL}" style="font-size:12px;" role="button" data-toggle="modal"> Delete </a>
				     
									<!-- Generate the URL with the dSuppOpId -->
									<c:url var="deleteUrl" value="../administration/decisionsupport/delete?id=${operation.dSuppOpId}" />
								    <form method="POST" action="${deleteUrl}">
								    
		 						    <!-- Modal for deleting the current dSuppOpId -->
								    <div id="${deleteOperationURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									        <div class="modal-header">
									            <a class="close" data-dismiss="modal">×</a>
											    <h3 id="myModalLabel"> Delete </h3>
										    </div>
										    
									        <div class="modal-body" style="text-align:left;">
										        <br/>
										    	<div> 
										    		Are you sure you want to delete operation with <br>
										    		<div>
										    		 	<span class="deleteSpan">OPSC01   </span><strong><c:out value="${operation.opsc1}" /></strong>
										    		 	
										    		 	<c:if test="${operation.opsc2 != ''}">
											    		 	<br><span class="deleteSpan">OPSC02   </span><strong><c:out value="${operation.opsc2}" /></strong>
										    		 	</c:if>		
										    		 								    		 	
										    		 	<br><span class="deleteSpan">OpDate   </span><strong><fmt:formatDate pattern="dd.MM.yyyy" value="${operation.opDate}" /></strong>
										    		 	
										    		 	<br><span class="deleteSpan">Op1   </span><strong><c:out value="${operation.op1}" /></strong>
										    		 	
										    		 	<c:if test="${operation.op2 != ''}">
											    		 	<br><span class="deleteSpan">Op2   </span><strong><c:out value="${operation.op2}" /></strong>
										    		 	</c:if>
										    		 	
										    		 	<c:if test="${operation.ass1 != ''}">
											    		 	<br><span class="deleteSpan">Ass1   </span><strong><c:out value="${operation.ass1}" /></strong> 
										    		 	</c:if>
										    		 	
										    		 	<span style="white-space: pre;">    ?</span>
											   			<br/>
										   			</div>
									            </div>
									        </div>
									        
									        <div class="modal-footer">
									            <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
									            <input type="submit" value="Delete" class="btn btn-primary" />
									        </div>
								    </div>
								    </form>
								</td>
								
							</tr>
						</c:forEach>
										
					</tbody>
				</table>
              </div>
            </div>
            
        </div>
<!-- 
--	End tabs with List of Recommended Residents + Table of Decision Support Operations
-->
		<div style="height:300px"> </div>

		<jsp:include page="/WEB-INF/jsp/common/footer.jspf"/>	
			
	</div>
	<div style = "height:30px"></div>
</body>
</html>