<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Job List</b>
				</div>
				<div align="right">
					<a href="createJob">Post Job</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty jobList}">
                There are no Job
            </c:if>
			<c:if test="${not empty jobList}">

				<form action="searchJob">
					<div class="row">
						<div class="col-md-4">
							Search Job: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover table-bordered">

					<tbody>
						<c:forEach items="${jobList}" var="job">
							<tr>
								<td>
									<p>
										Job Title:
										<c:out value="${job.title}" />
									</p>
									<p>
										Job Address:
										<c:out value="${job.location}" />
									</p>
									<p>
										Job Description:
										<c:out value="${job.description}" />
									</p>
									<p>
										Contact Number:
										<c:out value="${job.phoneNumber}" />
									</p>

									<p>
										Contact Email:
										<c:out value="${job.email}" />
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