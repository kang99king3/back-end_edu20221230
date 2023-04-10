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
		return sqlSession.selectOne(namespace+"calBoardDetail", seq);
	}

	@Override
	public boolean calBoardUpdate(CalDto dto) {
		int count=sqlSession.update(namespace+"calBoardUpdate", dto);
		return count>0?true:false;
	}

	@Override
	public boolean calMulDel(String[] seqs) {
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);//--> map에 넣는이유는 다이나믹쿼리사용할때 받는 파리미터가 map이여야함
		int count=sqlSession.delete(namespace+"calMulDel",map);
		return count>0?true:false;
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
