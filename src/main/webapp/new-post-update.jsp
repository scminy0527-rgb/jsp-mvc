<%@page import="com.app.vo.PostVO"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>게시글 수정</title>
    <link rel="stylesheet" href="/mvc/css/post.css" />
  </head>
  <body>
    <% PostVO postVO = (PostVO)request.getAttribute("post"); %>

    <div class="card">
      <div class="card-header">
        <h1>게시글 수정</h1>
        <p>원하는 부분을 수정해주세요</p>
      </div>

      <form action="/mvc/update-ok.post" method="post">
        <input type="hidden" name="id" value="<%= postVO.getId() %>" />
        <input
          type="hidden"
          name="postCreateAt"
          value="<%= postVO.getPostCreateAt() %>"
        />
        <div class="form-group">
          <label for="postTitle">제목</label>
          <input
            type="text"
            id="postTitle"
            name="postTitle"
            value="<%= postVO.getPostTitle() %>"
            placeholder="제목을 입력해 주세요."
            required
          />
        </div>

        <div class="form-group">
          <label for="postContent">내용</label>
          <textarea
            id="postContent"
            name="postContent"
            placeholder="내용을 입력해 주세요."
            required
          ><%= postVO.getPostContent() %></textarea>
        </div>

        <div class="form-actions">
          <button type="button" class="btn btn-cancel" onclick="history.back()">
            취소
          </button>
          <button type="submit" class="btn btn-submit">작성하기</button>
        </div>
      </form>
    </div>
  </body>
</html>
