package com.yedam.moa.self;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SelfVO {
	
	// 공통코드
	private String prov;  		// 공통 코드
	private String desct; 		// 공통 코드명
	
	//셀프구직-게시글 JOB_SEARCH_NOTIWR
	private String jobSearchNo; // 셀프구직 게시글 번호
	private String resumeNo; 	// 이력서 번호
	private String id;			// 아이디
	private String intro;		// 자기소개
	private String hopeWksite;	// 희망근무지역
	private String career; 		// 경력
	private String dutyFld;		// 직무분야 
	private String posit;		// 포지션(기술스택)
	private String hopeSal;		// 희망급여
	private String residency;	// 상주가능여부
	private String interest;	// 받은관심수
	private String prop;		// 받은제안수
	private String drwupDt;		// 작성일자
	private String pubcRange;	// 공개범위권한
	private String imgNo;		// 이미지그룹번호
	private String regDt;		// 등록일자
	
	// 스킬
	private String skillNo;		// 스킬번호
	private String skill;		// 스킬
	
	
	// 이력서 헤더
	private String ttl; 		// 이력서 제목
	private String carrNo;		// 이력서 경력번호
	private String shcrNo;		// 이력서 학력번호
	
	// 경력 사항
	private String co;			// 회사이름
	private String no;			// 구분
	private String wkdty;		// 직책
	private String depart;		// 부서명
	private String duty;		// 직무
	private String joinYy;		// 입사년도
	private String retiYy;		// 퇴사년도
	private String buss;		// 업무
	private String carrSt;		// 경력상태
	
	// 학력사항
	private String fg;			// 학교구분
	private String breu;		// 학교이름
	private String mj;			// 전공
	private String pnt;			// 학점
	private String shcrSt;		// 학력상태
	private String ttScore;		// 학점총점(4.5 , 4.3)

	// 첨부파일 영역
	private String myimg; 				// 프로필 이미지
	
	private List<SelfVO> carrArr; 		// 경력사항 리스트
	private List<SelfVO> schoolArr; 	// 학력사항 리스트
	
	// 포트폴리오
	private String fileNo;				// 포트폴리오 기본키
	private String title;				// 제목
	private String pofolImg;			// 포트폴리오 이미지
	private String pofolFile;			// 포트폴리오 원본파일명
	private String pofolUuidFile;		// 포트폴리오 UUID 파일명
	
	// 권한
	private String auth;				// 현재 로그인한 사람의 권한
		
	
}
