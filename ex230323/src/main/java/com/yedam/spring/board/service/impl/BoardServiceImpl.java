package com.yedam.spring.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public BoardVO getBoardNo() {
		return boardMapper.getBoardNo();
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		BoardVO vo = new BoardVO();
		vo.setBno(boardVO.getBno());
		if(boardMapper.insertBoard(boardVO) ==1) {
			return vo.getBno();
		} else {
			return -1;
		}
		
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		BoardVO vo = new BoardVO();
		vo.setBno(boardVO.getBno());
		if(boardMapper.updateBoard(boardVO) == 1) {
			return vo.getBno();
		} else {
			return -1;
		}
	}

	@Override
	public int deleteBoardInfo(int bno) {
		if(boardMapper.deleteBoard(bno) == 1) {
			return bno;
		} else {
			return -1;
		}
	}
	

}
