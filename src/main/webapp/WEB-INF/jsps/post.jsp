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
	
	<h2 class="big-title-font">${ blogPost.title }</h2>
	<div class="blog-post-data">Author: ${blogPost.author.username }  Posted: ${blogPost.postedAt }</div>

	<div class="main-blog-container">
		<div class="blog-picture-container"> Picture here</div>

		<div class="blog-content-container"> ${blogPost.content }</div>
		<div class=comments-container> 
		<span style="color: red">${confirmation}</span><br>
			<form action="/addComment" method="post">
				<input type="hidden" name="username" value="${user.username}">
				<input type="hidden" name="articleId" value="${blogPost.blogPostId}">
				<input class="comment-box" type="text" name="content" placeholder="Comment" required>
				<input type="submit" value="Comment">
			</form>
			
	<c:forEach items="${blogPost.comments}" var="comment">
	
		<div class="comment-box">
		Commenter: ${comment.commenter.username }    date: ${comment.date }<br>
		Comment text: ${comment.content }
		</div>
	
	</c:forEach>
	
	</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>