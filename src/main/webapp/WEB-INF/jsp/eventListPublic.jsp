<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Event List</b>
				</div>
				<div align="right">
					<!-- <a href="createVideo">Add New Video</a> -->
				</div>
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty eventList}">
                There are no events
            </c:if>
			<c:if test="${not empty eventList}">

				<form action="searchVideo">
					<div class="row">
						<div class="col-md-4">
							Search Event: <input type='text' name='title' id='title' />
						</div>
						<div class="col-md-4">
							<input class="btn btn-success" type='submit' value='Search' />
						</div>
					</div>
				</form>

				<table class="table table-hover table-bordered">

					<tbody>
						<c:forEach items="${eventList}" var="evnt">
							<tr>

								<th><img src="<c:out value="${evnt.imagePath}" />"
									alt="Event Image View" style="width: 304px; height: 228px;">

								</th>

								<th><c:out value="${evnt.address}" /></th>

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