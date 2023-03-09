package com.hk.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hk.dtos.HkDto;

public class DataBase {
	//1단계: 드라이버로딩
	public DataBase() {
		try {
			//https://downloads.mariadb.com/Connectors/java/
			//강제 객체 생성
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("1단계:드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1단계:드라이버로딩 실패");
			e.printStackTrace();
		}
	}
	//2단계: DB연결
	public Connection getConnection() throws SQLException {
		String url="jdbc:mariadb://localhost:3306/hk";
		String user="root";
		String password="manager";
		Connection conn=DriverManager.getConnection(url, user, password);
		System.out.println("2단계:DB연결성공");
		return conn;
	}
	
	//6단계: DB 연결 닫기
	public void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			System.out.println("6단계:DB닫기 성공");
		} catch (SQLException e) {
			System.out.println("6단계:DB닫기 실패");
			e.printStackTrace();
		}
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
	
	
	
	
	
	
//	public static void main(String[] args) {
//		DataBase db=new DataBase();
//	}
	
}











