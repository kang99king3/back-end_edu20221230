package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.command.AddUserCommand;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping(value = "/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping(value="/addUserForm")
	public String addUserForm(Model model) {
		System.out.println("회원가입폼으로 이동");

		model.addAttribute("addUserCommand", new AddUserCommand());
		return "thymeleaf/member/addUserForm";
	}
	
	@PostMapping(value="/addUser")
	public String addUser(@Validated AddUserCommand addUsercommand,
						  BindingResult result,  Model model) {
		System.out.println("회원가입하기"+addUsercommand.getId());
		
		if(result.hasErrors()) {
			return "thymeleaf/member/addUserForm";
		}
		
		
		try {
			boolean isS=memberService.addUser(addUsercommand);
			System.out.println("회원가입성공");
			return "redirect:/home";
		} catch (Exception e) {
			System.out.println("회원가입실패");
			e.printStackTrace();
			return "redirect:addUserForm";
					
		}
		
	}
}




