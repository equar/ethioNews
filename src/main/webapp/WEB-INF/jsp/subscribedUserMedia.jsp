<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>User Subscribed Medias</b>
				</div>
				<div align="right">
					<!-- <a href="getAllContacts">Contact List</a> -->
				</div>
			</h3>
		</div>

		<div class="panel-body">

			<div>
				<h4>Dear ${name}</h4>
				<p>You have subscribed to the below listed medias on a
					${frequency} basis. An email has been sent to ${email}</p>

				<div class="form-group">
					<table>

						<tbody>
							<c:forEach items="${mediaList}" var="med">
								<tr>
									<td><c:out value="${med.name}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<p>You can update your subscription any time by adding more
						subscribed medias, deleting already subscribed one or Totally
						unsubscribe</p>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>