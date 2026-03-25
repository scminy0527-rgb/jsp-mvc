<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h1>즐거운 게시글 작성</h1>
	<form action="/mvc/write-ok.post", method="post">
		<div>
			<span>게시글 제목</span>
			<input name="postTitle">
		</div>
		<div>
			<span>게시글 내용</span>
			<input name="postContent">
		</div>
		<button>작성하기</button>
	</form>
</body>
</html>