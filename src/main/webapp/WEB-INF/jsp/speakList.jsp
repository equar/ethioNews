<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Speak List</b>
				</div>
				<div align="right">
					<a href="createSpeak">Add New Speak</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty speakList}">
                There are no Speak
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

				<table class="table table-hover table-bordered">
					<thead style="background-color: #bce8f1;">
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Description</th>
							<th>Up</th>
							<th>Down</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${speakList}" var="spk">
							<tr>
								<th><c:out value="${spk.id}" /></th>
								<th><c:out value="${spk.title}" /></th>
								<th><c:out value="${spk.description}" /></th>
								<th><c:out value="${spk.up}" /></th>
								<th><c:out value="${spk.down}" /></th>
								<th><a href="editSpeak?id=<c:out value='${spk.id}'/>">Edit</a></th>
								<th><a href="deleteSpeak?id=<c:out value='${spk.id}'/>">Delete</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>