<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Rent Details</b>
				</div>
				<div align="right">
					<a href="getAllRents">Rent List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="rentForm" cssClass="form-horizontal"
				modelAttribute="rent" method="post" action="saveRent">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="beds">Beds</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${rentObject.id}" />
						<form:input cssClass="form-control" path="beds"
							value="${rentObject.beds}" />
						<form:errors path="beds" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="baths" cssClass="control-label col-xs-3">Baths</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="baths"
							value="${rentObject.baths}" />
						<form:errors path="baths" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="price" cssClass="control-label col-xs-3">Rent Price</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="price"
							value="${rentObject.price}" />
						<form:errors path="price" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="address" cssClass="control-label col-xs-3">Address</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="address"
							value="${rentObject.address}" />
						<form:errors path="address" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="phonenumber" cssClass="control-label col-xs-3">Phone Number</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="phonenumber"
							value="${rentObject.phonenumber}" />
						<form:errors path="phonenumber" cssStyle="color: #ff0000;" />
					</div>
				</div>


				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveRent" class="btn btn-primary"
								value="Save" onclick="submitRentForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>