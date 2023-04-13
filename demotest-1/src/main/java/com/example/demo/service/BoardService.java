package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.command.InsertBoardCommand;
import com.example.demo.dtos.BoardDto;
import com.example.demo.dtos.FileBoardDto;
import com.example.demo.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileService fileService;
	@Autowired
	private BoardDto boardDto;
	

	public List<BoardDto> getAllList(){
		return boardMapper.getAllList();
	}
	
	public BoardDto getBoard(int board_seq) {
		return boardMapper.getBoard(board_seq);
	}
	
	@Transactional
	public boolean insertBoard(InsertBoardCommand insertBoardCommand
			,MultipartFile multiFile) throws IllegalStateException, IOException {
		boardDto.setId(insertBoardCommand.getId());
		boardDto.setTitle(insertBoardCommand.getTitle());
		boardDto.setContent(insertBoardCommand.getContent());
		boolean isS= boardMapper.insertBoard(boardDto);
		if(!multiFile.isEmpty()) { //첨부됐다면
			//게시글의 첨부 파일 경로[절대경로로 설정해보자..]
			String filePath="C:/Users/user/git/back-end_edu20221230_2/"
					      + "demotest-1/src/main/resources/upload";
			//upload하기
			FileBoardDto fdto=fileService.uploadFile(filePath, multiFile);
			boardMapper.insertFileBoard(fdto);//db에 파일 정보 추가
		}
		return isS;
	}
	
}








