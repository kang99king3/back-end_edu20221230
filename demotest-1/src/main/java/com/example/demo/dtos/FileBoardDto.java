package com.example.demo.dtos;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "FileBoardDto")
public class FileBoardDto {

	private int file_seq;
	private int board_seq;
	private String origin_filename;
	private String stored_filename;
}
