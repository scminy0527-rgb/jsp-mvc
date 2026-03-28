package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.MemberDAO;
import com.app.vo.MemberVO;

public class MemberMyPageController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = memberDAO.findById(Long.parseLong(req.getParameter("id"))).orElseThrow(RuntimeException::new);
		
		req.setAttribute("member", memberVO);
		result.setPath("/member/my-page.jsp");
		return result;
	}
}
