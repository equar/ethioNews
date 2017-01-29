<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Crawel News Manually</b>
				</div>

			</h3>
		</div>
		<div class="panel-body"></div>

		<div>
			If you want to crawel news in case the auto crawel is not working,
			Please click on <a href="createRecord">Start Manually</a>
		</div>
		<div>${status}</div>
	</div>

</div><%@include file="adminPanel.jsp"%>
<%@include file="footer.jsp"%>