<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
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
							<td><img src="${rec.imageURL}" alt="Image not available"
								style="width: 240px; height: 180px;"></td>
							<td>
								<p>
								<h4>
									<a href="${rec.link}" target="_blank"> <c:out
											value="${rec.title}" />
									</a>
								</h4>
								</p>

								<p>
									<span align="left">${rec.media.name}</span>&emsp; <span
										align="right"><fmt:formatDate value="${rec.date}"
											pattern="EEEE, MMMM dd,yyyy HH:mm a" /></span>
								</p>
								<p>${rec.description}</p>
							</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>

			<tag:paginate max="10" offset="${offset}" count="${count}" uri="news"
				next="&raquo;" previous="&laquo;" />

		</div>
	</div>
</div>
<%@include file="footer.jsp"%>