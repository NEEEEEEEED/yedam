package com.yedam.notice.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class deleteNotice implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		NoticeService service = new NoticeServiceImpl();
		String json = "";
		
		if(service.remNotice(Integer.parseInt(id))>0) {
			json = "{\"retCode\":\"Success\"}";
		} else {
			json = "{\"retCode\":\"Fail\"}";
		}
		
		return json + ".json";
	}

}
