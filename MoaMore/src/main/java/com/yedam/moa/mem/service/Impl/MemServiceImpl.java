package com.yedam.moa.mem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.moa.mem.ArdVO;
import com.yedam.moa.mem.CarrVO;
import com.yedam.moa.mem.EduVO;
import com.yedam.moa.mem.IntroVO;
import com.yedam.moa.mem.LicnVO;
import com.yedam.moa.mem.MemVO;
import com.yedam.moa.mem.PrtflVO;
import com.yedam.moa.mem.SearchVO;
import com.yedam.moa.mem.ShcrVO;
import com.yedam.moa.mem.SkillVO;
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
	public MemVO getMemInfo(MemVO vo) {
		return mem.getMemInfo(vo);
	}
//	포폴 넘버 생성
	@Override
	public PrtflVO getPrtflNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	학력 넘버 생성
	@Override
	public ShcrVO getShcrlNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	스킬 넘버 생성
	@Override
	public SkillVO getSkillNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	수상 넘버 생성
	@Override
	public ArdVO getArdNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	경력 넘버 생성
	@Override
	public CarrVO getCarrNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	교육 넘버 생성
	@Override
	public EduVO getEduNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	자기소개 넘버 생성
	@Override
	public IntroVO getIntroNo() {
		// TODO Auto-generated method stub
		return null;
	}
//	자격증 넘버 생성
	@Override
	public LicnVO getLicnNo() {
		// TODO Auto-generated method stub
		return null;
	}



}
