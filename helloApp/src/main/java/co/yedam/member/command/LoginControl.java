package co.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceMybatis;
import co.yedam.member.vo.MemberVO;

public class LoginControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//로그인이 되면 session객체에 setAttribute("id",)
		
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw");
		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		MemberService service = new MemberServiceMybatis();
		MemberVO rvo = service.login(member);
		if(rvo != null) {
			try {
				//세션에 로그인 아이디 담기
				HttpSession session = req.getSession();
				session.setAttribute("id", rvo.getMemberId());
				session.setAttribute("name", rvo.getMemberName());
				
				resp.sendRedirect("empList.do");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				req.setAttribute("result", "회원정보를 확인하세요.");
				req.getRequestDispatcher("WEB-INF/member/login.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
