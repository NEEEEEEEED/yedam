package com.yedam.spring.board.service;

import java.util.List;
import java.util.Map;


public interface BoardService {
	//전체조회
	public List<BoardVO> getBoardList();
	//단건조회
	public BoardVO getBoardInfo(BoardVO boardVO);
	//번호조회
	public BoardVO getBoardNo();
	//등록 진행된 게시글 번호를 리턴하도록 만들기
	public int insertBoardInfo(BoardVO boardVO);
	//수정 진행된 게시글 번호를 리턴하도록 만들기
	public int updateBoardInfo(BoardVO boardVO);
	//삭제 진행된 게시글 번호를 리턴하도록 만들기
	public int deleteBoardInfo(int bno);
}
