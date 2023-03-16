package com.hk.dtos;

import java.io.Serializable;
import java.util.Date;


//직렬화: 데이터를 전송할 때 직렬화시켜서 데이터를 이동시키는 방법: 안정적으로 전송하기 위함
//      [data,data,data,data,data,data]
//Serialiazalble 인터페이스를 implements하면, 시스템에 직렬화시켜 전송하라고 알려주는거임 
public class LoginDto implements Serializable{

	private static final long serialVersionUID = -1130544940570946611L;
//	private static final long serialVersionUID = 1L;

	//맴버필드 작성
	//default 생성자 작성
	//생성자 오버로딩
	//getter, setter 메서드 작성
	//toString() 오버라이딩
	
	private int seq;
	private String id;
	private String name;
	private String password;
	private String address;
	private String email;
	private String enabled;
	private String role;
	private Date regdate;
	
	public LoginDto() {
		super();
	}

	public LoginDto(int seq, String id, String name, String password, String address,  String email,
			String enabled, String role, Date regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
		this.regdate = regdate;
	}

	public LoginDto(String id, String name, String password, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
	}

	public LoginDto(String id, String address, String email) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "LoginDto [seq=" + seq + ", id=" + id + ", name=" + name + ", password=" + password + ", address="
				+ address + ", email=" + email + ", enabled=" + enabled + ", role=" + role
				+ ", regdate=" + regdate + "]";
	}
	
}







