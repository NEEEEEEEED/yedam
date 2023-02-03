package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class MainControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		
			try {
				req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
