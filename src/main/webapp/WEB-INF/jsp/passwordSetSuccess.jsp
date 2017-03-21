<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Password Reset Successful</b>
				</div>
				<div align="right">
					<!-- <a href="getAllContacts">Contact List</a> -->
				</div>
			</h3>
		</div>

		<div class="panel-body">

			<h2>
				Password was set successfully to user <span
					style="font-weight: bold">${username}</span><br> Try to login
				again with the new password.
			</h2>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>