package com.yedam.spring.masterData.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.spring.masterData.service.BomService;
import com.yedam.spring.masterData.service.EdctsService;
import com.yedam.spring.mat.service.MatService;
import com.yedam.spring.production.service.BomVO;

@Controller
public class BomController {
	@Autowired
	BomService bomService;
	
	@Autowired
	EdctsService edctsService;
	
	@Autowired
	MatService matService;
	
	@GetMapping("bomMag")
	public String bomMagForm(Model model) {
		model.addAttribute("edctsList", edctsService.getEdctsList());
		model.addAttribute("rscList", matService.matList());
		model.addAttribute("prcsList", bomService.getPrcsList());
		return "bom/bomMag";
	}
	
	@GetMapping("bomList")
	@ResponseBody
	public List<BomVO> bomList(@RequestParam String edctsCd){
		return bomService.getBomList(edctsCd);
	}
}
