package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.datasource.DataBase;
import com.hk.dtos.AnsDto;



public class AnsDao extends DataBase{

	//1.글목록 조회하기
	public List<AnsDto> getAllList(){
		List<AnsDto> list=new ArrayList<>();
		Connection conn=null;// DB 연결 객체
		PreparedStatement psmt=null;// 쿼리 준비,실행 객체
		ResultSet rs=null;//결과 받는 객체
		
		String sql=" select seq,id,title,content,regdate "
				 + " ,refer,step,depth,readcount,delflag "
				 + " from answerboard order by refer,step ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			psmt=conn.prepareStatement(sql);//쿼리를 작성한 상태
			System.out.println("3단계:쿼리준비성공");
			rs=psmt.executeQuery();//쿼리를 실행한다.
			System.out.println("4단계:쿼리실행성공");
			while(rs.next()) { 
				AnsDto dto=new AnsDto();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				dto.setRefer(rs.getInt(6));
				dto.setStep(rs.getInt(7));
				dto.setDepth(rs.getInt(8));
				dto.setReadcount(rs.getInt(9));
				dto.setDelflag(rs.getString(10));
				list.add(dto);
				System.out.println(dto.toString());
			}
			System.out.println("5단계:DB결과받기성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);			
		}
		return list;
	}
	//2.새글 추가하기
	public boolean insertBoard(AnsDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		// refer컬럼:글의 그룹 --> 새글이 추가될때 중복된 값X
		// mariaDB에서는 insert할때 같은 테이블명으로 서브쿼리 사용 지원X : ALIAS_FOR_SUBQUERY
		String sql=" insert into answerboard "
				+ " values(null,?,?,?,SYSDATE(), "
				+ " (select NVL(MAX(refer),0)+1 from answerboard ALIAS_FOR_SUBQUERY)"
				+ " ,0,0,0,'N') ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			System.out.println("3단계:쿼리준비성공");
			
			count=psmt.executeUpdate();//DB 테이블에 내용을 수정하는 작업
			System.out.println("4단계:쿼리실행성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;//삼항연산자
	}
	//3.글 상세조회
	public AnsDto getBoard(int seq){
		AnsDto dto=new AnsDto();
		Connection conn=null;// DB 연결 객체
		PreparedStatement psmt=null;// 쿼리 준비,실행 객체
		ResultSet rs=null;//결과 받는 객체
		
		String sql=" select seq,id,title,content,regdate "
				 + " ,refer,step,depth,readcount,delflag "
				 + " from answerboard where seq = ? ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			psmt=conn.prepareStatement(sql);//쿼리를 작성한 상태
			psmt.setInt(1, seq);
			System.out.println("3단계:쿼리준비성공");
			rs=psmt.executeQuery();//쿼리를 실행한다.
			System.out.println("4단계:쿼리실행성공");
			while(rs.next()) { 
				
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				dto.setRefer(rs.getInt(6));
				dto.setStep(rs.getInt(7));
				dto.setDepth(rs.getInt(8));
				dto.setReadcount(rs.getInt(9));
				dto.setDelflag(rs.getString(10));
				
				System.out.println(dto.toString());
			}
			System.out.println("5단계:DB결과받기성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);			
		}
		return dto;
	}
	//4.글 수정하기
	public boolean updateBoard(AnsDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" update answerboard "
				 + " set title=? ,content=? , regdate=sysdate() "
				 + " where seq=? ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getSeq());
			System.out.println("3단계:쿼리준비성공");
			
			count=psmt.executeUpdate();//DB 테이블에 내용을 수정하는 작업
			System.out.println("4단계:쿼리실행성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;//삼항연산자
	}
	//5.글 삭제하기(update문: delflag[Y/N])
	// 글여러개 삭제하기 기능으로 통일하자(하나삭제기능, 여러개삭제 기능)
	public boolean muldelBoard(String[] seqs) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" update answerboard "
				 + " set delflag = 'Y' "
				 + " where seq in ("+String.join(",", seqs)+") ";
								//String객체에서 제공하는 join("sepa",array)
		                        // seqs{1 3 5 6} --> "1,3,5,6" --> "seq in (1,3,5,6)"
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			
			psmt=conn.prepareStatement(sql);
			System.out.println("3단계:쿼리준비성공");
			
			count=psmt.executeUpdate();//DB 테이블에 내용을 수정하는 작업
			System.out.println("4단계:쿼리실행성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;//삼항연산자
	}
	//6.글 조회수: update문 --> readcount의 값을 증가
	public boolean readCount(int seq) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" update answerboard "
				+ " set readcount=reacount+1 "
				+ " where seq=? ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("3단계:쿼리준비성공");
			
			count=psmt.executeUpdate();//DB 테이블에 내용을 수정하는 작업
			System.out.println("4단계:쿼리실행성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		
		return count>0?true:false;//삼항연산자
	}
	//7.답글 추가하기:Transaction 처리 
	//           update문[step수정], insert문[답글추가] 실행
	public boolean replyBoard(AnsDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		//같은 그룹에서 부모의 step보다 큰 글들을 구해서 step+1을 하자~~ 
		//update작성: 서브쿼리사용
		String sql1=" UPDATE answerboard SET step=step+1 "
				+ " WHERE refer=(SELECT refer FROM answerboard WHERE seq=?) "
				+ " AND step > (SELECT step FROM answerboard WHERE seq=?) ";
				
		//insert작성: 서브쿼리사용  , 부모의 refer / step+1 / depth+1		
		String sql2=" INSERT INTO answerboard "
				+ " VALUES(NULL, ?,?,?,SYSDATE() "
				+ "      ,(SELECT refer FROM answerboard ALIAS_FOR_SUBQUERY WHERE seq=?) "
				+ "      ,(SELECT step FROM answerboard ALIAS_FOR_SUBQUERY WHERE seq=?)+1 "
				+ "      ,(SELECT depth FROM answerboard ALIAS_FOR_SUBQUERY WHERE seq=?)+1,0,'N') ";
		
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			//transaction처리[ autocommit = false, commit , rollback , autocommit=true]
			conn.setAutoCommit(false);//트랜젝션처리
			
			psmt=conn.prepareStatement(sql1);//update문 준비
			psmt.setInt(1, dto.getSeq());
			psmt.setInt(2, dto.getSeq());
			System.out.println("3단계:쿼리준비성공");
			psmt.executeUpdate();//update문 실행
			
			psmt=conn.prepareStatement(sql2);//insert문 준비
			psmt.setString(1, dto.getId());	
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getSeq());	
			psmt.setInt(5, dto.getSeq());
			psmt.setInt(6, dto.getSeq());
			count=psmt.executeUpdate();//insert문 실행
			System.out.println("4단계:쿼리실행성공");
			conn.commit();//commit실행
		} catch (SQLException e) {
			System.out.println("JDBC실패:해당클래스는 "+getClass());
			e.printStackTrace();
			try {
				conn.rollback();//오류가 생기면 되돌리자!
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(null, psmt, conn);
		}
		
		return count>0?true:false;//삼항연산자
	}
	
}








