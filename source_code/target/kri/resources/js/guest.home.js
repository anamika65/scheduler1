$(document).ready(function () {
	 //init the date picker
     $('#datePicker').datepicker();
     //setup a callback for on change Date to dynamically change the scheduleDate and the cookie
     $('#datePicker').datepicker().on('changeDate', function(ev){
    	 //select the show current schedule button
    	 var currentSchButton = $('#showCurrentSch');
    	 //read cookie information
    	 var selectedSpecialty = $.cookie("selectedSpeciality");
    	 //check if cookie exists
    	 if( selectedSpecialty === undefined) { 
    		 selectedSpecialty = $('#chosenSpecialty').find('option:first').attr('value');
    	 } 
    	 //get the old schedule URL containing the old scheduleDate
    	 var oldDate = currentSchButton.attr('href');
    	 //get rid off the old scheduleDate
    	 var stringArray = oldDate.split('=');
    	 //set the new target for the showschedule button to contain the selected date and the selected cookie
    	 currentSchButton.attr('href', stringArray[0]+'='+ev.date.format("yyyy-mm-dd") + '&selectedSpecialty=' + selectedSpecialty);
     });
     //read the cookie information
	 var selectedSpecialty = $.cookie("selectedSpeciality");
	 //check if cookie is available
	 if( selectedSpecialty === undefined) {
		 //if not, select the first speciality
		 selectedSpecialty = $('#chosenSpecialty').find('option:first').attr('value');
	 }  
	 //for each button that contains the class "birt-button" add the selectedSpeciality as parameter
	 $(".birt-button").each(function(index, value) { 
		//get the old href from the a tag
        var oldHref = $(value).attr('href');
        //add the selectedSpecialty parameter to the birt URL
        $(value).attr('href', oldHref + '&selectedSpecialty=' + selectedSpecialty);
	 });
}) ;