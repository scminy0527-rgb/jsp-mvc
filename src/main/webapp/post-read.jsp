<%@page import="com.app.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세정보</title>
</head>
<body>
	<%
		PostVO postVO = (PostVO)request.getAttribute("post");
	%>
	<h1><%= postVO.getPostTitle() %></h1>
	<p><%= postVO.getPostContent() %></p>
	<p><%= postVO.getPostCreateAt() %></p>
	
	<div>
		<a href="/mvc/update.post?id=<%= postVO.getId() %>">수정하기</a>
	</div>
	<div>
		<a href="/mvc/delete-ok.post?id=<%= postVO.getId() %>">삭제하기</a>
	</div>
</body>
</html>