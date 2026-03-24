<%@page import="com.app.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록 페이지</title>
</head>
<body>
	<%
		List<ProductVO> products = (List<ProductVO>)request.getAttribute("products");
		System.out.println(products);
	%>
	<h1>!!상품목록 조회!!</h1>
	<table border="1">
		<tr>
			<th>id</th>
			<th>상품 명</th>
			<th>상품 가격</th>
			<th>상품 재고</th>
		</tr>
		<% 
			for(ProductVO product : products){
				%>
					<tr>
						<td><%= product.getId() %></td>
						<td>
							<a href="/mvc/read.product?id=<%= product.getId() %>">
								<%= product.getProductName() %>
							</a>
						</td>
						<td><%= product.getProductPrice() %></td>
						<td><%= product.getProductStock() %></td>
					</tr>
				<%
			}
		%>
	</table>
</body>
</html>