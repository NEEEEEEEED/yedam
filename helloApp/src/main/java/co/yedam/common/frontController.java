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

import co.yedam.emp.command.LoginControl;
import co.yedam.emp.command.ServiceControl;

@WebServlet("*.do")
public class frontController extends HttpServlet {
	
	//url패턴과 실행할 프로그램과 매핑.
	Map<String, Command> map;
	public frontController() {
		map = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/service.do", new ServiceControl());
		map.put("/login.do", new LoginControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
