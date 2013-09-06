<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/common/imports.jspf" %>
<html>
<head>
	<title>Import operations</title>
</head>
	
<body>
	<div class="wrap">
			
	    <jsp:include page="/WEB-INF/jsp/common/header.jspf">
			<jsp:param name="headerLogout" value="../logout"/>
			<jsp:param name="headerGoSchedule" value="../schedule/view"/>
			<jsp:param name="headerViewAdministration" value="../administration/home"/>
			<jsp:param name="headerModule" value="Import"/>
		</jsp:include>

		<table  class="homepageTable" style="width:100%;">
			
			<tr style="height:100px;"/>
			
			<form:form method="post" action="save.html"
			        modelAttribute="uploadForm" enctype="multipart/form-data">
			 	 <fieldset>
			 		 <legend>Upload Fields</legend>

            		   <input id="file" type="file" name="file" />
            	    <p><button type="submit">Upload</button></p> 
			 	 </fieldset>
			</form:form>
	
		</table>
		
		<div style="height:80px"> </div>

		<img style = " position: absolute; display: block; left:0; bottom: 0;" src = "../../resources/images/footer.png"/> 	
			
	</div>
	<div style = "height:30px"></div>
</body>
</html>