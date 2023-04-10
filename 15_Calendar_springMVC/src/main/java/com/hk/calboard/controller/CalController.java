package com.hk.calboard.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.dtos.CalDto;
import com.hk.calboard.service.ICalService;
import com.hk.calboard.utils.Util;

@Controller
public class CalController {

	//log를 원하는 위치에 설정하여 디버깅하기 위함
	private static final Logger logger=LoggerFactory.getLogger(CalController.class);
//	@Autowired
//	private TestController testController;
	@Autowired
	private ICalService calService;
	
//	@PostMapping()
//	@RequestMapping(value="/calendar.do", method = RequestMethod.GET)
	@GetMapping(value="/calendar.do")
	public String calendar(Locale locale, Model model,HttpServletRequest request) {
		logger.info("달력보기{}",locale);
//		Map<String, Integer>map=testController.makeCalendar(request);
//		model.addAttribute("calMap", map);
		return "calendar";//redirect가 아니죠?? forward 방식으로 응답
	}
	
	@GetMapping(value="/addCalBoardForm.do")
	public String addCalForm(Locale locale) {
		logger.info("일정 추가폼으로 이동{}",locale);
		return "addCalBoardForm";
	}
	
	@PostMapping(value="/addCalBoard.do")
	public String addCalBoard(InsertCalCommand insertCalCommand, Locale locale) {
		logger.info("일정작성하기{}",locale);
		
		boolean isS=calService.insertCalBoard(insertCalCommand);
		if(isS) {
			return "redirect:calendar.do";			
		}else {
			return "redirect:error500.do";
		}
		
	}
	
	@GetMapping(value="/calBoardList.do")
	public String calBoardList(Locale locale,
							   HttpServletRequest request,
							   Model model,
							   @RequestParam Map<String, String> map) {
		logger.info("일정 목록보기 이동{}",locale);
		//일정관리에서 id는 로그인 한 아이디를 사용해야 하기 때문에
//		HttpSession session=request.getSession();//session객체 구하기
//		String id=(String)session.getAttribute("id");//id는 session에서 가져오기
		System.out.println("year:"+map.get("year"));
		String id="kbj";
		String yyyyMMdd=map.get("year")
					   +Util.isTwo(map.get("month")) 
					   +Util.isTwo(map.get("date"));//8자리 만들기
		
		List<CalDto>list=calService.calBoardList(id, yyyyMMdd);
		model.addAttribute("list", list);
		return "calBoardList";
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
