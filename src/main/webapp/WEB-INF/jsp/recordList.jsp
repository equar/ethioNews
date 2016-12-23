<%@include file="header.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>News List</b>
				</div>

			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty recordList}">
                There are no Record
            </c:if>
			<c:if test="${not empty recordList}">

				<table class="table table-hover">

					<tbody>
						<c:forEach items="${recordList}" var="rec">
							<tr>
								<th><p>
										<a href="${rec.link}" target="_blank"> <c:out
												value="${rec.title}" />
										</a>
									</p>
									<p>
										<c:out value="${rec.description}" />
									</p>
									<p>
										<a href="${rec.content}" target="_blank"> READ MORE >></a>
									</p></th>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>

	<%@include file="footer.jsp"%>