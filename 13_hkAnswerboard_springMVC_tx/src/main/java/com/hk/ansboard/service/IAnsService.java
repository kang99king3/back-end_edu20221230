package com.hk.ansboard.service;

import java.util.List;

import com.hk.ansboard.dtos.AnsDto;

public interface IAnsService {
	//1.글목록 조회하기
	public List<AnsDto> getAllList(String pnum);
	//1-2.페이지수 구하기
	public int getPCount() ;
	//2.새글 추가하기
	public boolean insertBoard(AnsDto dto) ;
	//3.글 상세조회
	public AnsDto getBoard(int seq);
	//4.글 수정하기
	public boolean updateBoard(AnsDto dto);
	//5.글 삭제하기(update문: delflag[Y/N])
	public boolean muldelBoard(String[] seqs) ;
	//6.글 조회수: update문 --> readcount의 값을 증가
	public boolean readCount(int seq) ;
	//7.답글 추가하기:Transaction 처리 
	public boolean replyBoard(AnsDto dto);
}




