package com.example.demo.command;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DelBoardCommand {
	
	@NotEmpty(message = "최소 하나 이상 체크해야 합니다.")
	private String[] chk;
}
