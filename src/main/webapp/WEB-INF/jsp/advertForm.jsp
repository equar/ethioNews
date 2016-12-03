<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Advertisement Application Form</b>
				</div>
				<div align="right">
					<!-- <a href="getAllMedias">Media List</a> -->
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="advertForm" cssClass="form-horizontal"
				modelAttribute="advertisement" method="post" action="saveAdvert">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="firstName">First Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${advertObject.id}" />
						<form:input cssClass="form-control" path="firstName"
							value="${advertObject.firstName}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="lastName" cssClass="control-label col-xs-3">Last Name</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="lastName"
							value="${advertObject.lastName}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="email" cssClass="control-label col-xs-3">Email</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="email"
							value="${advertObject.email}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phoneNumber" cssClass="control-label col-xs-3">Phone Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phoneNumber"
							value="${advertObject.phoneNumber}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="country" cssClass="control-label col-xs-3">Country</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="country"
							value="${advertObject.country}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="city" cssClass="control-label col-xs-3">City</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="city"
							value="${advertObject.city}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="type" cssClass="control-label col-xs-3">Type</form:label>
					<div class="col-xs-6">
						<form:select cssClass="form-control" path="type">
							<option value="business">Business</option>
							<option value="event">Event</option>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<form:label path="fileName" cssClass="control-label col-xs-3">File Name</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="fileName"
							value="${advertObject.fileName}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveAdvert" class="btn btn-primary"
								value="Save" onclick="return submitAdvertForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>