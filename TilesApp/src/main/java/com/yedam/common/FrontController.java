package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.command.*;
import com.yedam.notice.command.*;


public class FrontController extends HttpServlet {

	private Map<String, Command> map;
	private String charset;
	
	public FrontController() {
		map = new HashMap<String, Command>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		map.put("/main.do", new MainControl());
		map.put("/second.do", new SecondControl());
		//공지사항
		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeListWithTables.do", new noticeListTable());
		map.put("/noticeDetail.do", new NoticeDetail()); // 글 상세
		map.put("/noticeForm.do", new NoticeForm()); // 글 등록폼
		map.put("/noticeAdd.do", new NoticeAdd()); // 글 등록
		map.put("/noticeAddJson.do", new NoticeAddJson());//datatable연습
		map.put("/noticeListJson.do", new NoticeListJson());
		map.put("/noticeListAjax.do", new noticeListAjax());
		map.put("/deleteNotice.do", new deleteNotice());
		
		//댓글
		map.put("/replyList.do", new ReplyList()); //댓글 조회
		map.put("/removeReply.do", new removeReply()); //댓글 삭제
		map.put("/addReply.do", new addReply());//댓글등록
		
		//회원관련
		map.put("/loginForm.do",new LoginForm());//로그인화면 이동
		map.put("/login.do",new Login());//로그인
		map.put("/logOut.do", new LogoutControl());//로그아웃
		map.put("/myPageForm.do",new myPageFormControl());//mypage
		map.put("/modifyMember.do", new modifyMember());//마이페이지 수정
		map.put("/imageUpload.do", new ImageUpload());//이미지 업로드
		
		//관리자 회원관리
		map.put("/memberManageForm.do", new memberManage());//멤버페이지이동
		map.put("/memberList.do", new MemberList());//멤버조회
		map.put("/addMember.do", new AddMember());
		map.put("/removeMember.do", new removeMember());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding(charset);
			
			String uri = req.getRequestURI();
			String context = req.getContextPath();
			String page = uri.substring(context.length());
			System.out.println(page);
			
			Command command = map.get(page);
			String viewPage = command.exec(req, resp);
			//viewPage = main/main.tiles
			//viewPage = notice/noticeList.tiles
			
			if(viewPage.endsWith(".tiles")) {
				RequestDispatcher rd = req.getRequestDispatcher(viewPage);
				rd.forward(req, resp);
			} else if(viewPage.endsWith(".do")) {
				resp.sendRedirect(viewPage);
			} else if(viewPage.endsWith(".json")) {
				resp.setContentType("text/json;charset=utf-8");
				resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
			}
			
	}
}
