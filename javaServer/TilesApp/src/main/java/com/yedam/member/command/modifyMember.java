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
import com.yedam.member.vo.MemberVO;

public class modifyMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mid = req.getParameter("mid");
		String mname = req.getParameter("mname");
		String mpw = req.getParameter("mpw");
		String mphone = req.getParameter("mphone");
		String maddr = req.getParameter("maddr");
		String auth = req.getParameter("resp");
		
		MemberVO member = new MemberVO();
		member.setMemberId(mid);
		member.setMemberPw(mpw);
		member.setMemberName(mname);
		member.setMemberAddr(maddr);
		member.setMemberPhone(mphone);
		member.setResponsibility(auth);
		
		
		Map<String,Object> resultMap = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		String json = "";
		
		MemberService service = new MemberServiceMybatis();
		
		if (service.modifyMember(member) > 0) {
			// {"retCode":"Success"}
			service = new MemberServiceMybatis();
			MemberVO vo = service.getMember(mid);
			resultMap.put("mvo", vo);
			resultMap.put("retCode","Success");
			
			//return "myPageForm.do"
		} else {
			// {"retCode":"Fail"}
			resultMap.put("retCode","Fail");
		}

	
//{"retCode":"success"},{"retCode":"Fail"}
		
		return gson.toJson(resultMap) + ".json";

		

	}

}
