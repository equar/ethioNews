<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Profession Details</b>
				</div>
				<div align="right">
					<a href="getUserProfessions">Profession List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="professionForm" cssClass="form-horizontal"
				modelAttribute="profession" method="post" action="saveProfession">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="name">Business/Person Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${professionObject.id}" />
						<form:input cssClass="form-control" path="name"
							value="${professionObject.title}" />
						<form:errors path="name" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="type" cssClass="control-label col-xs-3">Profession Type</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="type"
							value="${professionObject.type}" />
						<form:errors path="type" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="address" cssClass="control-label col-xs-3">Address</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="address"
							value="${professionObject.address}" />
						<form:errors path="address" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phonenumber" cssClass="control-label col-xs-3">Phone Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phonenumber"
							value="${professionObject.phonenumber}" />
						<form:errors path="phonenumber" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="website" cssClass="control-label col-xs-3">Web Site</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="website"
							value="${professionObject.website}" />
						<form:errors path="website" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="description" cssClass="control-label col-xs-3">Description</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="description"
							value="${professionObject.description}" />
						<form:errors path="description" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveProfession" class="btn btn-primary"
								value="Save" onclick="submitProfessionForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>