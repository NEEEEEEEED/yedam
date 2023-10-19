package com.yedam.emp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/empListJson")
public class EmpListJson extends HttpServlet {

	@Override // 등록
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String parm = req.getParameter("param");
		String id = req.getParameter("id");
		String lastName = req.getParameter("lastName");
		String mail = req.getParameter("mail");
		String hDate = req.getParameter("hDate");
		String job = req.getParameter("job");

		EmpVO vo = new EmpVO();
		vo.setEmployeeId(Integer.parseInt(id));
		vo.setLastName(lastName);
		vo.setEmail(mail);
		vo.setHireDate(hDate);
		vo.setJobId(job);

		EmpDAO dao = new EmpDAO();

		if (parm.equals("update")) {
			if (dao.modifyEmp(vo) > 0) {
				// {"retCode" : "Success"}
				resp.getWriter().print("{\"retCode\" : \"Success\"}");
			} else {
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
		} else {
			if (dao.addEmp(vo) > 0) {
				// {"retCode" : "Success"}
				resp.getWriter().print("{\"retCode\" : \"Success\"}");
			} else {
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			}
		}
	}

	// 제어의 역전(Inversion of Control; IoC)
	@Override // 삭제
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("del_id"); // 요청페이지에서 del_id로 넘겨줘야함

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);

		EmpDAO dao = new EmpDAO();
		if (dao.deleteEmp(Integer.parseInt(id)) > 0) {
			// {"retCode" : "Success"}
//			resp.getWriter().print("{\"retCode\" : \"Success\"}");
			map.put("retCode", "Success");
		} else {
			// {retCode" : "Fail"}
//			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			map.put("retCode", "Fail");
		}
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(map));

	}

	@Override // 조회
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");

		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.empVoList();
		// [{"id" : 100,},{"first_name" : "Hong"},,,] json형태
		String json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"id\" : " + list.get(i).getEmployeeId() + ", " + "\"lastName\" : \"" + list.get(i).getLastName()
					+ "\", " + "\"hireDate\" : \"" + list.get(i).getHireDate().substring(0, 10) + "\", "
					+ "\"job\" : \"" + list.get(i).getJobId() + "\", " + "\"email\" : \"" + list.get(i).getEmail()
					+ "\"}";
			if (i + 1 != list.size()) {
				json += ",";
			}
		}
		json += "]";

		resp.getWriter().print(json);

	}

}
