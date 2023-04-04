package com.hk.ansboard.dtos;

import java.util.Date;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

//@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
public class AnsDto {
	@Nullable
	private int seq;
	@Nullable
	private String id;
	@Nullable
	private String title;
	@Nullable
	private String content;
	@Nullable
	private Date regdate;
	@Nullable
	private int refer;
	@Nullable
	private int step;
	@Nullable
	private int depth;
	@Nullable
	private int readcount;
	@Nullable
	private String delflag;
	
//	public AnsDto() {
//		super();
//
//	}
//	public AnsDto(int seq, String id, String title, String content, Date regdate, int refer, int step, int depth,
//			int readcount, String delflag) {
//		super();
//		this.seq = seq;
//		this.id = id;
//		this.title = title;
//		this.content = content;
//		this.regdate = regdate;
//		this.refer = refer;
//		this.step = step;
//		this.depth = depth;
//		this.readcount = readcount;
//		this.delflag = delflag;
//	}
	
	
}



