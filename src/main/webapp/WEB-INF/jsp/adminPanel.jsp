<div class="container-fluid text-center">
	<footer class="container-fluid text-center">
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<span><a href="getAllUserRoles">User Role Mgt</a>|</span>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<span><a href="getAllUsers">User Mgt</a>| </span>
		</security:authorize>
		<span><a href="getAllVideos">Video Mgt</a></span>| <span><a
			href="getAllMedias">Media Mgt</a>| </span> <span><a
			href="recordCrawel">News Mgt</a></span>| <span><a
			href="getAllSubscribers">Subscription Mgt</a></span>| <span><a
			href="getAllContacts">Contact Mgt </a></span>|
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<span><a href="getAllEvents">Event Mgt </a></span>
		</security:authorize>
	</footer>
</div>