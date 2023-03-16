package com.hk.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hk.datasource.DataBase;
import com.hk.dtos.LoginDto;

public class LoginDao extends DataBase{

	//싱글톤 패턴: 객체를 한번만 생성해서 쓰자(반복적으로 생성하는걸 막는다)
	private static LoginDao loginDao;
	// new LoginDao() X  --> private 선언
	private LoginDao() { }
	//클래스명.메서드 호출 가능
	public static LoginDao getLoginDao() {
		if(loginDao==null) {
			loginDao=new LoginDao();			
		}
		return loginDao;
	}
	
	// 사용자 기능
	
	//1. 회원가입 기능 구현(enabled: 'Y', role:'USER')
	// insert문 작성: boolean 타입 반환
	public boolean insertUser(LoginDto dto) {
		int count=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		
		String sql=" insert into userinfo values( "
				 + " null,?,?,?,?,?,'Y','USER',SYSDATE()) ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPassword());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getEmail());
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("jdbc실패:insertUser():"+getClass());
			e.printStackTrace();
		}finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}
	
	//2.로그인 기능 구현: ID와 Password를 확인해서, 회원의 정보를 조회
	// select문 작성 : LoginDto 반환 
	public LoginDto getLogin(String id, String password) {
		LoginDto dto=new LoginDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" select id,name,role from userinfo "
				 + " where id=? and password=? and enabled='Y' ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			rs=psmt.executeQuery();
			while(rs.next()) {  // d d d d d d d  
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("jdbc실패:getLogin():"+getClass());
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return dto;
	}
	
	//아이디 중복 체크하기
	//select문 작성 : 
	public String idCheck(String id) {
		String resultId=null;//조회된 결과 id를 저장할 변수
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" select id from userinfo "
				 + " where id=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {  
				resultId=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("jdbc실패:idCheck():"+getClass());
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return resultId;
	}
	
	//나의 정보 조회하기: select문작성 , 파라미터 ID , 반환타입:LoginDto
	public LoginDto getUserInfo(String id) {
		LoginDto dto=new LoginDto();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		String sql=" select id,name,address,email,role,regdate "
				 + " from userinfo where id=? ";
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {  // d d d d d d d  
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setRole(rs.getString(5));
				dto.setRegdate(rs.getDate(6));
				System.out.println(dto);
			}
		} catch (SQLException e) {
			System.out.println("jdbc실패:getUserInfo():"+getClass());
			e.printStackTrace();
		}finally {
			close(rs, psmt, conn);
		}
		
		return dto;
	}
	
	//나의 정보 수정하기
	
	//회원 탈퇴하기
}









