package com.hk.ansboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hk.ansboard.dao.IAnsDao;
import com.hk.ansboard.dtos.AnsDto;

@Service
public class AnsService implements IAnsService{

	@Autowired
	private IAnsDao ansDao;
	
	@Override
	public List<AnsDto> getAllList(String pnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AnsDto getBoard(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBoard(AnsDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean muldelBoard(String[] seqs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}
     //propagation = Propagation.REQUIRED_NEW
	//propagation = Propagation.NESTED
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean replyBoard(AnsDto dto) {
		int count=0;
		ansDao.updateReplyBoard(dto);//update문 실행
		count=ansDao.insertReplyBoard(dto);//insert문 실행
		return count>0?true:false;
	}
	
	
}





