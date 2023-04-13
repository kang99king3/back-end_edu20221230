package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.command.InsertBoardCommand;
import com.example.demo.dtos.BoardDto;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/boardList")
	public String  boardList(Model model) {
		List<BoardDto> list=boardService.getAllList();
		model.addAttribute("list", list);
		return "thymeleaf/board/boardList";
	}
	
	@GetMapping(value = "/boardDetail")
	public String  boardDetail(int board_seq, Model model) {
		BoardDto dto=boardService.getBoard(board_seq);
		model.addAttribute("dto", dto);
		return "thymeleaf/board/boardDetail";
	}
	
	@GetMapping(value = "/boardInsertForm")
	public String  boardInsertForm(Model model) {
		model.addAttribute("insertBoardCommand", 
				           new InsertBoardCommand());
		return "thymeleaf/board/boardInsertForm";
	}
	
	@PostMapping(value = "/boardInsert")
	public String boardInsert(@Validated InsertBoardCommand insertBoardCommand
							  ,BindingResult result
							  ,@RequestParam("filename") MultipartFile multiFile
							  ,Model model) {
		if(result.hasErrors()) {
			System.out.println("글을 모두 입력하세요");
			return "thymeleaf/board/boardInsertForm";
		}
		
		try {
			boardService.insertBoard(insertBoardCommand, multiFile);
			System.out.println("글추가함");
		}catch(Exception e) {
			e.printStackTrace();
			return "thymeleaf/board/boardInsertForm";
		}
		
		return "redirect:/board/boardList";
	}
}









