package co.yedam.emp.command;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceImpl;
import co.yedam.emp.vo.EmpVO;

public class EmpModFormControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//수정화면: WEB-INF/views/modify.jsp 호출
        String id = req.getParameter("id");
		
		EmpService service = new EmpServiceImpl();
		EmpVO emp = service.getEmp(Integer.parseInt(id));
		
		req.setAttribute("searchVO", emp);
		
		service = new EmpServiceImpl();
		Map<String,String> jobList = service.jobList();
		
		req.setAttribute("jobList", jobList);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/modify.jsp");
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
