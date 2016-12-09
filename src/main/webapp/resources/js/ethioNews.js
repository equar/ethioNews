function submitMediaForm() {
	var name = $('#name').val().trim();
	var url = $('#url').val().trim();
	var type = $('#type').val().trim();
	var language = $('#language').val().trim();
	var country = $('#country').val().trim();
	var crawel = $('#crawel').val().trim();

	if (name.length == 0 || url.length == 0 || type.length == 0) {
		document.getElementById("error").innerHTML = "Enter missed data";
		$('#name').focus();
		return false;
	}
	if (language.length == 0 || country.length == 0 || crawel.length == 0) {
		document.getElementById("error").innerHTML = "Enter missed data";
		$('#country').focus();
		return false;
	}

	return true;
};

function submitMediaForm5() {

	$("#mediaForm").validate({
		rules : {
			"name" : {
				required : true,
				minlength : 6,
				maxlength : 40
			},
			"url" : {
				required : true,
				minlength : 6,
				maxlength : 40
			}
		},
		messages : {
			"name" : {
				required : "username is required!",
				minlength : "username must be at least 6 characters long"
			},
			"url" : {
				required : "Please enter a password",
				minlength : "Password must be at least 6 characters long"
			}
		},
		submitHandler : function(form) {
			form.submit();
			// alert('valid form');
		}
	});

};
