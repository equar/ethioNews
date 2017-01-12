<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Event Details</b>
				</div>
				<div align="right">
					<a href="getAllEvents">Event List</a>
				</div>
			</h3>
		</div>
		<div id="error"></div>
		<div class="panel-body">
			<form:form id="eventForm" cssClass="form-horizontal"
				modelAttribute="event" method="post" action="saveEvent"
				enctype="multipart/form-data">
				<span id="error"></span>
				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="type">Type</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${eventObject.id}" />
						<form:input cssClass="form-control" path="type"
							value="${eventObject.type}" />
						<form:errors path="type" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="address" cssClass="control-label col-xs-3">Address</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="address"
							value="${eventObject.address}" />
						<form:errors path="address" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="imagePath" cssClass="control-label col-xs-3">Image to upload:</form:label>
					<div class="col-xs-6">
						<input type="file" path="imagePath" name="file"
							value="${videoObject.imagePath}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveEvent" class="btn btn-primary"
								value="Save" onclick="submitEventForm()" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>