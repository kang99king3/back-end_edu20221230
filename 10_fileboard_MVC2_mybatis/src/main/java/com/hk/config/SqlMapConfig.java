package com.hk.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	//작업을 하기 위한 객체를 선언
	private SqlSessionFactory sqlSessionFactory;
	
	//작업을 하기 위한 객체를 구하는 메서드
	public SqlSessionFactory getSqlSessionFactory() {
		//환경설정 내용이 작성되어 있는 파일의 경로 설정
		String resource="sql/Configuration.xml";
		
		try {
			//Reader:작업메뉴얼,  Resources: 작업메뉴얼을 만드는 객체
			Reader	reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}




