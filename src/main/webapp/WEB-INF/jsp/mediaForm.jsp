<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Company Details</b>
				</div>
				<div align="right">
					<a href="getAllCompanys">Company List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="companyRegisterForm" cssClass="form-horizontal"
				modelAttribute="company" method="post" action="saveCompany">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="companyName">Company Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="companyId" value="${companyObject.companyId}" />
						<form:input cssClass="form-control" path="companyName"
							value="${companyObject.companyName}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="address" cssClass="control-label col-xs-3">Address</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="address"
							value="${companyObject.address}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phoneNumber" cssClass="control-label col-xs-3">Phone Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phoneNumber"
							value="${companyObject.phoneNumber}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="emailId" cssClass="control-label col-xs-3">EmailId</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="emailId"
							value="${companyObject.emailId}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveCompany" class="btn btn-primary"
								value="Save" onclick="return submitCompanyForm();" />
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
	function submitCompanyForm() {

		// getting the UserRole form values
		var name = $('#companyName').val().trim();
		if (name.length == 0) {
			alert('Please enter Company name');
			$('#companyName').focus();
			return false;
		}

		return true;
	};
</script>


<%@include file="footer.jsp"%>