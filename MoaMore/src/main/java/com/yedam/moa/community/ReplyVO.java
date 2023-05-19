package com.yedam.moa.community;

import java.util.List;

import lombok.Data;

@Data
public class ReplyVO {
	
	private String rplyNo; 				// 취업 Q&A 댓글번호
	private String qaNotiwrNo; 			// 취업 Q&A 게시글번호(fk)
	private String id;					// 아이디
	private String rplyCntn;			// 댓글내용
	private String regDt;				// 등록일자
	private int rplyDepth;				// 댓글 깊이 : 모댓글(일반댓글) - 0(default) / 대댓글 - 1
	private String rplyGroup;			// 댓글 그룹ID(모댓글 : rplyNo이 들어가는 부분)
	private String rplyDelYn;			// 댓글 삭제 여부 : N (default) 
	private int childCount;				// 해당 댓글의 대댓글 총갯수
	
	private List<ReplyVO> chreplyList;	// 해당 댓글(모댓글)의 자식 대댓글 리스트
	
}
