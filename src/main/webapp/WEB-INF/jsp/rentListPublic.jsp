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
					<a href="createRent">Post Rent</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty rentList}">
                There are no Rent
            </c:if>
			<c:if test="${not empty rentList}">

				<!-- <form action="searchRent">
					<div class="row">
						<div class="col-md-4">
							Search Rent: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form> -->

				<table class="table table-hover table-bordered">

					<tbody>
						<c:forEach items="${rentList}" var="rnt">
							<tr>
								<td>Image to be displayed</td>
								<td>
									<table border="0">
										<tr>
											<td>Address: <c:out value="${rnt.address}" /></td>
										</tr>
										<tr>
											<td>Available Beds: <c:out value="${rnt.beds}" /></td>
										</tr>
										<tr>
											<td>Total Baths: <c:out value="${rnt.baths}" /></td>
										</tr>
										<tr>
											<td>Total Price: <c:out value="${rnt.price}" /></td>
										</tr>
										<tr>
											<td>Contact Number: <c:out value="${rnt.phonenumber}" /></td>
										</tr>
									</table>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<tag:paginate max="10" offset="${offset}" count="${count}"
					uri="getPublicRents" next="&raquo;" previous="&laquo;" />
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>