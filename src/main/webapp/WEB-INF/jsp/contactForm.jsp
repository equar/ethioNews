<%@include file="header.jsp"%>
<%@include file="adminPanel.jsp"%>
<div class="container myrow-container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">
				<div align="left">
					<b>Use the following form to contact us</b>
				</div>
				<div align="right">
					<!-- <a href="getAllContacts">Contact List</a> -->
				</div>
			</h3>
		</div>
		<div id="error"></div>
		<div cssStyle="color: #ff0000;">${status}</div>
		<div>Your feedback is really important to us, so please feel
			free to drop us a line. If you are expecting a response, you will
			need to provide us your email* address, of course.</div>
		<div class="panel-body">

			<form:form id="contactForm" cssClass="form-horizontal"
				modelAttribute="contact" method="post" action="saveContact">
				<span id="error"></span>
				<div class="form-group">
					<div class="control-label col-xs-3">
						<form:label path="name">Name</form:label>
					</div>
					<div class="col-xs-6">
						<form:hidden path="id" value="${contactObject.id}" />
						<form:input cssClass="form-control" path="name"
							value="${contactObject.name}" />
						<form:errors path="name" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="email" cssClass="control-label col-xs-3">Email</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="email"
							value="${contactObject.email}" />
						<form:errors path="email" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="subject" cssClass="control-label col-xs-3">Subject</form:label>
					<div class="col-xs-6">
						<form:input cssClass="form-control" path="subject"
							value="${contactObject.subject}" />
						<form:errors path="subject" cssStyle="color: #ff0000;" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="message" cssClass="control-label col-xs-3">Message</form:label>
					<div class="col-xs-6">
						<form:textarea cssClass="form-control" path="message" rows="5"
							cols="30" value="${contactObject.message}" />
						<form:errors path="message" cssStyle="color: #ff0000;" />
					</div>
				</div>
				<form:hidden path="status" value="false" />
				<div class="form-group">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<input type="submit" id="saveContact" class="btn btn-primary"
								value="Submit" onclick="submitContactForm()" />
						</div>
						<div class="col-xs-4"></div>
					</div>
				</div>

			</form:form>
			<div class="row">
				<div>You may use this contact form to:</div>
				<div>
					<ul>
						<li>report any inaccuracies in the information presented on
							this website,</li>
						<li>advertise with us to promote your product or the services
							you provide, or</li>
						<li>provide suggestions to improve this website.</li>
					</ul>
				</div>
			</div>
			<div>We respect your privacy, so the information that you
				provide remains confidential. We will never share your email address
				or other personal information with anyone.</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>