package com.yedam.moa.community;

import lombok.Data;

@Data
public class CommunityVO {

		private String id;
		private String writer;
		private String ctnt;
		private String wdate;
		byte[] imgData; // blob 이미지
		private String atachFile;
		private String atachType;

}
