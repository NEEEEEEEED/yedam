package com.yedam.spring.eqm.web;

import java.util.HashMap;
import java.util.Map;

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

	// ���������� ,���� ��ü��ȸ, �����ȸ(����ڿ�)
	@GetMapping("/eqm")
	public String eqm(Model model) {
		model.addAttribute("eqmList", service.selectEqmList());
		model.addAttribute("maxCdList", service.selectMaxCd());
		model.addAttribute("empList",service.selectEmpList());
		return "eqm/eqm";
	}

	// ������
	@PostMapping("/eqm")
	public String insertEqm(EqmVO eqmVO) {
		service.insertEqm(eqmVO);
		return "redirect:eqm";
	}

	// ����ܰ���ȸ
	@GetMapping("/eqmDetail")
	@ResponseBody // ȭ���� �ƴ� ������ �ѱ� �� ��� ��ߵ� jsp���� dataType=json�ޱ�����
	public EqmVO eqmDetail(EqmVO eqmVO) {
		return service.selectEqm(eqmVO);
	}

	// �������
	@PostMapping("/deleteEqm")
	public String deleteEqm(EqmVO eqmVO) {
		service.deleteEqm(eqmVO);
		return "redirect:eqm";
	}

	// �������
	@PostMapping("/updateEqm")
	public String updateEqm(EqmVO eqmVO) {
		service.updateEqm(eqmVO);
		return "redirect:eqm";
	}

	//////////////// �������˳���//////////////////
	@GetMapping("/eqmCheck")
	public String eqmCheckPage(Model model) {
		model.addAttribute("list", service.selectCheckList());
		model.addAttribute("eqmList", service.selectEqmList());
		return "eqm/eqmCheck";
	}

	/*
	 * ���˰˻���ȸ
	 * 
	 * @PostMapping("/searchEqmCheck")
	 * 
	 * @ResponseBody public List<EqmVO> searchEqmCheck(@RequestBody EqmVO
	 * searchKeywords){ return "";
	 * 
	 * }
	 */

	// ���˴ܰ���ȸ
	@GetMapping("/selectCheck")
	@ResponseBody
	public EqmVO selectCheck(EqmVO eqmVO) {
		return service.selectCheck(eqmVO);
	}

	// ���˵��
	@PostMapping("/insertCheck")
	@ResponseBody
	public String insertCheck(EqmVO eqmVO) {
		service.insertCheck(eqmVO);
		return "insertSuccess";
	}

	// ���˻���
	@PostMapping("/deleteCheck")
	@ResponseBody
	public String deleteCheck(@RequestBody String[] deleteList) {
		for (int i = 0; i < deleteList.length; i++) {
			service.deleteCheck(deleteList[i]);
		}
		return "Success";
	}

	// ���˼���
	@PostMapping("/updateCheck")
	@ResponseBody
	public String updateCheck(EqmVO eqmVO) {
		service.updateCheck(eqmVO);
		return "update success";
	}

	// ����񰡵�

	// ����񰡵� ȭ�� �� ��ü��ȸ
	@GetMapping("/eqmOpr")
	public String eqmOpr(Model model) {
		model.addAttribute("OprList", service.selectOprList());
		return "eqm/eqmOpr";
	}

	// �񰡵����,Y������Ʈ
	@PostMapping("insertOpr")
	public String insertOprUpdateY(EqmVO eqmVO) {
		service.insertOprUpdateY(eqmVO);
		return "redirect:eqmOpr";
	}

	// �񰡵�����
	@PostMapping("/deleteOpr")
	@ResponseBody
	public String deleteOpr(@RequestBody String[] deleteList) {
		for (int i = 0; i < deleteList.length; i++) {
			service.deleteOpr(deleteList[i]);
		}
		return "Success";
	}
	
	//���â ���� �ִ��ڵ�� ���񸮽�Ʈ �ٽ� 
	@GetMapping("/oprModal")
	@ResponseBody
	public Map<String, Object> openModal(Model model){
		 Map<String, Object>  map = new HashMap<>();
		 map.put("maxNoprCd", service.selectMaxNoprCd());
		 map.put("YList", service.selectYList());
		return map;
	}
	
	//�񰡵�����
	@PostMapping("/updateOpr")
	public String updateOpr(EqmVO eqmVO) {
		service.updateOpr(eqmVO);
		return "redirect:eqmOpr"; //jsp���� ajax result�������� �� �޾Ƽ� �����̷�Ʈ �� ��
								  // success�κп� �׳� location.reload()���ֱ�	
	}
	

}
