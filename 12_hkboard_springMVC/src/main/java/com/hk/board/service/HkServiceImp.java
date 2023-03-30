package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.board.daos.IHkDao;
import com.hk.board.dtos.HkDto;

@Service
public class HkServiceImp implements IHkService{

	@Autowired
	private IHkDao hkDao;
	
	@Override
	public List<HkDto> getAllList() {
		return hkDao.getAllList();
	}

	@Override
	public HkDto getBoard(int seq) {
		return hkDao.getBoard(seq);
	}

	@Override
	public boolean insertBoard(HkDto dto) {
		return hkDao.insertBoard(dto);
	}

	@Override
	public boolean updateBoard(HkDto dto) {
		return hkDao.updateBoard(dto);
	}

	@Override
	public boolean delBoard(String seq) {
		return hkDao.delBoard(seq);
	}
	
	@Override
	public boolean mulDel(String[] seqs) {
		return hkDao.mulDel(seqs);
	}
	
//	@Transactional
//	public boolean del_mulDel() {
//		hkDao.delBoard(null);
//		hkDao.mulDel(null);
//		return true;
//	}
	

	
}
