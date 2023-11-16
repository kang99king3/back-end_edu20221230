package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.command.AddUserCommand;
import com.example.demo.command.LoginCommand;
import com.example.demo.dtos.MemberDto;
import com.example.demo.mapper.MemberMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
//
//@AllArgsConstructor
//@RequiredArgsConstructor
@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberDto mdto;
	
	public boolean addUser(AddUserCommand addUserCommand) {
//		MemberDto mdto=new MemberDto();
		mdto.setId(addUserCommand.getId());
		mdto.setName(addUserCommand.getName());
		//password는 암호화하여 저장하자
		mdto.setPassword(passwordEncoder.encode(addUserCommand.getPassword()));
		mdto.setEmail(addUserCommand.getEmail());
		mdto.setAddress(addUserCommand.getAddress());
		return memberMapper.addUser(mdto);
	}
	
	public String idChk(String id) {
		return memberMapper.idChk(id);
	}
	
	public String loginUser(LoginCommand loginCommand,
							HttpServletRequest request) {
		System.out.println("로그인");
		String path="thymeleaf/home";
		MemberDto mdto=memberMapper.loginUser(loginCommand.getId());
		if(mdto!=null) {
			if(passwordEncoder.matches(loginCommand.getPassword(), mdto.getPassword())) {
				System.out.println("패스워드 비교: 회원이 맞습니다.");
				request.getSession().setAttribute("mdto", mdto);
				request.getSession().setMaxInactiveInterval(30*60);
				return path;
			}else {
				System.out.println("패스워드가 틀림");
				path="thymeleaf/member/login";
			}
		}else {
			System.out.println("회원이 아닙니다.");
			path="thymeleaf/member/login";
		}
		return path;
	}
}






