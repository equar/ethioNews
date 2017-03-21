<c:if test="${pageContext.request.userPrincipal.name != null}">
	<div class="container-fluid text-center">
		<footer class="container-fluid text-center">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span><a href="getAllUserRoles">User Role Mgt</a>|</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span><a href="getAllUsers">User Mgt</a>| </span>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_VIDEO','ROLE_ADMIN')">
				<span><a href="getAllVideos">Video Mgt</a>|</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_VIDEO')">
				<span><a href="getAllMedias">Media Mgt</a>| </span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span><a href="recordCrawel">News Mgt</a>|</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span><a href="getAllSubscribers">Subscription Mgt</a>|</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span><a href="getAllContacts">Contact Mgt </a>|</span>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_EVENT')">
				<span><a href="getAllEvents">Event Mgt </a>|</span>
			</sec:authorize>
			<sec:authorize
				access="hasAnyRole('ROLE_VIDEO','ROLE_ADMIN','ROLE_EVENT')">
				<span><a href="passwordChange">Change Password</a>|</span>
			</sec:authorize>
		</footer>
	</div>
</c:if>