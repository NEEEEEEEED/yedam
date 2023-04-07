package com.yedam.spring.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.spring.eqm.service.EqmService;
import com.yedam.spring.eqm.service.EqmVO;

@Controller
public class EqmController {
	@Autowired
	EqmService service;
	
	//������ü��ȸ
	@GetMapping("/eqm")
	public String eqm(Model model) {
		model.addAttribute("eqmList",service.selectEqmList());
		model.addAttribute("maxCdList",service.selectMaxCd());
		return "eqm/eqm";
	}
	
	//������
	@PostMapping("/eqm")
	public String insertEqm(EqmVO eqmVO) {
		service.insertEqm(eqmVO);
		return "redirect:eqm";
	}
	
	//����ܰ���ȸ
	@GetMapping("/eqmDetail")
	@ResponseBody //ȭ���� �ƴ� ������ �ѱ� �� ��� ��ߵ� jsp���� dataType=json�ޱ�����
	public EqmVO eqmDetail(EqmVO eqmVO) {
		return service.selectEqm(eqmVO);
	}
	
	//�������
	@PostMapping("/deleteEqm")
	public String deleteEqm(EqmVO eqmVO) {
		service.deleteEqm(eqmVO);
		return "redirect:eqm";
	}
	
	//�������
	@PostMapping("/updateEqm")
	public String updateEqm(EqmVO eqmVO) {
		service.updateEqm(eqmVO);
		return "redirect:eqm";
	}
	////////////////�������˳���//////////////////
	@GetMapping("/eqmCheck")
	public String eqmCheckPage(Model model) {
		model.addAttribute("list", service.selectCheckList());
		model.addAttribute("eqmList",service.selectEqmList());
		return "eqm/eqmCheck";
	}
	
	/* ���˰˻���ȸ
	 * @PostMapping("/searchEqmCheck")
	 * 
	 * @ResponseBody public List<EqmVO> searchEqmCheck(@RequestBody EqmVO
	 * searchKeywords){ return "";
	 * 
	 * }
	 */
	
	//���˴ܰ���ȸ
	@GetMapping("/selectCheck")
	@ResponseBody
	public EqmVO selectCheck(EqmVO eqmVO) {
		return service.selectCheck(eqmVO);
	}
	
	//���˵��
	@PostMapping("/insertCheck")
	public String insertCheck(EqmVO eqmVO) {
		service.insertCheck(eqmVO);
		return "redirect:eqmCheck";
	}
	
	
	
	
	
}
