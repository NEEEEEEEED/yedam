package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.emp.EmpDAO;
import com.yedam.emp.EmpVO;

//자바코드로 웹 만들기 - servlet(tomcat 있어야 됨)
@WebServlet("/myInfo") // 연결할 url
public class FirstServlet extends HttpServlet {// http통신 요청-응답.

	@Override //post방식
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청방식이 post인 경우 tomcat 서버가 실행.
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("emp_id"); // form태그의 name속성의 값을 읽어들일때 사용.
		String name = req.getParameter("last_name");
		String mail = req.getParameter("email");
		String job = req.getParameter("job_id");
		String hdate = req.getParameter("hire_date");

		EmpVO emp = new EmpVO();
		emp.setEmployeeId(Integer.parseInt(id));
		emp.setLastName(name);
		emp.setEmail(mail);
		emp.setJobId(job);
		emp.setHireDate(hdate);

		System.out.println(emp);

		EmpDAO dao = new EmpDAO();
		dao.addEmp(emp);
		doGet(req, resp);// doGet 메소드 호출.
	}

	@Override //get방식
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		super.doGet(req, resp);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("<h3>servlet page</h3>");// client 출력스트림.
		resp.getWriter().print("<a href ='./Info/resume.html'>이력서</a>");
		resp.getWriter().print("<a href ='./index.html'>첫페이지</a>");

		// jdbc 연결처리.
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.empVoList();

		resp.getWriter().print("<ul>");
		for (EmpVO emp : list) {
			resp.getWriter()
					.print("<li>" + emp.getEmployeeId() + "/ " + emp.getEmail() + "/ " + emp.getLastName() + "</li>");
		}
		resp.getWriter().print("</ul>");

	}

}
