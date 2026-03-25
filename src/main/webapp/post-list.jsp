<%@page import="com.app.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<% 
		List<PostVO> postList = (List<PostVO>)request.getAttribute("postList");
	%>
	<h1>게시글 목록 조회</h1>
	<table border="1">
		<tr>
			<th>id</th>
			<th>제목</th>
			<th>작성일자</th>
		</tr>
		<%
			for(PostVO postVO : postList){
				%>
					<tr>
						<td><%= postVO.getId() %></td>
						<td>
							<a href="/mvc/read.post?id=<%= postVO.getId() %>">
								<%= postVO.getPostTitle() %>
							</a>
						</td>
						<td><%= postVO.getPostCreateAt() %></td>
					</tr>
				<%
			}
		%>
	</table>
	<a href="/mvc/write.post">게시글 작성</a>
</body>
</html>