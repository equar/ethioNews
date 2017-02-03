function submitVideoForm() {

	var validator = $("#videoForm").validate({
		rules : {
			"title" : required,
			"description" : required,
			"category" : required,
			"filename" : required
		},
		messages : {
			name : " Title is required",
			description : " Description is required",
			category : " Category is required",
			filename : " Filename is required"
		}

	});
	if (validator.form()) { // validation perform
		$('form#videoForm').attr({
			action : 'mycontroller'
		});
		$('form#videoForm').submit();
	}
}
