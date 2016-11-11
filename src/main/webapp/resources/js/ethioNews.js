function submitMediaForm() {
	var name = $('#name').val().trim();
	var url = $('#url').val().trim();
	var type = $('#type').val().trim();
	var language = $('#language').val().trim();
	var country = $('#country').val().trim();
	var crawel = $('#crawel').val().trim();
	if (name.length == 0 || url.length == 0 || type.length == 0
			|| language.length == 0 || name.country == 0 || crawel.length == 0) {
		alert('Please enter missed data');
		$('#name').focus();
		return false;
	}

	return true;
};