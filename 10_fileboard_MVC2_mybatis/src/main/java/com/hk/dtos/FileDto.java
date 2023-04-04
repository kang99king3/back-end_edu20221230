package com.hk.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FileDto {

	
	private int seq;
	private String origin_name;
	private String stored_name;
	private int file_size;
	private Date f_regdate;
	private String f_delflag;
	
	
}



