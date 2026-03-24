<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
</head>
<body>
	<form action="/mvc/write-ok.product" method="post">
		<div>
			<span>상품명</span>
			<input name="productName">
		</div>
		<div>
			<span>상품 가격</span>
			<input name="productPrice">
		</div>
		<div>
			<span>상품 재고</span>
			<input name="productStock">
		</div>
		<button>상품 등록</button>
	</form>
</body>
</html>