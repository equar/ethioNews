<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>SpeakUp List</b>
				</div>
				<div align="right">
					<a href="CreateSpeak">Post Speak</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty speakList}">
                There are no blogs or articles shared by any one
            </c:if>
			<c:if test="${not empty speakList}">

				<form action="searchSpeak">
					<div class="row">
						<div class="col-md-4">
							Search Speak: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover">
					<tbody>
						<c:forEach items="${speakList}" var="spk" varStatus="itr">
							<tr>
								<td>
									<p>
									<h4>
										<a href="${spk.url}" target="_blank"> <c:out
												value="${spk.title}" />
										</a>
									</h4>
									</p>

									<p>
										By <span align="left">${spk.author}</span>&emsp; <span
											align="right"><fmt:formatDate
												value="${spk.updateDate}"
												pattern="EEEE, MMMM dd,yyyy HH:mm a" /></span>
									</p>
									<p>${spk.description}</p>
								</td>
							<tr>
						</c:forEach>
					</tbody>
				</table>

				<tag:paginate max="10" offset="${offset}" count="${count}"
					uri="getPublicSpeaks" next="&raquo;" previous="&laquo;" />
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>