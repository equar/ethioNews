<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<h3>How Can We Help You</h3>
<form:form id="helpForm" method="post" action="writeus"
	modelAttribute="helpBean">

	<form:label path="name">Name</form:label>
	<form:input id="name" name="name" path="" />
	<br>
	<form:label path="emailId">Email ID</form:label>
	<form:input id="emailId" name="emailId" path="" />
	<br>
	<form:label path="phoneNumber">Phone Number</form:label>
	<form:input id="phoneNumber" name="phoneNumber" path="" />
	<br>
	<form:label path="issue">Select Issue</form:label>
	<form:input id="issue" name="issue" path="" />
	<br>
	<form:label path="category">Select Category</form:label>
	<form:input id="category" name="category" path="" />
	<br>
	<form:label path="description">Description</form:label>
	<form:input id="description" name="description" path="" />
	<br>

	<input type="submit" value="Submit Query" />
</form:form>

<%@include file="footer.jsp"%>