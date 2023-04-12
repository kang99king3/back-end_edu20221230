package com.example.demo.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginCommand {

	@NotBlank(message = "아이디를 입력해주세요")
	private String id;
	@NotBlank(message = "패스워드를 입력해주세요")
	private String password;
}
