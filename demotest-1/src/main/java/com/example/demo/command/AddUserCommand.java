package com.example.demo.command;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddUserCommand {
	
	@NotBlank(message = "아이디를 입력하세요")
	private String id;
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	@NotBlank(message = "비밀번호를 입력하세요")
	@Length(min=8 , max = 16, message = "비밀번호는 8자이상, 16자이하로 입력하세요")
	private String password;
	@NotBlank(message = "이메일을 입력하세요")
	private String email;
	@NotBlank(message = "주소를 입력하세요")
	private String address;

}
