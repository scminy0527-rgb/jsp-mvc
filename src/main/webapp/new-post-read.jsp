<%@page import="com.app.vo.PostVO"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>게시글 상세정보</title>
    <link rel="stylesheet" href="/mvc/css/post.css" />
  </head>
  <body>
    <% PostVO postVO = (PostVO)request.getAttribute("post"); %>

    <div class="card">
      <div class="post-meta">
        <span class="post-date"><%= postVO.getPostCreateAt() %></span>
      </div>

      <h1 class="post-title"><%= postVO.getPostTitle() %></h1>

      <hr class="divider" />

      <p class="post-content"><%= postVO.getPostContent() %></p>

      <div class="form-actions">
        <a href="/mvc/list.post" class="btn btn-cancel" style="margin-right: auto;">목록</a>
        <a href="/mvc/update.post?id=<%= postVO.getId() %>" class="btn btn-edit">수정하기</a>
        <a href="#" class="btn btn-delete"
           onclick="location.replace('/mvc/delete-ok.post?id=<%= postVO.getId() %>')">삭제하기</a>
      </div>
    </div>
  </body>
</html>
