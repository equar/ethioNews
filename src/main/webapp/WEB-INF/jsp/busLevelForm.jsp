<%@include file="header.jsp"%>
<%@include file="slidebus.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>BusLevel Details</b>
				</div>
				<div align="right">
					<a href="getAllBusLevels">BusLevel List</a>
				</div>
			</h3>
		</div>

		<div class="panel-body">
			<form:form id="busLevelRegisterForm" cssClass="form-horizontal"
				modelAttribute="busLevel" method="post" action="saveBusLevel">

				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="levelDesc">BusLevel Description</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="levelId" value="${busLevelObject.levelId}" />
						<form:input cssClass="form-control" path="levelDesc"
							value="${busLevelObject.levelDesc}" />
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveBusLevel" class="btn btn-primary"
								value="Save" onclick="return submitBusLevelForm();" />
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
	function submitBusLevelForm() {

		// getting the UserRole form values
		var name = $('#levelDesc').val().trim();
		if (name.length == 0) {
			alert('Please enter BusLevel Description');
			$('#levelDesc').focus();
			return false;
		}

		return true;
	};
</script>

<%@include file="topbus.jsp"%>
<%@include file="footer.jsp"%>