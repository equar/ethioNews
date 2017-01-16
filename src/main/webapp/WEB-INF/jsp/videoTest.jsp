<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Video Test</b>
				</div>
				<div align="right">
					<a href="getAllVideos">Video List</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">

			<table class="table table-hover table-bordered">

				<tbody>
					<tr>
						<th><iframe width="420" height="345"
								src=<c:out value="${videoTest}" />> </iframe></th>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


	<%@include file="footer.jsp"%>