
$(document).ready(function () {
	//when the schedule generation modal is shown hide the waiting animation
	$('#myModal').on('show', function() {
		//check if browser is IE
		if($.browser.msie) { 
			//if IE, due to IE bug delete the waiting animation
			$('#waitingAnimation').empty();
		} else { 
			// if not IE only hide the animation
			$('#waitingAnimation').hide();			
		}
	});
	//when schedule button is clicked show the waiting animation for schedule generation		
	$('#scheduleButton').on('click', function(e) { 
		//hide the cancel button
		$('#cancelScheduleButton').hide();
		//hide the schedule button
		$('#scheduleButton').hide();
		//check if browser is IE
		if($.browser.msie) {
			//if ie remove the waiting animation to be sure
			$('#waitingAnimation').empty();
			//add the waiting animation to show the user that the request is processed
			$('#waitingAnimation').append('Generation in progress, please wait...<img alt="activity indicator" src="../resources/images/ajax-loader.gif">');			
		} else { 
			//every other browser, show the animation that was previously hidden and it will
			//automatically start the waiting animation
			$('#waitingAnimation').show();			
		}
		
	});
});