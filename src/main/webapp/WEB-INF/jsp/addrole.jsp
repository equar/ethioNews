<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div>
	<h3>User Role Management</h3>
	<font color="red">${message}</font>
	<form:form id="roleForm" method="post" action="addrole"
		modelAttribute="userRole">
		<form:label path="roleType">Role Type:</form:label>
		<form:input id="roleType" name="roleType" path="" />
		<br>
		<br>
		<input type="submit" value="Add Role" />
		<input type="submit" value="Cancel" />
		<br>
		<br>
	</form:form>
</div>
<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>