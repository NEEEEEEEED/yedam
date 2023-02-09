package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class modifyMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mid = req.getParameter("mid");
		String mname = req.getParameter("mname");
		String mpw = req.getParameter("mpw");
		String mphone = req.getParameter("mphone");
		String maddr = req.getParameter("maddr");
		
		MemberVO member = new MemberVO();
		member.setMemberId(mid);
		member.setMemberPw(mpw);
		member.setMemberName(mname);
		member.setMemberAddr(maddr);
		member.setMemberPhone(mphone);
		
		MemberService service = new MemberServiceMybatis();
		service.modifyMember(member);
		
		return "myPageForm.do";
	}

}
