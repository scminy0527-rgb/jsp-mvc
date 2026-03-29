<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/mvc/join-ok.member" method="post">
		<div>
			<span>이름</span>
			<input name="memberName" placeholder="이름을 입력하세요">
		</div>
		<div>
			<span>이메일</span>
			<input name="memberEmail" placeholder="이메일을 입력하세요">
		</div>
		<div>
			<span>비밀번호</span>
			<input name="memberPassword" placeholder="비밀번호를 입력하세요">
		</div>
		<button>회원가입</button>
	</form>
</body>
</html>