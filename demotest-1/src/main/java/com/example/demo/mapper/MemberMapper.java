package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dtos.MemberDto;

@Mapper
public interface MemberMapper {

	public boolean addUser(MemberDto dto);
	
	public MemberDto loginUser(String id);
	
	public String idChk(String id);
}



