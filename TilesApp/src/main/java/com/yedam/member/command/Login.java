package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mid = req.getParameter("mid");
		String mpw = req.getParameter("mpw");
		
		MemberVO member = new MemberVO();
		member.setMemberId(mid);
		member.setMemberPw(mpw);
		
		MemberService service = new MemberServiceMybatis();
		MemberVO rvo = service.login(member);
		
		String link ="";
		if(rvo != null) {
			
				//세션에 로그인 아이디 담기
				HttpSession session = req.getSession();
				session.setAttribute("id", rvo.getMemberId());
				session.setAttribute("name", rvo.getMemberName());
				link = "myPageForm.do";
				
			
		} else {
				req.setAttribute("result", "회원정보를 확인하세요.");
				link = "member/login.tiles";
			 
		}
		
		return link;
		

	}

}
