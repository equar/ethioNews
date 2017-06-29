<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Job Details</b>
				</div>
				<div align="right">
					<a href="getAllJobs">Job List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="jobForm" cssClass="form-horizontal"
				modelAttribute="job" method="post" action="saveJob">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="title">Job Title</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${jobObject.id}" />
						<form:input cssClass="form-control" path="title"
							value="${jobObject.title}" />
						<form:errors path="title" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" cssClass="control-label col-xs-3">Description</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="description"
							value="${jobObject.description}" />
						<form:errors path="description" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="location" cssClass="control-label col-xs-3">Job Location</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="location"
							value="${jobObject.location}" />
						<form:errors path="location" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phoneNumber" cssClass="control-label col-xs-3">PhoneNumber</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phoneNumber"
							value="${jobObject.phoneNumber}" />
						<form:errors path="phoneNumber" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="email" cssClass="control-label col-xs-3">Email</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="email"
							value="${jobObject.email}" />
						<form:errors path="email" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="available" cssClass="control-label col-xs-3">Is available</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="available"
							value="${jobObject.available}" />
						<form:errors path="available" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveJob" class="btn btn-primary"
								value="Save" onclick="submitJobForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>