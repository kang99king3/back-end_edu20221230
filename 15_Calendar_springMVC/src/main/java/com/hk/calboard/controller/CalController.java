package com.hk.calboard.controller;

import java.util.Calendar;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public String calendar(String year,String month, Locale locale, Model model,HttpServletRequest request) {
		logger.info("달력보기{}",locale);
//		Map<String, Integer>map=testController.makeCalendar(request);
//		model.addAttribute("calMap", map);
		
		if(year==null||month==null) {
			Calendar cal=Calendar.getInstance();
			year=cal.get(Calendar.YEAR)+"";
			month=(cal.get(Calendar.MONTH)+1)+"";
		}
		
		try {
			String id="kbj";//나중에는 세션에서 로그인한 아이디로 쓰자
			String yyyyMM=year+Util.isTwo(month);//"202304" 6자리
			System.out.println("yyyyMM:"+yyyyMM);
			List<CalDto> clist = calService.CalViewList(id, yyyyMM);
			model.addAttribute("clist", clist);
		} catch (Exception e) {
			model.addAttribute("code", e.getMessage());
			return "error/500";
//			e.printStackTrace();
		}
	
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
		
		//일정목록 조회할 때마다 필요로 하는 year, month, date를 세션에 담아서 관리
		HttpSession session=request.getSession();
		if(map.get("year")==null) {
			map=(Map<String,String>)session.getAttribute("ymdMap");
		}else {			
			session.setAttribute("ymdMap", map);
		}
		
		String yyyyMMdd=map.get("year")
					   +Util.isTwo(map.get("month")) 
					   +Util.isTwo(map.get("date"));//8자리 만들기
		
		List<CalDto>list=calService.calBoardList(id, yyyyMMdd);
		model.addAttribute("list", list);
		return "calBoardList";
	}
	
	@GetMapping(value="/calBoardDetail.do")
	public String calBoardDetail(int seq, Model model) {
		logger.info("일정상세보기");
		CalDto dto=calService.calBoardDetail(seq);
		model.addAttribute("dto", dto);
		return "calBoardDetail";
	}
	
	@GetMapping(value="calBoardUpdateform.do")
	public String calBoardUpdateform(int seq, Model model) {
		logger.info("일정 수정폼이동");
		CalDto dto=calService.calBoardDetail(seq);
		model.addAttribute("dto", dto);
		return "calBoardUpdate";
	}
	
	@PostMapping(value="calBoardUpdate.do")
	public String calBoardUpdate(InsertCalCommand insertCalCommand, Model model) {
		logger.info("일정 수정하기");
		
		try {
			boolean isS=calService.calBoardUpdate(insertCalCommand);
		} catch (Exception e) {
			e.printStackTrace();
			return "error500.do";
		}
		
		return "redirect:calBoardDetail.do?seq="+insertCalCommand.getSeq();
	}
	
	@RequestMapping(value = "/calMulDel.do",method = {RequestMethod.POST,RequestMethod.GET})
	public String calMulDel(String[] chk,@RequestParam Map<String,String> map) {
		try {
			boolean isS=calService.calMulDel(chk);
		} catch (Exception e) {
			e.printStackTrace();
			return "error500.do";
		}
//		return "redirect:calBoardList.do?year="+map.get("year")
//										+"&month="+map.get("month")
//										+"&date="+map.get("date");
		return "redirect:calBoardList.do";
	}
	
//	public String ---> 값 하나 (text)로 반환 작성
//	public Map<String,Integer..String...> -> json로 반환 작성
	@ResponseBody  // --> printWriter pw=response.getWrite()
	@GetMapping(value="calCountAjax.do")
	public Map<String,Integer> calCountAjax(String yyyyMMdd){
		logger.info("일정개수보여주기");
		Map<String,Integer> map=new HashMap<>();
		String id="kbj";
		int count=calService.calBoardCount(id, yyyyMMdd);
		map.put("count", count);
		return map;
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
		
		model.addAttribute("code", "500오류:");
				
		return "error/404";
	}
}
