<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
	<title>CRUD Operation</title>
</head>
	
<body>
	<div class="wrap">
	
		<%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>		
		<c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
		<c:set var="headerViewAdministration" value="../administration/home" scope="session"/>		
		<c:set var="headerModule" value="CRUD Operation"/>		
								
		<c:remove var="headerViewSchedule" scope="session"/>	
		<c:remove var="headerGoAdministration" scope="session"/>	
			
		<%@include file="/WEB-INF/jsp/common/header.jspf"%>
		
					<!-- User Management CRUD Operation -->
		  
		
		<table id="zebraTable" class="table table-hover centeredTableNoTop"  style="width:1100px;">
 			<thead> 				
				<tr style="font-size:12px">
					<th>UserID</th>
					<th>Active</th>
					<th>Username</th>
					<th>Password</th>
					<th>User Role</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${userDetail}">
					<tr>
						<td><c:out value="${user.usrId}" /></td>					
						<td><c:out value="${user.active}" /></td>
						<td><c:out value="${user.userName}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.userRole}" /></td>
						<td>  
    						<ul class="dropdown nav pull-right" style="text-align: left;">
			                      <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">Manage<b class="caret"></b></a>
			                      <ul class="dropdown-menu" role="menu">
			                        <li role="presentation">
			                        <c:set var="myDeleteURL" value="deleteUser${user.usrId}" />
										<a role="menuitem" tabindex="-1" href="#${myDeleteURL}" role="button" data-toggle="modal"> 
										DELETE 
										</a> 
			                        </li>
			                        <li role="presentation">
			                        <c:set var="myUpdateUserURL" value="updateUser${user.usrId}" />
										<a role="menuitem" tabindex="-1" href="#${myUpdateUserURL}" role="button" data-toggle="modal"> 
										UPDATE 
										</a> 
			                        </li>
			                        </ul>
			                 </ul>
			                 
			                 <!-- Update User Information -->
								<c:url var="updateUserURL" value="../administration/crud/updateUserInformation?id=${user.usrId}" />
							    <form method="POST" action="${updateUserURL}">

	 						    <!------------------------------------- Modal for editing the current person ------------------------------------------------>
							    <div id="${myUpdateUserURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								        <div class="modal-header">
								            <a class="close" data-dismiss="modal">×</a>
										    <h3 id="myModalLabel"> Update User </h3>
									    </div>
								      	<div class="modal-body" style="text-align:left;">
											<br/>
											<table>
												<tr>
													<td class="tdCatalogueType1" style="vertical-align:baseline;">
														<label class="control-label" > Username: </label>
													</td>
													<td style="vertical-align:baseline;">
										              <div class="control-group">
										              	<div class="controls">
											            	<input name="username" type="text"  value="${user.userName}" required/> 
										             	</div>
										              </div>
										            </td>
										        </tr>
												<tr>
													<td class="tdCatalogueType1" style="vertical-align:baseline;">
														<label class="control-label" > Password: </label>
													</td>
													<td style="vertical-align:baseline;">
										              <div class="control-group">
										              	<div class="controls">
											            	<input name="password" type="text" value="${user.password}" required/> 
										             	</div>
										              </div>
										            </td>
									            </tr>
									            <tr>
									            	<td class="tdCatalogueType1" style="vertical-align:baseline;">
														<label class="control-label" > User Role: </label>
													</td>
													<td style="vertical-align:baseline;">
										              <div class="control-group">
										              	<div class="controls">
											            	<select class="input-block-level" id="user_role" name="user_role" >
											            	<c:if test=""></c:if>
																	<option value="ROLE_ADMIN" ${user.userRole == "ROLE_ADMIN" ? 'selected' : ''}>ADMIN</option>
																	<option value="ROLE_INSTRUCTOR" ${user.userRole == "ROLE_INSTRUCTOR" ? 'selected' : ''}>INSTRUCTOR</option>
																	<option value="ROLE_USER" ${user.userRole == "ROLE_USER" ? 'selected' : ''}>USER</option>
															</select> 
										             	</div>
										              </div>
										            </td>
										        </tr>
										        <tr>
										        	<td class="tdCatalogueType1" style="vertical-align:baseline;">
														<label class="control-label" > Activity: </label>
													</td>
													<td style="vertical-align:baseline;">
										              <div class="control-group">
										              	<div class="controls">
											            	<select class="input-block-level" id="activity" name="activity">
																<option value="1" ${user.active == true ? 'selected' : ''}>ACTIVE</option>
																<option value="0" ${user.active == false ? 'selected' : ''}>INACTIVE</option>
															</select> 
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
							    <!------------------------------------- End Modal for Updating the current User ------------------------------------------------>
			                 			                 
			                 <!------------------------------------- Delete Modal for Deleting the current User ------------------------------------------------>

								<!-- Delete User Modal Start-->
								<!-- Generate the URL with the UserId -->
								<c:url var="DeleteUrl" value="../administration/crud/delete?id=${user.usrId}" />
								<form method="POST" action="${DeleteUrl}">								    
			 						<!-- Modal for deactivating the current project -->
									<div id="${myDeleteURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-header">
										    	<a class="close" data-dismiss="modal">×</a>
												<h3 id="myModalLabel"> Delete </h3>
											</div>

										    <div class="modal-body" style="text-align:left;">
												<br/>
												<p> 
													Do you want to delete user
													 <c:out value="${user.userName}" /> ?
												   	<br/>
											    </p>
										    </div>

										    <div class="modal-footer">
											    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
											    <input type="submit" value="Delete" class="btn btn-primary" />
										    </div>
									</div>
								</form>
								<!--Delete User Modal End  -->  
    					</td> 
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