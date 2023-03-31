package com.hk.ansboard.daos;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hk.ansboard.dtos.AnsDto;

//단위테스트: 개발하는 중간에 제대로 작성됐는지 확인하기 위한 코드
//확인작업할때 : 서버쪽에 코드만 확인하는 경우, 
//            클라이언트로부터 요청받아서 처리하는 코드를 확인해야 하는 경
//            --> 실제 jsp나 html 페이지만들어서 정말 요청하는 페이지를 작성해야함

//@RunWith: spring에서 junit을 사용하기 위한 설정
//@ContextConfiguration: spring bean 설정 파일의 위치를 지정할때 사용
//@WebAppConfiguration: MVC 및 웹환경에 사용되는 빈들을 자동으로 등록 생성해줌
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class AnsDaoImpTest {

	//Spring container가 객체 타입으로 찾아서, 객체를 생성해서 주입해준다.
//	@Qualifier(value = "id") // 객체 이름으로 찾아서 생성,주입
	@Autowired
	public SqlSessionTemplate sqlSession;
	
//	@Before
	
	@Test
	public void testGetAllList() {
		Map<String, String>map=new HashMap<>();
		map.put("pnum", "1");
		List<AnsDto>lists=sqlSession.selectList("com.hk.ansboard.daos.getAllList", map);
		System.out.println("글목록개수:"+lists.size());
		assertEquals(10, lists.size());
//		fail("Not yet implemented");
	}

//	@After
	
	@Test
	public void testGetPCount() {
		int count=sqlSession.selectOne("com.hk.ansboard.daos.getPCount");
		if(count>0) {
			System.out.println("페이지개수:"+count);
		}else {
			fail("Not yet implemented");			
		}
	}

	@Test
	public void testInsertBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testMuldelBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateReplyBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertReplyBoard() {
		fail("Not yet implemented");
	}

}
