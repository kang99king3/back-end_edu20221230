package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.hk.config.SqlMapConfig;
import com.hk.datasource.DataBase;
import com.hk.dtos.AnsDto;

public class AnsDao extends SqlMapConfig{

	private String namespace="com.hk.daos.";
	
	//1.글목록 조회하기
	public List<AnsDto> getAllList(String pnum){
		List<AnsDto> list=new ArrayList<>();
		
		SqlSession sqlSession=null;
		Map<String, String> map=new HashMap<>();
		map.put("pnum", pnum);
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			list=sqlSession.selectList(namespace+"getAllList", map);
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	//1-2.페이지수 구하기
	public int getPCount() {
		int count=0;
		SqlSession sqlSession=null;
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.selectOne(namespace+"getPCount");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count;
	}
	
	
	//2.새글 추가하기
	public boolean insertBoard(AnsDto dto) {
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
	//3.글 상세조회
	public AnsDto getBoard(int seq){
		AnsDto dto=new AnsDto();

		SqlSession sqlSession=null;
		Map<String, Integer> map=new HashMap<>();
		map.put("seq", seq);
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			dto=sqlSession.selectOne(namespace+"getAllList", map);
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return dto;
	}
	//4.글 수정하기
	public boolean updateBoard(AnsDto dto) {
		int count=0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.update(namespace+"updateBoard", dto);
			//파라미터전달할때 타입: 값, DTO, Map   개수는 하나 전달
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;//삼항연산자
	}
	//5.글 삭제하기(update문: delflag[Y/N])
	// 글여러개 삭제하기 기능으로 통일하자(하나삭제기능, 여러개삭제 기능)
	public boolean muldelBoard(String[] seqs) {
		int count=0;
		
		//다이나믹 쿼리 사용해보기
		String sql=" update answerboard "
				 + " set delflag = 'Y' "
				 + " where seq in ("+String.join(",", seqs)+") ";
								//String객체에서 제공하는 join("sepa",array)
		                        // seqs{1 3 5 6} --> "1,3,5,6" --> "seq in (1,3,5,6)"
		System.out.println("sql:"+sql);
		try {
			
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			
		}
		
		return count>0?true:false;//삼항연산자
	}
	//6.글 조회수: update문 --> readcount의 값을 증가
	public boolean readCount(int seq) {
		int count=0;
	    SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.update(namespace+"readCount", seq);
		} catch (Exception e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;//삼항연산자
	}
	//7.답글 추가하기:Transaction 처리 
	//           update문[step수정], insert문[답글추가] 실행
	public boolean replyBoard(AnsDto dto) {
		int count=0;
	
		 SqlSession sqlSession=null;
		try {
			sqlSession=getSqlSessionFactory().openSession(false);//autocommit false: tx처리
			//같은 그룹에서 부모의 step보다 큰 글들을 구해서 step+1을 하자~~ 
			//update작성: 서브쿼리사용
			sqlSession.update(namespace+"replyUpdate", dto);
			//insert작성: 서브쿼리사용  , 부모의 refer / step+1 / depth+1		
			count=sqlSession.insert(namespace+"replyInsert", dto);
			sqlSession.commit();//정상적으로 실행이 되면 commit 실행--> DB에 반영 : tx처리
		} catch (Exception e) {
			sqlSession.rollback();//여러 작업중에 하나라도 실패하면 모두 되돌려~~  : tx처리
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;//삼항연산자
	}
	
}








