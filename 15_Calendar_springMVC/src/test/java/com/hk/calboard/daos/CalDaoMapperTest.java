package com.hk.calboard.daos;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hk.calboard.dtos.CalDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class CalDaoMapperTest {

	@Autowired
	public SqlSessionTemplate sqlSession;
	
	@Test
	public void testInsertCalBoard() {
//		fail("Not yet implemented");
	}

	@Test
	public void testCalBoardList() {
		Map<String, String>map=new HashMap<>();
		map.put("id", "kbj");
		map.put("yyyyMMdd", "20230407");
		List<CalDto>list=sqlSession
						.selectList("com.hk.calboard.daos.calBoardList", map);
		if(list.size()>0) {
			System.out.println("일정목록개수:"+list.size());
		}else {
			fail("Not yet implemented");			
		}
	}

	@Test
	public void testCalBoardDetail() {
		fail("Not yet implemented");
	}

}
