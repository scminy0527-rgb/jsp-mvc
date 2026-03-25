<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 작성</title>
<link rel="stylesheet" href="/mvc/css/post.css">
</head>
<body>

  <div class="card">
    <div class="card-header">
      <h1>게시글 작성</h1>
      <p>새로운 게시글을 작성해 주세요.</p>
    </div>

    <form action="/mvc/write-ok.post" method="post">
      <div class="form-group">
        <label for="postTitle">제목</label>
        <input type="text" id="postTitle" name="postTitle" placeholder="제목을 입력해 주세요." required>
      </div>

      <div class="form-group">
        <label for="postContent">내용</label>
        <textarea id="postContent" name="postContent" placeholder="내용을 입력해 주세요." required></textarea>
      </div>

      <div class="form-actions">
        <button type="button" class="btn btn-cancel" onclick="history.back()">취소</button>
        <button type="submit" class="btn btn-submit">작성하기</button>
      </div>
    </form>
  </div>

</body>
</html>
