package com.hk.ansboard;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.ansboard.dtos.AnsDto;
import com.hk.ansboard.service.IAnsService;
import com.hk.utils.Paging;


@Controller
public class AnsController {

	private static final Logger logger=LoggerFactory.getLogger(AnsController.class);
	
	@Autowired
	private IAnsService ansService;
	
	//원하는 쿠키 구하는 메서드
	public Cookie getCookie(String name,HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		Cookie cookie=null;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals(name)) {
				cookie=cookies[i];
			}
		}
		return cookie;
	}
	
	@RequestMapping(value="/boardlist.do",method = RequestMethod.GET)
	public String getAllList(String pnum, Model model,
			HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글목록조회");
//		System.out.println("파라미터:"+pnum);
		logger.info("글목록 조회함");
		logger.info("파라미터:"+pnum);
		//쿠키의 값을 가져오기: 반환타입이 배열
		Cookie cookie=getCookie("rseq", request);
		if(cookie!=null) {
			cookie.setMaxAge(0);//쿠키 삭제
			response.addCookie(cookie);//클라이언트에 반영
		}
		
		//---현재 페이지 상태 유지하기[세션활용] 시작
		HttpSession session=request.getSession();//session 객체 구하기
		if(pnum==null) { 
//			pnum=1+"";//페이지번호 없이 요청이 오면 기본 1페이지보여주기
			pnum=(String)session.getAttribute("pnum");//페이지번호 없이 요청하면 세션값 적용
		}else {
			session.setAttribute("pnum", pnum);//페이지번호와 함께 요청하면 세션에 새로 저장
		}
		//---현재 페이지 상태 유지하기[세션활용] 종료
		
		//작업1.글목록 구하고 request에 담기
		List<AnsDto> list=ansService.getAllList(pnum);//<---받은 페이지 번호에 해당하는 목록구하기
		request.setAttribute("list", list);
		//작업2.글의 페이지수 구하고 request에 담기
		int pcount=ansService.getPCount();
		request.setAttribute("pcount", pcount);// Object <---(Integer) int
		
		//--추가코드:페이지에 페이징처리 기능 시작           페이지수, 페이지번호, 한번에 볼 페이지범위
		Map<String, Integer> map=Paging.pagingValue(pcount, pnum   , 10   );
		request.setAttribute("pMap", map);
		//--추가코드:페이지에 페이징처리 기능 종료
		return "boardlist";
	}
	
	@RequestMapping(value = "/boardDetail.do",method = RequestMethod.GET)
	public String getBoard(Model model,int seq
			      ,HttpServletRequest request,HttpServletResponse response ) {
		logger.info("글상세내용 조회함");
		logger.info("파라미터:"+seq);
		//쿠키의 값을 가져오기: 반환타입이 배열
		Cookie[] cookies=request.getCookies();
		String s=null;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("rseq")) {
				s=cookies[i].getValue();
			}
		}
		
		//쿠키를 생성하는 전제조건: "rseq"라는 이름의 쿠키값이 없을 때
		if(s==null||!s.equals(seq+"")) {
			Cookie cookie=new Cookie("rseq", seq+"");//쿠키생성
			cookie.setMaxAge(60*10);//쿠키의 유효기간
			response.addCookie(cookie);//브라우저로 생성한 쿠키를 추가
			ansService.readCount(seq);//조회수 증가
		}
		
		AnsDto dto=ansService.getBoard(seq);
		model.addAttribute("dto", dto);
		
		return "board_detail";
	}
	
	@RequestMapping(value = "/board_update_form.do",method = RequestMethod.GET)
	public String board_update_form(Model model
									,@RequestParam(value="seq") int seq
									,HttpServletRequest request
									,HttpServletResponse response ) {
		
		AnsDto dto=ansService.getBoard(seq);
		model.addAttribute("dto", dto);
		
		return "board_update";
	}
	
	@RequestMapping(value = "/board_update.do",method = RequestMethod.POST)
	public String board_update(Model model
							  ,AnsDto dto 
						      ,HttpServletRequest request
							  ,HttpServletResponse response ) 
							  throws UnsupportedEncodingException {
		
		boolean isS=ansService.updateBoard(dto);
		if(isS) {
			return "redirect:boardDetail.do?seq="+dto.getSeq();
		}else {
			return "redirect:error.do?msg="+(URLEncoder.encode("수정실패", "utf-8"));			
		}
		
	}
	
	@RequestMapping(value = "/insertForm.do",method = RequestMethod.GET)
	public String insertForm(Model model
							  ,AnsDto dto 
						      ,HttpServletRequest request
							  ,HttpServletResponse response ) 
							  throws UnsupportedEncodingException {
		
		return "insertboard";
	}
	
	@RequestMapping(value = "/insertboard.do",method = RequestMethod.POST)
	public String insertBoard(Model model
							  ,AnsDto dto 
						      ,HttpServletRequest request
							  ,HttpServletResponse response ) 
							  throws UnsupportedEncodingException {
		
		boolean isS=ansService.insertBoard(dto);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			return "redirect:error.do?msg="
					+(URLEncoder.encode("글추가실패", "utf-8"));
		}
		
	}
	
	//답글달기  replyboard.do
	@RequestMapping(value = "/replyboard.do",method = RequestMethod.POST)
	public String replyBoard(Model model
							  ,AnsDto dto 
						      ,HttpServletRequest request
							  ,HttpServletResponse response ) 
							  throws UnsupportedEncodingException {
		
		boolean isS=ansService.replyBoard(dto);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			return "redirect:error.do?msg="
					+(URLEncoder.encode("답글추가실패", "utf-8"));
		}
		
	}
	//삭제하기
	
	
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











