<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print Ticket</title>
</head>
<body>
	<h3>Print/SMS Ticket</h3>
	<form:form id="ticketForm" method="post" action="printticket"
		modelAttribute="ticket">

		<form:label path="ticketNumber">Ticket Number</form:label>
		<form:input id="ticketNumber" name="ticketNumber" path="" />
		<br>
		<form:radiobutton path="ticketType" value="print" />Print Ticket<br>
		<form:radiobutton path="ticketType" value="sms" />Get Ticket by SMS<br>
		<form:radiobutton path="ticketType" value="email" />Get Ticket by Email<br>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>