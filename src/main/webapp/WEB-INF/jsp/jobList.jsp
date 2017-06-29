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
								<th><c:out value="${job.id}" /></th>
								<th><c:out value="${job.title}" /></th>
								<th><c:out value="${job.descritpion}" /></th>
								<th><c:out value="${job.location}" /></th>
								<th><c:out value="${job.phoneNumber}" /></th>
								<th><c:out value="${job.email}" /></th>
								<th><c:out value="${job.availabl}" /></th>
								<th><a href="editJob?id=<c:out value='${job.id}'/>">Edit</a></th>
								<th><a href="deleteJob?id=<c:out value='${job.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>