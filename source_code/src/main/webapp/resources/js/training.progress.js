$(document).ready(
function() {
	//init the datepicker
	$('#dp3').datepicker();
	//init the datepicker
	$('.datepicker').datepicker();
	//restrict the datepicker for on vacation to only select future date
	$(".datepicker").datepicker("setStartDate", $(".datepicker:first").attr("data-date"));
	//activate the validation for the following elements
	$("input,select,textarea").not("[type=submit]")
				.jqBootstrapValidation();
});
