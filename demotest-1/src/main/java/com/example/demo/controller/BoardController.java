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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.example.demo.command.DelBoardCommand;
import com.example.demo.command.InsertBoardCommand;
import com.example.demo.command.UpdateBoardCommand;
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
		model.addAttribute("delBoardCommand", new DelBoardCommand() );
		return "thymeleaf/board/boardList";
	}
	
	@GetMapping(value = "/boardDetail")
	public String  boardDetail(int board_seq, Model model) {
		BoardDto dto=boardService.getBoard(board_seq);
		model.addAttribute("updateBoardCommand", 
				new UpdateBoardCommand(dto.getBoard_seq(),
									   dto.getTitle(),
									   dto.getContent()));
		model.addAttribute("dto", dto);
		System.out.println(dto.getFileBoardDto().get(0));
		return "thymeleaf/board/boardDetail";
	}
	
	@PostMapping(value = "/boardUpdate")
	public String boardUpdate(@Validated UpdateBoardCommand updateBoardCommand
							  ,BindingResult result
							  ,Model model
							  ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("수정 목록을 모두 입력하세요");
			return "thymeleaf/board/boardDetail";
		}
		
		try { 
			boardService.updateBoard(updateBoardCommand);
			System.out.println("글수정함");
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/board/boardDetail?board_seq="+updateBoardCommand.getBoard_seq();
		}
		
		return "redirect:/board/boardDetail?board_seq="+updateBoardCommand.getBoard_seq();
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
	
//	@PostMapping(value = "/mulDel")
	@RequestMapping(value="mulDel")
	public String mulDel(@Validated DelBoardCommand delBoardCommand
						 ,BindingResult result
			             , Model model) {
		if(result.hasErrors()) {
			System.out.println("최소하나 체크하기");
			List<BoardDto> list=boardService.getAllList();
			model.addAttribute("list", list);
			return "thymeleaf/board/boardlist";
		}
		boardService.mulDel(delBoardCommand.getChk());
		System.out.println("글삭제함");
		return "redirect:/board/boardList";
	}
	
	
	@GetMapping(value = "/download")
	public void download(int file_seq,
						 HttpServletRequest request,
						 HttpServletResponse response) {
		System.out.println("다운로드:"+file_seq);
		String filePath="C:/Users/user/git/back-end_edu20221230_2/"
					  + "demotest-1/src/main/resources/upload";
		FileBoardDto fdto=fileService.getFileInfo(file_seq);
		
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









