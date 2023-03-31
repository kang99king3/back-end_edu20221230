package com.hk.ansboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hk.ansboard.dtos.AnsDto;

@Repository
public class AnsDaoImp implements IAnsDao{
	
	private String namespace="com.hk.ansboard.daos.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<AnsDto> getAllList(String pnum) {
		Map<String , String>map=new HashMap<>();
		map.put("pnum", pnum);
		return sqlSession.selectList(namespace+"getAllList", map);
	}

	@Override
	public int getPCount() {
		return sqlSession.selectOne(namespace+"getPCount");
	}

	@Override
	public boolean insertBoard(AnsDto dto) {
		int count=sqlSession.insert(namespace+"insertBoard", dto);
		return count>0?true:false;
	}

	@Override
	public AnsDto getBoard(int seq) {
		Map<String , Integer>map=new HashMap<>();
		map.put("seq", seq);
		return sqlSession.selectOne(namespace+"getAllList", map);
	}

	@Override
	public boolean updateBoard(AnsDto dto) {
		int count=sqlSession.update(namespace+"updateBoard", dto);
		return count>0?true:false;
	}

	@Override
	public boolean muldelBoard(String[] seqs) {
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);
		int count=sqlSession.update(namespace+"muldelBoard", map);
		return count>0?true:false;
	}

	@Override
	public boolean readCount(int seq) {
		int count=sqlSession.update(namespace+"readCount", seq);
		return count>0?true:false;
	}

	
	@Override
	public int updateReplyBoard(AnsDto dto) {
		return sqlSession.update(namespace+"replyUpdate", dto);
	}

	
	@Override
	public int insertReplyBoard(AnsDto dto) {
		return sqlSession.update(namespace+"replyInsert", dto);
	}
	
}
