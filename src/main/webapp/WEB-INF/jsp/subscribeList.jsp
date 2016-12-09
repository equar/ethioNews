<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Subscribe Media List</b>
				</div>

			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty mediaList}">
                There are no Media to subscribe
            </c:if>
			<c:if test="${not empty mediaList}">
				<form:form id="subscribeForm" cssClass="form-horizontal"
					modelAttribute="subscription" method="post"
					action="subscribeToMedias">
					<div class="form-group">
						<form:label path="email" cssClass="control-label col-xs-3">Enter EMail:</form:label>
						<div class="col-xs-3">
							<form:input cssClass="form-control" path="email" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="frequency">News Frequency Demand:</form:label>
						<div class="col-xs-2">
							<form:select cssClass="form-control" path="frequency">
								<option value="immed">Immediately</option>
								<option value="daily">Daily</option>
								<option value="weekly">Weekly</option>
								<option value="monthly">Monthly</option>
							</form:select>
						</div>
					</div>



					<div class="form-group">
						<table>
							<!-- class="table table-hover table-bordered"> -->
							<!-- <thead style="background-color: #bce8f1;">
								<tr>
									<th>Please select the media you want to get news</th>
								</tr>
							</thead> -->
							<tbody>
								<c:forEach items="${mediaList}" var="med">
									<tr>
										<th><form:checkbox path="" value="${med}" /> <c:out
												value="${med.name}" /></th>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="col-xs-4">
						<input class="btn btn-success" type='submit' value='Subscribe' />
					</div>

				</form:form>
			</c:if>
		</div>
	</div>

	<%@include file="footer.jsp"%>