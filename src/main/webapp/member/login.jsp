<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<c:if test="${param.flag == 'memberEmail'}">
		이메일 주소 에러
	</c:if>
	<c:if test="${param.flag == 'memberPassword'}">
		비밀번호 에러
	</c:if>
	<form action="login-ok.member" method="post">
		<div>
			<span>이메일</span>
			<input name="memberEmail" placeholder="이메일을 입력하세요">
		</div>
		<div>
			<span>비밀번호</span>
			<input name="memberPassword" placeholder="비밀번호를 입력하세요" type="password">
		</div>
		<button>로그인</button>
	</form>
</body>
</html>