package com.hk.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.board.daos.IHkDao;
import com.hk.board.dtos.HkDto;
import com.hk.board.service.IHkService;

//DispatcherServlet이 @Controller로 선언된 클래스들을 찾고
//찾은 클래스들 중에 home.do라고 선언되어있는 메서드를 실행시킨다.
@Controller
public class HomeController {
 
	@Autowired
	private IHkService hkService;
//	@Autowired
//	private IHkDao hkDao;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request,
									HttpServletResponse response) {
		String str="Spring Framework MVC 프로젝트 생성하기";
		System.out.println(str);
		model.addAttribute("str", str);// requestScope와 같은 역할
		return "home"; // ---> "WEB-INF/views/+"home"+".jsp" 이렇게 만들어서 찾으러 감
//		return "redirect:boardlist.do";// response.sendRedirect(URL) 같으거임
	}
	
	@RequestMapping(value="/boardlist.do",method = RequestMethod.GET)
	public String getAllList(Model model, HttpServletRequest request) {
		System.out.println("글목록조회");
		List<HkDto> list=hkService.getAllList();
		request.setAttribute("lists", list);
//		model.addAttribute("lists", list);
		return "boardlist";
	}
	
	@RequestMapping(value="/board_detail.do",method = RequestMethod.GET)
	public String getBoard(Model model, HttpServletRequest request
						 ,int seq) {
		System.out.println("글상세보기");
//		int seq=Integer.parseInt(request.getParameter("seq"));
		HkDto dto=hkService.getBoard(seq);
		request.setAttribute("dto", dto);
		return "board_detail";
	}
	
//	@GetMapping()
	@RequestMapping(value="/insertBoardForm.do",method = RequestMethod.GET)
	public String insertBoardForm(Model model, HttpServletRequest request) {
		System.out.println("글추가하기 폼이동");
		return "insertboard";
	}
	
	@RequestMapping(value="/insertboard.do",method = RequestMethod.POST)
//	public String insertBoard(Model model,HkDto dto) {
	public String insertBoard(Model model,@RequestParam Map<String,String> map) {
		                      //파라미터에 HkDto를 선언하면 파라미터와 
		//                      맴버필드가 같으면 받을 수 있다
		//                    @RequestParam Map<String,String> map
		System.out.println("글추가하기");
//		boolean isS=hkService.insertBoard(dto);
		boolean isS=hkService.insertBoard(new HkDto(map.get("id")
												   ,map.get("title")
												   ,map.get("content")));
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			return "error";			
		}
	}
	
	@RequestMapping(value="/board_update_form.do",method = RequestMethod.GET)
	public String boardUpdateForm(int seq, Model model, HttpServletRequest request) {
		System.out.println("글수정하기 폼이동");
		HkDto dto=hkService.getBoard(seq);
		model.addAttribute("dto", dto);
		return "board_update";
	}
	
	@RequestMapping(value="/board_update.do",method = RequestMethod.POST)
	public String boardUpdate(HkDto dto, Model model, HttpServletRequest request) {
		System.out.println("글수정하기");
		boolean isS=hkService.updateBoard(dto);
		if(isS) {
			return "redirect:board_detail.do?seq="+dto.getSeq();
		}else {
			return "error";			
		}
	}
	
	@RequestMapping(value="/board_delete.do",method = RequestMethod.GET)
	public String boardDelete(HkDto dto, Model model, HttpServletRequest request) {
		System.out.println("글삭제하기");
		boolean isS=hkService.delBoard(dto.getSeq()+"");
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			return "error";			
		}
	}
	
	@RequestMapping(value="/muldel.do",method = RequestMethod.POST)
	public String boardMuldel(String[] chk, Model model) {
		System.out.println("여러글삭제하기");
		boolean isS=hkService.mulDel(chk);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			return "error";			
		}
	}
}








