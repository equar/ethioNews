<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>User Signup Result</b>
				</div>
			</h3>
		</div>

		<div class="panel-body">

			<span>You have successfuly registered and an email sent to
				${emailId}. Please activate your account by clicking on the link in
				your email. </span>

		</div>
	</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>