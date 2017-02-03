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
						<td width="50%"><iframe width="420" height="345"
								src=<c:out value="${filename}" />> </iframe></td>
						<td width="50%"><p>Title: ${title}</p>
							<p>Category: ${category}</p>
							<p>Description: ${description}</p>
							<p>If you want to edit in case the video or its information
								were not displayed as expected, please click on Edit</p></td>
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