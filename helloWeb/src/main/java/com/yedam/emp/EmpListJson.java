package com.yedam.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empListJson")
public class EmpListJson extends HttpServlet {
	
	//제어의 역전(Inversion of Control; IoC)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("del_id"); // 요청페이지에서 del_id로 넘겨줘야함
		EmpDAO  dao = new EmpDAO();
		
		if(dao.deleteEmp(Integer.parseInt(id))>0) {
			//{"retCode" : "Success"}
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		} else {
			//{retCode" : "fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		};
		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.empVoList();
		// [{"id" : 100,},{"first_name" : "Hong"},,,] json형태
		String json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"id\" : "+list.get(i).getEmployeeId()+", "
					+ "\"firstName\" : \""+list.get(i).getFirstName()+"\", "
					+ "\"hireDate\" : \""+list.get(i).getHireDate()+"\", "
					+ "\"job\" : \""+list.get(i).getJobId()+"\", "
					+ "\"email\" : \"" +list.get(i).getEmail()+"\"}";
			if(i + 1 != list.size()) {
				json += ",";
			}
		}
		json += "]";

		resp.getWriter().print(json);
		
	}

}
