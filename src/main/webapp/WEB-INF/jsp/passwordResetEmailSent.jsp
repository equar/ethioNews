<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Password Reset Email Sent</b>
				</div>
				<div align="right">
					<!-- <a href="getAllContacts">Contact List</a> -->
				</div>
			</h3>
		</div>

		<div class="panel-body">

			<p>
				A Password reset instructions has been sent to <span
					style="font-weight: bold">${username}</span><br> Please follow
				the instructions in the message in order to set a new password.
			</p>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>