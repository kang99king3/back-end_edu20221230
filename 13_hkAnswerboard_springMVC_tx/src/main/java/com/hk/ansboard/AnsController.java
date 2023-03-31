package com.hk.ansboard;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.ansboard.dtos.AnsDto;
import com.hk.ansboard.service.IAnsService;
import com.hk.utils.Paging;


@Controller
public class AnsController {

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
		System.out.println("글목록조회");
		
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
}




