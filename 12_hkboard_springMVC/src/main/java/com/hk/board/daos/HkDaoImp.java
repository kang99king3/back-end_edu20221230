package com.hk.board.daos;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class HkDaoImp {
	
	//스프링이 알아서 객체를 생성해서(IOC) 주입시켜준다(DI)
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//원래 방식은 우리가 객체를 생성하는 코드를 작성해서 주입시켜줘야 하는데..
//	public HkDaoImp() {
//		sqlSession=new SqlSessionTemplate();
//	}
	
	public void test() {
		sqlSession.selectList("namespace", "1");
	}
}
