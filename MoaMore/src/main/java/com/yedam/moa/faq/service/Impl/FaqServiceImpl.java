package com.yedam.moa.faq.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.faq.mapper.FaqMapper;
import com.yedam.moa.faq.service.FaqService;
import com.yedam.moa.faq.service.FaqVO;

@Service
public class FaqServiceImpl implements FaqService {
	@Autowired 
	FaqMapper mapper;
	
	@Override
	public Map<String, List<FaqVO>> selectFaq() {
		Map<String, List<FaqVO>> map = new HashMap<String, List<FaqVO>>(); 
		List<FaqVO> faqList = mapper.selectFaq(); // 전체 faq 불러오기
		List<FaqVO> memList = new ArrayList<FaqVO>(); // 일반회원관련 faq담을 List
		List<FaqVO> coList = new ArrayList<FaqVO>(); // 기업관련 faq담을 List
		
		
		for(int i=0; i<faqList.size(); i++) { // memList와 coList에 각각 담기
			String MEM = "MEM";
			String CO = "CO";
			
			if(faqList.get(i).getMemCode().equals(MEM)) {
				memList.add(faqList.get(i));
			}else if(faqList.get(i).getMemCode().equals(CO)) {
				coList.add(faqList.get(i));
			}
		}
		
		map.put("coList", coList);
		map.put("memList", memList);
		return map;
	}
	
}
