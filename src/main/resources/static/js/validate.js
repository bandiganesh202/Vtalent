$(document).ready(function() {
	$.ajaxSetup({
		cache : false
	});
	$("#clender").datepicker({
		showButtonPanel: true,
		dateFormat: "dd/M/yy",
		beforeShow: function() {
			$(".ui-datepicker").css('font-size', 12)
		}
	});
});

// This function is used to enter only Float values in the text box.
function validateFloat(evt, txtObject) {
	var charCode = (evt.which) ? evt.which : evt.keyCode
	if (txtObject.value.indexOf(".") == -1 || charCode != 46) {
		if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	}
	return false;
}

function onchangeZip(url) {
	$("#error").html("");
	var zip = $("#zip").val();
	/*var form = $("#formId").serialize();*/
	alert(zip);
	$.ajax({
		url : url,
		type : "POST",
		contentType: "application/json; charset=utf-8",
		data : JSON.stringify({'zip': zip}),
		success : function(data) {
			$("#city").val(data.city);
			$("#state").val(data.state);
		},
		error: function(err) {
			$("#error").html( "<span style='color: red'>Invalid zip code entered</span>" );
			$("#city").html("");
			$("#state").html("");
		}
	});
}