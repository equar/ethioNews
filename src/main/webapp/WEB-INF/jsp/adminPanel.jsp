<c:if test="${pageContext.request.userPrincipal.name != null}">
	<div class="container-fluid text-center">
		<footer class="container-fluid text-center">
			<!-- <security:authorize access="hasRole('ROLE_ADMIN')"> -->
			<span><a href="getAllUserRoles">User Role Mgt</a>|</span>
			<!-- </security:authorize>
			<security:authorize access="hasRole('ROLE_ADMIN')"> -->
			<span><a href="getAllUsers">User Mgt</a>| </span>
			<!-- </security:authorize>
			<security:authorize access="hasAnyRole('ROLE_VIDEO','ROLE_ADMIN')"> -->
			<span><a href="getAllVideos">Video Mgt</a>|</span>
			<!-- </security:authorize>
			<security:authorize access="hasRole('ROLE_VIDEO')"> -->
			<span><a href="getAllMedias">Media Mgt</a>| </span>
			<!-- </security:authorize>
			<security:authorize access="hasRole('ROLE_ADMIN')"> -->
			<span><a href="recordCrawel">News Mgt</a>|</span>
			<!-- </security:authorize>
			<security:authorize access="hasRole('ROLE_ADMIN')"> -->
			<span><a href="getAllSubscribers">Subscription Mgt</a>|</span>
			<!-- </security:authorize>
			<security:authorize access="hasRole('ROLE_ADMIN')"> -->
			<span><a href="getAllContacts">Contact Mgt </a>|</span>
			<!-- </security:authorize>
			<security:authorize access="hasRole('ROLE_EVENT')"> -->
			<span><a href="getAllEvents">Event Mgt </a></span>
			<!-- </security:authorize> -->
		</footer>
	</div>
</c:if>