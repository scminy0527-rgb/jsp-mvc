<%@page import="java.util.Optional"%>
<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 상품의 상세 정보^^</title>
</head>
<body>
	<% 
		ProductVO productVO = (ProductVO)request.getAttribute("product");
		Optional<ProductVO> foundProduct = Optional.ofNullable(productVO);
		
		if(foundProduct.isPresent()){
			%>
				<h1>상품 상세 조회</h1>
				<table border="1">
					<tr>
						<th>id</th>
						<th>상품 명</th>
						<th>상품 가격</th>
						<th>상품 재고</th>
					</tr>
					<tr>
						<td><%= productVO.getId() %></td>
						<td><%= productVO.getProductName() %></td>
						<td><%= productVO.getProductPrice() %></td>
						<td><%= productVO.getProductStock() %></td>
					</tr>
				</table>
				
				<div>
					<a href="/mvc/update.product?id=<%= productVO.getId() %>">수정하기</a>
				</div>
				<div>
					<a href="/mvc/delete.product?id=<%= productVO.getId() %>">삭제하기</a>
				</div>
			<%
		} else {
			%>
				<h2>상품 없음. ㅠㅠㅠ</h2>
			<%
		}
	%>

</body>
</html>