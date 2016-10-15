<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<h3>Ticket Cancellation and refund</h3>
<h4>Enter your details below</h4>
<form:form id="cancelForm" method="post" action="ticketcancel"
	modelAttribute="ticketBean">
	<form:label path="ticketNumber">Ticket Number</form:label>
	<form:input id="ticketNumber" name="ticketNumber" path="" />
	<br>
	<form:label path="emailId">Email ID</form:label>
	<form:input id="emailId" name="emailId" path="" />
	<br>

	<input type="submit" value="Search" />
</form:form>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>