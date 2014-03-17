<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="../resources/js/jquery-1.8.3.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="<c:url value='/scheduler/resources/js/jqBootstrapValidation.js'/>"></script>
<script src="<c:url value='/scheduler/resources/js/jqEmailValidation.js'/>"></script>

<script src="<c:url value='/scheduler/resources/js/admin.usrmngement.js'/>"></script>

<script type="text/javascript">
$(function(){
	var OK = 0;
	$(".dropdown-toggle").dropdown();
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
        <title>User Management</title>
</head>
        
<body >

        <div class="wrap">
        
                <%-- <c:set var="headerLogout" value="../logout" scope="session"/> --%>                
                <c:set var="headerGoSchedule" value="../schedule/view" scope="session"/>
                <c:set var="headerViewAdministration" value="../administration/home" scope="session"/>                
                <c:set var="headerModule" value="User Management"/>                
                                                                
                <c:remove var="headerViewSchedule" scope="session"/>        
                <c:remove var="headerGoAdministration" scope="session"/>        
                        
                <%@include file="/WEB-INF/jsp/common/header.jspf"%>
                
                <!-- User Management CRUD Operation -->
                  
                <table  class="homepageTable" style="width:100%;">
                    <tr>                                        
                                <td style="width:50px;"/>
                                <td style="width:950px;">
                                    <legend class="legendFont">User Management</legend>
                            </td>
                                   <td class="buttonRight">
                                          <!-- Button to trigger modal for adding a User -->
            <a href="#userRegistration" class="btn btn-primary" role="button" data-toggle="modal">Add User</a>
                   <!-- URL for adding the catalogue; the new values will be available in controller using parameters -->
                      <c:url var="addUser" value="../administration/crud/add" />
                         <form method="POST" action="${addUser}">
                  <!-- Modal1 -->
              <div id="userRegistration" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                  <h3 id="myModalLabel" style="text-align:left">User Registration</h3>
            </div>
            <div class="modal-body">
             
                <table>
                <tr>
                    <td class="tdCatalogueType1" style="vertical-align:baseline;">
                        <label class="control-label" > Username: </label>
                    </td>
                    <td style="vertical-align:baseline;">
                        <div class="control-group">
                            <div class="controls">
                                <input id="usr_name" name="username" type="text" placeholder="Enter Username" required/> 
                            </div>
                        </div>
                    </td>  
                    <td>
                    	<span class="mappingSuggestion1 miniSugg" ></span>
                    </td>                      
                </tr>
                
                <tr>
                    <td class="tdCatalogueType1" style="vertical-align:baseline;">
                        <label class="control-label" > Password: </label>
                    </td>
                    <td style="vertical-align:baseline;">
                        <div class="control-group">
                            <div class="controls">
                                <input name="password" type="password" placeholder="Enter Password" required/> 
                            </div>
                        </div>
                    </td>
                </tr>
                
                <tr>
                    <td class="tdCatalogueType1" style="vertical-align:baseline;">
                        <label class="control-label" > Role: </label>
                    </td>
                    <td style="vertical-align:baseline;">
                        <div class="control-group">
                            <div class="controls">
                                <select class="input-block-level" id="month" name="user_role">
                                    <option value="ROLE_ADMIN">ADMIN</option>
                                    <option value="ROLE_INSTRUCTOR">INSTRUCTOR</option>
                                </select> 
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="tdCatalogueType1" style="vertical-align:baseline;">
                        <label class="control-label" > Speciality: </label>
                    </td>
                    <td style="vertical-align:baseline;">
                        <div class="control-group">
                            <div class="controls">
                                <select   name="specialityID" >
                                      <c:forEach items="${specIality}" var="speciality">  
                                        <option value="${speciality.specialtyID}">
                                             <c:out value="${speciality.name}"/></option>
                                        </c:forEach> 
                                </select> 
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="tdCatalogueType1" style="vertical-align:baseline;">
                        <label class="control-label" > Training System: </label>
                    </td>
                    <td style="vertical-align:baseline;">
                        <div class="control-group">
                            <div class="controls">
                                <select   name="trainSysId" >
                                      <c:forEach items="${trainSystems}" var="trainSystem">  
                                        <option value="${trainSystem.train_system_id}">
                                             <c:out value="${trainSystem.train_system_name}"/></option>
                                        </c:forEach> 
                                </select> 
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>

                    <td class="tdCatalogueType1" style="vertical-align:baseline;">
                        <label class="control-label" for="email">Email Address</label>
                    </td>
                    <td style="vertical-align:baseline;">
                         <div class="control-group">
                          <div class="controls">
                           <input type="email" name="emailAdd" id="email" placeholder="Your email address">
                          </div>
                         </div>
                    </td>
                    </tr>
                    </table>
                    </div>
                    <div class="modal-footer">
                    <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
                    <input type="submit" value="Register" class="btn btn-primary" />
                                        </div>
                                    </div>
                                </form>
                                   </td>
                                <td style="width:50px;"/>
                        </tr>
                </table>       
                <!-- here end -->
                <table id="zebraTable" class="table table-hover centeredTableNoTop"  style="width:1100px;">
                         <thead>                                 
                                <tr style="font-size:12px">
                                        <th>Username</th>
                                        <!-- th>UserID</th>
                                        <th>Password</th -->
                                        <th>User Role</th>
                                        <th>Status</th>
                                        <th>&nbsp;</th>
                                </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${userDetail}">
                                        <tr>
                                                <td><c:out value="${user.userName}" /></td>
                                                <!-- td><c:out value="${user.usrId}" /></td>
                                                <td><c:out value="${user.password}" /></td -->
                                                <td><c:out value="${user.userRole}" /></td>
                                                <td><c:out value="${user.active == true ? 'Active' : 'Inactive' }" /></td>
                                                <td>  
                                             	<ul class="dropdown nav pull-right" style="text-align: left;">
                                              <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown"> Manage <b class="caret"></b></a>
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
                                                <li role="presentation">
                                                <c:set var="myUpdatePasswordURL" value="updatePassword${user.usrId}" />
                                                       <a role="menuitem" tabindex="-1" href="#${myUpdatePasswordURL}" role="button" data-toggle="modal"> 
                                                           CHANGE PASSWORD 
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
                                                                                    <h3 id="myModalLabel"> Update User for <c:out value="${user.userName}" /></h3>
                                                                            </div>
                                                                              <div class="modal-body" style="text-align:left;">
                                                                                        <br/>
                                                                                        <table>
                                                                                                
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
                                                                                                                                        <option value="ROLE_INSTRUCTOR" ${user.userRole == "ROLE_RESIDENT" ? 'selected' : ''}>RESIDENT</option>
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
                                                                                                                    
                                                <!-- Update Password for Admin and Instructor -->
			                                    <c:url var="updatePasswordURL" value="../administration/crud/updatePassword?id=${user.usrId}&fromPage=userManagement" />
			                                    <form method="POST" action="${updatePasswordURL}" class="passwordChangeForm">
			
			                                    <!------------------------------------- Modal  for Updating Password for Admin and Instructor ------------------------------------------------>
			                                    <div id="${myUpdatePasswordURL}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			                                         <div class="modal-header"><a class="close" data-dismiss="modal">×</a><h3 id="myModalLabel">Change Password</h3></div>
			                                         <div class="modal-body" style="text-align:left;">
			                                         	<br/>
			                                         	<table> 
			                                                <tr>
			                                                     <td class="tdCatalogueType1" style="vertical-align:baseline;">
			                                                          <label class="control-label" >Current Password: </label>
			                                                     </td>
			                                                     <td style="vertical-align:baseline;">
			                                             				<div class="control-group">
			                                                     			<div class="controls">
			                                                           		<input class="curr_password" name="curr_password" type="password" required/> 
			                                                    			<input class="upid" name="upid" type="hidden" value = "${user.usrId}"/> <!-- Necessary for ajax validation -->
			                                                    			<input class="pageType" name="pageType" type="hidden" value = "userManagement"/> <!-- Necessary for ajax validation -->
			                                                    			</div>
			                                             				</div>
			                                           			</td>
			                                           			<td><span class="mappingSuggestionPass miniSugg" ></span></td> 	
			                                      			</tr> 
			                                      			<tr>
			                                                     <td class="tdCatalogueType1" style="vertical-align:baseline;">
			                                                          <label class="control-label" >New Password: </label>
			                                                     </td>
			                                                     <td style="vertical-align:baseline;">
			                                             				<div class="control-group">
			                                                     			<div class="controls">
			                                                           		<input class="newPassword" name="newPassword" type="password" required/> 
			                                                    			</div>
			                                             				</div>
			                                            			</td>
			                                          			<td>&nbsp;</td> 
			                                         		</tr>
			                                     	 	</table>
			                                         </div>
			                                         <div class="modal-footer">
			                                             <a href="#" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</a>
			                                             <input type="submit" value="Save" class="btn btn-primary" />
			                                         </div>
			                                    </div>
			                                    </form>
			                                    <!------------------------------------- End Modal for Updating Password for ADMIN and INSTRUCTOR ------------------------------------------------>

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