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
					<form:label path="type" cssClass="control-label col-xs-3">Event Type</form:label>
					<form:hidden path="id" value="${eventObject.id}" />
					<div class="col-xs-6">
						<form:select cssClass="form-control" path="type">
							<option value="concert">Concert</option>
							<option value="party">Party</option>
							<option value="meeting">Meeting</option>
							<option value="seminar">Seminar</option>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" cssClass="control-label col-xs-3">Event Description</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="description"
							value="${eventObject.description}" />
						<form:errors path="description" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="address" cssClass="control-label col-xs-3">Street address</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="address"
							value="${eventObject.address}" />
						<form:errors path="address" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="city" cssClass="control-label col-xs-3">City</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="city"
							value="${eventObject.city}" />
						<form:errors path="city" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="zipCode" cssClass="control-label col-xs-3">Zip Code</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="zipCode"
							value="${eventObject.zipCode}" />
						<form:errors path="zipCode" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="country" cssClass="control-label col-xs-3">Country</form:label>
					<div class="col-xs-6">
						<form:select cssClass="form-control" path="country"></form:select>
					</div>
				</div>
				<div class="form-group">
					<form:label path="state" cssClass="control-label col-xs-3">State</form:label>
					<div class="col-xs-6">
						<form:select cssClass="form-control" path="state"></form:select>
					</div>
				</div>
				<script language="javascript">
					populateCountries("country", "state");
				</script>

				<div class="form-group">
					<form:label path="date" cssClass="control-label col-xs-3">Event Date</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="date"
							value="${eventObject.date}" />
						<form:errors path="date" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="time" cssClass="control-label col-xs-3">Time starts</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="time"
							value="${eventObject.time}" />
						<form:errors path="time" cssStyle="color: #ff0000;" />
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