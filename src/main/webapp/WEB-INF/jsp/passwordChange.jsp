<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Password Change Form</b>
				</div>
			</h3>
		</div>
		<c:if test="${not empty message}">
			<div>${message}</div>
		</c:if>
		<div class="panel-body">
			<form:form id="passwordChange" cssClass="form-horizontal"
				modelAttribute="user" method="post" action="passwordChange">

				<div class="form-group">
					<form:label path="passwordOld" cssClass="control-label col-xs-3">Old Password</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="passwordOld"
							value="${user.passwordOld}" />
						<form:errors path="passwordOld" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="password" cssClass="control-label col-xs-3">New Password</form:label>
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
							<input type="submit" id="changePass" class="btn btn-primary"
								value="Submit" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>