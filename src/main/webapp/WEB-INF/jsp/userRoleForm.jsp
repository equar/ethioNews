<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
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
						<form:hidden path="id" value="${userRoleObject.id}" />
						<form:input cssClass="form-control" path="roleType"
							value="${userRoleObject.roleType}" />
						<form:errors path="roleType" cssStyle="color: #ff0000;" />
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

<%@include file="footer.jsp"%>