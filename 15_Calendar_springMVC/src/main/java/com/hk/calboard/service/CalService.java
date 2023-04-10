package com.hk.calboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.daos.ICalDao;
import com.hk.calboard.dtos.CalDto;
import com.hk.calboard.utils.Util;

@Service
public class CalService implements ICalService{

	@Autowired
	private ICalDao calDaoMapper;
	
	@Override
	public boolean insertCalBoard(InsertCalCommand insertCalCommand) {
		// DB에 mdate 컬럼에 저장할 값을 처리: year,month,date... 12자리로 변환
		String mdate=insertCalCommand.getYear()
				    +Util.isTwo(insertCalCommand.getMonth())
				    +Util.isTwo(insertCalCommand.getDate())
				    +Util.isTwo(insertCalCommand.getHour())
				    +Util.isTwo(insertCalCommand.getMin()); // 12자리 생성
		//dto <---command값을 저장
		CalDto dto=new CalDto();
		dto.setId(insertCalCommand.getId());
		dto.setTitle(insertCalCommand.getTitle());
		dto.setContent(insertCalCommand.getContent());
		dto.setMdate(mdate);
		
		int count=calDaoMapper.insertCalBoard(dto);
		return count>0?true:false;
	}

	@Override
	public List<CalDto> calBoardList(String id, String yyyyMMdd) {
		return calDaoMapper.calBoardList(id, yyyyMMdd);
	}

	@Override
	public CalDto calBoardDetail(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean calBoardUpdate(CalDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean calMulDel(String[] seqs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calBoardCount(String id, String yyyyMMdd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CalDto> CalViewList(String id, String yyyyMM) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
