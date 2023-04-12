package com.yedam.spring.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.spring.sales.service.EdctsIstService;
import com.yedam.spring.sales.service.EdctsIstVO;

@Controller
public class EdctsIstController {
	
	@Autowired
	EdctsIstService edctsistService;
	
	@GetMapping("edctsIst")
	public String edctsIstForm(Model model) {
		model.addAttribute("edctsistList", edctsistService.selectEdctsIstAll());
		return "sales/EdctsIstMag";
	}
	
	@GetMapping("completePro")
	@ResponseBody
	public List<EdctsIstVO> completeProList(){
		return edctsistService.selectCompletePro();
	}
	
	@PostMapping("insertEdctsIst")
	@ResponseBody
	public List<EdctsIstVO> insertEdctsIstProcess(EdctsIstVO vo){
		edctsistService.insertEdctsIst(vo);
		return edctsistService.selectEdctsIstAll();
	}
	
	@GetMapping("searchEdctsIst")
	@ResponseBody
	public List<EdctsIstVO> searchEdctsIstProcess(EdctsIstVO vo){
		return edctsistService.searchEdctsList(vo);
	}
}
