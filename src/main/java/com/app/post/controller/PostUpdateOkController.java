package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.vo.PostVO;

public class PostUpdateOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
//		수정하는 화면에서 받은 값을 토대로 게시글 수정 하고 다시 게시글 화면으로 이동해주도록 컨트롤
		PostDAO postDAO = new PostDAO();
		PostVO postVO = new PostVO();
		Long id = Long.parseLong(req.getParameter("id"));
		
		postVO.setId(id);
		postVO.setPostTitle(req.getParameter("postTitle"));
		postVO.setPostContent(req.getParameter("postContent"));
		postDAO.update(postVO);
		
//		결과 리디렉션
		result.setPath("/mvc/read.post?id=" + id);
		result.setRedirect(true);
		
		return result;
	}
}
