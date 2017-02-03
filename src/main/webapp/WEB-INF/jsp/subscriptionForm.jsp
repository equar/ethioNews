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
						<form:label path="name" cssClass="control-label col-xs-3">Name:</form:label>
						<div class="col-xs-3">
							<form:input cssClass="form-control" path="name" />
							<form:errors path="name" cssStyle="color: #ff0000;" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="email" cssClass="control-label col-xs-3">EMail:</form:label>
						<div class="col-xs-3">
							<form:input cssClass="form-control" path="email" />
							<form:errors path="email" cssStyle="color: #ff0000;" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="frequency" cssClass="control-label col-xs-3">Frequency:</form:label>
						<div class="col-xs-3">
							<form:select cssClass="form-control" path="frequency">
								<option value="daily">Daily</option>
								<option value="weekly">Weekly</option>
								<option value="monthly">Monthly</option>
							</form:select>
							<form:errors path="frequency" cssStyle="color: #ff0000;" />
						</div>
					</div>

					<%-- <div class="form-group">
						<table>

							<tbody>
								<%!int length = 0;%>
								<c:forEach items="${mediaList}" var="med" varStatus="count">
								<c:forEach items="${mediaList}" var="med" varStatus="status">
									<tr>
										<td>${count.count}</td>
										<td><form:checkbox path="media" value="${med.id}" /> <c:out
												value="${med.name}" /></td>


									</tr>

								</c:forEach>
								<tr>
								<td>Choose the Media you like:</td>
								<td><form:checkboxes path="media" items="${mediaList}" />
								</td>
								</tr>
							</tbody>
						</table>
					</div> --%>

					<div class="col-xs-4">
						<input class="btn btn-success" type='submit' value='Subscribe' />
					</div>

				</form:form>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>