package co.yedam.emp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceImpl;
import co.yedam.emp.service.EmpServiceMybatis;
import co.yedam.emp.vo.EmpVO;

public class EmpControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher rd = null;
		
		String method = req.getMethod();
		PrintWriter out = null;

		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (method.equals("GET")) {

			try {
				resp.sendRedirect("result/empList.jsp");
//				resp.sendRedirect("https://www.daum.net");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (method.equals("POST")) {
			String eid = req.getParameter("eid");
			String lName = req.getParameter("last_name");
			String job = req.getParameter("job");
			String hire = req.getParameter("hire_date");
			String mail = req.getParameter("email");

			EmpVO emp = new EmpVO();
			emp.setEmployeeId(Integer.parseInt(eid));
			emp.setLastName(lName);
			emp.setJobId(job);
			emp.setHireDate(hire);
			emp.setEmail(mail);

			// 서비스 로직.
			EmpService service = new EmpServiceMybatis();
			int r = service.addEmp(emp);
			System.out.println(r);
			// 요청재지정
			try {
				if(r>0) {
					resp.sendRedirect("empList.do");
//					rd = req.getRequestDispatcher("WEB-INF/result/addResult.jsp");
//					try {
//						rd.forward(req, resp);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}

				} else {
					//resp.sendRedirect("WEB-INF/result/errorResult.jsp");
					rd = req.getRequestDispatcher("WEB-INF/result/errorResult.jsp");
					try {
						rd.forward(req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("알 수 없는 요청입니다.");
			try {
				resp.sendRedirect("https://www.daum.net");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
