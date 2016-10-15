<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email with Spring MVC</title>
</head>
<body>
	<h1>Sending e-mail with Spring MVC</h1>
	<form:form id="emailForm" method="post" action="sendemail"
		modelAttribute="emailBean">

		<form:label path="to">To:</form:label>
		<form:input id="to" name="to" path="" size="65" />
		<br>
		<form:label path="subject">Subject:</form:label>
		<form:input id="subject" name="subject" path="" size="65" />
		<br>
		<form:label path="message">Message:</form:label>
		<%-- <form:textarea id="message" name="message" path="" cols="50" rows="10" /> --%>
		<form:input id="message" name="message" path="" size="65" />
		<br>
		<input type="submit" value="Send E-mail" />

	</form:form>
</body>
</html>