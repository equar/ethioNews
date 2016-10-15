<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>BusLevel List</b>
				</div>
				<div align="right">
					<a href="createBusLevel">Add New BusLevel</a>
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty busLevelList}">
                There are no BusLevel
            </c:if>
			<c:if test="${not empty busLevelList}">

				<form action="searchBusLevel">
					<div class="row">
						<div class="col-md-4">
							Search BusLevel: <input type='text' name='levelDesc'
								id='levelDesc' />
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
							<th>LevelDesc</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${busLevelList}" var="level">
							<tr>
								<th><c:out value="${level.levelId}" /></th>
								<th><c:out value="${level.levelDesc}" /></th>
								<th><a
									href="editBusLevel?id=<c:out value='${level.levelId}'/>">Edit</a></th>
								<th><a
									href="deleteBusLevel?id=<c:out value='${level.levelDesc}'/>">Delete</a></th>
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

	<%@include file="topbus.jsp"%>
	<%@include file="footer.jsp"%>