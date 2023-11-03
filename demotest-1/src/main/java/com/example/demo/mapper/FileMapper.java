package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dtos.FileBoardDto;

@Mapper
public interface FileMapper {
	//파일 정보 추가
	public boolean insertFileBoard(FileBoardDto dto);
	//파일 정보 조회
	public FileBoardDto getFileInfo(int file_seq);
	//파일 정보 수정
	public boolean updateFile(FileBoardDto dto);
}
