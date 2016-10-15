<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
	<h3>Change Password</h3>
		<font color="red">${message}</font>
		<form:form id="changepasswordForm" method="post" action="changepassword" modelAttribute="loginBean">

			<form:label path="username">Enter your email</form:label>
			<form:input id="username" name="username" path="" /><br>
			<form:label path="password">Enter your password</form:label>
			<form:password id="password" name="password" path="" /><br>
			<form:label path="confirmPassword">Confirm your password</form:label>
			<form:password id="confirmPassword" name="confirmPassword" path="" /><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>