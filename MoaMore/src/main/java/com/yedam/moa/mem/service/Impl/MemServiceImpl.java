package com.yedam.moa.mem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.community.Criteria;
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



	@Override
	public String insertResume(ResumeVO vo) {
		int count = 0; //입력 프로 시져 실행 횟 수
		int compare = 0; //count와 비교하기 위해 배열의 크기
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
		 
//		 compare(배열의 크기)와 count(입력 횟수)를 비교해서 메소드의 성공여부 확인
		if(count == compare) {
			return "{\"result\": \"Success\"}";
		}else {
			return "{\"result\": \"Fail\"}";
		}
		
	}

	@Override
	public ResumeVO lastRe(MemVO vo) {
		ResumeVO rvo = new ResumeVO();
			System.out.println(rvo);
			//이력서 개수가 0보다 크면
			if(mem.getCountRe(vo)>0) {
//			이력서 기본 정보 가져오기
			rvo = mem.lastRe(vo);
			System.out.println(rvo);
//			기본정보에서 수상번호 있을경우 수상 정보 가져오기
			if(rvo.getArdNo()!=null) {
				rvo.setArd(mem.getArd(rvo));
			}
//			커리어번호 있을경우 커리어 정보 가져오기
			if(rvo.getCarrNo()!=null) {
				rvo.setCarr(mem.getCarr(rvo));
			}
//			교육번호 있을경우 교육 정보 가져오기
			if(rvo.getEduNo()!=null) {
				rvo.setEdu(mem.getEdu(rvo));
			}
//			자소서번호 있을경우 자소서 정보 가져오기
			if(rvo.getIntroNo()!=null) {
				rvo.setIntro(mem.getIntro(rvo));
			}
//			자격증번호 있을경우 자격증 정보 가져오기
			if(rvo.getLicnNo()!=null) {
				rvo.setLicn(mem.getLicn(rvo));
			}
//			학력번호 있을경우 학력 정보 가져오기
			if(rvo.getShcrNo()!=null) {
				rvo.setSch(mem.getShcr(rvo));
			}
			if(rvo.getPrtflNo()!=null) {
				rvo.setPrtfl(mem.getPrtfl(rvo));
			}
//			기술번호 있을경우 기술 정보 가져오기
			if(rvo.getSkillNo()!=null) {
				rvo.setSkill(mem.getSkill(rvo));
				System.out.println(rvo.getSkill());
				rvo.setUnSkill(mem.getUnSkill(rvo));
			}
			
			}
	
		return rvo;
		
	}

	@Override
	public int withdraw(String id) {
		return mem.withdraw(id);
	}

	
	//포트폴리오 입력 생성된 prtflno반환
	@Override
	public PrtflVO insertPofl(PrtflVO vo) {
		mem.insertPrtfl(vo);
		return vo ;
	}
	//입력으로 발생한 prtflno로 입력 포폴 조회(포폴 입력후 화면에 뿌려주기 위한것) => 최신이력서 불러 올때 쓰기 위해서 ResumeVO로 반환
	@Override
	public List<PrtflVO>  getPrtfl(ResumeVO vo) {
		return mem.getPrtfl(vo);
	}

	@Override
	public int delPofol(PrtflVO vo) {
		System.out.println(vo);
		return mem.delPofol(vo);
	}

	@Override
	public ResumeVO getRe(ResumeVO rvo) {
//		이력서 기본 정보 가져오기
		rvo = mem.getRe(rvo);
		System.out.println(rvo);
//		기본정보에서 수상번호 있을경우 수상 정보 가져오기
		if(rvo.getArdNo()!=null) {
			rvo.setArd(mem.getArd(rvo));
		}
//		커리어번호 있을경우 커리어 정보 가져오기
		if(rvo.getCarrNo()!=null) {
			rvo.setCarr(mem.getCarr(rvo));
		}
//		교육번호 있을경우 교육 정보 가져오기
		if(rvo.getEduNo()!=null) {
			rvo.setEdu(mem.getEdu(rvo));
		}
//		자소서번호 있을경우 자소서 정보 가져오기
		if(rvo.getIntroNo()!=null) {
			rvo.setIntro(mem.getIntro(rvo));
		}
//		자격증번호 있을경우 자격증 정보 가져오기
		if(rvo.getLicnNo()!=null) {
			rvo.setLicn(mem.getLicn(rvo));
		}
//		학력번호 있을경우 학력 정보 가져오기
		if(rvo.getShcrNo()!=null) {
			rvo.setSch(mem.getShcr(rvo));
		}
		if(rvo.getPrtflNo()!=null) {
			rvo.setPrtfl(mem.getPrtfl(rvo));
		}
//		기술번호 있을경우 기술 정보 가져오기
		if(rvo.getSkillNo()!=null) {
			rvo.setSkill(mem.getSkill(rvo));
			System.out.println(rvo.getSkill());
			rvo.setUnSkill(mem.getUnSkill(rvo));
		}
		
		

	return rvo;
	}

	@Override
	public void updateRe(ResumeVO vo) {
		mem.delResume(vo);
	}

	@Override
	public int checkId(MemInfoVO vo) {
		return mem.checkId(vo);
	}

	@Override
	public int getPageCnt(String id) {
		return mem.getPageCnt(id);
	}

	@Override
	public List<ResumeVO> resumeList(Criteria cri) {
		return mem.resumeList(cri);
	}

	@Override
	public int delResume(ResumeVO rvo) {
		int count = mem.getPageCnt(rvo.getId());
		 mem.delResume(rvo);
		 int countAft = mem.getPageCnt(rvo.getId());
		 if(count-countAft==1) {
			 return 1;
		 }else {
			 return 0;
		 }
	}
}
