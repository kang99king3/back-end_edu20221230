package com.hk.calboard.service;

import java.util.List;

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.dtos.CalDto;

public interface ICalService {
	// 일정추가하기: ID, TITLE, CONTENT, MDATE
	public boolean insertCalBoard(InsertCalCommand insertCalCommand);
	// 일정목록조회하기: 파라미터[ID, YYYYMMDD]
	public List<CalDto> calBoardList(String id, String yyyyMMdd);
	// 일정 상세내용 조회: SEQ
	public CalDto calBoardDetail(int seq);
	// 일정 수정하기: 파리미터[SEQ, TITLE, CONTENT, MDATE)
	public boolean calBoardUpdate(CalDto dto);
	// 일정 삭제하기: SEQ
	public boolean calMulDel(String[] seqs);
	// 일정 개수 구하기: ID, YYYYMMDD
	public int calBoardCount(String id, String yyyyMMdd);
	// 달력에서 일정 보여주기: ID, YYYYMM
	public List<CalDto> CalViewList(String id, String yyyyMM);
}
