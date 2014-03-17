$(document).ready(function() {
	var cnt = 0;
	
	//Empty checking Form
	$(".passwordChangeForm").submit(function(event) {
		//alert($(this).find(".curr_password").val());
		//alert(cnt);
		if (cnt == 0) {
				return false;
		}
		return true;
	});
	$(".curr_password").change(function(){
		
		if($.trim($(this).val()).length >0){
			
			var form = $(this).parents("form").eq(0);//.get(0) added
			var curPassword = $.trim($(this).val());
			var upid = $.trim(form.find(".upid").val());
			var pageType = $.trim(form.find(".pageType").val());
			//alert(curPassword + " " + upid + " " + pageType);
			$.ajax({
				url : "../administration/crud/checkCurrentPassWithUserName",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
				data : "currPassValue="+ curPassword + "&upid="+ upid + "&pageType="+ pageType ,
				type : "POST",//request type, can be GET
				cache : false,//do not cache returned data
			}).done(function(data) {
				// -1,0 : Password doesn't exist, others : Password found
				if (data == "-1" || data == "0") {
					//console.log(data);
					// ask user to enter passwords
					$(".mappingSuggestionPass").html("Incorrect")
											.css("color","#aa0000");
					cnt = 0;
				}
				else{
					$(".mappingSuggestionPass").html("Correct")
					.css("color","#00aa00");
					cnt = 1;
				}
			});
		} else {
			// ask user to set password
			$(".mappingSuggestionPass").html("Enter Password")
									.css("color", "#aa0000");
			cnt = 0;
		}
		
	});
	/*$("#new_password").change(function(){
		if(($.trim($("#new_password").val()).length >0) ){
			var new_pass = $("#new_password").val();
			var usrName = $.trim($("#username").val());
			
			$.ajax({
				url : "../administration/crud/checkNewPassword",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
				data : "newPassValue=" + new_pass + "&userNameValue="+ usrName,
				type : "POST",//request type, can be GET
				cache : false,//do not cache returned data
			}).done(function(data) {
				// 0 : Password Matches, others : Password doesn't match 
				if (data == "1") {
					// ask user to enter passwords
					$(".mappingSuggestion2").html("Can't be Current Password")
											.css("color","#aa0000");
				}
				else{
					$(".mappingSuggestion2").html("Available")
					.css("color","#00aa00");
					cnt = cnt +1;
				}
			});
		} 
	});
	$( "#passwordChangeForm" ).submit(function( event ) {
		  if ( cnt == 2 ) { //all are ok
		    return;
		  }
		  event.preventDefault();
		});
	// End Update Password on UsrMangment.jsp	
	*/
});