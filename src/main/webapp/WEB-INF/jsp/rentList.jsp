<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Rent List</b>
				</div>
				<div align="right">
					<a href="createRent">Add New Rent</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty rentList}">
                There are no Rent
            </c:if>
			<c:if test="${not empty rentList}">

				<form action="searchRent">
					<div class="row">
						<div class="col-md-4">
							Search Rent: <input type='text' name='title' id='title' />
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
							<th>Beds</th>
							<th>Baths</th>
							<th>Price</th>
							<th>Area</th>
							<th>Available</th>
							<th>Furnished</th>
							<th>Date</th>
							<th>Address</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rentList}" var="rnt">
							<tr>
								<th><c:out value="${rnt.id}" /></th>
								<th><c:out value="${rnt.beds}" /></th>
								<th><c:out value="${rnt.baths}" /></th>
								<th><c:out value="${rnt.price}" /></th>
								<th><c:out value="${rnt.area}" /></th>
								<th><c:out value="${rnt.available}" /></th>
								<th><c:out value="${rnt.furnished}" /></th>
								<th><c:out value="${rnt.availableDate}" /></th>
								<th><c:out value="${rnt.address}" /></th>
								<th><a href="editRent?id=<c:out value='${rnt.id}'/>">Edit</a></th>
								<th><a href="deleteRent?id=<c:out value='${rnt.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>