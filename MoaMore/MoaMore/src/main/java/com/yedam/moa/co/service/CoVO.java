package com.yedam.moa.co.service;

import lombok.Data;

@Data
public class CoVO {
	//기업정보
	private String id;
	private String pw;
	private String rpstr; //대표자
	private String sale; //매출액
	private String coFg; //기업구분
	private String empTtl; //사원수
	private String fondtDt; //설립일
	private String idst; //산업
	private String addr; //주소
	private String cptl; //자본금
	private String homePage; //홈페이지
	private String bizno; //사업자등록번호
	private String coNm; //기업명
	private String profileImg; //프로필이미지 member
	
	//셀프구직 제안 양식
	private String offerCd; //채용제안코드
	private String wksite; //근무지
	private String tech; //기술스택
	private String maBuss; //주요업무
	private String bnft; //복지 및 혜택
	private String saly; //제안급여;연봉
	private String bussStartDt; //업무시작일
	private String clsDt; //제안 마감일
	private String projectNm; //프로젝트명
	private String ttl; //구인공고 
	
	//채용제안상태
	private String jobSearchNo; //셀프구직게시글번호
	private String acceptStatus; //제안수락상태
	
	//이메일
	private String email;
	
	//구인공고에 대한 지원
	private String recruitNo; // 구인공고번호
	private String resumeNo; // 이력서 번호
	private String aplySt; // 지원상태 b1지원완료 b2지원취소
	private String aplyDt; // 지원일자
	private String st; // 열람여부 0미열람 1열람
	private String win; // 합격여부 T 합 대 불
	private String attl;  // 구인공고 제목 
	private String exprDt; // 구인공고 마감일
	private String rttl; // 이력서 제목
	
	
}
