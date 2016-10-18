<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>TicketAgent List</b>
				</div>
				<div align="right">
					<a href="createTicketAgent">Add New TicketAgent</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty ticketAgentList}">
                There are no TicketAgent
            </c:if>
			<c:if test="${not empty ticketAgentList}">

				<form action="searchTicketAgent">
					<div class="row">
						<div class="col-md-4">
							Search TicketAgent: <input type='text' name='contactName'
								id='contactName' />
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
							<th>Contact Name</th>
							<th>EmailId</th>
							<th>Address</th>
							<th>EmailId</th>
							<th>PhoneNumber</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ticketAgentList}" var="tick">
							<tr>
								<th><c:out value="${tick.agentId}" /></th>
								<th><c:out value="${tick.contactName}" /></th>
								<th><c:out value="${tick.address}" /></th>
								<th><c:out value="${tick.emailId}" /></th>
								<th><c:out value="${tick.phoneNumber}" /></th>
								<th><a
									href="editTicketAgent?id=<c:out value='${tick.agentId}'/>">Edit</a></th>
								<th><a
									href="deleteTicketAgent?id=<c:out value='${tick.agentId}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	
	<%@include file="footer.jsp"%>