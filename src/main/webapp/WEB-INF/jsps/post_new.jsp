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
	
<div class="in-center">
	<h3>Add new post</h3>
	
		
	<span style="color: red">${errorMessage}</span>
	<br>
	<form action="/posts/new" method="post">
		<input type="hidden" name="authorUsername" value="${ newPost.author }" /><br>
		<input type="hidden" name="authorUsername" value="${ newPost.author }" /><br>
		<label class="name-box">Title</label><br>
		<input class="form-field" type="text" name="title" placeholder="Title"/><br>
		<label class="name-box">Body of the post</label><br>
		<input class="form-field" type="text" name="content" placeholder="Content"/><br>
		<br> 
		<input class="form-field submit-button2" type="submit" value="Add post">
	</form>
	<br>
	<br>
</div>

	<jsp:include page="footer.jsp" />


</body>
</html>