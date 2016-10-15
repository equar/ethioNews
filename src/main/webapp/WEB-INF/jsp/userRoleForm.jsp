<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>UserRole Details</b>
				</div>
				<div align="right">
					<a href="getAllUserRoles">UserRole List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="userRoleRegisterForm" cssClass="form-horizontal"
				modelAttribute="userRole" method="post" action="saveUserRole">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="roleType">Role Type</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="roleId" value="${userRoleObject.roleId}" />
						<form:input cssClass="form-control" path="roleType"
							value="${userRoleObject.roleType}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveUserRole" class="btn btn-primary"
								value="Save" onclick="return submitUserRoleForm();" />
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
	function submitUserRoleForm() {

		// getting the UserRole form values
		var name = $('#roleType').val().trim();
		if (name.length == 0) {
			alert('Please enter role type');
			$('#roleType').focus();
			return false;
		}

		return true;
	};
</script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>