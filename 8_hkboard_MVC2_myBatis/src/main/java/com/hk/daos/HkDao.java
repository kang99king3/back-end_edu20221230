package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hk.config.SqlMapConfig;
import com.hk.datasource.DataBase;
import com.hk.dtos.HkDto;

public class HkDao extends SqlMapConfig{

	private String namespace="com.hk.board.";//namespace+queryid
	
	public HkDao() {//생략가능
		super();//생략가능
	}
	
	
	//글목록 조회: List<HkDto> --> 글목록 여러개
	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<>();
		SqlSession sqlSession=null;
		
		try {
			//1.sqlSessionFactory객체 구해야 됨--> SqlSession객체를 쓸 수 있다
			SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
			//2.sqlSession객체 구하기
			sqlSession=sqlSessionFactory.openSession(true);//autocommit:true로 설정
			//3.쿼리 실행하기:selectList()의 반환타입은 List다
			list=sqlSession.selectList(namespace+"getAllList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//글 상세조회 : 쿼리?, 파리미터?, 반환타입 
	public HkDto getBoard(int seq){
		HkDto dto=new HkDto();//row하나를 담을 객체
		SqlSession sqlSession=null;
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			dto=sqlSession.selectOne(namespace+"getBoard", seq);
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return dto;
	}
	
	
	//글추가하기: 결과 X --> boolean --> 쿼리 성공한 행의 개수를 반환 -> true/false
	//          insert문작성, 화면에서 글의 정보를 입력받아서 DB에 추가-> DTO로 전달
	public boolean insertBoard(HkDto dto) {
		int count=0;
		SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.insert(namespace+"insertBoard", dto);
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;//삼항연산자
	}
	
	//글 수정하기: boolean , update문 , 파라미터: seq, 제목, 내용 [DTO에 담아서전달할지, 그냥 값 자체를 전달할지 결정
	public boolean updateBoard(int seq, String title , String content) {
		int count=0;
		SqlSession sqlSession=null;
		//map에 여러개의 파라미터를 저장해서 전달할 수 있다.
		Map<String, Object>map=new HashMap<>();
		map.put("seq", seq);
		map.put("title", title);
		map.put("content", content);
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.update(namespace+"updateBoard", map);
		} catch (Exception e) {
			System.out.println("JDBC실패:updateBoard():"+getClass());
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	//글삭제하기: boolean , delete문(update문:컬럼에 삭제여부y/n) , 파라미터: seq
	public boolean delBoard(String seq) {
		int count=0;
		SqlSession sqlSession=null;
		
		try {
			//sqlSeFactory구현 --->sqlSession객체 구현
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.delete(namespace+"delBoard", seq);
		} catch (Exception e) {
			System.out.println("JDBC실패:delBoard():"+getClass());
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	//글 여러개 삭제하기
	// seq값이 [seq,seq,seq,seq] 일때, 배열의 길이만큼 반복시켜서 쿼리를 실행
	//쿼리: delete from hkboard where seq=?
	//     delete from hkbaord where seq in (3,4,45,6)
	
	//transaction개념: 성공할꺼면 다 성공하고, 실패할거면 다 실패로 치자
	// 삭제 작업 여러개를 하나의 작업처럼 만들자
	// 삭제해줘 ------> del(O), del(X), del(O), del(X) --> 결론은 실패 --> 성공한것도 실패로 돌려놓자!!
	// autocommit설정 ->  commit -> rollback
	public boolean mulDel(String[] seqs) {
		int count=0;//실행결과를 담을 배열
		SqlSession sqlSession=null;
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.delete(namespace+"mulDel", map);
		} catch (Exception e) {        
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;
	}
}






