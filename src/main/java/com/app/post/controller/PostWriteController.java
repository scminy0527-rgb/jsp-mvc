package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;

public class PostWriteController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		해당 컨트롤러는 사용자가 게시글을 작성 하는 페이지로 이동을 하게 하는 것
		Result result = new Result();
		result.setPath("/post-write.jsp");
		
		return result;
	}
}
