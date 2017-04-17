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
					<a href="getAllUsers">All Users</a>| <a href="getEnabledUsers">Enabled
						Users</a>| <a href="getDisabledUsers">Disabled Users</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty userList}">
                There are no Users
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

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user">
							<tr>
								<th><c:out value="${user.id}" /></th>
								<th><c:out value="${user.username}" /></th>
								<th><c:out value="${user.enabled}" /></th>
								<c:if test="${user.enabled == true}">
									<th><a
										href="disableUser?id=<c:out value='${user.username}'/>&action=<c:out value='false'/>">Disable</a></th>
								</c:if>
								<c:if test="${user.enabled == false}">
									<th><a
										href="enableUser?id=<c:out value='${user.username}'/>&action=<c:out value='true'/>">Enable</a></th>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>