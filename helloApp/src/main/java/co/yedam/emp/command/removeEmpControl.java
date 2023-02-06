package co.yedam.emp.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceImpl;
import co.yedam.emp.vo.EmpVO;

public class removeEmpControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");

		EmpVO emp = new EmpVO();
		emp.setEmployeeId(Integer.parseInt(id));
		
		EmpService service = new EmpServiceImpl();
		int r = service.removeEmp(emp);

		try {
			if(r>0) {
				resp.sendRedirect("empList.do");

			} else {
				
				try {
					resp.sendRedirect("errorPage.do");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
