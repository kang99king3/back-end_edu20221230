package com.hk.calboard.dtos;

import java.util.Date;

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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CalDto {
	
	@NonNull
	private int seq;
	@NonNull
	private String id;
	@NonNull
	private String title;
	private String content;
	private String mdate;
	private Date regdate;
}




