<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EthioNews One Stop News</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/ethioNews.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/ethioNews.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/countries.js" />">
	
</script>

<script src="https://code.jquery.com/jquery-2.1.3.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script>
	$(function() {
		$("#date").datepicker();
	});
</script> -->
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">sidraBook</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="news">News</a></li>
				<!-- <li><a href="getPublicVideos">Video</a></li> -->
				 <li><a href="getPublicEvents">Events</a></li> 
				<!-- <li><a href="getMediasToSubscribe">Subscribe</a></li> -->
				 <li><a href=getPublicJobs>Jobs</a></li>
				<li><a href=getPublicProfessions>Professional Services</a></li>
				<li><a href=getPublicRides>Ride Sharing</a></li>
				<li><a href=getPublicRents>Rent Sharing</a></li>
				<li><a href=getPublicSpeaks>Speak Up</a></li> 
				 <li><a href=createContact>Contact Us</a></li> 
			</ul>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<ul class="nav navbar-nav navbar-right">
					<!-- <li><a href=createContact>Contact Us</a></li> -->
					<li><a href="userLogin"><span
							class="glyphicon glyphicon-log-in"></span> Sign Up/Sign In</a></li>
				</ul>
			</c:if>

			<c:url value="/logout" var="logoutUrl" />
			<form id="logout" action="${logoutUrl}" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<ul class="nav navbar-nav navbar-right">
					<!-- <li><a href=createContact>Contact Us</a></li> -->
					<li><a
						href="javascript:document.getElementById('logout').submit()"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
			</c:if>

		</div>
	</div>
	</nav>