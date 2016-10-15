<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>UserRole List</b>
				</div>
				<div align="right">
					<a href="createUserRole">Add New UserRole</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty userRoleList}">
                There are no User roles
            </c:if>
			<c:if test="${not empty userRoleList}">

				<form action="searchEmployee">
					<div class="row">
						<div class="col-md-4">
							Search UserRole: <input type='text' name='roleType' id='roleType' />
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
							<th>RoleType</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userRoleList}" var="role">
							<tr>
								<th><c:out value="${role.roleId}" /></th>
								<th><c:out value="${role.roleType}" /></th>
								<th><a
									href="editUserRole?id=<c:out value='${role.roleId}'/>">Edit</a></th>
								<th><a
									href="deleteUserRole?id=<c:out value='${role.roleId}'/>">Delete</a></th>
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

	<%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>
	<%@include file="topbus.jsp"%>
	<%@include file="footer.jsp"%>