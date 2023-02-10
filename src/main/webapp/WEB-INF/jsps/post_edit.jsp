<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/css/style3.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" /><br>

	<br>
	<h2 class="big-title-font">Edit your post</h2>
	<h2 class="big-title-font">${ blogPost.title }</h2>
	<div class="blog-post-data">Author: ${blogPost.author.username }  Posted: ${blogPost.postedAt }</div>
	<div class="blog-content-container"> ${blogPost.content }</div>
		<form action="/posts/${blogPost.blogPostId}/edit" method="get">
				<input type="submit" value="Edit">
		</form>
		<form action="/posts/${blogPost.blogPostId}/delete" method="get">
				<input type="submit" value="Delete">
		</form>

	<jsp:include page="footer.jsp" />
</body>
</html>