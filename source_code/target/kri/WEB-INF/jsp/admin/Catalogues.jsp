<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common/imports.jspf"%>

<html>

<script
	src="<c:url value='/scheduler/resources/js/jqBootstrapValidation.js'/>"></script>
<script>
	$(document).ready(
			function() {
				$("input,select,textarea").not("[type=submit]")
						.jqBootstrapValidation();
				$("#zebraTable tr:nth-child(even)").addClass("zerba");
			});
</script>

<head>
<title>Catalogues</title>
</head>


<body>
	<div class="wrap">

		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session" />
		<c:set var="headerViewAdministration" value="../administration/home"
			scope="session" />
		<c:set var="headerModule" value="Catalogues" />

		<c:remove var="headerViewSchedule" scope="session" />
		<c:remove var="headerGoAdministration" scope="session" />

		<%@include file="/WEB-INF/jsp/common/header.jspf"%>

		<table class="homepageTable" style="width: 100%;">
			<tr>
				<td style="width: 50px;" />
				<td style="width: 915px;"><legend class="legendFont">Configure
						catalogues</legend></td>
				<td class="buttonRight">
					<!-- Button to trigger modal for adding a new Catalogue --> <a
					href="#myAddTrainURL" class="btn btn-primary" role="button"
					data-toggle="modal"> Add Training System </a> <!-- URL for adding the catalogue; the new values will be available in controller using parameters -->
					<c:url var="addUrl"
						value="../administration/catalogues/addTrainSystem" />
					<form method="POST" action="${addUrl}">

						<!-- Modal for adding a new catalogue -->
						<div id="myAddTrainURL" class="modal hide fade" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-header">
								<a class="close" data-dismiss="modal">×</a>
								<h3 id="myModalLabel" style="text-align: left">New Training
									System</h3>
							</div>

							<div class="modal-body" style="text-align: left;">
								<br />
								<table>
									<tr>
										<td class="tdCatalogueType1" style="vertical-align: baseline;">
											<label class="control-label"> Name Training System: </label>
										</td>
										<td style="vertical-align: baseline;">
											<div class="control-group">
												<div class="controls">
													<input name="trainSysName" type="text"
														placeholder="Type Training System..." required />
												</div>
											</div>
										</td>
									</tr>
								</table>
							</div>

							<div class="modal-footer">
								<a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
								<input type="submit" value="Add" class="btn btn-primary" />
							</div>
						</div>
					</form>
				</td>

				<td style="width: 50px;" />
			</tr>
		</table>
		<!--  Here Accordian for Different Training System Start Added by Anamika-->
		<div class="centeredTableNoTop" style="width: 1100px;">
			<div class="accordion" id="accordion2">
				<c:set var="tName" value="0" />
				<c:forEach items="${opCataloguesByTrain_ID}"
					var="cataloguebyTrainSys">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#${cataloguebyTrainSys.key}">
								${trainSysName[tName]} </a>
							<!-- Here incremented tName -->
						</div>
						<div id="${cataloguebyTrainSys.key}"
							class="accordion-body collapse">
							<div class="accordion-inner">
								<table id="zebraTable"
									class="table table-hover centeredTableNoTop"
									style="width: 100%; margin: 0px;">
									<thead>
										<tr style="font-size: 12px">
											<th></th>
											<th>Name</th>
											<th>Description</th>
											<th>Trunk</th>
											<th style="text-align: center;">easy / normal / hard</th>
											<th style="text-align: center;">Block size</th>
											<th style="text-align: center;">Monthly Capacity</th>
										</tr>
									</thead>
									<tbody>
										<!--  Here is my Catalgue -->
										<c:set var="count" value="0" />
										<c:forEach items="${cataloguebyTrainSys.value}"
											var="catalgueTrainsSys">

											<!-- Iterate each item in the list and display the position and fields -->
											<tr>
												<td><c:set var="count" value="${count + 1}" /> <c:out
														value="${count}" /></td>
												<td><c:out value="${catalgueTrainsSys.name}" /></td>
												<td><c:out value="${catalgueTrainsSys.description}" /></td>
												<td><c:if
														test="${catalgueTrainsSys.specialTrunk == true}">
								Special
							</c:if> <c:if test="${catalgueTrainsSys.specialTrunk == false}">
								Common
							</c:if></td>
												<td style="text-align: center;"><c:out
														value="${catalgueTrainsSys.leve1OpNo}" />/<c:out
														value="${catalgueTrainsSys.leve2OpNo}" />/<c:out
														value="${catalgueTrainsSys.leve3OpNo}" /></td>
												<td style="text-align: center;"><c:out
														value="${catalgueTrainsSys.blockSize}" /></td>
												<td style="text-align: center;">${catalgueTrainsSys.monthlyCapacity}</td>
												<td style="text-align: center;">
													<!-- Button to trigger modal for entering the new block size -->
													<!-- The URL is dynamically set when clicking on the item, this allows a dynamic modal -->
													<c:set var="myURL" value="confCatalog${count}" /> <a
													href="#${myURL}" role="button" style="font-size: 12px;"
													data-toggle="modal"> Configure blocks </a> <!-- Generate the URL with the catalogueID; the new value will be available in controller using parameters -->
													<c:url var="configureUrl"
														value="../administration/catalogues/save?id=${catalgueTrainsSys.catalogueID}" />
													<form method="POST" action="${configureUrl}">

														<!-- Modal for entering the new block size -->
														<div id="${myURL}" class="modal hide fade" tabindex="-1"
															role="dialog" aria-labelledby="myModalLabel"
															aria-hidden="true">
															<div class="modal-header">
																<a class="close" data-dismiss="modal">×</a>
																<h3 id="myModalLabel" style="text-align: left">
																	Configure block size</h3>
															</div>

															<div class="modal-body" style="text-align: left;">
																<br />
																<c:set var="totalNrOperations"
																	value="${catalgueTrainsSys.leve1OpNo + catalgueTrainsSys.leve2OpNo + catalgueTrainsSys.leve3OpNo}" />
																<p>
																	Catalog '
																	<c:out value="${catalgueTrainsSys.name}" />
																	' has a number of
																	<c:out value="${totalNrOperations}" />
																	operations.
																</p>
																<p>
																	Current block size is
																	<c:out value="${catalgueTrainsSys.blockSize}" />
																	.
																</p>
																<br />
																<div class="control-group">
																	<label class="control-label"> New block size: </label>
																	<div class="controls">
																		<input name="newBlockSize" min="1" max="100"
																			type="number" placeholder="Type nr..."
																			style="width: 120px; vertical-align: baseline"
																			required />
																	</div>
																</div>
															</div>

															<div class="modal-footer">
																<a href="#" class="btn" data-dismiss="modal"
																	aria-hidden="true">Cancel</a> <input type="submit"
																	value="Save" class="btn btn-primary" />
															</div>
														</div>
													</form>
												</td>

												<td>
													<!-- Button to trigger modal for configure monthly capacity -->
													<c:set var="myConfigureMonthlyURL"
														value="configureMonthly${count}" /> <a
													href="#${myConfigureMonthlyURL}" style="font-size: 12px;"
													role="button" data-toggle="modal"> Configure capacity </a>
													<!-- Generate the URL with the catalogueID --> <c:url
														var="configureMonthlyCapacityURL"
														value="../administration/catalogues/configureMonthlyCapacity?id=${catalgueTrainsSys.catalogueID}" />
													<form method="POST" action="${configureMonthlyCapacityURL}">

														<!-- Modal for deleting the current catalogue -->
														<div id="${myConfigureMonthlyURL}" class="modal hide fade"
															tabindex="-1" role="dialog"
															aria-labelledby="myModalLabel" aria-hidden="true">
															<div class="modal-header">
																<a class="close" data-dismiss="modal">×</a>
																<h3 id="myModalLabel">Configure monthly capacity of
																	operations</h3>
															</div>

															<div class="modal-body" style="text-align: left;">
																<br />
																<p>
																	Current monthly capacity for catalog
																	${catalgueTrainsSys.name} is
																	<c:out value="${catalgueTrainsSys.monthlyCapacity}" />
																	.
																</p>
																<br />
																<div class="control-group">
																	<label class="control-label"> New monthly
																		capacity: </label>
																	<div class="controls">
																		<input name="newMonthlyCapacity" min="1" max="300"
																			type="number" placeholder="Type nr..."
																			style="width: 120px; vertical-align: baseline"
																			required />
																	</div>
																</div>
															</div>
															<div class="modal-footer">
																<a href="#" class="btn" data-dismiss="modal"
																	aria-hidden="true">Cancel</a> <input type="submit"
																	value="Save" class="btn btn-primary" />
															</div>
														</div>
													</form>
												</td>
												<td><c:if test="${catalgueTrainsSys.allowDelete}">
														<!-- Button to trigger modal for deleting the current catalogue -->
														<c:set var="myDeleteURL" value="delCatalog${count}" />
														<a href="#${myDeleteURL}" style="font-size: 12px;"
															role="button" data-toggle="modal"> Delete </a>
														<!-- Generate the URL with the catalogueID -->
														<c:url var="deleteUrl"
															value="../administration/catalogues/delete?id=${catalgueTrainsSys.catalogueID}" />
														<form method="POST" action="${deleteUrl}">

															<!-- Modal for deleting the current catalogue -->
															<div id="${myDeleteURL}" class="modal hide fade"
																tabindex="-1" role="dialog"
																aria-labelledby="myModalLabel" aria-hidden="true">
																<div class="modal-header">
																	<a class="close" data-dismiss="modal">×</a>
																	<h3 id="myModalLabel">Delete</h3>
																</div>

																<div class="modal-body" style="text-align: left;">
																	<br />
																	<p>
																		Do you want to delete catalog '
																		<c:out value="${catalgueTrainsSys.name}" />
																		' ? <br />
																	</p>
																</div>

																<div class="modal-footer">
																	<a href="#" class="btn" data-dismiss="modal"
																		aria-hidden="true">Cancel</a> <input type="submit"
																		value="Delete" class="btn btn-primary" />
																</div>
															</div>
														</form>
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<br />
								<div>
									<!-- Button to trigger modal for adding a new Catalogue -->
									<c:set var="myAddURL" value="addCatalog${tName}" />
									<a href="#${myAddURL}" class="btn btn-primary" role="button"
										data-toggle="modal"> Add Catalogue </a>
									<!-- URL for adding the catalogue; the new values will be available in controller using parameters -->
									<c:url var="addUrl"
										value="../administration/catalogues/add?id=${trainSysID[tName]}" />
									<form method="POST" action="${addUrl}">
										<!-- Modal for adding a new catalogue -->
										<div id="${myAddURL}" class="modal hide fade" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-header">
												<a class="close" data-dismiss="modal">×</a>
												<h3 id="myModalLabel" style="text-align: left">New
													Catalog</h3>
											</div>

											<div class="modal-body" style="text-align: left;">
												<br />
												<table>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;"><label
															class="control-label"> Name: </label></td>
														<td style="vertical-align: baseline;">
															<div class="control-group">
																<div class="controls">
																	<input name="name" type="text"
																		placeholder="Type name..." required />
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;">Description:</td>
														<td style="vertical-align: baseline;"><textarea
																name="description" type="text"
																placeholder="Type description..." rows="3"></textarea></td>
													</tr>
													<tr style="height: 55px; vertical-align: top;">
														<td></td>
														<td><input name="specialTrunk" type="radio"
															value="true" checked="checked"
															style="vertical-align: baseline" /> Special trunk <br>
															<input name="specialTrunk" type="radio" value="false"
															style="vertical-align: baseline"> Common trunk</td>
													</tr>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;"><label
															class="control-label"> Number of easy operations:
														</label></td>
														<td style="vertical-align: baseline;">
															<div class="control-group">
																<div class="controls">
																	<input name="easy" type="number" min="0" max="150"
																		placeholder="Type nr..."
																		style="width: 120px; vertical-align: baseline"
																		required />
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;"><label
															class="control-label"> Number of normal
																operations: </label></td>
														<td style="vertical-align: baseline;">
															<div class="control-group">
																<div class="controls">
																	<input name="normal" type="number" min="0" max="150"
																		placeholder="Type nr..."
																		style="width: 120px; vertical-align: baseline"
																		required />
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;"><label
															class="control-label"> Number of hard operations:
														</label></td>
														<td style="vertical-align: baseline;">
															<div class="control-group">
																<div class="controls">
																	<input name="hard" type="number" min="0" max="150"
																		placeholder="Type nr..."
																		style="width: 120px; vertical-align: baseline"
																		required />
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;"><label
															class="control-label"> Block size:
														</label></td>
														<td style="vertical-align: baseline;">
															<div class="control-group">
																<div class="controls">
																	<input name="blockSize" type="number" min="1" max="150"
																		placeholder="Type nr..."
																		style="width: 120px; vertical-align: baseline"
																		required />
																</div>
															</div>
														</td>
													</tr>
													<tr>
														<td class="tdCatalogueType1"
															style="vertical-align: baseline;"><label
															class="control-label"> Capacity:
														</label></td>
														<td style="vertical-align: baseline;">
															<div class="control-group">
																<div class="controls">
																	<input name="capacity" type="number" min="0" max="150"
																		placeholder="Type nr..."
																		style="width: 120px; vertical-align: baseline"
																		required />
																</div>
															</div>
														</td>
													</tr>
												</table>
											</div>

											<div class="modal-footer">
												<a href="#" class="btn" data-dismiss="modal"
													aria-hidden="true">Cancel</a> <input type="submit"
													value="Add" class="btn btn-primary" />
											</div>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
					<c:set var="tName" value="${tName + 1}" />
				</c:forEach>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/common/footer.jspf" />

	</div>
	<div style="height: 30px"></div>
</body>
</html>