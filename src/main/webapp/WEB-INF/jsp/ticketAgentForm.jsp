<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>TicketAgent Details</b>
				</div>
				<div align="right">
					<a href="getAllTicketAgents">TicketAgent List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="ticketRegisterForm" cssClass="form-horizontal"
				modelAttribute="ticketAgent" method="post" action="saveTicketAgent">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="contactName">Contact Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="agentId" value="${ticketAgentObject.agentId}" />
						<form:input cssClass="form-control" path="contactName"
							value="${ticketAgentObject.contactName}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="address" cssClass="control-label col-xs-3">Address</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="address"
							value="${ticketAgentObject.address}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="emailId" cssClass="control-label col-xs-3">EmailId</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="emailId"
							value="${ticketAgentObject.emailId}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phoneNumber" cssClass="control-label col-xs-3">Phone Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phoneNumber"
							value="${ticketAgentObject.phoneNumber}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveTicketAgent" class="btn btn-primary"
								value="Save" onclick="return submitTicketAgentForm();" />
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
	function submitTicketAgentForm() {

		// getting the UserRole form values
		var name = $('#name').val().trim();
		if (name.length == 0) {
			alert('Please enter TicketAgent name');
			$('#name').focus();
			return false;
		}

		return true;
	};
</script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>