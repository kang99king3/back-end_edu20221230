package com.hk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hk.daos.HkDao;
import com.hk.dtos.HkDto;

public class BoardListController {

	//execute메서드: request 요청정보를 받아서 처리
	public void execute(HttpServletRequest request) {
		HkDao dao=new HkDao();
		List<HkDto> lists=dao.getAllList();
		request.setAttribute("lists", lists);
	}
	
}



