<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Passenger Details</b>
				</div>
				<div align="right">
					<a href="getAllPassengers">Passenger List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="passengerRegisterForm" cssClass="form-horizontal"
				modelAttribute="passenger" method="post" action="savePassenger">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="name">Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="passengerId" value="${passengerObject.passengerId}" />
						<form:input cssClass="form-control" path="name"
							value="${passengerObject.name}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="emailId" cssClass="control-label col-xs-3">Email Id</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="emailId"
							value="${passengerObject.emailId}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="gender" cssClass="control-label col-xs-3">Gender</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="gender"
							value="${passengerObject.gender}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="age" cssClass="control-label col-xs-3">Age</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="age"
							value="${passengerObject.age}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phoneNumber" cssClass="control-label col-xs-3">Phone Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phoneNumber"
							value="${passengerObject.phoneNumber}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="savePassenger" class="btn btn-primary"
								value="Save" onclick="return submitPassengerForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function submitPassengerForm() {

		// getting the UserRole form values
		var name = $('#name').val().trim();
		if (name.length == 0) {
			alert('Please enter Passenger name');
			$('#name').focus();
			return false;
		}

		return true;
	};
</script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>