<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Media Details</b>
				</div>
				<div align="right">
					<a href="getAllMedias">Media List</a>
				</div>
			</h3>
		</div>
		<div id="error"></div>
		<div class="panel-body">
			<form:form id="mediaForm" cssClass="form-horizontal"
				modelAttribute="media" method="post" action="saveMedia">
				<span id="error"></span>
				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="name">Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${mediaObject.id}" />
						<form:input cssClass="form-control" path="name"
							value="${mediaObject.name}" />
						<form:errors path="name" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="url" cssClass="control-label col-xs-3">URL</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="url"
							value="${mediaObject.url}" />
						<form:errors path="url" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="type" cssClass="control-label col-xs-3">Type</form:label>
					<div class="col-xs-6">
						<form:select cssClass="form-control" path="type">
							<option value="website">Website</option>
							<option value="tv">TV</option>
							<option value="radio">Radio</option>
							<option value="paper">News Paper</option>
						</form:select>
						<form:errors path="type" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="language" cssClass="control-label col-xs-3">Language</form:label>
					<div class="col-xs-6">
						<form:select cssClass="form-control" path="language">
							<option value="english">English</option>
							<option value="amharic">Amharic</option>
							<option value="oromifa">Oromifa</option>
							<option value="tigrigna">Tigrigna</option>
						</form:select>
						<form:errors path="language" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="country" cssClass="control-label col-xs-3">Country</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="country"
							value="${mediaObject.country}" />
						<form:errors path="country" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="crawel" cssClass="control-label col-xs-3">Crawel</form:label>
					<div class="col-xs-6">
						<form:radiobutton path="crawel" value="true" />
						Yes
						<form:radiobutton path="crawel" value="false" />
						No
						<form:errors path="crawel" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveMedia" class="btn btn-primary"
								value="Save" onclick="submitMediaForm()" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>