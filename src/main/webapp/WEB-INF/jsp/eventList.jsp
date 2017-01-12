<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Event List</b>
				</div>
				<div align="right">
					<a href="createEvent">Add New Event</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty eventList}">
                There are no Events
            </c:if>
			<c:if test="${not empty eventList}">

				<form action="searchCompany">
					<div class="row">
						<div class="col-md-4">
							Search Event: <input type='text' name='name' id='name' />
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
							<th>Type</th>
							<th>Address</th>
							<th>ImagePath</th>
							<th>Status</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${eventList}" var="evnt">
							<tr>
								<th><c:out value="${evnt.id}" /></th>
								<th><c:out value="${evnt.type}" /></th>
								<th><c:out value="${evnt.address}" /></th>
								<th><c:out value="${evnt.imagePath}" /></th>
								<th><c:out value="${evnt.status}" /></th>
								<th><a href="editEvent?id=<c:out value='${evnt.id}'/>">Edit</a></th>
								<th><a href="deleteEvent?id=<c:out value='${evnt.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

	<%@include file="footer.jsp"%>