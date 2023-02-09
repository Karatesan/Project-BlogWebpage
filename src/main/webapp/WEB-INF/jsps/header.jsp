<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<c:url value="/css/style.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet">


</head>
<body>
	<header>
		<div class="navbar">
			<!-- navigation bar with basic functions -->


			<div class="functions">


				<c:choose>
					<c:when test="${loggedIn == true}"> <!-- aAND CHECK FOR user.role -->
					
						<a class="italic"> ${user.username}</a>
						<a href="/logout"><spring:message code="label.logout"/></a>
						<a href="/posts/new">Add New Post</a>
						<a href="/admin/listUsers">Show all users</a>
						<!-------------- SEE PROFILE------------------------- -->
						<a href="/showProfile"><svg xmlns="http://www.w3.org/2000/svg"
								width="25" height="25" fill="currentColor"
								class="bi bi-person-circle" viewBox="0 0 16 16">
  						<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
 						 <path fill-rule="evenodd"
									d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
						</svg></a>


						
						
					
					</c:when>
					<c:otherwise>
    <div class='navigation-bar'>
        <div class="hamburger-menu">
            <div class="hamburger-menu-element"></div>
            <div class="hamburger-menu-element"></div>
            <div class="hamburger-menu-element"></div>
        </div>
        <div class="logins">
            <a href="/login" class='button'>Login</a>
            <a href="/goRegisterPage" class='button'>Sign Up</a>
        </div>
        <div class="blog-menu">
            <div class="navbar-searchBar">
                <input class="search-bar" type="search" id="search-bar" name="search" placeholder="Search">
            </div>
            <a href="/" class='button'>Home</a>
            <a href="/about" class='button'>About</a>
            <a href="mailto:maciej.gomulec@fdmgroup.com" class='button'>Contact</a>
            <a class='button support'>Patreon</a>
        </div>
    </div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>

	</header>
</body>
</html>