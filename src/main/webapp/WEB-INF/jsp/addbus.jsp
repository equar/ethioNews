<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div>
	<h3>Bus Management</h3>
	<font color="red">${message}</font>
	<form:form id="busForm" method="post" action="addbus"
		modelAttribute="bus">
		<form:label path="plateNumber">Plate Number:</form:label>
		<form:input id="plateNumber" name="plateNumber" path="" />
		<br>
		<form:label path="busLevel">Bus Level:</form:label>
		<form:input id="busLevel" name="busLevel" path="" />
		<br>
		<form:label path="model">Model:</form:label>
		<form:input id="model" name="model" path="" />
		<br>
		<form:label path="amenity">amenities:</form:label>
		<form:input id="amenity" name="amenity" path="" />
		<br>
		<br>
		<input type="submit" value="Add Bus" />
		<input type="submit" value="Cancel" />
		<br>
		<br>
	</form:form>
</div>
<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>