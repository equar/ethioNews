<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>User List</b>
				</div>
				<div align="right">
					<!-- <a href="createUserRole">Add New UserRole</a> -->
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty userList}">
                There are no User roles
            </c:if>
			<c:if test="${not empty userList}">

				<form action="searchUser">
					<div class="row">
						<div class="col-md-4">
							Search Username: <input type='text' name='username' id='username' />
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
							<th>Username</th>
							<th>Status</th>
							<th>Action</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user">
							<tr>
								<th><c:out value="${user.id}" /></th>
								<th><c:out value="${user.username}" /></th>
								<th><c:out value="${user.enabled}" /></th>
								<th><a href="editUser?id=<c:out value='${user.id}'/>">Edit</a></th>
								<th><a href="deleteUser?id=<c:out value='${user.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>