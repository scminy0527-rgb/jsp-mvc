package com.app.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.PostDAO;
import com.app.dao.ProductDAO;
import com.app.vo.PostVO;

public class PostListController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		
//		DB에 접근을 해서 게시글 전부 가져와서 화면에 뿌려야 함
		List<PostVO> postList = (List<PostVO>)postDAO.selectAll();
		
//		어쨋든 사람이 호출을 한 uri 와 최종적으로 갈 곳이 동일하기에 foward, req 살아있음
		req.setAttribute("postList", postList);
		
		result.setPath("/new-post-list.jsp");
		return result;
	}
}
