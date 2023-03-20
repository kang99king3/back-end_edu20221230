package com.hk.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//Tomcat7.0 이후 부터는 아래와 같이 어노테이션으로 URL Mapping을 지원한다.
//@WebServlet(
//		urlPatterns = { "/HelloServlet" }, 
//		initParams = { 
//				@WebInitParam(name = "id", value = "hk")
//		})
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 파라미터가 한글일때 인코딩처리
		request.setCharacterEncoding("utf-8");
		//응답할때 브라우저에 표현할 한글 인코딩처리
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
