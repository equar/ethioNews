<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Ride Details</b>
				</div>
				<div align="right">
					<a href="getPublicRides">Ride List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="rideForm" cssClass="form-horizontal"
				modelAttribute="ride" method="post" action="saveRide">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="from">From City</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${rideObject.id}" />
						<form:input cssClass="form-control" path="from"
							value="${rideObject.from}" />
						<form:errors path="from" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="to" cssClass="control-label col-xs-3">To City</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="to"
							value="${rideObject.to}" />
						<form:errors path="to" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="date" cssClass="control-label col-xs-3">Leaving Date</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="date"
							value="${rideObject.date}" />
						<form:errors path="date" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="time" cssClass="control-label col-xs-3">Leaving Time</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="time"
							value="${rideObject.time}" />
						<form:errors path="time" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phonenumber" cssClass="control-label col-xs-3">Contact Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phonenumber"
							value="${rideObject.phonenumber}" />
						<form:errors path="phonenumber" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" cssClass="control-label col-xs-3">Description</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="description"
							value="${rideObject.description}" />
						<form:errors path="description" cssStyle="color: #ff0000;" />
					</div>
				</div>



				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveRide" class="btn btn-primary"
								value="Save" onclick="submitRideForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>