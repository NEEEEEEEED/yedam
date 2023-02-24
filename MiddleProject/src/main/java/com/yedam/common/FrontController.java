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


import com.yedam.member.command.LoginForm;
import com.yedam.notice.command.NoticeListControl;


import com.yedam.order.control.orderControl;
import com.yedam.product.command.ProductCartAdd;
import com.yedam.product.command.ProductDetail;




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
		map.put("/main.do", new MainControl());
		map.put("/orderPage.do", new orderControl());



		
		
		
		
		
		
		
		

		//민규
		map.put("/productDetail.do", new ProductDetail()); // 제품 상세 페이지
		map.put("/productCartAdd.do", new ProductCartAdd()); // 제품을 장바구니에 추가

		
		
		
		
		
		
		
		
		
		
		//종민
		map.put("/loginForm.do", new LoginForm());

		
		
		
		
		
		
		

		
		
		
		//주안
		map.put("/noticeList.do", new NoticeListControl());


		
		
		
		
		
		
		
		
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
