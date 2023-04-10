package com.hk.calboard.command;

import java.util.Date;


import lombok.Data;


@Data
public class InsertCalCommand {

	private int seq;
	private String id;
	private String year;
	private String month;
	private String date;
	private String hour;
	private String min;
	private String title;
	private String content;
	private String mdate;
	private Date regdate;
	
//	public InsertCalCommand(int seq, String id, String year, String month, String date, String hour, String min,
//			String title, String content, String mdate, Date regdate) {
//		super();
//		this.seq = seq;
//		this.id = id;
//		this.year = year;
//		this.month = month;
//		this.date = date;
//		this.hour = hour;
//		this.min = min;
//		this.title = title;
//		this.content = content;
//		this.mdate = mdate;
//		this.regdate = regdate;
//	}
//
//	public InsertCalCommand() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	
}






