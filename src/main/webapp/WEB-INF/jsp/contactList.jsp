<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Contact List</b>
				</div>
				<div align="right">
					<a href="createContact">Add New Contact</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty contactList}">
                There are no Contact
            </c:if>
			<c:if test="${not empty contactList}">

				<form action="searchCompany">
					<div class="row">
						<div class="col-md-4">
							Search Contact: <input type='text' name='name' id='name' />
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
							<th>Email</th>
							<th>subject</th>
							<th>Message</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${contactList}" var="cont">
							<tr>
								<th><c:out value="${cont.id}" /></th>
								<th><c:out value="${cont.name}" /></th>
								<th><c:out value="${cont.email}" /></th>
								<th><c:out value="${cont.subject}" /></th>
								<th><c:out value="${cont.message}" /></th>
								<th><a href="editContact?id=<c:out value='${cont.id}'/>">Read</a></th>
								<th><a href="deleteContact?id=<c:out value='${cont.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

	<%@include file="footer.jsp"%>