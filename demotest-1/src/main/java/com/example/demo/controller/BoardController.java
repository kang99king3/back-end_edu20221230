package com.example.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.multipart.MultipartRequest;

import com.example.demo.command.InsertBoardCommand;
import com.example.demo.dtos.BoardDto;
import com.example.demo.dtos.FileBoardDto;
import com.example.demo.dtos.MemberDto;
import com.example.demo.service.BoardService;
import com.example.demo.service.FileService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private FileService fileService;
	
	@GetMapping(value = "/boardList")
	public String  boardList(Model model) {
		System.out.println("글목록보기");
		List<BoardDto> list=boardService.getAllList();
		model.addAttribute("list", list);
		return "thymeleaf/board/boardList";
	}
	
	@GetMapping(value = "/boardDetail")
	public String  boardDetail(int board_seq, Model model) {
		BoardDto dto=boardService.getBoard(board_seq);
		model.addAttribute("dto", dto);
		System.out.println(dto.getFileBoardDto().get(0));
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
//							  ,@RequestParam("filename") MultipartFile multiFile
							  ,MultipartRequest multipartRequest
							  ,Model model
							  ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("글을 모두 입력하세요");
			return "thymeleaf/board/boardInsertForm";
		}
		
		try {
			//글추가 폼에서 id가 출력안되서 session에서 id 가져옴
			MemberDto mdto=(MemberDto)request.getSession().getAttribute("mdto");
			insertBoardCommand.setId(mdto.getId());  
			
//			boardService.insertBoard(insertBoardCommand, multiFile);
			boardService.insertBoard(insertBoardCommand, multipartRequest);
			System.out.println("글추가함");
		}catch(Exception e) {
			e.printStackTrace();
			return "thymeleaf/board/boardInsertForm";
		}
		
		return "redirect:/board/boardList";
	}
	
	@GetMapping(value = "/download")
	public void download(int file_seq,
						 HttpServletRequest request,
						 HttpServletResponse response) {
		System.out.println("다운로드:"+file_seq);
		String filePath="C:/Users/user/git/back-end_edu20221230_2/"
					  + "demotest-1/src/main/resources/upload";
		FileBoardDto fdto=boardService.getFileInfo(file_seq);
		
		try {
			fileService.fileDownload(filePath,
									 fdto.getOrigin_filename(),
									 fdto.getStored_filename(),
									 request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}









