package com.hk.calboard.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalController {

	//log를 원하는 위치에 설정하여 디버깅하기 위함
	private static final Logger logger=LoggerFactory.getLogger(CalController.class);
	@Autowired
	private TestController testController;
	
//	@PostMapping()
//	@RequestMapping(value="/calendar.do", method = RequestMethod.GET)
	@GetMapping(value="/calendar.do")
	public String calendar(Locale locale, Model model,HttpServletRequest request) {
		logger.info("달력보기{}",locale);
		Map<String, Integer>map=testController.makeCalendar(request);
		model.addAttribute("calMap", map);
		return "calendar";//redirect가 아니죠?? forward 방식으로 응답
	}
	
	
	
	
	//웹 처리 상태에 따라 오류페이지 처리
	@RequestMapping(value = "/error404.do", method = RequestMethod.GET)
	public String error404(Locale locale, Model model) {
		logger.info("404 오류{}.", locale);
		model.addAttribute("code", "404오류");
		return "error/404";
	}
	
	@RequestMapping(value = "/error500.do", method = RequestMethod.GET)
	public String error500(Locale locale, Model model) {
		logger.info("500 오류{}.", locale);
		model.addAttribute("code", "500오류");
				
		return "error/404";
	}
}
