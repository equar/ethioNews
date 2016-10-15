<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
	<h3>Forgot Password</h3>
		<font color="red">${message}</font>
		<form:form id="loginForm" method="post" action="forgotpassword" modelAttribute="loginBean">

			<form:label path="">Enter your email address and we will send you a link to reset your password</form:label><br>
			<form:label path="email">Enter your Email</form:label>
			<form:password id="email" name="email" path="" /><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>