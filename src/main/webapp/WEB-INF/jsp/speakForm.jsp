<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Speak Details</b>
				</div>
				<div align="right">
					<a href="getAllSpeaks">Speak List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="speakForm" cssClass="form-horizontal"
				modelAttribute="speak" method="post" action="saveSpeak">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="title">Title</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${speakObject.id}" />
						<form:input cssClass="form-control" path="title"
							value="${speakObject.title}" />
						<form:errors path="title" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" cssClass="control-label col-xs-3">Description</form:label>
					<div class="col-xs-6">
						<form:textarea cssClass="form-control" path="description" rows="5"
							cols="50" value="${speakObject.description}" />
						<form:errors path="description" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="url" cssClass="control-label col-xs-3">URL</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="url"
							value="${speakObject.url}" />
						<form:errors path="url" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveSpeak" class="btn btn-primary"
								value="Save" onclick="submitSpeakForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>