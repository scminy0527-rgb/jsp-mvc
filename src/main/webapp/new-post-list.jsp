<%@page import="com.app.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 목록</title>
<link rel="stylesheet" href="/mvc/css/post.css">
</head>
<body>

  <%
    List<PostVO> postList = (List<PostVO>)request.getAttribute("postList");
  %>

  <div class="list-container">
    <div class="list-header">
      <h1>게시글 목록</h1>
      <a href="/mvc/write.post" class="btn btn-submit">글쓰기</a>
    </div>

    <table class="post-table">
      <thead>
        <tr>
          <th>No</th>
          <th>제목</th>
          <th>작성일자</th>
        </tr>
      </thead>
      <tbody>
        <%
          for(PostVO postVO : postList) {
        %>
        <tr>
          <td class="col-id"><%= postVO.getId() %></td>
          <td class="col-title">
            <a href="/mvc/read.post?id=<%= postVO.getId() %>">
              <%= postVO.getPostTitle() %>
            </a>
          </td>
          <td class="col-date"><%= postVO.getPostCreateAt() %></td>
        </tr>
        <%
          }
        %>
      </tbody>
    </table>
  </div>

</body>
</html>
