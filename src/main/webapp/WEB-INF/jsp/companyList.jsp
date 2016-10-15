<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Company List</b>
				</div>
				<div align="right">
					<a href="createCompany">Add New Company</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty companyList}">
                There are no Company
            </c:if>
			<c:if test="${not empty companyList}">

				<form action="searchCompany">
					<div class="row">
						<div class="col-md-4">
							Search Company: <input type='text' name='companyName' id='companyName' />
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
							<th>CompanyName</th>
							<th>Address</th>
							<th>PhoneNumber</th>
							<th>EmailId</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${companyList}" var="comp">
							<tr>
								<th><c:out value="${comp.companyId}" /></th>
								<th><c:out value="${comp.companyName}" /></th>
								<th><c:out value="${comp.address}" /></th>
								<th><c:out value="${comp.phoneNumber}" /></th>
								<th><c:out value="${comp.emailId}" /></th>
								<th><a
									href="editCompany?id=<c:out value='${pass.companyId}'/>">Edit</a></th>
								<th><a
									href="deleteCompany?id=<c:out value='${pass.companyId}'/>">Delete</a></th>
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

	<%@include file="topbus.jsp"%>
	<%@include file="footer.jsp"%>