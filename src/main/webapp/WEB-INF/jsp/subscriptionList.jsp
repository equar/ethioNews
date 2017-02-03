<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Subscribers List</b>
				</div>

			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty subscriptionList}">
                There are no Subscribers
            </c:if>
			<c:if test="${not empty subscriptionList}">

				<form action="searchSubscriber">
					<div class="row">
						<div class="col-md-4">
							Search Subscriber: <input type='text' name='name' id='name' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover table-bordered">
					<thead style="background-color: #bce8f1;">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Frequency</th>
							<th>Date</th>
							<!-- <th>Detail</th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${subscriptionList}" var="sub">
							<tr>
								<td><c:out value="${sub.id}" /></td>
								<td><c:out value="${sub.name}" /></td>
								<td><c:out value="${sub.email}" /></td>
								
								<td><c:out value="${sub.frequency}" /></td>
								
								<td><c:out value="${sub.frequency}" /></td>
							
								<%-- <th><a
									href="detailSubscribers?id=<c:out value='${sub.id}'/>">Detail</a></th> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>