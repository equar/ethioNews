<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Record Details</b>
				</div>
				<div align="right">
					<a href="getAllRecords">Record List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="recordForm" cssClass="form-horizontal"
				modelAttribute="record" method="post" action="saveRecord">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="title">Title</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${recordObject.id}" />
						<form:input cssClass="form-control" path="title"
							value="${recordObject.title}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" cssClass="control-label col-xs-3">Description</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="description"
							value="${recordObject.description}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="url" cssClass="control-label col-xs-3">URL</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="url"
							value="${recordObject.url}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="category" cssClass="control-label col-xs-3">Category</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="category"
							value="${recordObject.category}" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="media" cssClass="control-label col-xs-3">Media</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="media"
							value="${recordObject.media}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="savePassenger" class="btn btn-primary"
								value="Save" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>