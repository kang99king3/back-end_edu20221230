package com.hk.ansboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.ansboard.dtos.AnsDto;
import com.hk.ansboard.service.IAnsService;


@Controller
public class AnsController {

	@Autowired
	private IAnsService ansService;
	
	
	@RequestMapping(value="/boardlist.do",method = RequestMethod.GET)
	public String getAllList(String pnum, Model model, HttpServletRequest request) {
		System.out.println("글목록조회");
		List<AnsDto> list=ansService.getAllList(pnum);
		request.setAttribute("lists", list);
//		model.addAttribute("lists", list);
		return "boardlist";
	}
}




