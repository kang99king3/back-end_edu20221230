package com.hk.calboard.daos;

import java.util.List;

import com.hk.calboard.dtos.CalDto;

public interface ICalDao {

	// 일정추가하기: ID, TITLE, CONTENT, MDATE
	public boolean insertCalBoard(CalDto dto);
	// 일정목록조회하기: 파라미터[ID, YYYYMMDD]
	public List<CalDto> calBoardList(String id, String yyyyMMdd);
	// 일정 상세내용 조회: SEQ
	
	// 일정 수정하기: 파리미터[SEQ, TITLE, CONTENT, MDATE)
	
	// 일정 삭제하기: SEQ
	
	// 일정 개수 구하기: ID, YYYYMMDD
	
	// 달력에서 일정 보여주기: ID, YYYYMM
}
