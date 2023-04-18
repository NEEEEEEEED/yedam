package com.yedam.spring.prcsInsp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.spring.eqm.service.EqmService;
import com.yedam.spring.prcsInsp.service.PrcsInspService;
import com.yedam.spring.prcsInsp.service.PrcsInspVO;

@Controller
public class PrcsInspController {
	@Autowired
	PrcsInspService service;
	@Autowired
	EqmService eqmService;

	// prcsInsp��������
	@GetMapping("/prcsInsp")
	public String prcsInspPage(Model model) {
		model.addAttribute("maxChkCd", service.selectMaxChkCd());
		model.addAttribute("empList", eqmService.selectEmpList());
		return "prcsInsp/prcsInsp";
	}

	// ��޿� �˻��ؾ��� �������
	@GetMapping("/selectPrcsList")
	@ResponseBody
	public List<PrcsInspVO> selectPrcsList() {
		return service.selectPrcsList();
	}

	// ������ �˻����
	@GetMapping("/selectPrcsStd")
	@ResponseBody
	public List<PrcsInspVO> selectPrcsStd(PrcsInspVO prcsCd) {
		return service.selectPrcsStd(prcsCd);
	}

	// �˻�Ϸ�
	@PostMapping("/chkDone")
	@ResponseBody
	public String chkDone(@RequestBody PrcsInspVO[] list) {
		for (int i = 0; i < list.length; i++) {
			/*
			 * if(list[0].prcsCd.equals("PRCS5000")) { service.updateIndiPlan(list[0]); }
			 */
			if (i != list.length - 1) {
				service.insertDtl(list[i]);
			} else if (i == list.length - 1) {

				service.inferUpdateInsert(list[i]);
			}
		}
		return "success";
	}

	// �˻�Ϸ� ��ü����Ʈ
	@GetMapping("/selectCompletedList")
	@ResponseBody
	public List<PrcsInspVO> selectCompletedList() {
		return service.selectCompletedPrcs();
	}

	@GetMapping("/inspDtl")
	@ResponseBody
	public List<PrcsInspVO> inspDtl(PrcsInspVO prcsCd) {
		return service.inspDtl(prcsCd);
	}

	// �˻�Ϸ� ����
	@PostMapping("/deleteCompleted")
	@ResponseBody
	public String deleteCompleted(@RequestBody String[] deleteList) {
		for(int i=0;i<deleteList.length;i++) {
			service.deleteCompleted(deleteList[i]);
		}
		return "deleteSuccess";
	}

}
