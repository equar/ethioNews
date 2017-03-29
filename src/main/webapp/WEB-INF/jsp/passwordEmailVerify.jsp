<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Password Reset Email</b>
				</div>
				<div align="right">
					<!-- <a href="getAllContacts">Contact List</a> -->
				</div>
			</h3>
		</div>
		<c:if test="${not empty message}">
			<div>${message}</div>
		</c:if>
		<div class="panel-body">

			<form:form id="passwordEmailVerify" cssClass="form-horizontal"
				modelAttribute="user" method="post" action="passwordEmailVerify">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="username">Email</form:label>
					</div>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="username"
							value="${user.username}" autofocus="true" />
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

<%@include file="footer.jsp"%>