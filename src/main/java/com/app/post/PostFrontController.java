package com.app.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.post.controller.PostDeleteOkController;
import com.app.post.controller.PostListController;
import com.app.post.controller.PostReadController;
import com.app.post.controller.PostUpdateController;
import com.app.post.controller.PostUpdateOkController;
import com.app.post.controller.PostWriteController;
import com.app.post.controller.PostWriteOkController;

public class PostFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String target = req.getRequestURI().split("\\.")[0].replace(req.getContextPath() + "/", "");
		System.out.println("경로 타겟");
		System.out.println(target);
		Result result = null;
		
		if(target.equals("write")) {
			result = new PostWriteController().excute(req, resp);
		} else if(target.equals("write-ok")) {
			result = new PostWriteOkController().excute(req, resp);
		} else if(target.equals("list")) {
			result = new PostListController().excute(req, resp);
		} else if(target.equals("read")) {
			result = new PostReadController().excute(req, resp);
		} else if(target.equals("update")) {
			result = new PostUpdateController().excute(req, resp);
		} else if(target.equals("update-ok")) {
			result = new PostUpdateOkController().excute(req, resp);
		} else if(target.equals("delete-ok")) {
			result = new PostDeleteOkController().excute(req, resp);
		} else {
			// not found
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			} else {
//				포워드
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
