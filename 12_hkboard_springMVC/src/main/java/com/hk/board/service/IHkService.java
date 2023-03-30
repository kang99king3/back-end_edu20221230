package com.hk.board.service;

import java.util.List;

import com.hk.board.dtos.HkDto;

public interface IHkService {

	//글목록 조회
	public List<HkDto> getAllList();
	
	//글 상세조회 
	public HkDto getBoard(int seq);
	
	//글추가하기
	public boolean insertBoard(HkDto dto) ;
	
	//글 수정하기
	public boolean updateBoard(HkDto dto);
	
	//글삭제하기
	public boolean delBoard(String seq);
	
	//여러글삭제하기
	public boolean mulDel(String[] seqs) ;
}
