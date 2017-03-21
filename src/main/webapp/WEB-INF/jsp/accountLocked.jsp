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

			Your account has been locked as a result of too many login attempts.<br>
			<br> Instructions have been sent to your email.<br> You may
			also contact your administrator. <br>
			<br>
			<br>
			<br>
			<br>
			<div id="LockedAccount_TopHidden"
				style="display: none; visibility: hidden;">Your Account Has
				Been Locked</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>