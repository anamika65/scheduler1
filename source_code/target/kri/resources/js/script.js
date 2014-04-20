$(document).ready(function() {
	var cnt=0;
	
	//Empty checking Form
	$("#changePasswordForm").submit(function(event) {
		if ($.trim($("#c_password").val()).length <= 0) {
				return false;
		}
		if ($.trim($("#new_password").val()).length <= 0) {
				return false;	
		}
		if ($.trim($("#repeat_password").val()).length <= 0) {
			return false;	
	}
		return true;
	});
	$("#c_password").change(function(){
		if($.trim($("#c_password").val()).length >0){
			var curPassword = $.trim($(this).val());
			$.ajax({
				url : "../schedule/changepassword/checkCurrentPass",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
				data : "currPassValue="+ curPassword,
				type : "POST",//request type, can be GET
				cache : false,//do not cache returned data
			}).done(function(data) {
				// -1,0 : Password doesn't exist, others : Password found
				if (data == "-1" || data == "0") {
					console.log(data);
					// ask user to enter passwords
					$(".mappingSuggestion1").html("Password doesn't match")
											.css("color","#aa0000");
					
				}
				else{
					$(".mappingSuggestion1").html("Password found")
					.css("color","#00aa00");
					cnt = cnt +1;
				}
			});
		} else {
			// ask user to set password
			$(".mappingSuggestion1").html("Enter Password")
									.css("color", "#aa0000");
		}
		
	});
	$("#repeat_password").change(function(){
		if(($.trim($("#new_password").val()).length >0)){
			var new_pass = $("#new_password").val();
			var repeat_pass = $("#repeat_password").val(); 
			
			$.ajax({
				url : "../schedule/changepassword/checkNewPass",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
				data : "newPassValue=" + new_pass + "&repeatPassValue="+ repeat_pass,
				type : "POST",//request type, can be GET
				cache : false,//do not cache returned data
			}).done(function(data) {
				// 0 : Password Matches, others : Password doesn't match 
				if (data != "0") {
					// ask user to enter passwords
					$(".mappingSuggestion2").html("Password doesn't match")
											.css("color","#aa0000");
				}
				else{
					$(".mappingSuggestion2").html("Password Match")
					.css("color","#00aa00");
					cnt = cnt +1;
				}
			});
		} 
	});
	$( "#changePasswordForm" ).submit(function( event ) {
		  if ( cnt == 2 ) { //all are ok
		    return;
		  }
		  event.preventDefault();
		});
	// End Update Password on UsrMangment.jsp	
});