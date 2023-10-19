package com.yedam.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;

public class removeMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		
		MemberService service = new MemberServiceMybatis();
		
		Map<String,Object> resultMap = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		if (service.removeMember(id) > 0) {
			// {"retCode":"Success"}
			resultMap.put("retCode","Success");
			
		} else {
			// {"retCode":"Fail"}
			resultMap.put("retCode","Fail");
		}


	return gson.toJson(resultMap) + ".json";
	}

}
