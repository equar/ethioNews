<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Amenity Details</b>
				</div>
				<div align="right">
					<a href="getAllAmenities">Amenity List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="amenityRegisterForm" cssClass="form-horizontal"
				modelAttribute="amenity" method="post" action="saveAmenity">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="amenityName">Amenity Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="amenityId" value="${amenityObject.amenityId}" />
						<form:input cssClass="form-control" path="amenityName"
							value="${amenityObject.amenityName}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveAmenity" class="btn btn-primary"
								value="Save" onclick="return submitAmenityForm();" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function submitAmenityForm() {

		// getting the UserRole form values
		var name = $('#amenityName').val().trim();
		if (name.length == 0) {
			alert('Please enter amenity name');
			$('#amenityName').focus();
			return false;
		}

		return true;
	};
</script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>