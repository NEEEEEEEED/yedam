package com.yedam.moa.mem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.mem.MemInfoVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
import com.yedam.moa.mem.ResumeVO;
import com.yedam.moa.mem.SearchVO;
import com.yedam.moa.mem.mapper.MemMapper;
import com.yedam.moa.mem.service.MemService;

@Service
public class MemServiceImpl implements MemService {

	@Autowired
	MemMapper mem;
	
	
	@Override
	public List<MemVO> openSesame(MemVO vo) {
		return mem.openSesame(vo);
	}

	@Override
	public SearchVO getCount(MemVO vo) {
		
		return mem.getCount(vo);
	}

	@Override
	public List<MemVO> getSearch(SearchVO vo) {
		List<MemVO> sv = mem.getSearch(vo);
		for(int i = 0; i<sv.size();i++) {
			if( sv.get(i).getSt().contains("1")) {
				sv.get(i).setSt("열람");
			}else if(sv.get(i).getSt().contains("0")) {
				sv.get(i).setSt("미열람");
			}
			if(sv.get(i).getExprSt() > 0) {
				sv.get(i).setExprStatus("진행중");
			}else if(sv.get(i).getExprSt() < 0) {
				sv.get(i).setExprStatus("마감");
			}
		}
		System.out.println(sv);
		return sv;
	}
//	공고 검색 목록에서 삭제하기
	@Override
	public int delAnun(SearchVO vo) {
		return mem.delAnun(vo);
	}
//	개인정보 불러오기
	@Override
	public MemInfoVO getMemInfo(MemVO vo) {
		return mem.getMemInfo(vo);
	}

//	디비에 포폴 입력하고 생성된 번호로 입력한 포폴 리스트 가져오기
	@Override
	public List<PrtflVO> insGetPofl(PrtflVO vo) {
		
		
		return null;
	}

	@Override
	public String insertResume(ResumeVO vo) {
		int count = 0;
		int compare = 0;
		System.out.println(vo.getSkill());
		System.out.println(!vo.getSkill().isEmpty());
//		스킬 번호 생성 입력
		if(!vo.getSkill().isEmpty()) {
			compare +=vo.getSkill().size();
			vo.setSkillNo(mem.getSkillNo());
			for(int i=0;i<vo.getSkill().size();i++) {
				vo.getSkill().get(i).setSkillNo(vo.getSkillNo());
				mem.insertSkill(vo.getSkill().get(i));
				count++;
			}
			System.out.println(count);
		}
//		수상 번호 생성 입력
		if(!vo.getArd().isEmpty()) {
			compare += vo.getArd().size();
			vo.setArdNo(mem.getArdNo());
			for(int i=0;i<vo.getArd().size();i++) {
				vo.getArd().get(i).setArdNo(vo.getArdNo());
				mem.insertAward(vo.getArd().get(i));
				count++;
			}
			System.out.println(count);
		}
//		경력 번호 생성 입력
		if(!vo.getCarr().isEmpty()) {
			compare += vo.getCarr().size();
			vo.setCarrNo(mem.getCarrNo()); 
			for(int i=0;i<vo.getCarr().size();i++) {
				vo.getCarr().get(i).setCarrNo(vo.getArdNo());
				mem.insertCarrer(vo.getCarr().get(i));
				count++;
			}
			System.out.println(count);
		}
//		교육번호 생성 입력
		if(!vo.getEdu().isEmpty()) {
			compare+=vo.getEdu().size();
			vo.setEduNo(mem.getEduNo());
			for(int i=0;i<vo.getEdu().size();i++) {
				vo.getEdu().get(i).setEduNo(vo.getEduNo());
				mem.insertEducate(vo.getEdu().get(i));
				count++;
			}
			System.out.println(count);
		}
//		자소서 번호생성 입력
		if(!vo.getIntro().isEmpty()) {
			compare += vo.getIntro().size();
			 vo.setIntroNo(mem.getEduNo());
			for(int i=0;i<vo.getIntro().size();i++) {
				vo.getIntro().get(i).setIntroNo(vo.getIntroNo());
				mem.insertIntro(vo.getIntro().get(i));
				count++;
			}
			System.out.println(count);
		}
//		자격증 번호 생성 입력
		if(!vo.getLicn().isEmpty()) {
			compare += vo.getLicn().size();
			vo.setLicnNo( mem.getLicnNo()); 
			for(int i=0;i<vo.getLicn().size();i++) {
				vo.getLicn().get(i).setLicnNo(vo.getLicnNo());
				mem.insertLicence(vo.getLicn().get(i));
				count++;
			}
			System.out.println(count);
		}
//		학력 번호 생성 입력
		if(!vo.getSch().isEmpty()) {
			compare += vo.getSch().size();
			vo.setShcrNo(mem.getSchNo());
			for(int i=0;i<vo.getSch().size();i++) {
				vo.getSch().get(i).setShcrNo(vo.getShcrNo());
				mem.insertSchool(vo.getSch().get(i));
				count++;
			}
			System.out.println(count);
		}
		if(!vo.getMemInfo().isEmpty()) {
			compare += vo.getMemInfo().size();
			vo.getMemInfo().get(0).setId(vo.getId());
			mem.insertMem(vo.getMemInfo().get(0));
				count++;
			System.out.println(count);
		}
//		이력서 헤더 입력
		
		vo.setResumeNo(mem.getResumeNo());	
		count += mem.insertResume(vo);
		if(count == compare-1 ) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
		
	}
	




}
