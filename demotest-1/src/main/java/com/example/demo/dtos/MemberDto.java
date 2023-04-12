package com.example.demo.dtos;

import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Bean;
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
@Alias(value="MemberDto")
@Component     // @Controller, @Service... @Bean.. @Component : 객체 등록 기능
public class MemberDto {
	
	private int memberId;
	private String id;
	private String name;
	private String password;
	private String email;
	private String address;
	private String role; //등급:ADMIN, USER
	
//	@Bean
//	public MemberDto getMemberDto() {
//		return new MemberDto();
//	}
}






