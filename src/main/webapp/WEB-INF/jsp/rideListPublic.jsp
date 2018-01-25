<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Ride List</b>
				</div>
				<div align="right">
					<a href="createRide">Post Ride</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty rideList}">
                There are no Ride
            </c:if>
			<c:if test="${not empty rideList}">

				<form action="searchRide">
					<div class="row">
						<div class="col-md-4">
							Search Ride: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover table-bordered">

					<tbody>
						<c:forEach items="${rideList}" var="rid">
							<tr>
								<td>
									<p>
										From:
										<c:out value="${rid.from}" />
										&nbsp;&nbsp; &nbsp; &nbsp; To:
										<c:out value="${rid.to}" />
									</p>
									<p>
										Leaving on:
										<c:out value="${rid.date}" />
										at
										<c:out value="${rid.time}" />
									</p>

									<p>
										Contact Number:
										<c:out value="${rid.phonenumber}" />
									</p>

									<p>
										Description:
										<c:out value="${rid.description}" />
									</p>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<tag:paginate max="10" offset="${offset}" count="${count}"
					uri="getPublicRides" next="&raquo;" previous="&laquo;" />
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>