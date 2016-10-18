<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Passenger List</b>
				</div>
				<div align="right">
					<a href="createPassenger">Add New Passenger</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty passengerList}">
                There are no Passenger
            </c:if>
			<c:if test="${not empty passengerList}">

				<form action="searchPassenger">
					<div class="row">
						<div class="col-md-4">
							Search Passenger: <input type='text' name='name' id='name' />
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
							<th>Name</th>
							<th>EmailId</th>
							<th>Gender</th>
							<th>Age</th>
							<th>PhoneNumber</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${passengerList}" var="pass">
							<tr>
								<th><c:out value="${pass.passengerId}" /></th>
								<th><c:out value="${pass.name}" /></th>
								<th><c:out value="${pass.emailId}" /></th>
								<th><c:out value="${pass.gender}" /></th>
								<th><c:out value="${pass.age}" /></th>
								<th><c:out value="${pass.phoneNumber}" /></th>
								<th><a
									href="editPassenger?id=<c:out value='${pass.passengerId}'/>">Edit</a></th>
								<th><a
									href="deletePassenger?id=<c:out value='${pass.passengerId}'/>">Delete</a></th>
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