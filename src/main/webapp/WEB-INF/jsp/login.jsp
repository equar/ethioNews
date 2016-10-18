<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<h3>Sign In</h3>
<font color="red">${message}</font>
<form:form id="loginForm" method="post" action="login"
	modelAttribute="user">

	<form:label path="emailId">Enter your email or mobile no</form:label>
	<form:input id="emailId" name="emailId" path="" />
	<br>
	<form:label path="password">Enter your password</form:label>
	<form:password id="password" name="password" path="" />
	<br>
	<input type="submit" value="Submit" />
	<form:label path="">You don't have an account? 	<a
			href="signup">Sign Up</a>
	</form:label>
</form:form>

<%@include file="footer.jsp"%>