package com.hk.board.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hk.board.dtos.HkDto;

public interface IHkDao {
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
