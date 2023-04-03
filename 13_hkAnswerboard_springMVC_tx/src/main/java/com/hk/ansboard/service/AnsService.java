package com.hk.ansboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
		return ansDao.getAllList(pnum);
	}

	@Override
	public int getPCount() {
		return ansDao.getPCount();
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		return ansDao.insertBoard(dto);
	}

	@Override
	public AnsDto getBoard(int seq) {
		return ansDao.getBoard(seq);
	}

	@Override
	public boolean updateBoard(AnsDto dto) {
		return ansDao.updateBoard(dto);
	}

	@Override
	public boolean muldelBoard(String[] seqs) {
		return ansDao.muldelBoard(seqs);
	}

	@Override
	public boolean readCount(int seq) {
		return ansDao.readCount(seq);
	}
     //propagation = Propagation.REQUIRED_NEW
	//propagation = Propagation.NESTED
//	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean replyBoard(AnsDto dto) {
		int count=0;
		ansDao.updateReplyBoard(dto);//update문 실행
		count=ansDao.insertReplyBoard(dto);//insert문 실행
		return count>0?true:false;
	}
	
	
	
}





