package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.emp.command.EmpControl;
import co.yedam.emp.command.EmpDetailControl;
import co.yedam.emp.command.EmpForm;
import co.yedam.emp.command.EmpList;
import co.yedam.emp.command.EmpModControl;
import co.yedam.emp.command.EmpModFormControl;
import co.yedam.emp.command.ServiceControl;
import co.yedam.emp.command.removeEmpControl;
import co.yedam.member.command.LoginControl;
import co.yedam.member.command.LoginFormControl;
import co.yedam.member.command.LogoutControl;
import co.yedam.member.command.SignUpControl;
import co.yedam.member.command.SignUpFormControl;
import co.yedam.member.command.memberListControl;

@WebServlet("*.do")
public class frontController extends HttpServlet {
	
	//url패턴과 실행할 프로그램과 매핑.
	Map<String, Command> map;
	public frontController() {
		map = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/service.do", new ServiceControl());
		map.put("/errorPage.do", new ErrorPage());
		// get : 목록출력(json)요청, post : 입력처리. 
		map.put("/employee.do", new EmpControl());
		
		// xxxForm.do : 숨겨진 페이지 오픈.
		map.put("/empForm.do", new EmpForm());
		map.put("/empList.do", new EmpList());
		map.put("/empDetail.do", new EmpDetailControl());
		map.put("/empModForm.do", new EmpModFormControl());	//수정화면페이지
		map.put("/empModify.do", new EmpModControl());	//수정처리페이지
		map.put("/empRemove.do", new removeEmpControl());	//삭제
		
		//member 회원관리
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logOut.do", new LogoutControl());
		map.put("/signUpForm.do", new SignUpFormControl());
		map.put("/signUp.do", new SignUpControl());
		
		map.put("/memberList.do", new memberListControl());
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//요청 한글
		resp.setCharacterEncoding("utf-8");//응답 한글
		resp.setContentType("text/html;charset=utf-8");
		
		// url 패턴을 확인 => 요청페이지 찾기
		String uri = req.getRequestURI(); // url값에서 호스트 정보제외하고 리턴
//		System.out.println("uri : "+uri);
		String context = req.getContextPath();// url에서 어플리케이션 값만 리턴
//		System.out.println("context : " + context);
		String page = uri.substring(context.length());
		System.out.println(page);
		
		Command command = map.get(page);
		command.exec(req,resp);
	}
	@Override
	public void destroy() {
		
	}
	
}
