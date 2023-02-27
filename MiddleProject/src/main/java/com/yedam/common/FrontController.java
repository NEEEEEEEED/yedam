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

import com.yedam.member.command.Login;
import com.yedam.member.command.LoginForm;
import com.yedam.member.command.LogoutControl;
import com.yedam.member.command.MemberList;
import com.yedam.member.command.MemberManager;
import com.yedam.member.command.MemberModify;
import com.yedam.member.command.MemberRemove;
import com.yedam.member.command.Signup;
import com.yedam.member.command.selectCouponControl;
import com.yedam.mypage.command.MyPageControl;
import com.yedam.mypage.command.ZzimListControl;
import com.yedam.notice.command.AddNoticeControl;
import com.yedam.notice.command.AddNoticeFormControl;
import com.yedam.notice.command.NoticeDeleteControl;
import com.yedam.notice.command.NoticeDetailControl;
import com.yedam.notice.command.NoticeListControl;
import com.yedam.order.control.orderControl;
import com.yedam.product.command.ModifyProductManager;
import com.yedam.product.command.ProductCartAdd;
import com.yedam.product.command.ProductDetail;
import com.yedam.product.command.ProductManagerList;
import com.yedam.product.command.ProductManagerPage;
import com.yedam.product.command.RemoveProductManager;
import com.yedam.product.command.addZzimControl;
import com.yedam.product.command.cartControl;
import com.yedam.product.command.searchProductControl;
import com.yedam.zzim.command.ProductZzimAdd;
import com.yedam.zzim.command.ProductZzimDel;




public class FrontController extends HttpServlet {

	private Map<String, Command> map;
	private String charset;

	public FrontController() {
		map = new HashMap<String, Command>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		charset = config.getInitParameter("charset");
		//효상
		map.put("/main.do", new MainControl()); //메인페이지
		map.put("/orderPage.do", new orderControl()); //주문페이지
		map.put("/searchProduct.do", new searchProductControl()); //검색 결과
		map.put("/logOut.do", new LogoutControl()); //로그아웃
		map.put("/cart.do", new cartControl()); //메인에서 장바구니 담기
		map.put("/addZzim.do", new addZzimControl()); //찜추가 기능
		map.put("/selectCoupon.do", new selectCouponControl()); //쿠폰 조회 기능

		
		
		
		
		
		
		
		

		//민규
		map.put("/productDetail.do", new ProductDetail()); // 제품 상세 페이지
		map.put("/productCartAdd.do", new ProductCartAdd()); // 제품을 장바구니에 추가
		map.put("/productZzimAdd.do", new ProductZzimAdd()); // 제품을 찜에 추가
		map.put("/productZzimDel.do", new ProductZzimDel()); // 제품 찜 취소
		map.put("/productManagerPage.do", new ProductManagerPage()); // 관리자 전용 상품 페이지
		map.put("/productManagerList.do", new ProductManagerList()); // 관리자 전용 상품 리스트
		map.put("/removeProductManager.do", new RemoveProductManager()); // 관리자 전용 상품 삭제
		map.put("/modifyProductManager.do", new ModifyProductManager()); // 관리자 전용 상품 수정
		
		
		
		
		
		
		
		
		
		//종민
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/signup.do", new Signup());
		// 관리자 회원관리
		map.put("/memberManageForm.do", new MemberManager()); // 관리자 화면 등록 폼
		map.put("/memberList.do", new MemberList()); //관리자 화면 리스트
		map.put("/removeMember.do", new MemberRemove()); //관리자 화면에서 삭제
		map.put("/updateMember.do", new MemberModify()); //관리자 화면에서 수정
		
		

		
		
		//주안
		map.put("/noticeList.do", new NoticeListControl()); //공지사항페이지 이동
		map.put("/myPage.do",new MyPageControl()); //마이페이지 이동
		map.put("/zzimList.do", new ZzimListControl()); // zzim목록 출력
		map.put("/addNoticeForm.do", new AddNoticeFormControl()); //공지사항 작성 폼
		map.put("/addNotice.do", new AddNoticeControl()); //공지사항 작성기능
		map.put("/noticeDetail.do", new NoticeDetailControl()); //공지사항 상세보기
		map.put("/noticeDelete.do", new NoticeDeleteControl()); //공지사항 삭제
		
		
		
		
		
		
		
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
		// notice/noticeList.tiles

		if (viewPage.endsWith(".tiles")) {
			RequestDispatcher rd = req.getRequestDispatcher(viewPage);
			rd.forward(req, resp);

		} else if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);

		} else if (viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length() - 5));
		}

	}
}
