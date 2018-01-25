<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Profession List</b>
				</div>
				<div align="right">
					<a href="createProfession">Add New Profession</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty professionList}">
                There are no Profession
            </c:if>
			<c:if test="${not empty professionList}">

				<form action="searchProfession">
					<div class="row">
						<div class="col-md-4">
							Search Profession: <input type='text' name='title' id='title' />
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
							<th>Type</th>
							<th>Address</th>
							<th>PhoneNumber</th>
							<th>Web site</th>
							<th>Description</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${professionList}" var="prof">
							<tr>
								<td><c:out value="${prof.id}" /></td>
								<td><c:out value="${prof.name}" /></td>
								<td><c:out value="${prof.type}" /></td>
								<td><c:out value="${prof.address}" /></td>
								<td><c:out value="${prof.phonenumber}" /></td>
								<td><c:out value="${prof.website}" /></td>
								<td><c:out value="${prof.description}" /></td>
								<td><a href="editProfession?id=<c:out value='${prof.id}'/>">Edit</a></td>
								<td><a
									href="deleteProfession?id=<c:out value='${prof.id}'/>">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>