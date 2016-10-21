<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Record List</b>
				</div>
				<div align="right">
					<a href="createRecord">Add New Record</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty recordList}">
                There are no Record
            </c:if>
			<c:if test="${not empty recordList}">

				<form action="searchPassenger">
					<div class="row">
						<div class="col-md-4">
							Search Record: <input type='text' name='title' id='title' />
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
							<th>URL</th>
							<th>Category</th>
							<th>Date</th>
							<th>Media</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recordList}" var="rec">
							<tr>
								<th><c:out value="${pass.id}" /></th>
								<th><c:out value="${rec.title}" /></th>
								<th><c:out value="${rec.description}" /></th>
								<th><c:out value="${rec.url}" /></th>
								<th><c:out value="${rec.category}" /></th>
								<th><c:out value="${rec.date}" /></th>
								<th><c:out value="${rec.media}" /></th>
								<th><a
									href="editRecord?id=<c:out value='${rec.id}'/>">Edit</a></th>
								<th><a
									href="deleteRecord?id=<c:out value='${rec.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

	<%@include file="footer.jsp"%>