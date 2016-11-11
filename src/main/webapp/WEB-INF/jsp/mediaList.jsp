<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Media List</b>
				</div>
				<div align="right">
					<a href="createMedia">Add New Media</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty mediaList}">
                There are no Media
            </c:if>
			<c:if test="${not empty mediaList}">

				<form action="searchCompany">
					<div class="row">
						<div class="col-md-4">
							Search Media: <input type='text' name='name' id='name' />
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
							<th>URL</th>
							<th>Type</th>
							<th>Language</th>
							<th>Country</th>
							<th>Crawel</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mediaList}" var="med">
							<tr>
								<th><c:out value="${med.id}" /></th>
								<th><c:out value="${med.name}" /></th>
								<th><c:out value="${med.url}" /></th>
								<th><c:out value="${med.type}" /></th>
								<th><c:out value="${med.language}" /></th>
								<th><c:out value="${med.country}" /></th>
								<th><c:out value="${med.crawel}" /></th>
								<th><a href="editMedia?id=<c:out value='${pass.id}'/>">Edit</a></th>
								<th><a href="deleteMedia?id=<c:out value='${pass.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
	
	<%@include file="footer.jsp"%>