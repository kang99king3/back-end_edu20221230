package com.example.demo.dtos;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

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
@Alias(value = "BoardDto")
@Component
public class BoardDto {

	private int board_seq;
	private String id;
	private String title;
	private String content;
	private Date regdate;
	
//	private FileBoardDto fileBoardDto;
	private List<FileBoardDto> fileBoardDto;
}




