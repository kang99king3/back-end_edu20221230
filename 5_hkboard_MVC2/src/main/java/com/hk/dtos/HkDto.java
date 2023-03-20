package com.hk.dtos;

import java.util.Date;

//DTO: 데이터를 저장하고 운반할 수 있는 객체
public class HkDto {
	// 데이터를 담기 때문에 은닉화로 관리한다.
	// --> 데이터를 숨기고, 메서드를 통해 접근하도록 하는 기법: setter, getter메서드 작성
	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regdate;
	
	public HkDto() {
		super();
	}

	public HkDto(int seq, String id, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public HkDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "HkDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ "]";
	}
	
}
