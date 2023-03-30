package com.hk.board.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.HkDto;

//@Component
@Repository
public class HkDaoImp implements IHkDao{
	
	//원래 방식은 우리가 객체를 생성하는 코드를 작성해서 주입시켜줘야 하는데..
//	public HkDaoImp() {
//		sqlSession=new SqlSessionTemplate();
//	}
//	public HkDaoImp(SqlSessionTemplate sqlSession) {
//		this.sqlSession=sqlSession;
////	}
	
	//스프링이 알아서 객체를 생성해서(IOC) 주입시켜준다(DI)
	//Autowired: Bean을 타입으로 구분해서 주입시켜 주는 기능
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.hk.board.daos.";
	
	@Override
	public List<HkDto> getAllList() {
		return sqlSession.selectList(namespace+"getAllList");
	}

	@Override
	public HkDto getBoard(int seq) {
		return sqlSession.selectOne(namespace+"getBoard",seq) ;
	}

	@Override
	public boolean insertBoard(HkDto dto) {
		int count=sqlSession.insert(namespace+"insertBoard", dto);
		return count>0?true:false;
	}

	@Override
	public boolean updateBoard(HkDto dto) {
		int count=sqlSession.update(namespace+"updateBoard",dto);
		return count>0?true:false;
	}

	@Override
	public boolean delBoard(String seq) {
		int count=sqlSession.delete(namespace+"delBoard", seq);
		return count>0?true:false;
	}

	@Override
	public boolean mulDel(String[] seqs) {
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);
		int count=sqlSession.delete(namespace+"mulDel", map);
		return count>0?true:false;
	}
	


}






