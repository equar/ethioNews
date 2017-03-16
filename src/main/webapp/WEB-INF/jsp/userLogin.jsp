<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>User Login Form</b>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<c:if test="${not empty error}">
				<div>${error}</div>
			</c:if>
			<c:if test="${not empty message}">
				<div>${message}</div>
			</c:if>

			<form:form id="userLogin" cssClass="form-horizontal" method="post"
				action="userLogin">

				<table>
					<tr>
						<td>UserName:</td>
						<td><input type='text' name='username' value=''></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit"
							value="submit" /></td>
					</tr>
				</table>


				<h4 class="text-center">
					<a href="createUser">Create an account</a>
				</h4>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>