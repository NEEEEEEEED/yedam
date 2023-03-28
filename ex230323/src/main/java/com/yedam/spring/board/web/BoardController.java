package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;


@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//전체조회 : URI - getBoardList, return - board/boardList > Tiles 형태
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		//데이터 보낼때 사용
		model.addAttribute("boardList",boardService.getBoardList());
		return "board/boardList";
	}
	//단건조회 : URI - getBoardInfo, return - board/boardInfo
	@GetMapping("/getBoardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo",boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	//등록 - 페이지 요청 : URI - boardInsert, return - board/boardInsert
	//작성시 다음 게시글 번호를 같이 들고 들어가도록 하는 방법
	@GetMapping("/boardInsert")
	public String boardInsertForm(Model model) {
		model.addAttribute("boardNo",boardService.getBoardNo().getBno());
		return "board/boardInsert";
	}
	//등록 - 처리 요청 : URI - boardInsert, return - 전체조회 다시 호출
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:getBoardList";
	}
	//수정 - 페이지 요청 : URI - boardUpdate, return - board/boardUpdate
	@GetMapping("/boardUpdate")
	public String boardUpdateForm(BoardVO boardVO,Model model) {
		model.addAttribute("boardInfo" , boardService.getBoardInfo(boardVO));
		return "board/boardUpdate";
	}
	//수정 - 처리 요청 : URI - boardUpdate, return - 단건조회 다시 호출
	@PostMapping("/boardUpdate")
	public String boardUpdateProcess(BoardVO boardVO) {
		boardService.updateBoardInfo(boardVO);
		return "redirect:getBoardInfo?bno="+boardVO.getBno();
	}
	//삭제 : URI - boardDelete, return - 전체조회 다시 호출
	@GetMapping("/boardDelete")
	public String boardDeleteProcess(@RequestParam int bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:getBoardList";
	}
	
}
