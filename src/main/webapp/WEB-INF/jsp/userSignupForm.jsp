<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>User Signup Details</b>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="signupForm" cssClass="form-horizontal"
				modelAttribute="user" method="post" action="saveUser">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="emailId">Email</form:label>
					</div>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="emailId"
							value="${user.emailId}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phoneNumber" cssClass="control-label col-xs-3">PhoneNumber</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phoneNumber"
							value="${user.phoneNumber}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="password" cssClass="control-label col-xs-3">Password</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="password"
							value="${user.password}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="confirmPassword"
						cssClass="control-label col-xs-3">Confirm Password</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="confirmPassword"
							value="${user.confirmPassword}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveUser" class="btn btn-primary"
								value="Submit" onclick="return submitUserSignupForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<script src="<c:url value="/resources/js/agileBus.js" />"></script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>