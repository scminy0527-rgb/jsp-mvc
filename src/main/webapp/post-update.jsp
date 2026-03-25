<%@page import="com.app.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<% 
		PostVO postVO = (PostVO)request.getAttribute("post");
	%>
	<h1>게시글 수정</h1>
	<form action="/mvc/update-ok.post" method="post">
		<input type="hidden" name="id" value="<%= postVO.getId() %>">
		<input type="hidden" name="postCreateAt" value="<%= postVO.getPostCreateAt() %>">
		<div>
			<span>게시글 제목</span>
			<input name="postTitle" value="<%= postVO.getPostTitle() %>">
		</div>
		<div>
			<span>게시글 내용</span>
			<input name="postContent" value="<%= postVO.getPostContent() %>">
		</div>
		
		<button>수정하기</button>
	</form>
</body>
</html>