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

	if (validator.form()) {
		$('form#mediaForm').submit();
	}
}

function submitMediaForm() {

	var validator = $("#mediaForm").validate({
		rules : {
			"name" : required,
			"url" : required,
			"type" : required,
			"language" : required,
			"country" : required,
			"crawel" : required
		},
		messages : {
			name : " Name is required",
			url : " URL is required",
			type : " Please select type",
			language : " Please select language ",
			country : "Country is required",
			crawel : " Please select crawel"
		}

	});
	if (validator.form()) { // validation perform
		$('form#mediaForm').submit();
	}
}

function submitSubscribeForm() {

	var validator = $("#subscribeForm").validate({
		rules : {
			"name" : required,
			"email" : required,
			"frequency" : required
		},
		messages : {
			name : " Nmae is required",
			email : " Email is required",
			frequency : " Please select frequency"
		}

	});
	if (validator.form()) { // validation perform
		$('form#subscribeForm').submit();
	}
}

function submitContactForm() {

	var validator = $("#contactForm").validate({
		rules : {
			"name" : required,
			"email" : required,
			"subject" : required,
			"message" : required
		},
		messages : {
			name : " Name is required",
			email : " Email is required",
			subject : " Subject is required",
			message : " Message is required"
		}

	});
	if (validator.form()) { // validation perform
		$('form#contactForm').submit();
	}
}

function submitEventForm() {

	var validator = $("#eventForm").validate({
		rules : {
			"title" : required,
			"description" : required,
			"category" : required,
			"title" : required,
			"description" : required,
			"category" : required,
			"title" : required,
			"description" : required,
			"category" : required,
			"filename" : required
		},
		messages : {
			name : " Title is required",
			description : " Description is required",
			category : " Category is required",
			name : " Title is required",
			description : " Description is required",
			category : " Category is required",
			name : " Title is required",
			description : " Description is required",
			category : " Category is required",
			filename : " Filename is required"
		}

	});
	if (validator.form()) { // validation perform
		$('form#eventForm').submit();
	}
}
