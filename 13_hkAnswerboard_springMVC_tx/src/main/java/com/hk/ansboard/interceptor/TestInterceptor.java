package com.hk.ansboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{

	//preHandle():컨트롤러 실행 전 호출된다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("ldto");//로그인 정보
		
//			if(obj==null) {
//				System.out.println("인터셉터[preHandle]:컨트롤러 실행전입니다.");
//				response.sendRedirect("index.jsp");
//			}else 
		if(request.getRequestURI().contains("/boardlist.do")){
			System.out.println("글목록은 진행시키고..");
			return true;				
		}else if(request.getRequestURI().contains("/boardDetail.do")) {
			if(obj==null) {
				System.out.println("글상세조회는 로그인한 상태일때만...");
				response.sendRedirect("./boardlist.do");
				//       /boardlist.do  ---> / root경로부터 시작
				//       http://localhost:8090/13_hkAnswerboard_springMVC/boardlist.do
				//       http://localhost:8090/boardlist.do --> 404
				
				//       ./boardlist.do : 현재 있는 위치에서 경로 이어서 시작
				//         boardlist.do :       동일한 의미
			}   //       ./../img/a.jpg
		}
		
		return true;
	}
	
	//postHandle(): 컨트롤러 실행 후 DispatcherServlet이 뷰로 보내기 전에 호출된다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("인터셉터[postHandle]:컨트롤러 실행 후 ");
	}
	
	//afterCompletion: 컨트롤러에서 뷰까지 수행이 완료된 후 호출된다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("인터셉터[afterCompletion]:컨트롤러 실행 및 화면 이동 후");
	}
}
