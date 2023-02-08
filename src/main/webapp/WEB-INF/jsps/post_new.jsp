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
	
	<div class="author-photo-box2">
			<img class="author2" src="pictures/Gamer2.png">
		</div>
<div class="in-center">
	<h3>Add new post</h3>
	
		
	<span style="color: red">${errorMessage}</span>
	<br>
	<form action="#" th:action="@{'/posts/new'}" method="post">
		<input type="hidden" th:field="*{author}" /><br>
		<input type="hidden" th:field="*{postedAt}" /><br>
		<label>Title</label>
		<input class="form-field" type="text" name="title" placeholder="Title"/><br>
		<label>Body of the post</label>
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