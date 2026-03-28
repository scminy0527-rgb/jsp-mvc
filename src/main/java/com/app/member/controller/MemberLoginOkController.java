package com.app.member.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.MemberDAO;
import com.app.vo.MemberVO;

public class MemberLoginOkController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		String memberEmail = req.getParameter("memberEmail");
		System.out.println("멤버 이메일: " + memberEmail);
		String memberPassword = req.getParameter("memberPassword");
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberPassword(memberPassword);
		
//		먼저 해당 아이디가 있는지 확인
		if(memberDAO.iruByMemberEmail(memberEmail) == 0) {
			System.out.println("해당 " + memberEmail + " 은 없습니다.");
			result.setRedirect(true);
			result.setPath("/mvc/login.member?flag=memberEmail");
			return result;
		}
		
//		만약 이메일이 있다면 일단 쿼리로 가져오기
		Optional<MemberVO> foundMember = memberDAO.findByMemberEmailAndMemberPassword(memberVO);
		
		if(!foundMember.isPresent()) {
			System.out.println("비밀번호가 틀렸습니다.");
			result.setRedirect(true);
			result.setPath("/mvc/login.member?flag=memberPassword");
			return result;
		}
		
//		정상적으로 로그인 된 경우
//		req.setAttribute("member", foundMember.get());
		result.setRedirect(true);
		result.setPath("/mvc/my-page.member?id=" + foundMember.get().getId());
		
		return result;
	}
}
