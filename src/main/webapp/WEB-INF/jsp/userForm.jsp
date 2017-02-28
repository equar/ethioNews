<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
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
			<form:form id="userForm" cssClass="form-horizontal"
				modelAttribute="user" method="post" action="saveUser">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="username">Email</form:label>
					</div>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="username"
							value="${user.username}" />
						<form:errors path="username" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="password" cssClass="control-label col-xs-3">Password</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="password"
							value="${user.password}" />
						<form:errors path="password" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="passwordConfirm"
						cssClass="control-label col-xs-3">Confirm Password</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="passwordConfirm"
							value="${user.passwordConfirm}" />
						<form:errors path="passwordConfirm" cssStyle="color: #ff0000;" />
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
				<h4 class="text-center">
					Already Have Account? &nbsp;&nbsp; <a href="userLogin">Sign In</a>
				</h4>
			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>