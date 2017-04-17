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
					<a href="createVideo">Add New Video</a>
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
					<thead style="background-color: #bce8f1;">
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Desc</th>
							<th>Category</th>
							<th>Filename</th>
							<th>Date</th>
							<th>Test</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${videoList}" var="vid">
							<tr>
								<th><c:out value="${vid.id}" /></th>
								<th><c:out value="${vid.title}" /></th>
								<th><c:out value="${vid.description}" /></th>
								<th><c:out value="${vid.category}" /></th>
								<th><a href="${vid.filename}" target="_blank"><c:out
											value="${vid.filename}" /></a></th>
								<th><c:out value="${vid.date}" /></th>
								<th><a
									href="testVideo?id=<c:out value='${vid.id}'/>&
									title=<c:out value='${vid.title}'/>&
									description=<c:out value='${vid.description}'/>&
									category=<c:out value='${vid.category}'/>&
									filename=<c:out value='${vid.filename}'/>">Test</a></th>
								<th><a href="editVideo?id=<c:out value='${vid.id}'/>">Edit</a></th>
								<th><a href="deleteVideo?id=<c:out value='${vid.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<%@include file="footer.jsp"%>