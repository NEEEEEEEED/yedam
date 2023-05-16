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
		String no = null;

//		스킬 번호 생성 입력
		if(!vo.getSkill().isEmpty()) {
			compare += vo.getSkill().size();
			for(int i=0;i<vo.getSkill().size();i++) {

				vo.getSkill().get(i).setSkillNo(no);
				mem.insertSkill(vo.getSkill().get(i));
				no=vo.getSkill().get(i).getSkillNo();
					if(no == null){break;}
				count++;
				System.out.println(count);
				System.out.println(compare);
				
			}
			vo.setSkillNo(no);
			no=null;
		}
//		수상 번호 생성 입력
		if(!vo.getArd().isEmpty()) {
			compare += vo.getArd().size();
			for(int i=0;i<vo.getArd().size();i++) {
				vo.getArd().get(i).setArdNo(no);
				mem.insertAward(vo.getArd().get(i));
				no = vo.getArd().get(i).getArdNo();
				System.out.println(no);
				if(no == null){break;}
				count++;
				System.out.println(count);
				 System.out.println(compare);
			}
			vo.setArdNo(no);
			no=null;
		}
//		경력 번호 생성 입력
		if(!vo.getCarr().isEmpty()) {
			compare += vo.getCarr().size();
			for(int i=0;i<vo.getCarr().size();i++) {
				vo.getCarr().get(i).setCarrNo(no);
				 mem.insertCarrer(vo.getCarr().get(i));
				 no = vo.getCarr().get(i).getCarrNo();
				 if(no == null){break;}
				 count++;
				 System.out.println(count);
				 System.out.println(compare);
			}
			vo.setCarrNo(no);
			no =null;
		}
//		교육번호 생성 입력
		if(!vo.getEdu().isEmpty()) {
			compare += vo.getEdu().size();
			for(int i=0;i<vo.getEdu().size();i++) {
				vo.getEdu().get(i).setEduNo(no);
				mem.insertEducate(vo.getEdu().get(i));
				no = vo.getEdu().get(i).getEduNo();
				 if(no == null){break;}
				 count++;
				 System.out.println(count);
				 System.out.println(compare);
			}
			vo.setEduNo(no);
			no=null;
		}
//		자소서 번호생성 입력
		if(!vo.getIntro().isEmpty()) {
			compare += vo.getIntro().size();
			for(int i=0;i<vo.getIntro().size();i++) {
				vo.getIntro().get(i).setIntroNo(no);
				mem.insertIntro(vo.getIntro().get(i));
				no=vo.getIntro().get(i).getIntroNo();
				if(no == null){break;}
				count++;
				System.out.println(count);
				 System.out.println(compare);
			}
			vo.setIntroNo(no);
			no=null;
		}
//		자격증 번호 생성 입력
		if(!vo.getLicn().isEmpty()) {
			compare += vo.getLicn().size();
			for(int i=0;i<vo.getLicn().size();i++) {
				vo.getLicn().get(i).setLicnNo(no);
				 mem.insertLicence(vo.getLicn().get(i));
				no=vo.getLicn().get(i).getLicnNo();
				if(no == null){break;}
				count++;
				System.out.println(count);
				 System.out.println(compare);
			}
			vo.setLicnNo(no);
			no=null;
		}
//		학력 번호 생성 입력
		if(!vo.getSch().isEmpty()) {
			compare += vo.getSch().size();
			for(int i=0;i<vo.getSch().size();i++) {
				vo.getSch().get(i).setShcrNo(no);
				mem.insertSchool(vo.getSch().get(i));
				no=vo.getSch().get(i).getShcrNo();
				if(no == null){break;}
				count++;
				System.out.println(count);
				 System.out.println(compare);
			}
			vo.setShcrNo(no);
			no=null;
		}
		if(!vo.getMemInfo().isEmpty()) {
			vo.getMemInfo().get(0).setId(vo.getId());
			count += mem.insertMem(vo.getMemInfo().get(0));
			compare++;
			System.out.println(count);
			 System.out.println(compare);
		}
//		이력서 헤더 입력
		 vo.setResumeNo(mem.getResumeNo());	
		 count += mem.insertResume(vo);
		 compare ++;
		 System.out.println(count);
		 System.out.println(compare);
		if(count == compare) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
		
	}

	@Override
	public ResumeVO lastRe(MemVO vo) {
		ResumeVO rvo = new ResumeVO();
	
		
		rvo = mem.lastRe(vo);
		System.out.println(rvo);
		if(rvo != null) {
		if(rvo.getArdNo()!=null) {
			rvo.setArd(mem.getArd(rvo));
		}
		if(rvo.getCarrNo()!=null) {
			rvo.setCarr(mem.getCarr(rvo));
		}
		if(rvo.getEduNo()!=null) {
			rvo.setEdu(mem.getEdu(rvo));
		}
		if(rvo.getIntroNo()!=null) {
			rvo.setIntro(mem.getIntro(rvo));
		}
		if(rvo.getLicnNo()!=null) {
			rvo.setLicn(mem.getLicn(rvo));
		}
		if(rvo.getShcrNo()!=null) {
			rvo.setSch(mem.getShcr(rvo));
		}
		if(rvo.getSkillNo()!=null) {
			rvo.setSkill(mem.getSkill(rvo));
		}
		
		}else {rvo.setResumeNo("none");}
		return rvo;
		
	}
}
