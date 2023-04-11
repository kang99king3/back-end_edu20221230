package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.command.AddUserCommand;
import com.example.demo.dtos.MemberDto;
import com.example.demo.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public boolean addUser(AddUserCommand addUserCommand) {
		MemberDto mdto=new MemberDto();
		mdto.setId(addUserCommand.getId());
		mdto.setName(addUserCommand.getName());
		//password는 암호화하여 저장하자
		mdto.setPassword(addUserCommand.getPassword());
		mdto.setEmail(addUserCommand.getEmail());
		mdto.setAddress(addUserCommand.getAddress());
		return memberMapper.addUser(mdto);
	}
	
	public String idChk(String id) {
		return memberMapper.idChk(id);
	}
}






