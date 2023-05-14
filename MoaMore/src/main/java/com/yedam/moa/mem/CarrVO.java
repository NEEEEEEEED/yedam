package com.yedam.moa.mem;

import lombok.Data;

@Data
public class CarrVO {
	private String carrNo;		//경력 번호
	private String wkdty;		//직책
	private String depart;		//부서명
	private String duty;		//직무
	private String joinYy;		//입사년도
	private String retiYy;		//퇴사년도
	private String buss;		//업무
	private String carrSt;		//경력 상태(재직 퇴사..)
	private String co;			//회사이름
	
}
