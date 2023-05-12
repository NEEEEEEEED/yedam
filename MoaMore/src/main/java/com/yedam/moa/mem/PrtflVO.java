package com.yedam.moa.mem;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PrtflVO {
	
	private String prtflNo;   //포폴 번호
	private String prtflFile; //포폴 파일명
	private String prtfImg;	  //포폴 이미지명
	private String uuid;	  //UUID 파일명
	private String ttl;		  //포폴 제목
	private MultipartFile uploadPofolImg;	//포폴 이미지 멀티파트용
	private MultipartFile uploadPofolFile;	//포포 파일 멀티파트용
}
