package com.hk.ansboard;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class AnsControllerTest {

	@Autowired
	public WebApplicationContext wac;
	
	public MockMvc mock;
	
	@Test
	public void testGetAllList() throws Exception {
		
		//mock 객체를 활용해서 가상의 클라이언트 요청 --> 컨트롤러 테스트
		this.mock=MockMvcBuilders.webAppContextSetup(wac).build();
		
		//boardlist.do를 요청하기
		MvcResult result=mock.perform(MockMvcRequestBuilders.get("/boardlist.do"))
							  .andExpect(MockMvcResultMatchers.status().isOk())
							  .andReturn();
		int statusCode=result.getResponse().getStatus();
		System.out.println("status 코드:"+statusCode);
		//200코드와 같은지 비교-->200은 성공을 의미
		assertEquals(HttpStatus.OK.value(), statusCode);
//		fail("Not yet implemented");
	}

}






