package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.exception.PostNotFoundException;
import com.app.vo.PostVO;

public class PostUpdateController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		해당 컨트롤러는 유저가 게시글을 수정 하는 페이지로 이동하게 해주는 컨트롤러
//		이때 수정하고자 하는 post 내용을 db 에서 받아서 해당 내용을 가지고 보내줘야 함
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		PostVO postVO = postDAO.select(id).orElseThrow(PostNotFoundException::new);
		
		req.setAttribute("post", postVO);
		
//		result 설정
		result.setPath("/new-post-update.jsp");
		
		return result;
	}

}
