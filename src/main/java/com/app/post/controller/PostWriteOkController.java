package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.vo.PostVO;

public class PostWriteOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		PostVO postVO = new PostVO();
		
//		게시글 작성 페이지 로부터 받은 제목과 내용을 DB 에 쏴줘야 함
		postVO.setPostTitle(req.getParameter("postTitle"));
		postVO.setPostContent(req.getParameter("postContent"));
		postDAO.insert(postVO);
		
//		결과 반환, 어디로 어떻게
//		req.setAttribute("id", postVO.getId());
		result.setPath("/mvc/read.post?id="+postVO.getId());
		result.setRedirect(true);
		
		return result;
	}
}
