package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.dao.ProductDAO;
import com.app.exception.PostNotFoundException;
import com.app.vo.PostVO;

public class PostReadController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		게시글 한개를 DAO 를 통해서 DB 에 접근해서 가져온 거를 화면에 뿌려주는 역할
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		PostVO postVO = postDAO.select(id).orElseThrow(PostNotFoundException::new);
		req.setAttribute("post", postVO);
		
		result.setPath("/post-read.jsp");
		
		return result;
	}

}
