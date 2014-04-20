$(document).ready(function () {
	//read the cookie information
	var selectedSpecialty = $.cookie("selectedSpeciality");
	//check if cookie is available
	if( selectedSpecialty !== undefined) { 
		//if cookie is available select the associated specialty
		$('#chosenSpecialty').find('option[value="'+selectedSpecialty+'"]').attr('selected', 'selected');
	} 
	//if the specialty is changed remove the old cookie and reset the cookie with the new selected specialty
	$('#chosenSpecialty').change(function(){
		//take the selected specialty from the dropdown list
	    var selectedOption = $(this).find('option:selected').attr('value');
	    //remove the old cookie information
		$.removeCookie('selectedSpeciality', { path: '/' });
		//set the new cookie info to the selected specialty
		$.cookie("selectedSpeciality", selectedOption, { expires: 365, path: '/' });
		//reload the page without parameters
		window.location = window.location.href.split("?")[0];	
	});
});