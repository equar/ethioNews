<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Video List</b>
				</div>
				<div align="right">
					<!-- <a href="createVideo">Add New Video</a> -->
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty videoList}">
                There are no Video
            </c:if>
			<c:if test="${not empty videoList}">

				<form action="searchVideo">
					<div class="row">
						<div class="col-md-4">
							Search Video: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover table-bordered">

					<tbody>
						<c:forEach items="${videoList}" var="vid">
							<tr>

								<th><iframe width="420" height="345"
										src=<c:out value="${vid.filename}" />> </iframe></th>

								<th><c:out value="${vid.date}" /></th>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


	<%@include file="footer.jsp"%>