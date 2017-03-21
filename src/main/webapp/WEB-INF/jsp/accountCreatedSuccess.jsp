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

			<h3>Account Created Successfully</h3>
			<div style="margin-top: 25px; position: relative; font: 15px">
				An activation message was sent to <span style="font-weight: bold">${username}</span><br>
				Please follow the instructions in the message to complete the
				authentication process.
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>