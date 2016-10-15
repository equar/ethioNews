<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Amenity List</b>
				</div>
				<div align="right">
					<a href="createAmenity">Add New Amenity</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty amenityList}">
                There are no Amenity
            </c:if>
			<c:if test="${not empty amenityList}">

				<form action="searchEmployee">
					<div class="row">
						<div class="col-md-4">
							Search amenity: <input type='text' name='amenityName'
								id='amenityName' />
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
							<th>AmenityName</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${amenityList}" var="amen">
							<tr>
								<th><c:out value="${amen.amenityId}" /></th>
								<th><c:out value="${amen.amenityName}" /></th>
								<th><a
									href="editAmenity?id=<c:out value='${amen.amenityId}'/>">Edit</a></th>
								<th><a
									href="deleteAmenity?id=<c:out value='${amen.amenityName}'/>">Delete</a></th>
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