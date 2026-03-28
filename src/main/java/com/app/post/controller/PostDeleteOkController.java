package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;

public class PostDeleteOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		
//		화면에서 버튼을 눌러서 전송된 id 의 게시글을 지운 다음에 게시글 목록으로 되돌아가게 해주는 컨트롤러
		PostDAO postDAO = new PostDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		postDAO.delete(id);
		
		result.setPath("/mvc/list.post");
		result.setRedirect(true);
		
		return result;
	}
}
