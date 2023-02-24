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

		// login.jsp 에서 입력받은 정보 추출
		String id = req.getParameter("mid");
		String pass = req.getParameter("mpw");
		
		MemberService service = new MemberServiceMybatis();

		// 받아온 정보 담음
		MemberVO member = new MemberVO();
		member.setMemId(id);
		member.setMemPw(pass);

		// 받아온 정보를 담은 VO 객체를 service 로 넘김
		MemberVO rvo = service.login(member);
		
		
//		System.out.println(rvo);					// 로그인용 정보 테스트 출력 (서비스에 담고나서 확인)
		

		if (rvo != null) {
			HttpSession session = req.getSession();

			session.setAttribute("logId", rvo.getMemId());
			session.setAttribute("logName", rvo.getMemName());

			req.setAttribute("vo", rvo); // 요청정보에 vo를 저장 해당 데이터를 가지고, main 페이지로 일단은 이동

			return "main.do";			// main/main.titles 안 됨.

		} else {
			req.setAttribute("result", "회원정보를 확인하세요!!"); // 요청 정보 : 응답하고 나면 사라짐
			return "member/login.tiles";
		}
	}
}