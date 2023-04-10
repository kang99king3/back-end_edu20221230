package com.hk.calboard.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.calboard.dtos.CalDto;

@Repository
public class CalDaoMapper implements ICalDao{

	private String namespace="com.hk.calboard.daos.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertCalBoard(CalDto dto) {
		return sqlSession.insert(namespace+"insertCalBoard", dto);
	}

	@Override
	public List<CalDto> calBoardList(String id, String yyyyMMdd) {
		Map<String, String>map=new HashMap<>();
		map.put("id", id);
		map.put("yyyyMMdd",yyyyMMdd);
		return sqlSession.selectList(namespace+"calBoardList", map);
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
