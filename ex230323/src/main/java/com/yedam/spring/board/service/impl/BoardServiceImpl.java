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
	public List<BoardVO> getBoardAll() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardMapper.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int bno) {
		return boardMapper.deleteBoard(bno);
	}

}
