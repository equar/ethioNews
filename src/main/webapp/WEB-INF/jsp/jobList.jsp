<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Job List</b>
				</div>
				<div align="right">
					<a href="createJob">Add New Job</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty jobList}">
                There are no Job
            </c:if>
			<c:if test="${not empty jobList}">

				<form action="searchJob">
					<div class="row">
						<div class="col-md-4">
							Search Job: <input type='text' name='title' id='title' />
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
							<th>Description</th>
							<th>Location</th>
							<th>PhoneNumber</th>
							<th>Email</th>
							<th>Available</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobList}" var="job">
							<tr>
								<td><c:out value="${job.id}" /></td>
								<td><c:out value="${job.title}" /></td>
								<td><c:out value="${job.description}" /></td>
								<td><c:out value="${job.location}" /></td>
								<td><c:out value="${job.phoneNumber}" /></td>
								<td><c:out value="${job.email}" /></td>
								<td><c:out value="${job.available}" /></td>
								<td><a href="editJob?id=<c:out value='${job.id}'/>">Edit</a></td>
								<td><a href="deleteJob?id=<c:out value='${job.id}'/>">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>