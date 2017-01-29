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

			<table class="table table-hover">

				<tbody>
					<c:forEach items="${records}" var="rec" varStatus="itr">
						<tr>
							<td colspan="2">
								<h4>
									<a href="${rec.link}" target="_blank"> <c:out
											value="${rec.title}" />
									</a>
								</h4>
							</td>
						</tr>
						<tr>
							<td>Image not available</td>
							<td>
								<p>
									<c:out value="${rec.description}" />
								</p>
								<p>
									<a href="newsContent?content=<c:out value='${rec.content}'/>">
										READ MORE >></a>
								</p>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

			<tag:paginate max="10" offset="${offset}" count="${count}" uri="news"
				next="&raquo;" previous="&laquo;" />

		</div>
	</div>

	<%@include file="footer.jsp"%>