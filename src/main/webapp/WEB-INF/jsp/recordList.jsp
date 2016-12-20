<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Record List</b>
				</div>
				<div align="right">
					<a href="createRecord">Add New Record</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty recordList}">
                There are no Record
            </c:if>
			<c:if test="${not empty recordList}">

				<table class="table table-hover table-bordered">

					<tbody>
						<c:forEach items="${recordList}" var="rec">
							<tr>
								<th><c:out value="${rec.title}" /></th>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

	<%@include file="footer.jsp"%>