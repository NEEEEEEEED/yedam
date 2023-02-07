package co.yedam.emp.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceImpl;
import co.yedam.emp.service.EmpServiceMybatis;
import co.yedam.emp.vo.EmpVO;

public class EmpModControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// service:int modEmp(EmpVO) -> serviceImpl: modEmp(EmpVO) -> dao:updateEmp(EmpVO)
		RequestDispatcher rd = null;
		
		String id = req.getParameter("employeeId");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String job = req.getParameter("jobId");	
		String mail = req.getParameter("email");
		String hireDate = req.getParameter("hireDate");

		EmpVO emp = new EmpVO();
		emp.setEmployeeId(Integer.parseInt(id));
		emp.setLastName(lastName);
		emp.setJobId(job);
		emp.setFirstName(firstName);
		emp.setEmail(mail);
		emp.setHireDate(hireDate);
		System.out.println(emp);
		
		EmpService service = new EmpServiceMybatis();
		int r = service.modEmp(emp);
		System.out.println(r);
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
