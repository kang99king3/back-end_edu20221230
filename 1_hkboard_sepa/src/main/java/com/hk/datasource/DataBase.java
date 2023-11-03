package com.hk.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
//		String url="jdbc:mariadb://54.180.139.24:3306/hk";
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
	
	
	
	
	

	
}











