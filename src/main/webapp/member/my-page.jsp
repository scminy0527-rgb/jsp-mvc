<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h1>회원 정보</h1>
	<h2>이름: <c:out value="${member.memberName}"></c:out> </h2>
	<h2>이메일: <c:out value="${member.memberEmail}"></c:out> </h2>
</body>
<script type="text/javascript">
	console.log("마이페이지 오신걸 환영합니다.")
	console.log(`${member}`)
</script>
</html>