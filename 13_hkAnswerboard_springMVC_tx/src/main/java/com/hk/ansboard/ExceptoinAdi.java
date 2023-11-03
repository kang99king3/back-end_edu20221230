package com.hk.ansboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ExceptoinAdi {

	private Logger logger=LoggerFactory.getLogger(ExceptoinAdi.class);
	
//	@ExceptionHandler(Exception.class)
//	public String handleException(Exception e, Model model) {
//		logger.error("Exception 발생:{}",e.getMessage());
//		model.addAttribute("msgs", "오류가 발생하여 확인중입니다.");
//		return "error";
//	}
}
