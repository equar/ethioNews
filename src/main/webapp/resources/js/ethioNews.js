function submitUserSignupForm() {
	var emailId = $('#emailId').val().trim();
	var phoneNumber = $('#phoneNumber').val().trim();
	var password = $('#password').val().trim();
	var confPass = $('#confirmPassword').val().trim();
	if (name.length == 0) {
		alert('Please enter missed data');
		$('#emailId').focus();
		return false;
	}

	return true;
};