package com.yedam.checkout;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/checkOutJson")
public class CheckOutJson extends HttpServlet {

	@Override // 조회
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");

		BookDAO dao = new BookDAO();
		List<BookVO> list = dao.bookVoList();

		String json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"no\" : " + list.get(i).getNo() + ", " + "\"bookName\" : \"" + list.get(i).getBookName() + "\", "
					+ "\"uName\" : \"" + list.get(i).getUserName() + "\", " + "\"uPhone\" : \""
					+ list.get(i).getUserPhone() + "\", " + "\"rentalDate\" : \"" + list.get(i).getRentalDate() + "\", "
					+ "\"returnDate\" : \"" + list.get(i).getReturnDate() + "\", " + "\"deadline\" : \""
					+ list.get(i).getDeadline() + "\"}";
			if (i + 1 != list.size()) {
				json += ",";
			}
		}
		json += "]";
		

		resp.getWriter().print(json);

	}

	@Override // 등록
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String parm = req.getParameter("param");
		String no = req.getParameter("no");
		String bookName = req.getParameter("bookName");
		String uName = req.getParameter("uName");
		String uPhone = req.getParameter("uPhone");
		String rentalDate = req.getParameter("rentalDate");
		String returnDate = req.getParameter("returnDate");
		String deadline = req.getParameter("deadline");

		BookVO vo = new BookVO();
		vo.setNo(Integer.parseInt(no));
		vo.setBookName(bookName);
		vo.setUserName(uName);
		vo.setUserPhone(uPhone);
		vo.setRentalDate(rentalDate);
		vo.setReturnDate(returnDate);
		vo.setDeadline(deadline);

		BookDAO dao = new BookDAO();

		if (parm.equals("update")) {
			if (dao.modifyBook(vo) > 0) {
				// {"retCode" : "Success"}
				resp.getWriter().print("{\"retCode\" : \"Success\"}");
			} else {
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
		} else {
			if (dao.addBook(vo) > 0) {
				// {"retCode" : "Success"}
				resp.getWriter().print("{\"retCode\" : \"Success\"}");
			} else {
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
		}
	}
//
//	// 제어의 역전(Inversion of Control; IoC)
//	@Override // 삭제
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("del_id"); // 요청페이지에서 del_id로 넘겨줘야함
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("id", id);
//
//		BookDAO dao = new BookDAO();
//		if (dao.deleteEmp(Integer.parseInt(id)) > 0) {
//			// {"retCode" : "Success"}
////			resp.getWriter().print("{\"retCode\" : \"Success\"}");
//			map.put("retCode", "Success");
//		} else {
//			// {retCode" : "Fail"}
////			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
//			map.put("retCode", "Fail");
//		}
//		Gson gson = new GsonBuilder().create();
//		resp.getWriter().print(gson.toJson(map));
//
//	}

}
