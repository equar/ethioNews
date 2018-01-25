<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Ride List</b>
				</div>
				<div align="right">
					<a href="createRide">Add New Ride</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty rideList}">
                There are no Ride
            </c:if>
			<c:if test="${not empty rideList}">

				<form action="searchRide">
					<div class="row">
						<div class="col-md-4">
							Search Ride: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover table-bordered">
					<thead style="background-color: #bce8f1;">
						<tr>
							<td>Id</td>
							<td>From</td>
							<td>To</td>
							<td>Date</td>
							<td>Time</td>
							<td>Phone number</td>
							<td>Description</td>
							<td>Edit</td>
							<td>Delete</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rideList}" var="rid">
							<tr>
								<th><c:out value="${rid.id}" /></th>
								<th><c:out value="${rid.from}" /></th>
								<th><c:out value="${rid.to}" /></th>
								<th><c:out value="${rid.date}" /></th>
								<th><c:out value="${rid.time}" /></th>
								<th><c:out value="${rid.phonenumber}" /></th>
								<th><c:out value="${rid.description}" /></th>
								<th><a href="editRide?id=<c:out value='${rid.id}'/>">Edit</a></th>
								<th><a href="deleteRide?id=<c:out value='${rid.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>