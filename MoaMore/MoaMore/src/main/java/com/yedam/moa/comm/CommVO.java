package com.yedam.moa.comm;

import lombok.Data;

@Data
public class CommVO {
 
	private String desct;		//총 코드
	private String prov;		//내용
	private String commCd;
	private String commNm;
	
	
	public CommVO(String st) {
		setCommCd(st);
	}
//	public CommVO(String std, String st) {
//		setCommNm(st);
//	}
}
