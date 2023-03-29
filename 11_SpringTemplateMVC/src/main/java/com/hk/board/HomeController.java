package com.hk.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//DispatcherServlet이 @Controller로 선언된 클래스들을 찾고
//찾은 클래스들 중에 home.do라고 선언되어있는 메서드를 실행시킨다.
@Controller
public class HomeController {
 
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request,
									HttpServletResponse response) {
		String str="Spring Framework MVC 프로젝트 생성하기";
		System.out.println(str);
		model.addAttribute("str", str);// requestScope와 같은 역할
		return "home"; // ---> "WEB-INF/views/+"home"+".jsp" 이렇게 만들어서 찾으러 감
//		return "redirect:boardlist.do";// response.sendRedirect(URL) 같으거임
	}
}








