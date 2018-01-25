<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Professional Service List</b>
				</div>
				<div align="right">
					<a href="createProfession">Post Profession</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty professionList}">
                There are no Professional Services
            </c:if>
			<c:if test="${not empty professionList}">

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
						<c:forEach items="${professionList}" var="prf">
							<tr>
								<td>
									<p>
										Business Name:
										<c:out value="${prf.name}" />
									</p>
									<p>
										Type of Business:
										<c:out value="${prf.type}" />
									</p>
									<p>
										Address:
										<c:out value="${prf.address}" />
									</p>
									<p>
										Contact Number:
										<c:out value="${prf.phonenumber}" />
									</p>
									<p>
										Web site:
										<c:out value="${prf.website}" />
									</p>
									<p>
										Description:
										<c:out value="${prf.description}" />
									</p>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<tag:paginate max="10" offset="${offset}" count="${count}"
					uri="getPublicProfessions" next="&raquo;" previous="&laquo;" />
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>