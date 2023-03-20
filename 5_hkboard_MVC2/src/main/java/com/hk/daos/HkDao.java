package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hk.datasource.DataBase;
import com.hk.dtos.HkDto;

public class HkDao extends DataBase{

	public HkDao() {//생략가능
		super();//생략가능
	}
	
	
	//글목록 조회: List<HkDto> --> 글목록 여러개
	public List<HkDto> getAllList(){
		List<HkDto> list=new ArrayList<>();
		Connection conn=null;// DB 연결 객체
		PreparedStatement psmt=null;// 쿼리 준비,실행 객체
		ResultSet rs=null;//결과 받는 객체
		
		String sql=" select seq, id, title, content, regdate "
				 + " from hkboard order by regdate desc ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			psmt=conn.prepareStatement(sql);//쿼리를 작성한 상태
			System.out.println("3단계:쿼리준비성공");
			rs=psmt.executeQuery();//쿼리를 실행한다.
			System.out.println("4단계:쿼리실행성공");
			while(rs.next()) { // next()란 메서드가 결과값이 있는지 행단위로 확인을 한다.
				//rs[row,row,row...] ---> list[dto,dto,dto...]
				HkDto dto=new HkDto();//row하나를 담을 객체
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
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
	
	//글 상세조회 : 쿼리?, 파리미터?, 반환타입 
	public HkDto getBoard(int seq){
		HkDto dto=new HkDto();//row하나를 담을 객체
		Connection conn=null;// DB 연결 객체
		PreparedStatement psmt=null;// 쿼리 준비,실행 객체
		ResultSet rs=null;//결과 받는 객체
		
		String sql=" select seq, id, title, content, regdate "
				 + " from hkboard where seq=? ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결성공");
			psmt=conn.prepareStatement(sql);//쿼리를 작성한 상태
			psmt.setInt(1, seq);
			System.out.println("3단계:쿼리준비성공");
			rs=psmt.executeQuery();//쿼리를 실행한다.
			System.out.println("4단계:쿼리실행성공");
			while(rs.next()) { // next()란 메서드가 결과값이 있는지 행단위로 확인을 한다.
				//rs[row] ---> dto
				
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			
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
	
	
	//글추가하기: 결과 X --> boolean --> 쿼리 성공한 행의 개수를 반환 -> true/false
	//          insert문작성, 화면에서 글의 정보를 입력받아서 DB에 추가-> DTO로 전달
	public boolean insertBoard(HkDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" insert into hkboard "
				 + " values(null, ?, ?, ?, SYSDATE()) ";
		
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
	
	//글 수정하기: boolean , update문 , 파라미터: seq, 제목, 내용 [DTO에 담아서전달할지, 그냥 값 자체를 전달할지 결정
	public boolean updateBoard(int seq, String title , String content) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" update hkboard set title=?, content=?,regdate=SYSDATE() where seq=? ";
		
		try {
			conn=getConnection();
			System.out.println("2단계:DB연결 성공");
			
			psmt=conn.prepareStatement(sql);
			//java 값 --> DB : java의 값의 타입을 확인하여 메서드 결정(setString? , setInt?.. )
			psmt.setString(1, title); 
			psmt.setString(2, content);
			psmt.setInt(3, seq);
			System.out.println("3단계:쿼리준비 성공");
			
			count=psmt.executeUpdate();//실행후 반환값은 수정된 row의 개수
			System.out.println("4단계:쿼리실행 성공");
		} catch (SQLException e) {
			System.out.println("JDBC실패:updateBoard():"+getClass());
			e.printStackTrace();
		}finally {
			//기본타입 : 0 , 0.0  , 참조타입: null
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//글삭제하기: boolean , delete문(update문:컬럼에 삭제여부y/n) , 파라미터: seq
	public boolean delBoard(String seq) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" delete from hkboard where seq=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, seq);
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("JDBC실패:delBoard():"+getClass());
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
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
		boolean isS=true;//성공여부
		int [] count=null;//실행결과를 담을 배열
		
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql = " delete from hkboard whe seq=? ";
		
		try {
			conn=getConnection();
			conn.setAutoCommit(false);//자동커밋해제 -> 커밋후에는 rollback이 안돼~~
			psmt=conn.prepareStatement(sql);
			for (int i = 0; i < seqs.length; i++) {
				psmt.setString(1, seqs[i]);//쿼리 하나 완성 
				psmt.addBatch();    //    delete from hkboard where seq=2  
			}                       //    delete from hkboard where seq=4 여러개 준비해놓고 한번에 실행
			//int타입으로 결과값을 배열로 반환: 결과값은 성공하면 1을 반환 [1,1,1..]
			count=psmt.executeBatch();//준비된 여러 쿼리가 한번에 실행됨
			conn.commit();//DB에 반영하기
			System.out.println(Arrays.toString(count));
		} catch (SQLException e) {        
			e.printStackTrace();
			try {
				conn.rollback();//일부가 실패하면 성공한 것도 모두 되돌리기
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(null, psmt, conn);
			//화면처리를 위한 성공여부 확인
			for (int i = 0; i < count.length; i++) {
				if(count[i]!=1) {
					isS=false;
					break;
				}
			}
		}
		
		return isS;
	}
}






